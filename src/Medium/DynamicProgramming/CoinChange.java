package Medium.DynamicProgramming;

import java.util.Arrays;

public class CoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins1 = {1,2,5};
		int amount1 = 11;
		System.out.print(coinChange(coins1, amount1));
	}
	
	public static int coinChange(int[] coins, int amount) {
		if(amount <= 0) {
			return 0;
		}
		Arrays.sort(coins);
		int[] ways = new int[1];
		return helper(coins, amount, 0, Integer.MAX_VALUE, 0, ways);
        
    }
	
	public static int helper(int[] coins, int amount, int currTotal, int prevCoin, int currCoin, int[] ways) {
		
		//already visited - Memo
		if(currCoin > prevCoin) {
			return 0;
		}
		
		//gone past
		if(currTotal > amount) {
			return 0;
		}
		
		//exact amount reached
		if(currTotal == amount) {
			ways[0]++;
			return 1;
		}
		
		//need to add more coins - Rec
		for(int i = coins.length-1; i >= 0; --i){
			if(i < coins.length-1) { // not first val
				helper(coins, amount, currTotal + coins[i], coins[i+1], coins[i], ways);
			} else { // first val
				helper(coins, amount, currTotal + coins[i], Integer.MAX_VALUE, coins[i], ways);
			}
		}
		return ways[0];
	}

}
