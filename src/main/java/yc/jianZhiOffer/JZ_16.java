package yc.jianZhiOffer;

public class JZ_16 {
    //输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
    public ListNode Merge(ListNode list1,ListNode list2) {
        //此处创建时需要对其创建一个对象  否则会报错  java.lang.NullPointerException
        //不可写成ListNode head = null；
       ListNode head = new ListNode(0);
       ListNode newList = head;

       if(list1 == null)
           return list2;
       if(list2 == null){
           return list1;
       }

       while(list1 != null && list2 != null){
           if(list1.val <= list2.val){
               newList.next = list1;
               list1 = list1.next;
           }else{
               newList.next = list2;
               list2 = list2.next;
           }
           newList = newList.next;
       }
       if(list1 != null){
           newList.next = list1;
       }
       if(list2 != null){
           newList.next = list2;
       }

       return head.next;
    }
}
