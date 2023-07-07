package yc.Data.Linked;


import java.util.Scanner;

/**
 * @author yangcheng <yangcheng03@kuaishou.com>
 * Created on 2023-06-26
 */
public class LRULinkedList<T> {

    private final static Integer DEFAULT_CAPACITY = 10;

    private SNode<T> headNode;

    private Integer length;

    private Integer capacity;

    public LRULinkedList() {
        this.headNode = new SNode<T>();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }

    public LRULinkedList(Integer capacity) {
        this.headNode = new SNode<T>();
        this.capacity = capacity;
        this.length = 0;
    }

    public void add(T data) {
        SNode preNode = findPreNode(data);

        // 链表中存在，删除原数据，再插入到链表的头部
        if (preNode != null) {
            deleteElemOptim(preNode);
            intsertElemAtBegin(data);
        } else {
            if (length >= this.capacity) {
                //删除尾结点
                deleteElemAtEnd();
            }
            intsertElemAtBegin(data);
        }
    }


    /**
     * 删除preNode结点下一个元素
     */
    private void deleteElemOptim(SNode preNode) {
        SNode temp = preNode.getNext();
        preNode.setNext(temp.getNext());
        temp = null;
        length--;
    }


    /**
     * 链表头部插入节点
     */

    private void intsertElemAtBegin(T data) {
        SNode next = headNode.getNext();
        headNode.setNext(new SNode(data, next));
        length++;
    }

    /**
     * 获取查找到元素的前一个结点
     * @param data
     * @return
     */
    public SNode<T> findPreNode(T data) {

        SNode node = headNode;

        while (node.getNext() != null) {
            if (data.equals(node.getNext().getElement())) {
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    public void deleteElemAtEnd() {
        SNode ptr = headNode;
        // 空链表直接返回
        if (ptr.getElement() == null) {
            return;
        }

        // 倒数第二个结点
        while (ptr.getNext().getNext() != null) {
            ptr = ptr.next;
        }

        SNode tmp = ptr.getNext();
        ptr.setNext(null);
        tmp = null;
        length--;
    }

    private void printAll() {
        SNode node = headNode.getNext();
        while (node != null) {
            System.out.print(node.getElement() + ",");
            node = node.getNext();
        }
        System.out.println();
    }


    public class SNode<T> {
        private T element;
        private SNode next;

        public SNode() {
            this.element = element;
        }

        public SNode(T element, SNode next) {
            this.next = next;
            this.element = element;
        }

        public T getElement() {
            return element;
        }

        public SNode getNext() {
            return next;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public void setNext(SNode next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LRULinkedList list = new LRULinkedList();
        Scanner sc = new Scanner(System.in);
        while (true) {
            list.add(sc.nextInt());
            list.printAll();
        }
    }
}
