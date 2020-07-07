package yc.jianZhiOffer;

public class JZ_25 {
    /*输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点）
    ，请对此链表进行深拷贝，并返回拷贝后的头结点。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）*/


    //方法1、原地修改  方法2、哈希的做法
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null)
            return null;

        //1、首先复制原链表的每个元素  把 1'放在1后面
        RandomListNode pNext = pHead;
        while(pNext != null){
            RandomListNode cloneNode = new RandomListNode(pNext.label);
            RandomListNode pTemp = pNext.next;
            pNext.next = cloneNode;
            cloneNode.next = pTemp;
            pNext = pTemp;
        }

        //2、重新遍历链表吗，复制老结点的随机指针给新结点  如 A1.random = A.random.next;
        pNext = pHead;
        while(pNext != null){
            pNext.next.random = pNext.random == null ? null : pNext.random.next;
            pNext = pNext.next.next;
        }

        //3、拆分链表，将链表拆分为原链表和复制后的链表
        RandomListNode pHeadClone = pHead.next;
        pNext = pHead;
        while(pNext != null){
            RandomListNode cloneNode = pNext.next;
            pNext.next = cloneNode.next;
            cloneNode.next = pNext.next == null ? null : cloneNode.next.next;
            pNext = pNext.next;
        }

        return pHeadClone;
    }
}
