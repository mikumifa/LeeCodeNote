# LeeCodeNote



```java
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
}
```

涉及复杂的流程以及条件情况，容易写出错误代码。使用自动机概念，每次获取数据，实现状态的改变，为每个状态写一个子函数。

![fig1](README.assets/fig1.png)

## [23. 合并K个升序链表 - 力扣（LeetCode）](https://leetcode.cn/problems/merge-k-sorted-lists/)

```java
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        //链表接到一起
        if(lists.length==0)
            return null;
        //多次遍历，把每次最小的遍历到上面
        ListNode ansHeader=new ListNode(0,null);
        ListNode ansTailer=ansHeader;
        while(true){
            int minNum=Integer.MAX_VALUE;          
            for(var list:lists){
                if(list==null)
                    continue;
                minNum=Math.min(list.val, minNum);
            }

            if(minNum==Integer.MAX_VALUE)//全都null
                break;
            for(int i=0;i<lists.length;i++){
                 if(lists[i]==null)
                    continue;
                if(lists[i].val==minNum)
                {
                    ansTailer.next=new ListNode(minNum,null);
                    ansTailer=ansTailer.next;
                    lists[i]=lists[i].next;
                }
            }
        }
                    return ansHeader.next;
    }
}
```

```java
class Solution {
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
}
```

