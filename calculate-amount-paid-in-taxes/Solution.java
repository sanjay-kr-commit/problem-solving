class Solution {
    public double calculateTax(int[][] brackets, int income) {
        if ( brackets.length == 0 || income == 0 ) return 0 ;
        int reciept = income ;int i = 1 ;
        double taxPayed = ( income > brackets[0][0] ) ? brackets[0][0] : income ;
        taxPayed /= 100 ;
        taxPayed *= brackets[0][1] ;
        reciept -= brackets[0][0] ;
        while ( reciept > 0 && i < brackets.length ) {
            int amountCut = brackets[i][0] - brackets[i-1][0] ;
            double taxCut = ( reciept > amountCut ) ? amountCut : reciept ;
            taxCut /= 100 ;
            taxCut *= brackets[i][1] ;
            taxPayed += taxCut ;
            reciept -= amountCut ;
            i++ ;
        }
        return taxPayed ;
    }
}
