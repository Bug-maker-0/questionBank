package yc.leetCode.Tree;

import java.util.LinkedList;
import java.util.List;

public class LeetCode_94 {
    //给定一个二叉树，返回它的中序 遍历。
    //进阶: 递归算法很简单，你可以通过迭代算法完成吗？
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> tree = new LinkedList<>();
        temp(root,tree);
        return tree;
    }

    public void temp(TreeNode root,List list){
        if(root != null){
            temp(root.left,list);
            list.add(root.val);
            temp(root.right,list);
        }
    }
}
