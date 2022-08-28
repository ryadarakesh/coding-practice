package dynamicprogramming;

import java.util.Arrays;
import java.util.Comparator;

public class DPNonOverlappingJobsMaxProfit {

    public static void main(String[] args) {
        Job[] jobs = new Job[6];
        jobs[0] = new Job(1,4,3);
        jobs[1] = new Job(2,6,5);
        jobs[2] = new Job(4,7,5);
        jobs[3] = new Job(6,8,11);
        jobs[4] = new Job(5,9,7);
        jobs[5] = new Job(7,10,13);
        System.out.println(getMaxProfit(jobs));
    }

    static int getMaxProfit (Job[] jobs) {
        /*
            Here we sort jobs based on their finish time and for each position starting with 1 we try to compare what non colliding combination gives max profit
            By the time we come to poition 3 calculation we already have max profits for 0,1 & 2 hence we need to consider
            via either of the position which gives max profit with current job
         */
        Arrays.sort(jobs, Comparator.comparing(Job::getEndTime));
        int[] maxProfits = new int[jobs.length];
        maxProfits[0] = jobs[0].profit;
        for (int i = 1; i < jobs.length; i++) {
            maxProfits[i] = jobs[i].profit;
            for (int j = 0; j < i; j++) {
                if (jobs[j].endTime <= jobs[i].startTime) {
                    // We need to hold the max value of profit when we add current profit to either of the previously calculate max profits
                    maxProfits[i] = Math.max(maxProfits[i], jobs[i].profit + maxProfits[j]);
                }
            }
        }
        int max=maxProfits[0];
        for (int i=1; i< maxProfits.length; i++) {
           if (max<maxProfits[i]) {
               max = maxProfits[i];
           }
        }
        return max;
    }

    static class Job {
        int startTime;
        int endTime;
        int profit;

        public Job(int startTime, int endTime, int profit) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }

        public int getStartTime() {
            return startTime;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }

        public int getProfit() {
            return profit;
        }

        public void setProfit(int profit) {
            this.profit = profit;
        }
    }
}
