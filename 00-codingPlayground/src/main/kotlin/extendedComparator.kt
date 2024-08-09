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

fun isEqual( obj1 : Array<IntArray> , obj2 : Array<IntArray> ) : Boolean {
    if ( obj1.size != obj2.size ) return false ;
    for ( i in obj1.indices) if ( !isEqual( obj1[i],obj2[i] ) ) return false ;
    return true
}

fun isEqual( obj1 : Array<CharArray> , obj2 : Array<CharArray> ) : Boolean {
    if ( obj1.size != obj2.size ) return false ;
    for ( i in obj1.indices) if ( !isEqual( obj1[i],obj2[i] ) ) return false ;
    return true
}

fun isEqual( obj1 : Array<FloatArray> , obj2 : Array<FloatArray> ) : Boolean {
    if ( obj1.size != obj2.size ) return false ;
    for ( i in obj1.indices) if ( !isEqual( obj1[i],obj2[i] ) ) return false ;
    return true
}

fun isEqual( obj1 : Array<LongArray> , obj2 : Array<LongArray> ) : Boolean {
    if ( obj1.size != obj2.size ) return false ;
    for ( i in obj1.indices) if ( !isEqual( obj1[i],obj2[i] ) ) return false ;
    return true
}

fun isEqual( obj1 : Array<DoubleArray> , obj2 : Array<DoubleArray> ) : Boolean {
    if ( obj1.size != obj2.size ) return false ;
    for ( i in obj1.indices) if ( !isEqual( obj1[i],obj2[i] ) ) return false ;
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

fun isEqual( obj1 : TreeNode? , obj2: TreeNode? , level : Int = 0 , nodeIndex : Int = 0 ) : Boolean {
    if ( obj1 == null && obj2 == null ) return true
    if ( obj1 == null || obj2 == null ) {
        println( "Data Mismatch At level : $level , index : $nodeIndex\nnode1 : ${
            obj1?.`val`
        } != node2 : ${obj2?.`val`}" )

        return false
    }
    return (obj1.`val` == obj2.`val`)
        .also {
            if ( !it ) {
                println( "Data Mismatch At level : $level , index : $nodeIndex" )
            }
        } &&
            isEqual( obj1.left , obj2.left , level+1, nodeIndex*2 ) &&
            isEqual( obj1.right , obj2.right , level+1 , (nodeIndex*2)+1 )

}