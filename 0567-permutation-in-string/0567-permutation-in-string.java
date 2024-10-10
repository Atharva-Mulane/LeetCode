class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        
        if (m < n) return false;
        
        // Frequency array for s1
        int[] map1 = new int[26];
        // Fill the frequency array for s1
        for (int i = 0; i < n; i++) {
            map1[s1.charAt(i) - 'a']++;
        }
        
        // Frequency array for the sliding window in s2
        int[] map2 = new int[26];
        
        // Initial window
        for (int i = 0; i < n; i++) {
            map2[s2.charAt(i) - 'a']++;
        }
        
        // Compare the first window
        if (isMatched(map1, map2)) return true;
        
        // Slide the window over s2
        for (int i = n; i < m; i++) {
            // Add the new character to the current window
            map2[s2.charAt(i) - 'a']++;
            // Remove the old character from the current window
            map2[s2.charAt(i - n) - 'a']--;
            
            // Check if the current window matches
            if (isMatched(map1, map2)) return true;
        }
        
        return false;
    }
    
    // Function to check if two frequency arrays match
    private boolean isMatched(int[] map1, int[] map2) {
        for (int i = 0; i < 26; i++) {
            if (map1[i] != map2[i]) return false;
        }
        return true;
    }
}
