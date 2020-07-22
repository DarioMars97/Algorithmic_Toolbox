import java.util.Arrays;

/**
 * DiscreteKnapsackWithRepetitions
 */
public class DiscreteKnapsackWithRepetitions {

    public static int repetitiveDiscreteKnapsackMaxValue(int KSWeight, int[] itemsValues, int[] itemsWeights){
        if (KSWeight <= 0) {
            return 0;
        }

        int[] values = new int[KSWeight+1];
        Arrays.fill(values, 0);

        for (int i = 1; i < KSWeight+1; i++) {
            for (int j = 0; j < itemsWeights.length; j++) {
                if (i >= itemsWeights[j]) {
                    // i is the current weight in the knapsack,
                    // if we now calculating which items fit in weight 5 as example 
                    // so for items of weight 2, 4 and 5 i get the value i put in values[ 5 -5 ] and
                    // values[ 5 - 4 ] and values[ 5 - 2 ] then add each one i get to value that item has.
                    // and put the max of all of them to the values[i]
                    values[i] = Math.max(values[i], values[i-itemsWeights[j]] + itemsValues[j]);
                }
            }
        }
        return values[KSWeight];
    }

    public static void main(String[] args) {
        int[] weights = {6, 3, 4, 2};
        int[] values = {30, 14, 16, 9};
        int result = repetitiveDiscreteKnapsackMaxValue(10, values, weights);
        System.out.println(result);
    }
}