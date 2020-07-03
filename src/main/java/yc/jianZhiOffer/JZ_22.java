package yc.jianZhiOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class JZ_22 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if(root == null)
            return arrayList;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        //offer是在队列的末尾添加元素
        queue.offer(root);
        //队列不为空循环继续
        while(!queue.isEmpty()){
            //poll()方法是访问队头元素并去除
            TreeNode temp =  queue.poll();
            arrayList.add(temp.val);
            if(temp.left != null){
                queue.offer(temp.left);
            }
            if(temp.right != null){
                queue.offer(temp.right);
            }
        }
        return arrayList;
    }


    public static void main(String[] args) {
        TreeNode treeNode =  new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        JZ_22 jz_22 = new JZ_22();
        ArrayList<Integer> arrayList = jz_22.PrintFromTopToBottom(treeNode);
        for (int i:arrayList
             ) {
            System.out.println(i);
        }

    }
}
