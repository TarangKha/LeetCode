package Medium.Misc;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test1 = {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea2(test1));
	}
	
	public static int maxArea(int[] height) {
		int maxArea = 0;
		for(int i = 0; i < height.length; i++) {
			for(int j = 0; j < height.length; j++) {
				if(j <= i) {
					continue;
				}
				int length = Math.min(height[i], height[j]);
				int width = j - i;
				int area = length*width;
				if(area > maxArea) {
					maxArea = area;
				}
			}
		}
		return maxArea;
	}
	
	public static int maxArea2(int[] height) {
		int maxArea = 0;
		int p1 = 0;
		int p2 = height.length-1;
		while(p1 < p2) {
			int length = Math.min(height[p1], height[p2]);
			int width = p2 - p1;
			maxArea = length*width > maxArea ? length*width : maxArea;
			if(height[p1] < height[p2]) {
				p1++;
			} else {
				p2--;
			}
		}
		return maxArea;
	}

}
