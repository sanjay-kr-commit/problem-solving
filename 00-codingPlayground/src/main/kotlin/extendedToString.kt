val Any?.toString: String
    get() = this?.run {
        when {
            this is Array<*> && this.isArrayOf<IntArray>() -> {
                StringBuilder().apply {
                    append( "[" )
                    (this@toString as Array<IntArray>).forEach {
                        append( it.toList() )
                        append( "," )
                    }
                    append( "]" )
                }.toString()
            }
            this is Array<*> && this.isArrayOf<DoubleArray>() -> {
                StringBuilder().apply {
                    append( "[" )
                    (this@toString as Array<IntArray>).forEach {
                        append( it.toList() )
                        append( "," )
                    }
                    append( "]" )
                }.toString()
            }
            this is Array<*> && this.isArrayOf<FloatArray>() -> {
                StringBuilder().apply {
                    append( "[" )
                    (this@toString as Array<IntArray>).forEach {
                        append( it.toList() )
                        append( "," )
                    }
                    append( "]" )
                }.toString()
            }
            this is Array<*> && this.isArrayOf<ShortArray>() -> {
                StringBuilder().apply {
                    append( "[" )
                    (this@toString as Array<IntArray>).forEach {
                        append( it.toList() )
                        append( "," )
                    }
                    append( "]" )
                }.toString()
            }
            this is Array<*> && this.isArrayOf<LongArray>() -> {
                StringBuilder().apply {
                    append( "[" )
                    (this@toString as Array<IntArray>).forEach {
                        append( it.toList() )
                        append( "," )
                    }
                    append( "]" )
                }.toString()
            }
            this is Array<*> && this.isArrayOf<BooleanArray>() -> {
                StringBuilder().apply {
                    append( "[" )
                    (this@toString as Array<IntArray>).forEach {
                        append( it.toList() )
                        append( "," )
                    }
                    append( "]" )
                }.toString()
            }
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
