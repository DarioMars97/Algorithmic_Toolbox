class DiscreteKnapsackWithNoRepetitions {

    public static int knapsack(int weight, int[] itemsWeights, int[] itemsValues) {
        int[][] values = new int[itemsWeights.length+1][weight+1];
        for (int i = 0; i < values.length; i++) {
            values[i][0] = 0;
        }
        for (int i = 0; i < values[0].length; i++) {
            values[0][i] = 0;
        }

        for (int i = 1; i < values.length; i++) {
            for (int j = 1; j < values[i].length; j++) {
                values[i][j] = values[i-1][j];
                if (itemsWeights[i-1] <= j) {
                    int val = values[i-1][j-itemsWeights[i-1]]+itemsValues[i-1];
                    if (val > values[i][j]){
                        values[i][j] = val;
                    }
                }
            }
        }

        return values[itemsWeights.length][weight];
    }

    public static void main(String[] args) {
        int[] weights = {6, 3, 4, 2};
        int[] values = {30, 14, 16, 9};
        int result = knapsack(10, weights, values);
        System.out.println(result);
    }
}