fun main() : Unit = captureAndCreateReportLog {

    logTime
    //onlyShowFailed
    cacheTime
    //stopExecutionOnError,
    logStackTrace
//    askForExceptionLo


    Solution() scope {

        String::class.java overrideChecker  { a , b ->
            if ( a is String && b is String ) {
                a == b
            } else false
        }

        "Radiant" logPassReference {
            logCheck {
                predictPartyVictory( "DDRRRR" )
            }
            logCheck {
                predictPartyVictory( "RD" )
            }
        }
        "Dire" logPassReference {
            logCheck {
                predictPartyVictory("RDD")
            }
        }
    }

//    Solution() scope {
//        "12921" logCheck {
//            nearestPalindromic( "12932" )
//        }
//        "99999" logCheck {
//            nearestPalindromic( "99800" )
//        }
//        "12121" logCheck {
//            nearestPalindromic( "12120" )
//        }
//        "1221" logCheck {
//            nearestPalindromic( "1234" )
//        }
//        "1001" logCheck {
//            nearestPalindromic( "999" )
//        }
//        "1001" logCheck {
//            nearestPalindromic( "1000" )
//        }
//        "9" logCheck {
//            nearestPalindromic( "10" )
//        }
//        "1221" logCheck {
//            nearestPalindromic( "1213" )
//        }
//        "121" logCheck {
//            nearestPalindromic("123")
//        }
//        "0" logCheck {
//            nearestPalindromic( "1" )
//        }
//    }

}

infix fun <T> T.scope( scope : T.() -> Unit ) = scope.invoke(this)
