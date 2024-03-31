class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int [] collisionStats = new int[ asteroids.length ] ;
        int size = -1 ;
        for ( int asteroid : asteroids ) {
            boolean isNegative = asteroid < 0 ;
            int val = asteroid * ((isNegative)?-1:1) ;
            if ( !isNegative || size == -1 || collisionStats[size] < 0 ) collisionStats[++size] = asteroid ;
            else {
                while ( size != -1 && collisionStats[size] > 0 && collisionStats[size] < val ) size-- ;
                if ( size != -1 && collisionStats[size] == val ) size-- ;
                else if ( size == -1 || collisionStats[size] < 0 || collisionStats[size] < val ) collisionStats[++size] = asteroid ;
            }
        }
        size++ ;
        int [] collisionImpact = new int[ size ] ;
        System.arraycopy(collisionStats, 0, collisionImpact, 0, size);
        return collisionImpact ;
    }
}