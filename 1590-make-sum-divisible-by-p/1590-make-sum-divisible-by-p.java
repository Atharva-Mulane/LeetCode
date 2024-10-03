import java.util.HashMap;

class Solution {
    public int minSubarray(int[] nums, int p) {
        long sm = 0;
        for (int num : nums) {
            sm += num;
        }

        int n = nums.length;
        if (sm % p == 0) 
            return 0;
        
        int r = (int) (sm % p); // remainder we need to match
        int s = 0;
        int res = n;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        map.put(0, -1);
        
        for (int i = 0; i < n; i++) {
            s = (s + nums[i]) % p;
            
            if (s < 0) {
                s += p;
            }

            int target = (s - r + p) % p;
            if (map.containsKey(target)) {
                res = Math.min(res, i - map.get(target));
            }
            map.put(s, i);
        }
        return res < n ? res : -1;
    }
}
