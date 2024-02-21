class Solution {
    public String mergeAlternately(String word1, String word2) {
        char[] ch = new char[word1.length()+ word2.length()];
        int idx1=0,i=0,idx2=0; 
        while(i< ch.length){
            if(idx1<word1.length()) ch[i++]=  word1.charAt(idx1++);

            if(idx2 <word2.length()) ch[i++]=  word2.charAt(idx2++); 
        }
        
        return String.valueOf(ch);
    }
}