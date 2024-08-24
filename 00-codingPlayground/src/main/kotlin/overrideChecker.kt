val Report.checkListValues : Unit
    get() {
        overrideGenericChecker = { a : Any? ->
            a is List<*> && a.firstOrNull() is String
        } to { a : Any? , b : Any? ->
            val l1 = (a as List<*>).map { it.toString() }
            val l2 = (b as List<*>).map { it.toString() }
            var isEqual = l1.size == l2.size
            var i = 0
            while ( i < l1.size && isEqual ) {
                isEqual = l2.contains( l1[i++] )
            }
            isEqual
        }
    }