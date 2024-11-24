class Solution {
    public int maxArea(int[] height) {
        int area = 0;
        int a = 0;
        int b = height.length - 1;
        
        while(a < b){
            if(height[a] < height[b]){
                area = Math.max(area,height[a] * (b - a));
                    a++;
            }else{
                area = Math.max(area, height[b] * (b - a));
                b--;
            }
        }
        return area;
    }
}