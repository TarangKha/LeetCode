package Medium.DynamicProgramming;

import java.util.Arrays;

public class CoinChangeLeet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins1 = {1,2,5};
		int amount1 = 100;
		
		int[] coins2 = {2};
		int amount2 = 3;
		
		int[] coins3 = {1,2147483647};
		int amount3 = 2;
		
		int[] coins4 = {186,419,83,408};
		int amount4 = 6249;
		
		int[] coins5 = {1,5,7};
		int amount5 = 10;
				
		System.out.print(coinChangeLeetANS(coins5, amount5));

	}
	
	public static int coinChange(int[] coins, int amount) {
		if(amount <= 0) {
			return 0;
		}
		Arrays.sort(coins);
		int[] minCoins = {Integer.MAX_VALUE};
		int[] recCount = {Integer.MAX_VALUE};
		
		return helper(coins, amount, 0, 0, Integer.MAX_VALUE, 0, minCoins, recCount);
	}
	
	public static int helper(int[] coins, int amount, int currTotal, int numCoins, int prevCoin, int currCoin, int[] minCoins, int[] recCount) {
		if(numCoins > recCount[0]) {
			return -1;
		}
		
		if(currCoin > prevCoin) {
			return -1;
		}
		
		if(currCoin > amount) {
			return -1;
		}
		
		if(currTotal > amount) {
			return -1;
		}
		if(currTotal == amount) {
			return numCoins;
		}
		
		
		int answer = -1;
		for(int i = coins.length-1; i >= 0; i--) {
			if(i < coins.length - 1) { //not first
				answer = helper(coins, amount, currTotal + coins[i], numCoins+1, coins[i+1], coins[i], minCoins, recCount);
			} else { //first time
				answer = helper(coins, amount, currTotal + coins[i], numCoins+1, Integer.MAX_VALUE, coins[i], minCoins, recCount);
			}
			if(answer != -1) {
				if(answer < minCoins[0] && answer > 0) {
					minCoins[0] = answer;
					recCount[0] = minCoins[0];
				}
			}
		}
		if(minCoins[0] == Integer.MAX_VALUE) {
			return -1;
		} else {
			return minCoins[0];
		}
	}
	
	public static int coinChangeLeetANS(int[] coins, int amount) {
        int[] answer = new int[amount + 1];
        answer[0] = 0;
        for(int i=1; i<=amount; i++) answer[i] = Integer.MAX_VALUE;
        for(int coin : coins)
            for(int i=1; i<=amount; i++)
                if(coin <= i)
                    answer[i] = answer[i - coin] != Integer.MAX_VALUE ? Math.min(answer[i], answer[i-coin] + 1) : answer[i];
        return answer[amount] == Integer.MAX_VALUE ? -1 : answer[amount];
    }
}
