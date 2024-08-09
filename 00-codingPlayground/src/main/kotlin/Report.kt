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

    val toStringHandler : HashMap<( Any? )->Boolean,( Any? )->String> = hashMapOf()


    private var _logTime_ : Boolean = false
    private var _only_show_failed_ = false
    private var _cache_time_ : Boolean = false
    private var _mute_print_ : Boolean = false
    private var _print_stack_trace_ : Boolean = false
    private var _nano_precision_ : Boolean = false

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

    fun <T:Comparable<T>> T.logCheck( obj: T  ) : T {
        val isEqual = this == obj
        if ( isEqual && !_only_show_failed_ ) {
            controlledPrintln( "Case ${case+1}" )
            controlledPrintln("${green}${toStr(this)}$reset")
        } else if ( !isEqual ) {
            controlledPrintln( "Case ${case+1}" )
            controlledPrintln("${green}Expected : ${toStr(obj)}$reset"  )
            controlledPrintln("${red}Received : ${toStr(this)}$reset")
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

    fun <T> T.logCheck( comparableBlock : ( T , T ) -> Boolean , logTimeBlock : () -> T ) : T? {
        controlledPrintln( "Running Case ${case+1}" )
        try {
            logTime {
                logTimeBlock()
            }.let { obj ->
                val isEqual = comparableBlock(this, obj.first)
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
            controlledPrintln( "${red}> Failed With Exception : ${e.javaClass.name}${
                if ( _print_stack_trace_ ) "\n${e.stackTraceToString()}"
                else ""
            }$reset" )
        }
        return null
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
                controlledPrintln( "Time Take For ${ 
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

    // proxy functions
    infix fun <T:Comparable<T>> Array<T>.logCheck(  logTimeBlock : () -> Array<T> ) : Array<T>? = logCheck( ::isEqual , logTimeBlock )
    infix fun Array<IntArray>.logCheck(  logTimeBlock : () -> Array<IntArray> ) : Array<IntArray>? = logCheck( ::isEqual , logTimeBlock )
    infix fun Array<CharArray>.logCheck(  logTimeBlock : () -> Array<CharArray> ) : Array<CharArray>? = logCheck( ::isEqual , logTimeBlock )
    infix fun Array<FloatArray>.logCheck(  logTimeBlock : () -> Array<FloatArray> ) : Array<FloatArray>? = logCheck( ::isEqual , logTimeBlock )
    infix fun Array<DoubleArray>.logCheck(  logTimeBlock : () -> Array<DoubleArray> ) : Array<DoubleArray>? = logCheck( ::isEqual , logTimeBlock )
    infix fun Array<LongArray>.logCheck(  logTimeBlock : () -> Array<LongArray> ) : Array<LongArray>? = logCheck( ::isEqual , logTimeBlock )
    infix fun IntArray.logCheck(  logTimeBlock : () -> IntArray ) : IntArray? = logCheck( ::isEqual , logTimeBlock )
    infix fun LongArray.logCheck(  logTimeBlock : () -> LongArray ) : LongArray? = logCheck( ::isEqual , logTimeBlock )
    infix fun DoubleArray.logCheck(  logTimeBlock : () -> DoubleArray ) : DoubleArray? = logCheck( ::isEqual , logTimeBlock )
    infix fun FloatArray.logCheck(  logTimeBlock : () -> FloatArray ) : FloatArray? = logCheck( ::isEqual , logTimeBlock )
    infix fun CharArray.logCheck(  logTimeBlock : () -> CharArray ) : CharArray? = logCheck( ::isEqual , logTimeBlock )
    infix fun TreeNode.logCheck(  logTimeBlock : () -> TreeNode ) : TreeNode? = logCheck( ::isEqual , logTimeBlock )
    infix fun <T:Comparable<T>> T.logCheck( logTimeBlock : () -> T  ) : T? = logCheck( ::isEqual , logTimeBlock )
    infix fun <T:Comparable<T>> List<T>.logCheck( logTimeBlock: () -> List<T> ) : List<T>? = logCheck( ::isEqual , logTimeBlock )

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

    var addStringHandler : Pair<(Any?)->Boolean,(Any?)->String>?
        get() = null
        set(value) {
            if ( value == null ) return
            toStringHandler[value.first] = value.second
        }

    val enableNanoPrecision : Unit
        get() {
            _nano_precision_ = true
        }

    val disableNanoPrecision : Unit
        get() {
            _nano_precision_ = false
        }

}