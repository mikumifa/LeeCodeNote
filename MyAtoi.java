public class MyAtoi{
    public static void main(String[] args) {
    }
}
/*class Solution {
    public int myAtoi(String s) {
        int beginPos=0,i;
        for(i=0; i<s.length(); i++) {
            if(s.charAt(i) != ' ') {
                beginPos=i;
                break;
            }
        }
        if(i==s.length())
            return 0; 
        int sign;
        if(s.charAt(beginPos)=='+'){
            sign=1;beginPos++;
        }else if(s.charAt(beginPos)=='-'){
            sign=-1; beginPos++;
        }
        else{
            sign=1;
        }
        long ans=0;
        for(i=beginPos; i<s.length(); i++) {
            if(s.charAt(i)<'0'||s.charAt(i)>'9')
             break;
             ans=ans*10+s.charAt(i)-'0';
             if(ans-1>Integer.MAX_VALUE)
             break;
        }
        ans=sign*ans;
        if(ans>Integer.MAX_VALUE&&sign==1)
        {
            return Integer.MAX_VALUE;
        }else if(ans<Integer.MIN_VALUE&&sign==-1)
        {
            return Integer.MIN_VALUE;
        }
        return (int)ans;
    }
}*/