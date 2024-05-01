class Solution {
    public String reversePrefix(String word, char ch) {
        if(word.length()==0){
            return "";
        }
        StringBuilder s=new StringBuilder();
        for(int i=0;i<word.length();i++){
            if(ch==word.charAt(i)){
                s.append(word.substring(0,i+1));
                s.reverse();
                s.append(word.substring(i+1,word.length()));
                break;
            }
        }
        String ans=(s.length()==0)?word:s.toString();
        return ans;
    }
}