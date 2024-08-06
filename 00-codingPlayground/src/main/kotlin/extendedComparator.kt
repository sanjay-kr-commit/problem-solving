fun <T:Comparable<T>> isEqual( obj1 : T , obj2 : T ) : Boolean = obj1 == obj2

fun <T:Comparable<T>> isEqual(obj1 : List<T>, obj2 : List<T> ) : Boolean {
    if ( obj1.size != obj2.size ) return false ;
    for ( i in obj1.indices) if ( obj1[i] != obj2[i] ) return false ;
    return true
}

fun <T:Comparable<T>> isEqual( obj1 : Array<T> , obj2 : Array<T> ) : Boolean {
    if ( obj1.size != obj2.size ) return false ;
    for ( i in obj1.indices) if ( obj1[i] != obj2[i] ) return false ;
    return true
}

fun  isEqual( obj1 : CharArray , obj2 : CharArray ) : Boolean {
    if ( obj1.size != obj2.size ) return false ;
    for ( i in obj1.indices) if ( obj1[i] != obj2[i] ) return false ;
    return true
}

fun  isEqual( obj1 : IntArray , obj2 : IntArray ) : Boolean {
    if ( obj1.size != obj2.size ) return false ;
    for ( i in obj1.indices) if ( obj1[i] != obj2[i] ) return false ;
    return true
}

fun  isEqual( obj1 : LongArray , obj2 : LongArray ) : Boolean {
    if ( obj1.size != obj2.size ) return false ;
    for ( i in obj1.indices) if ( obj1[i] != obj2[i] ) return false ;
    return true
}

fun  isEqual( obj1 : FloatArray , obj2 : FloatArray ) : Boolean {
    if ( obj1.size != obj2.size ) return false ;
    for ( i in obj1.indices) if ( obj1[i] != obj2[i] ) return false ;
    return true
}

fun  isEqual( obj1 : DoubleArray , obj2 : DoubleArray ) : Boolean {
    if ( obj1.size != obj2.size ) return false ;
    for ( i in obj1.indices) if ( obj1[i] != obj2[i] ) return false ;
    return true
}

fun isEqual( obj1 : TreeNode? , obj2: TreeNode? ) : Boolean {
    if ( obj1 == null && obj2 == null ) return true
    if ( obj1 == null || obj2 == null ) return false
    return obj1.`val` == obj2.`val` && isEqual( obj1.left , obj2.left ) && isEqual( obj1.right , obj2.right )
}