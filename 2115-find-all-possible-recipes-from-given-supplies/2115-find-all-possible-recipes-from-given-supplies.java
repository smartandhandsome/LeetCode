class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, Integer> recipeToIndex = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {
            recipeToIndex.put(recipes[i], i);
        }

        Set<String> suppliesSet = new HashSet<>(Arrays.asList(supplies));
        Set<String> canMake = new HashSet<>();


        Queue<String> q = new ArrayDeque<>();
        Map<String, List<String>> graph = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {
            if (suppliesSet.containsAll(ingredients.get(i))) {
                q.add(recipes[i]);
                canMake.add(recipes[i]);
            }

            for (String ing : ingredients.get(i)) {
                if (suppliesSet.contains(ing)) {
                    continue;
                }
                if (!graph.containsKey(ing)) {
                    graph.put(ing, new ArrayList<>());
                }
                graph.get(ing).add(recipes[i]);

            }
        }

        while (!q.isEmpty()) {
            String r = q.poll();
            List<String> next = graph.get(r);
            if (next == null || next.isEmpty()) {
                continue;
            }
            suppliesSet.add(r);
            for (String recipe : next) {
                List<String> ing = ingredients.get(recipeToIndex.get(recipe));
                if (suppliesSet.containsAll(ing)) {
                    q.add(recipe);
                    suppliesSet.add(recipe);
                    canMake.add(recipe);
                }
            }
        }
        return new ArrayList<>(canMake);
    }
}