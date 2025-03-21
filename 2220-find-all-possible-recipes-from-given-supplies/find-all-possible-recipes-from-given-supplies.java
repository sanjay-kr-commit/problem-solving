import java.util.*;

class Solution {

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashMap<String,List<String>> ingredientsMap = new HashMap<>();
        for ( int i = 0 ; i < recipes.length ; i++ ) {
            ingredientsMap.putIfAbsent(recipes[i], ingredients.get(i));
        }
        return findAllRecipes(
                new HashSet<>(Arrays.asList(recipes)) , ingredientsMap , new HashSet<>(Arrays.asList(supplies))
        ) ;
    }

    List<String> findAllRecipes( HashSet<String> recipes , HashMap<String,List<String>> ingredientsMap, HashSet<String> supplies) {
        HashSet<String> result = new HashSet<>() ;
        for ( String recipe : recipes ) {
            canThisRecipeBeBuilt(
                    recipe , recipes , new HashSet<>() , ingredientsMap , supplies , result
            ) ;
        }
        return result.stream().toList() ;
    }

    boolean canThisRecipeBeBuilt( String recipe , HashSet<String> recipes , HashSet<String> visited , HashMap<String,List<String>> ingredientsMap , HashSet<String> supplies , HashSet<String> alreadyBuilt ) {
        if ( visited.contains( recipe ) ) return alreadyBuilt.contains( recipe ) ;
        visited.add( recipe ) ;
        if ( alreadyBuilt.contains( recipe ) ) return true ;
        if ( !ingredientsMap.containsKey( recipe ) ) return false;
        for ( String ingredient : ingredientsMap.get(recipe) ) {
            if ( supplies.contains( ingredient ) ) continue;
            if ( recipes.contains( ingredient ) && canThisRecipeBeBuilt(
                    ingredient , recipes , visited , ingredientsMap , supplies , alreadyBuilt
            ) ) continue;
            return false ;
        }
        alreadyBuilt.add( recipe ) ;
        return true ;

    }
}