fun isArrayOfTypeIntArray(obj : Any? ) : Boolean = obj is Array<*> && obj.isArrayOf<IntArray>()
fun isArrayOfTypeDoubleArray( obj : Any? ) : Boolean = obj is Array<*> && obj.isArrayOf<DoubleArray>()
fun isArrayOfTypeFloatArray( obj : Any? ) : Boolean = obj is Array<*> && obj.isArrayOf<FloatArray>()
fun isArrayOfTypeBooleanArray( obj : Any? ) : Boolean = obj is Array<*> && obj.isArrayOf<Boolean>()
fun isArrayOfTypeLongArray( obj : Any? ) : Boolean = obj is Array<*> && obj.isArrayOf<LongArray>()
fun isArrayOfTypeShortArray( obj : Any? ) : Boolean = obj is Array<*> && obj.isArrayOf<ShortArray>()
fun isArray(obj : Any? ) : Boolean = obj is Array<*>
fun isIntArray( obj : Any? ) : Boolean = obj is IntArray
fun isDoubleArray( obj : Any? ) : Boolean = obj is DoubleArray
fun isFloatArray( obj : Any? ) : Boolean = obj is FloatArray
fun isBooleanArray( obj : Any? ) : Boolean = obj is BooleanArray
fun isLongArray( obj : Any? ) : Boolean = obj is LongArray
fun isShortArray( obj : Any? ) : Boolean = obj is ShortArray

// extended checker
@Suppress("NAME_SHADOWING")
val Report.addListNodeChecker : Unit
    get() {
        ListNode::class.java overrideChecker { a , b ->
            var isEqual = false
            if ( a is ListNode && b is ListNode ) {
                isEqual = true
                var a = a as ListNode?
                var b = b as ListNode?
                while ( isEqual && a != null && b != null ) {
                    isEqual = a.`val` == b.`val`
                    a = a.next
                    b = b.next
                }
                isEqual = a == null && b == null
            }
            isEqual
        }
    }