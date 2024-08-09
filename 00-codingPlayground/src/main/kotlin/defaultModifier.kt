fun arrayOfTypeIntArrayToString( obj : Any? ) : String = StringBuilder().apply {
    append( "[" )
    (obj as Array<IntArray>).forEach {
        append( it.toList() )
        append( "," )
    }
    append( "]" )
}.toString()

fun arrayOfTypeFloatArrayToString( obj : Any? ) : String = StringBuilder().apply {
    append( "[" )
    (obj as Array<FloatArray>).forEach {
        append( it.toList() )
        append( "," )
    }
    append( "]" )
}.toString()

fun arrayOfTypeDoubletArrayToString( obj : Any? ) : String = StringBuilder().apply {
    append( "[" )
    (obj as Array<DoubleArray>).forEach {
        append( it.toList() )
        append( "," )
    }
    append( "]" )
}.toString()

fun arrayOfTypeLongArrayToString( obj : Any? ) : String = StringBuilder().apply {
    append( "[" )
    (obj as Array<LongArray>).forEach {
        append( it.toList() )
        append( "," )
    }
    append( "]" )
}.toString()

fun arrayOfTypeBooleanArrayToString( obj : Any? ) : String = StringBuilder().apply {
    append( "[" )
    (obj as Array<BooleanArray>).forEach {
        append( it.toList() )
        append( "," )
    }
    append( "]" )
}.toString()

fun arrayOfTypeShortArrayToString( obj : Any? ) : String = StringBuilder().apply {
    append( "[" )
    (obj as Array<ShortArray>).forEach {
        append( it.toList() )
        append( "," )
    }
    append( "]" )
}.toString()

fun returnArraySize( obj : Any? ) : String = obj?.run {
    ( this as Array<*> ).size.toString()
} ?: "0"