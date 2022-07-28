package logical;

public class StockBuySell {

    public static void main(String[] args) {
        int price[] = { 100, 180, 260, 310,40, 535, 695 };
        System.out.println(multiBuyStockProfit(price));
        int price1[] = {7,1,5,3,6,4};
        System.out.println(multiBuyStockProfit(price1));
        int price2[] = {8,6,4,2,1};
        System.out.println(multiBuyStockProfit(price2));

        int prices[] = { 7, 1, 5, 6, 4 };
        System.out.println(singleBuyStockProfit(prices));
    }

    public static int multiBuyStockProfit(int[] prices) {
        int i=0;
        int profit=0;
        while (i<prices.length) {
            while (i<prices.length-2 && prices[i]>=prices[i+1]) {
                i++;
            }
            int buyAt = i++;
            if (i >= prices.length-1) {
                break;
            }
            while (i<prices.length-1 && prices[i]<=prices[i+1]) {
                i++;
            }
            if (i> prices.length-1) {
             break;
            }
            int sellAt = i++;

            profit+=(prices[sellAt]-prices[buyAt]);
        }
        return profit;
    }

    public static int singleBuyStockProfit(int[] prices) {
        int bestBuy=prices[0];
        int maxProfit=0;
        for (int i = 1; i < prices.length; i++) {
            if (bestBuy > prices[i]) {
                bestBuy = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - bestBuy);
            }
        }
        return maxProfit;
    }
}
