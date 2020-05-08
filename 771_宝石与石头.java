//1 
class Solution {
    public int numJewelsInStones(String J, String S) {
        int res = 0;
        for(int i = 0; i < J.length(); ++i){
            for(int j = 0; j < S.length(); ++j){
                if(J.charAt(i) == S.charAt(j)){
                    ++res;
                }
            }
        }
        return res;
    }
}


//2
class Solution {
    public int numJewelsInStones(String J, String S) {
        int res = 0;
        for(int i = 0; i < S.length(); ++i){
            if(J.indexOf(S.charAt(i)) != -1){
                ++res;
            }
        }
        return res;
    }
}