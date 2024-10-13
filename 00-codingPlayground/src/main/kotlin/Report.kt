class Report {

    private var case = 0
    private var passed = 0
    private var failed = 0
    private var timeTaken = 0L
    private var timeLoggedForCases = 0
    private val timeTakenLog = StringBuilder()
    private val red = "\u001b[31m"
    private val green = "\u001b[32m"
    private val reset = "\u001b[0m"

    val _to_string_handler_ : HashMap<Class<*>,(Any)->String> = hashMapOf()
    val _generic_to_string_handler_ : HashMap<(Any?)->Boolean,(Any?)->String> = hashMapOf()
    private var _logTime_ : Boolean = false
    private var _only_show_failed_ = false
    private var _cache_time_ : Boolean = false
    private var _mute_print_ : Boolean = false
    private var _print_stack_trace_ : Boolean = false
    private var _nano_precision_ : Boolean = false
    private var _log_at_exit_ : Boolean = false
    private var _ask_for_log_ : Boolean = false
    private var _break_execution_on_error_ : Boolean = false
    private var _error_occured_ : Boolean = false
    private var _skip_test_ : Int = 0
    private var _override_checker_ : HashMap<Class<*>,(Any,Any)->Boolean> = hashMapOf()
    private var _override_generic_checker_ : HashMap<(Any?)->Boolean,(Any?,Any?)->Boolean> = hashMapOf()
    private var genericChecker : ((Any?,Any?)->Boolean)? = null
    private fun HashMap<(Any?)->Boolean,(Any?,Any?)->Boolean>.contains( data : Any? ) : Boolean {
        genericChecker = null
        for ( ( checker , modifier ) in this ) {
            if ( checker( data ) ) {
                genericChecker = modifier
                break
            }
        }
        return genericChecker != null
    }

    val logAtExit: Boolean
        get() = _log_at_exit_
    val isNanoSecondPrecisionEnable : Boolean
        get() = _nano_precision_

    var configureLogScope : LogScope.() -> Unit = { }

    private fun <R> logTime( observableScope : () -> R ) : Pair<R,String> {
        val returnedObj : R
        val startTime = if ( _nano_precision_ ) System.nanoTime() else System.currentTimeMillis()
        try {
            returnedObj = observableScope.invoke()
        } catch ( e : Exception ) {
            val endTime = if ( _nano_precision_ ) System.nanoTime() else System.currentTimeMillis()
            timeLoggedForCases++
            timeTaken += if ( _nano_precision_ ) ((endTime - startTime)/(1e6)).toLong() else endTime-startTime
            if (_cache_time_) timeTakenLog.append(
                "${red}Case ${case+1} Time Taken : ${endTime-startTime} ${
                    if ( _nano_precision_ ) "nanoseconds" else "milliseconds"
                }$reset\n"
            )
            throw e
        }
        val endTime = if ( _nano_precision_ ) System.nanoTime() else System.currentTimeMillis()
        timeLoggedForCases++
        timeTaken += if ( _nano_precision_ ) ((endTime - startTime)/(1e6)).toLong() else endTime-startTime
        return Pair( returnedObj!! , "Time Taken : ${endTime-startTime} ${
            if ( _nano_precision_ ) "nanoseconds" else "milliseconds"
        }" )
    }

    fun <T:Comparable<T>> T.check( obj : T ) : Boolean {
        val isEqual = obj == this
        case++
        if ( isEqual ) passed++
        else failed++
        return isEqual
    }

    infix fun <T:Comparable<T>> T.check( logTimeBlock : () -> T ) : Boolean {
        try {
            logTime {
                logTimeBlock()
            }.let {
                it.first.check(this)
                    .also { isEqual ->
                        if (_cache_time_) timeTakenLog.append(
                            "${
                                if (isEqual) green else red
                            }Case $case ${it.second}$reset\n"
                        )
                        if (_logTime_ && ((_only_show_failed_ && !isEqual) || (isEqual && !_only_show_failed_))) controlledPrintln(
                            it.second
                        )
                    }
            }
        } catch (e: Exception) {
            case++
            failed++
            controlledPrintln( "${red}> Failed With Exception : ${e.javaClass.name}${
                if ( _print_stack_trace_ ) "\n${e.stackTraceToString()}"
                else ""
            }$reset" )
        }
        return false
    }

    fun <T:Comparable<T>> T.logCheck( obj: T ) : T {
        val isEqual = this == obj
        if ( isEqual && !_only_show_failed_ ) {
            controlledPrintln( "Case ${case+1}" )
            controlledPrintln("${green}${toExtendedStr(this)}$reset")
        } else if ( !isEqual ) {
            controlledPrintln( "Case ${case+1}" )
            controlledPrintln("${green}Expected : ${toExtendedStr(obj)}$reset"  )
            controlledPrintln("${red}Received : ${toExtendedStr(this)}$reset")
        }
        case++
        if ( isEqual ) passed++
        else failed++
        return this
    }

// remove due to function overload conflict
//    fun <T> T.logCheck( obj: T , comparableBlock : ( T , T ) -> Boolean ) : T {
//        val isEqual = comparableBlock( this , obj )
//        if ( isEqual && !_only_show_failed_ ) {
//            controlledPrintln( "Case ${case+1}" )
//            controlledPrintln("${green}$this$reset")
//        } else if ( !isEqual ) {
//            controlledPrintln( "Case ${case+1}" )
//            controlledPrintln("${green}Expected : $obj$reset"  )
//            controlledPrintln("${red}Received : $this$reset")
//        }
//        case++
//        if ( isEqual ) passed++
//        else failed++
//        return this
//    }

    fun <T> T.logCheck(comparableBlock : (T, T ) -> Boolean, logTimeBlock : LogScope.() -> T ) : T? {
        if ( _skip_test_ > 0 ) {
            _skip_test_--
            return null
        }
        if ( _break_execution_on_error_ && _error_occured_ ) return null
        controlledPrintln( "Running Case ${case+1}" )
        val logScope = LogScope()
        logScope.configureLogScope()
        try {
            logTime {
                logScope.logTimeBlock()
            }.let { obj ->
                @Suppress("UNCHECKED_CAST")
                val overriddenChecker : (T, T ) -> Boolean = when {
                    logScope.isOverrideCheckerInitialized -> logScope.overrideChecker as (T,T)->Boolean
                    obj.first != null && _override_checker_.contains( obj.first!!::class.java ) -> _override_checker_[obj.first!!::class.java] as (T,T)->Boolean
                    _override_generic_checker_.contains( obj.first ) -> genericChecker!!
                    else -> comparableBlock
                }
                val isEqual = overriddenChecker(this, obj.first)
                val toStr : (Any?) -> String = if ( logScope.isOverrideToStringInitialized ) logScope.overrideToString else { a ->
                    toExtendedStr( a )
                }
                if (isEqual && !_only_show_failed_) {
                    controlledPrintln("Case ${case + 1}")
                    controlledPrintln("${green}${toStr(obj.first)}$reset")
                } else if (!isEqual) {
                    controlledPrintln("Case ${case + 1}")
                    controlledPrintln("${green}Expected : ${toStr(this)}$reset")
                    controlledPrintln("${red}Received : ${toStr(obj.first)}$reset")
                }
                if (_cache_time_) timeTakenLog.append(
                    "${
                        if (isEqual) green else red
                    }Case ${case + 1} ${obj.second}$reset\n"
                )
                if (_logTime_ && ((_only_show_failed_ && !isEqual) || (isEqual && !_only_show_failed_))) controlledPrintln(
                    obj.second
                )
                case++
                if (isEqual) passed++
                else failed++
                return this
            }
        } catch ( e : Exception ) {
            case++
            failed++
            _error_occured_ = true
            controlledPrintln( "${red}> Failed With Exception : ${e.javaClass.name}${
                if ( _print_stack_trace_ || logScope.isPrintStackTraceEnabled || ( (_ask_for_log_||logScope.isAskForLogEnabled) && readConsent() )) "\n${e.stackTraceToString()}"
                else ""
            }$reset" )
        }
        return null
    }

    private fun readConsent() : Boolean {
        print( "Enter y to log exception : " )
        return readln() == "y"
    }

    val logReport : Unit
        get() {
            controlledPrintln( "Logging Report" )
            if ( case == 0 ) {
                controlledPrintln( "Nothing to log" )
                return
            }
            controlledPrintln( "Total Cases  : $case" )
            if ( passed > 0 ) controlledPrintln( "${green}Cases Passed : $passed$reset" )
            if ( failed > 0 ) controlledPrintln( "${red}Cases Failed : $failed$reset" )
            if ( passed > 0 ) controlledPrintln( "${green}Success Rate : ${(passed*100)/case}%$reset" )
            if ( failed > 0 ) controlledPrintln( "${red}Failure Rate : ${(failed*100)/case}%$reset" )
            if ( timeLoggedForCases > 0 ) {
                controlledPrintln( "Time Taken For ${ 
                    if ( case == timeLoggedForCases ) "All"
                    else timeLoggedForCases
                } Cases : $timeTaken milliseconds" )
            }
            if ( _cache_time_ && timeTakenLog.isBlank() ) controlledPrintln( "No case time was captured" )
            else if (timeTakenLog.isNotBlank()) controlledPrintln( timeTakenLog )
        }

    private fun controlledPrint( message: Any? ) {
        if (_mute_print_) return
        print( message )
    }

    private fun controlledPrintln( message: Any? ) = controlledPrint( "$message\n" )

    data class PassedReference<T>(
        var data : T
    )

    infix fun <T> T.logPassReference( scopeBlock : PassedReference<T>.() -> Unit ) {
        if (_skip_test_ > 0) {
            _skip_test_--
            return
        }
        PassedReference( this ).scopeBlock()
    }
    // proxy functions
    infix fun <T:Comparable<T>> Array<T>.logCheck(  logTimeBlock : LogScope.() -> Array<T> ) : Array<T>? = logCheck( ::isEqual , logTimeBlock )
    infix fun Array<IntArray>.logCheck(  logTimeBlock : LogScope.() -> Array<IntArray> ) : Array<IntArray>? = logCheck( ::isEqual , logTimeBlock )
    infix fun Array<CharArray>.logCheck(  logTimeBlock : LogScope.() -> Array<CharArray> ) : Array<CharArray>? = logCheck( ::isEqual , logTimeBlock )
    infix fun Array<FloatArray>.logCheck(  logTimeBlock : LogScope.() -> Array<FloatArray> ) : Array<FloatArray>? = logCheck( ::isEqual , logTimeBlock )
    infix fun Array<DoubleArray>.logCheck(  logTimeBlock : LogScope.() -> Array<DoubleArray> ) : Array<DoubleArray>? = logCheck( ::isEqual , logTimeBlock )
    infix fun Array<LongArray>.logCheck(  logTimeBlock : LogScope.() -> Array<LongArray> ) : Array<LongArray>? = logCheck( ::isEqual , logTimeBlock )
    infix fun IntArray.logCheck(  logTimeBlock : LogScope.() -> IntArray ) : IntArray? = logCheck( ::isEqual , logTimeBlock )
    infix fun LongArray.logCheck(  logTimeBlock : LogScope.() -> LongArray ) : LongArray? = logCheck( ::isEqual , logTimeBlock )
    infix fun DoubleArray.logCheck(  logTimeBlock : LogScope.() -> DoubleArray ) : DoubleArray? = logCheck( ::isEqual , logTimeBlock )
    infix fun FloatArray.logCheck(  logTimeBlock : LogScope.() -> FloatArray ) : FloatArray? = logCheck( ::isEqual , logTimeBlock )
    infix fun CharArray.logCheck(  logTimeBlock : LogScope.() -> CharArray ) : CharArray? = logCheck( ::isEqual , logTimeBlock )
    infix fun TreeNode.logCheck(  logTimeBlock : LogScope.() -> TreeNode ) : TreeNode? = logCheck( ::isEqual , logTimeBlock )
    infix fun <T:Comparable<T>> T.logCheck( logTimeBlock : LogScope.() -> T  ) : T? = logCheck( ::isEqual , logTimeBlock )
    infix fun <T:Comparable<T>> List<T>.logCheck( logTimeBlock: LogScope.() -> List<T> ) : List<T>? = logCheck( ::isEqual , logTimeBlock )
    infix fun <T> T.logCheck( logTimeBlock: LogScope.() -> T ) : T? = this?.run {
        if ( _skip_test_ > 0 ) {
            _skip_test_--
            return null
        }
        if ( this is PassedReference<*> ) {
            this.data logCheck( logTimeBlock )
            return@run null
        }
        @Suppress("UNCHECKED_CAST")
        var overrideChecker : ((T, T)->Boolean)? = if ( _override_checker_.contains( this::class.java ) ) _override_checker_[this::class.java] as (T, T)->Boolean else null
        if ( overrideChecker == null ) {
            for ( ( checker , equator ) in _override_generic_checker_ ) {
                if ( checker( this@logCheck ) ) {
                    overrideChecker = equator
                    break
                }
            }
        }
        overrideChecker?.let {
            logCheck( it , logTimeBlock )
        } ?: run {
            controlledPrintln( "Running Case ${case+1}" )
            case++
            failed++
            timeLoggedForCases++
            println( "${red}No Checker Found For ${this@logCheck!!::class.java}${reset}" )
            if (_logTime_) controlledPrintln(
                "${red}Case $case Time Taken : 0 ${
                    if ( _nano_precision_ ) "nanoseconds" else "milliseconds"
                }$reset"
            )
            if (_cache_time_) timeTakenLog.append(
                "${red}Case $case Time Taken : 0 ${
                    if ( _nano_precision_ ) "nanoseconds" else "milliseconds"
                }$reset\n"
            )
            null
        }
    }

    val logTime : Unit
        get() {
            _logTime_ = true
        }

    val dontLogTime : Unit
        get() {
            _logTime_ = false
        }

    val onlyShowFailed : Unit
        get() {
            _only_show_failed_ = true
        }

    val showAllCases : Unit
        get() {
            _only_show_failed_ = false
        }

    val cacheTime : Unit
        get() {
            _cache_time_ = true
        }

    val dontCacheTime : Unit
        get() {
            _cache_time_ = false
        }
    
    val disableLogging : Unit
        get() {
            _mute_print_ = true
        }
    
    val enableLogging : Unit
        get() {
            _mute_print_ = false
        }

    val logStackTrace : Unit
        get() {
            _print_stack_trace_ = true
        }

    val disableStackTraceLog : Unit
        get() {
            _print_stack_trace_ = false
        }

    /**
     * Primitive data types not supported
     */
    var addStringHandler : Pair<Class<*>,(Any?)->String>?
        get() = null
        set(value) {
            if ( value == null ) return
            _to_string_handler_[value.first] = value.second
        }

    var addGenericStringHandler : Pair<(Any?)->Boolean,(Any?)->String>?
        get() = null
        set(value) {
            if ( value == null ) return
            _generic_to_string_handler_[value.first] = value.second
        }

    /**
     * Primitive data types not supported
     */
    var overrideChecker : Pair<Class<*>,(Any,Any)->Boolean>?
        get() = null
        set(value) {
            if ( value == null ) return
            _override_checker_[value.first] = value.second
        }

    infix fun Class<*>.overrideChecker( isEqualLambda: (Any,Any) -> Boolean ) {
        _override_checker_[this] = isEqualLambda
    }

    var overrideGenericChecker : Pair<(Any?)->Boolean,(Any?,Any?)->Boolean>?
        get() = null
        set(value) {
            if ( value == null ) return
            _override_generic_checker_[value.first] = value.second
        }

    val enableNanoPrecision : Unit
        get() {
            _nano_precision_ = true
        }

    val disableNanoPrecision : Unit
        get() {
            _nano_precision_ = false
        }

    val enableLogAtExit : Unit
        get() {
            _log_at_exit_ = true
        }

    val askForExceptionLog : Unit
        get() {
            _ask_for_log_ = true
        }

    val stopExecutionOnError : Unit
        get() {
            _break_execution_on_error_ = true
        }

    var skipTest : Int
        get() {
            _skip_test_++
            return -1
        }
        set(value) {
            _skip_test_ += value
        }

}