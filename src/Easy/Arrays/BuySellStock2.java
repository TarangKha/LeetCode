package Easy.Arrays;

public class BuySellStock2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {1,9,6,9,1,7,1,1,5,9,9,9};
		System.out.println(maxProfit(prices));
	}
	
	public static int maxProfit(int[] prices) {
        int currentBuyPoint = -1;
        int currentSellPoint = -1;
        int buyPoint = -1;
        int sellPoint = -1;
        int bank = 0;
        int p1 = 0;
        //test case
        if (prices.length == 1 || prices.length == 0){
            return 0;
        }
        //test care
        if (prices.length == 2){
            if (prices[1] > prices[0]){
                return prices[1] - prices[0];
            } else {
                return 0;
            }
        }
        //meat
        for (int p2 = 1; p2 < prices.length; p2++,p1++){
            //downslope
            if (prices[p2] < prices[p1]){
                if (buyPoint == -1){  //holding or nothing bought
                    currentBuyPoint = p2; //keep holding till upslope
                } else if (buyPoint != -1){ //found lowest value
                    sellPoint = currentSellPoint; //max of slope
                    bank = bank + (prices[sellPoint] - prices[buyPoint]); //make transaction
                    buyPoint = -1; //reset
                    sellPoint = -1; //reset
                    currentSellPoint = -1; //reset
                    currentBuyPoint = -1; //reset
                }
            }
            //upslope
            if (prices[p2] > prices[p1]){
                if (currentBuyPoint == -1){ //nothing bought yet
                    currentBuyPoint = p1; //new lowest value
                    currentSellPoint = p2; //new highest value
                    buyPoint = currentBuyPoint;
                } else if (currentBuyPoint != -1){ //holding
                    currentSellPoint = p2; //keep holding till downslope
                    buyPoint = currentBuyPoint; //min of slope
                }
                if (p2 == prices.length - 1) { //ends on upslope
                	if (prices[currentSellPoint] > prices[buyPoint]) {
                		bank = bank + (prices[currentSellPoint] - prices[buyPoint]);
                	}
                }
            }
            //horizontal
            if (prices[p2] == prices[p1]){
            	if (p2 == prices.length - 1) { //ends on horizontal
                    if (currentSellPoint == -1 || buyPoint == -1){
                        continue;
                    }
                	if (prices[currentSellPoint] > prices[buyPoint]) {
                		bank = bank + (prices[currentSellPoint] - prices[buyPoint]);
                	}
                }
                continue;
            }
        }
        return bank;
    }
}
