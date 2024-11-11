class Solution {
    public boolean isPalindrome(String s) {
        String lowerStr = s.toLowerCase();
        
        StringBuilder cleanStr = new StringBuilder();
        
        for(int i = 0; i < lowerStr.length(); i++){
            char c = lowerStr.charAt(i);
            
            if(Character.isLetterOrDigit(c)){
                cleanStr.append(c);
            }
        }
        
        String cleaned = cleanStr.toString();
        String reversed = new StringBuilder(cleaned).reverse().toString();
        
        return cleaned.equals(reversed);
    }
}