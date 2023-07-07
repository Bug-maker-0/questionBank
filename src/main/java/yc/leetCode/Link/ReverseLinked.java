package yc.leetCode.Link;

/**
 * @author yangcheng <yangcheng03@kuaishou.com>
 * Created on 2023-07-06
 */
public class ReverseLinked {

    public static ListNode reverseList(ListNode head) {
        if(head.next == null || head.next.next == null){
            return head;
        }


        ListNode cur = head;
        ListNode pre = null;
        ListNode tmp;

        /**
         * while判断不能用cur.next != null，否者会导致最后一个节点无法反转
         */

        while(cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        /**
         * return 不能使用cur，使用cur，在最后一步 cur被赋值为 tmp = cur.next,导致只返回最后一节点的值
         *
         */
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                            new ListNode(2,
                                    new ListNode(3,
                                            new ListNode(4,
                                                new ListNode(5, null)))));

        reverseList(head);

        System.out.println();
    }



     public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

}
