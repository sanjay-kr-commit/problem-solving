class LogScope {

    private var _print_stack_trace_ : Boolean = false
    val isPrintStackTraceEnabled : Boolean
    get() = _print_stack_trace_
    val logException : Unit
        get() {
            _print_stack_trace_ = true
        }
    private var _ask_for_log_ : Boolean = false
    val isAskForLogEnabled : Boolean
    get() = _ask_for_log_
    val askForExceptionLog : Unit
        get() {
            _ask_for_log_ = true
        }

    lateinit var overrideChecker : ( Any , Any ) -> Boolean
    val isOverrideCheckerInitialized : Boolean
        get() = this::overrideChecker.isInitialized
    lateinit var overrideToString : ( Any? ) -> String
    val isOverrideToStringInitialized : Boolean
        get() = this::overrideToString.isInitialized

}