
public class MergeKLists {
    public static void main(String[] args) {
        
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

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