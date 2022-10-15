package java;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public int myAtoi(String s) {
        //找到开头的元素，可能找不到。
        int beginPos=0,i;
        for(i=0; i<s.length(); i++) {
            if(s.charAt(i) != ' ') {
                beginPos=i;
                break;
            }
        }
        if(i==s.length())
            return 0; //找不到就是0
        //确定符号
        int sign;
        if(s.charAt(beginPos)=='+'){
            sign=1;beginPos++;
        }else if(s.charAt(beginPos)=='-'){
            sign=-1; beginPos++;
        }
        else{
            sign=1;
        }
        //
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
    //23
    public ListNode mergeKLists(ListNode[] lists) {
        //链表接到一起
        if(lists.length==0)
            return null;
        //多次遍历，把每次最小的遍历到上面
        ListNode ansHeader=new ListNode(0,null);
        ListNode ansTailer=ansHeader;
        while(true){
            ListNode minNode=null;        
            for(var list:lists){
                if(list==null)
                    continue;
                if(minNode==null||minNode.val>list.val)
                {
                    minNode=list;
                }
            }
            if(minNode==null)
                break;
            ansTailer.next=minNode;
            ansTailer=ansTailer.next;
            for(int i=0;i<lists.length;i++){
                if(lists[i]==minNode)
                    lists[i]=lists[i].next;
            } 
        }
        return ansHeader.next;
     }
/*
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * 
 */
public int strStr(String haystack, String needle) {
}
}