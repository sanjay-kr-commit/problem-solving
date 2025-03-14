import java.awt.Color
import kotlin.math.min

infix fun <E> List<E>.groupInto(n : Int ) : List<List<E>> = ArrayList<List<E>>() . apply {
    var toAdd = ArrayList<E>(n)
    this@groupInto.forEach {
        toAdd.add( it )
        if ( toAdd.size == n ) {
            add( toAdd )
            toAdd = ArrayList(n)
        }
    }
    if ( toAdd.size > 0 ) add( toAdd )
}

fun <E> List<List<E>>.appendResult( vararg expected : E ) : List<List<E>> = appendResult( expected.toList() )

infix fun <E> List<List<E>>.appendResult( expected : List<E> ) : List<List<E>> = ArrayList<List<E>>() . apply {
    for ( i in 0 until min( this@appendResult.size , expected.size ) ) {
        val toAdd : ArrayList<E> = this@appendResult[i] as ArrayList
        toAdd.add( expected[i] )
        add( toAdd )
    }
}

fun List<String>.argumentSignature(vararg serializerLambda : (String) -> Any ) : List<Any> = ArrayList<Any>() . apply {
    for ( i in 0 until serializerLambda.size.coerceAtMost(this@argumentSignature.size)) {
        add( serializerLambda[i]( this@argumentSignature[i] ) )
    }
}

fun ignore(received : Any ) : Any = received
fun unquote(received: String) : Any = received.let {
    it.substring( 1 , it.length-1)
}
fun int( received: String ) : Any = received.toInt()
fun long( received: String ) : Any = received.toLong()
fun bool( received: String ) : Any = received.toBoolean()
fun intArray( received: String ) : Any = received.substring( 1 , received.length-1 )
        .split(",")
        .map {
            it.toInt()
        }.toIntArray()

fun String.array( serializedType : (String) -> Any ) : Array<Any> = substring( 1 , length-1 ).let {
    val arrayNesting = it.contains("]")
    var size : Int
    val list = it.split(
        if ( arrayNesting ) "]," else ","
    ).also { size = it.size-1 }
        .let {
            if ( arrayNesting ) it.mapIndexed { index, s ->
                if ( index == size ) serializedType( s )
                else serializedType( "$s]" )
            } else it.map {
                serializedType(it)
            }
        }
    Array(list.size) {
        list[it]
    }
}

fun longArray( received: String ) : Any = received.substring( 1 , received.length-1 )
    .split(",")
    .map {
        it.toLong()
    }.toLongArray()


fun String.testcase() : List<String> = ArrayList<String>().apply {
    split("\n").forEach {
        if ( it.isNotEmpty() ) add( it )
    }
}

inline fun <T> Iterable<T>.forEach(vararg executionOrder : Int, action: (T) -> Unit): Unit {
    var count = -1
    executionOrder.forEach {
        println( "\u001B[33mindex $it ran\u001B[0m" )
        action(this.elementAt(it))
    }
    for (element in this) {
        count++
        if ( executionOrder.contains(count) ) continue
        println( "\u001B[33mindex $count ran\u001B[0m" )
        action(element)
    }
}

data class Indexer(
    private var index : Int = 0
) {
    val Any.index : Any
        get() =
            if ( this is ColoredOutput<*> )
                index = this@Indexer.index++
            else ColoredOutput( this , index = this@Indexer.index++ )

}

fun indexer( indexerBlock : Indexer.() -> Unit ) : Unit = Indexer().indexerBlock()

data class ColoredOutput<T>(
    val data : T ,
    var showDifference : Boolean = false ,
    var index : Int? = null
) {

    private var _ifIncorrect_ : (()->Unit)? = null

    var ifIncorrect : () -> Unit
        get() {
            if ( _ifIncorrect_ == null ) throw Exception( "Null Access" )
            return _ifIncorrect_!!
        }
        set(value) {
            _ifIncorrect_ = value
        }

    override fun toString(): String {
        return data.toString()
    }
}

fun <T> T.showDifference() : ColoredOutput<*> {
    if ( this is ColoredOutput<*> ) {
        showDifference = true
        return this
    }
    return ColoredOutput( data = this , showDifference = true )
}

fun <T> T.ifIncorrect( executionBlock : () -> Unit ) : ColoredOutput<*> {
    if ( this is ColoredOutput<*> ) {
        ifIncorrect = executionBlock
        return this
    }
    return ColoredOutput( data = this ).apply {
        ifIncorrect = executionBlock
    }
}

fun <T,E> T.coloredOutput(
    other : E
) : String {
    val isEqual =
        if ( this is ColoredOutput<*> ) this@coloredOutput.data == other
        else this@coloredOutput == other
    val st = StringBuilder( "${
        if (isEqual) "\u001b[32m"
        else "\u001b[31m" }$this\u001b[0m" )
    if ( this is ColoredOutput<*> ) {
        if ( !isEqual ) ifIncorrect.invoke()
        if ( showDifference && !isEqual ) {
            val buffer = st.toString()
            st.clear()
            st.append("\u001B[32mExpected : $other\u001B[0m\n")
            st.append("\u001B[31mReceived : \u001B[0m")
            st.append(buffer)
        }
        if ( index != null ) {
            val buffer = st.toString()
            st.clear()
            st.append( "\u001B[33mindex $index \u001B[0m\n" )
            st.append(buffer)
        }
    }
    return st.toString()
}

fun <R> timeTaken(observableScope : () -> R ) : R {
    val startTime = System.currentTimeMillis()
    val returnedObj : R = observableScope.invoke()
    val endTime = System.currentTimeMillis()
    println( "Time Taken : ${endTime-startTime} millisecond" )
    return returnedObj
}

infix fun <R> R.capture(observableScope : (R ) -> Unit ) : Unit = observableScope.invoke(this)

fun heapToTree( head : Array<Int?> , index : Int = 0 ) : TreeNode? = when {
    index >= head.size || head[index] == null -> null
    else -> TreeNode( head[index]!! ).apply {
        left = heapToTree( head , (index*2)+1 )
        right = heapToTree( head , (index*2)+2 )
    }
}

fun heapToTree( vararg nodes : Int? ) : TreeNode? = heapToTree(
    arrayOf( *nodes )
)

private fun TreeNode?.count( level : Int = 0 ) : Int = when {
    this == null -> 0
    else -> {
        var current = 1
        repeat( level ) { current *= 2 }
        val left = left.count( level+1 )
        val right = right.count( level+1 )
        current + if ( left > right ) left else right
    }
}

private fun TreeNode?.recursiveAdd( heap : Array<Int?> , index : Int = 0 ) {
    this?.run {
        heap[index] = `val`
        left.recursiveAdd( heap , index*2+1 )
        right.recursiveAdd( heap , index*2+2 )
    }
}

private inline fun <reified T> Array<T?>.trimNullSuffix() : Array<T?> {
    var i = size-1
    while ( get( i ) == null ) i--
    i++
    val trimmedArray = Array<T?>(i){null}
    for ( j in 0 until i ) trimmedArray[j] = get(j)
    return trimmedArray
}

fun TreeNode?.transformToHeap() : Array<Int?> {
    val heap = Array<Int?>( count() ) { null }
    recursiveAdd( heap )
    return heap.trimNullSuffix()
}

val IntArray.asList : ListNode?
    get() {
        val dummy = ListNode()
        var current = dummy
        forEach { i ->
            current = current.let { node ->
                node.next = ListNode().apply {
                    `val` = i
                }
                node.next
            }
        }
        return dummy.next
    }

val ListNode?.toArray : IntArray
    get() = _toArray_()

private fun ListNode?._toArray_( size : Int = 0 ) : IntArray = this?.let { node ->
    node.next._toArray_( size+1 ).apply {
        set( size , node.`val` )
    }
} ?: IntArray(size)

val Int.fibonacciWithoutDP : Long
    get() {
        if ( this < 2 ) return this.toLong()
        print( "\r$this   " )
        return (this-1).fibonacciWithoutDP + (this-2).fibonacciWithoutDP
    }

private fun Int._fibonacci_( cache : LongArray = LongArray(this){-1} ): Long {
    if ( this < 2 ) return this.toLong()
    if ( cache[this-1] != -1L ) {
        return cache[this-1]
    }
    val fib = (this-1)._fibonacci_(cache) + (this-2)._fibonacci_(cache)
    cache[this-1] = fib
    return fib
}

val Int.fibonacci : Long
    get() = this._fibonacci_()

fun <T:Comparable<T>> T.check( obj : T ) : Boolean = this == obj

val <T> T.log : T
    get()  {
        println( this )
        return this
    }

fun <T:Comparable<T>> T.logCheck( obj: T  ) : T {
    val red = "\u001b[31m"
    val green = "\u001b[32m"
    val reset = "\u001b[0m"
    val isEqual = this == obj
    if ( isEqual ) println("${green}$this$reset")
    else {
        println("${green}Expected : $obj$reset"  )
        println("${red}Received : $this$reset")
    }
    return this
}

fun <T> T.logCheck( obj: T , comparableBlock : ( T , T ) -> Boolean ) : T {
    val red = "\u001b[31m"
    val green = "\u001b[32m"
    val reset = "\u001b[0m"
    val isEqual = comparableBlock( this , obj )
    if ( isEqual ) println("${green}$this$reset")
    else {
        println("${green}Expected : $obj$reset"  )
        println("${red}Received : $this$reset")
    }
    return this
}


fun createReport( reportBlock : Report.() -> Unit ) {
    Report().also(reportBlock)
}

fun captureAndCreateReport( reportBlock: Report.() -> Unit ) = Report().run {
    val startTime = System.nanoTime()
    reportBlock()
    val endTime = System.nanoTime()
    println()
    if ( logAtExit ) logReport
    if ( !isNanoSecondPrecisionEnable ) println("Net Time Taken : ${((endTime / 1e6) - (startTime / 1e6)).toLong()} milliseconds")
    else println("Net Time Taken : ${endTime - startTime} nanoseconds")
}

fun captureAndCreateReportLog( reportBlock: Report.() -> Unit ) = Report().run {
    val startTime = System.nanoTime()
    reportBlock()
    val endTime = System.nanoTime()
    println()
    logReport
    if ( !isNanoSecondPrecisionEnable ) println("Net Time Taken : ${((endTime / 1e6) - (startTime / 1e6)).toLong()} milliseconds")
    else println("Net Time Taken : ${endTime - startTime} nanoseconds")
}

val Int.tree : TreeNode
    get() = TreeNode( this )

infix fun Int.tree( block : TreeNode.() -> Unit ) : TreeNode = TreeNode( this ).also(block)

val List<Int>.toListNode : ListNode?
    get() {
        val dummyHead = ListNode()
        var temp = dummyHead
        forEach {
            temp.next = ListNode( it )
            temp = temp.next
        }
        return dummyHead.next
    }

fun listNodeOf( vararg node : Int ) : ListNode {
    val dummyNode = ListNode()
    var curr = dummyNode
    node.forEach {
        curr.next = ListNode( it )
        curr = curr.next
    }
    return dummyNode.next
}

inline infix fun <T> Class<T>.open( lambda : T.() -> Unit ) : Unit = ( getConstructor().newInstance() as T ).lambda()
inline infix fun String.open(lambda: Any.() -> Unit ) : Unit = Class.forName(this).getConstructor().newInstance().lambda()