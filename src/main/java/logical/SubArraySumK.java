package logical;

/*
Print sub array indexes matching given sum
 */
public class SubArraySumK {
    public static void main(String[] args) {
        int arr[] = { 15, 2, 4, 8, 9, 5, 10, 23 };
        int sum = 23;
        subArraySum(arr, sum);
    }

    static void subArraySum (int[] a, int sum) {
        int currSum = a[0];
        int start=0;
        for (int i=1; i<a.length; i++) {
            // substract from starting when curr sum > sum and add from i pos if not matches to sum
            while (currSum>sum && start<i) {
                currSum = currSum - a[start];
                start++;
            }
            if (sum==currSum) {
                System.out.println("Sub array found from "+start+" to "+(i-1));
                return;
            }
            // This need to be added at the end without any condition as we cant come back to i later
            currSum = currSum+a[i];
        }

        System.out.println("Not found");
    }
}
