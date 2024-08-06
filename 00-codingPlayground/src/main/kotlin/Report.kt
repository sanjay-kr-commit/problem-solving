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

    private var _logTime_ : Boolean = false
    private var _only_show_failed_ = false
    private var _cache_time_ : Boolean = false
    private var _mute_print_ : Boolean = false


    private fun <R> logTime( observableScope : () -> R ) : Pair<R,String> {
        val startTime = System.currentTimeMillis()
        val returnedObj : R = observableScope.invoke()
        val endTime = System.currentTimeMillis()
        timeLoggedForCases++
        timeTaken += endTime - startTime
        return Pair( returnedObj , "Time Taken : ${endTime-startTime} milliseconds" )
    }

    fun <T:Comparable<T>> T.check( obj : T ) : Boolean {
        val isEqual = obj == this
        case++
        if ( isEqual ) passed++
        else failed++
        return isEqual
    }

    infix fun <T:Comparable<T>> T.check( logTimeBlock : () -> T ) : Boolean = logTime {
        logTimeBlock()
    }.let {
        it.first.check( this )
            .also { isEqual ->
                if ( _cache_time_ ) timeTakenLog.append( "${
                    if ( isEqual ) green else red
                }Case $case ${it.second}$reset\n" )
                if ( _logTime_ && (( _only_show_failed_ && !isEqual ) || ( isEqual && !_only_show_failed_ )) ) controlledPrintln( it.second )
            }
    }

    fun <T:Comparable<T>> T.logCheck( obj: T  ) : T {
        val isEqual = this == obj
        if ( isEqual && !_only_show_failed_ ) {
            controlledPrintln( "Case ${case+1}" )
            controlledPrintln("${green}$this$reset")
        } else if ( !isEqual ) {
            controlledPrintln( "Case ${case+1}" )
            controlledPrintln("${green}Expected : $obj$reset"  )
            controlledPrintln("${red}Received : $this$reset")
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

    fun <T> T.logCheck( comparableBlock : ( T , T ) -> Boolean , logTimeBlock : () -> T ) : T {
        controlledPrintln( "Running Case ${case+1}" )
        logTime {
            logTimeBlock()
        }.let { obj ->
            val isEqual = comparableBlock(this, obj.first)
            if (isEqual && !_only_show_failed_) {
                controlledPrintln("Case ${case + 1}")
                controlledPrintln("${green}${obj.first}$reset")
            } else if (!isEqual) {
                controlledPrintln("Case ${case + 1}")
                controlledPrintln("${green}Expected : $this$reset")
                controlledPrintln("${red}Received : ${obj.first}$reset")
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
    }

    val logReport : Unit
        get() {
            if ( !_mute_print_ ) println()
            controlledPrintln( "Logging Report" )
            if ( case == 0 ) {
                controlledPrintln( "Nothing to log" )
                return
            }
            controlledPrintln( "Total Cases  : $case" )
            if ( passed > 0 ) controlledPrintln( "${green}Cases Passed : $passed ${(passed*100)/case}%$reset" )
            if ( failed > 0 ) controlledPrintln( "${red}Cases Failed : $failed ${(failed*100)/case}%$reset" )
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
    infix fun <T:Comparable<T>> Array<T>.logCheck(  logTimeBlock : () -> Array<T> ) : Array<T> = logCheck( ::isEqual , logTimeBlock )
    infix fun IntArray.logCheck(  logTimeBlock : () -> IntArray ) : IntArray = logCheck( ::isEqual , logTimeBlock )
    infix fun LongArray.logCheck(  logTimeBlock : () -> LongArray ) : LongArray = logCheck( ::isEqual , logTimeBlock )
    infix fun DoubleArray.logCheck(  logTimeBlock : () -> DoubleArray ) : DoubleArray = logCheck( ::isEqual , logTimeBlock )
    infix fun FloatArray.logCheck(  logTimeBlock : () -> FloatArray ) : FloatArray = logCheck( ::isEqual , logTimeBlock )
    infix fun CharArray.logCheck(  logTimeBlock : () -> CharArray ) : CharArray = logCheck( ::isEqual , logTimeBlock )
    infix fun TreeNode.logCheck(  logTimeBlock : () -> TreeNode ) : TreeNode = logCheck( ::isEqual , logTimeBlock )
    infix fun <T:Comparable<T>> T.logCheck( logTimeBlock : () -> T  ) : T = logCheck( ::isEqual , logTimeBlock )
    infix fun <T:Comparable<T>> List<T>.logCheck( logTimeBlock: () -> List<T> ) : List<T> = logCheck( ::isEqual , logTimeBlock )

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

}