fun Report.toStr(obj : Any? ) : String
    = obj?.run {

        for ( ( checker , modifier ) in toStringHandler ) {
            if ( checker( obj ) ) return@run modifier(obj)
        }

        when {
            isArrayOfTypeIntArray( obj ) -> arrayOfTypeIntArrayToString( obj )
            isArrayOfTypeDoubleArray( obj )-> arrayOfTypeDoubletArrayToString( obj )
            isArrayOfTypeFloatArray(obj) -> arrayOfTypeFloatArrayToString( obj )
            isArrayOfTypeShortArray( obj) -> arrayOfTypeShortArrayToString( obj )
            isArrayOfTypeLongArray( obj ) -> arrayOfTypeLongArrayToString( obj )
            isArrayOfTypeBooleanArray( obj ) -> arrayOfTypeBooleanArrayToString( obj )
            this is Array<*> -> toList().toString()
            this is IntArray -> toList().toString()
            this is LongArray -> toList().toString()
            this is ShortArray -> toList().toString()
            this is FloatArray -> toList().toString()
            this is DoubleArray -> toList().toString()
            this is BooleanArray -> toList().toString()
            this is CharArray -> toList().toString()
            else -> toString()
        }
    } ?: "null"
