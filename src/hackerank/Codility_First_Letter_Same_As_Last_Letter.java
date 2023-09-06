package hackerank;

/**
Initially, string S of length N is given. Then N-1 operations are applied to it: move the first letter of S to the end. How many times is the first letter of S the same as the last letter?
For example, given S = "abbaa", the obtained sequence of strings is:
abbaa →→bbaaa → baaab →→→ aaabb →→ aabba
Three of them have the same first and last letter.
Write a function:
class Solution { public int solution (String S); }
that, given a string S of length N, consisting of letters 'a' and/or 'b', returns the number of times the first letter is the same as the last in the obtained sequence of strings.
Examples:
1. Given S = "abbaa", the function should return 3, as described above.
2. Given S = "aaaa", the function should return 4. The first and last letters are always the same.
3. Given S = "abab", the function should return 0. The first and last letters are always different.
 **/

class Codility_First_Letter_Same_As_Last_Letter {
    public static int solution(String S) {
        int count = 0;
        String s_temp = S;
        if(S.length() < 2){
            return count;
        }
        else {
            for(int i = 0; i< S.length()-1; i++){
                if((s_temp.substring(0,1)).equals(s_temp.substring(s_temp.length()-1))){
                    count++;
                }
                s_temp = s_temp.substring(1) + s_temp.substring(0,1);
                if(i == (S.length()-2)) {
                	if((s_temp.substring(0,1)).equals(s_temp.substring(s_temp.length()-1)))
                	{
                        count++;
                	}
                }
            }
        }
        return count;
    }
 
    public static void main(String[] args) {
    	String S = "aaaa";
		
		int numOfTimes = solution(S);
		
		System.out.println("Final: " + numOfTimes);
	}

}
