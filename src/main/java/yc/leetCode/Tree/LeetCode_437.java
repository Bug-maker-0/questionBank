package yc.leetCode.Tree;

import java.util.ArrayList;

public class LeetCode_437 {
    /*给定一个二叉树，它的每个结点都存放着一个整数值。
    找出路径和等于给定数值的路径总数。
    路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
    二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。*/
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> list = new ArrayList<>();

    public int pathSum(TreeNode root, int sum) {
        temp(root,sum);
        return result.size();
    }

    public ArrayList<ArrayList<Integer>> temp(TreeNode root,int sum){
        if(root == null)
            return result;
        list.add(root.val);
        sum -= root.val;
        if(sum == 0 && root.left == null && root.right == null)
            result.add(new ArrayList<Integer>(list));
        pathSum(root.left,sum);
        pathSum(root.right,sum);
        list.remove(list.size()-1);
        return result;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode tou = root;
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        TreeNode temp = root.right;
        root = root.left;
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        temp.left = new TreeNode(6);
        temp.right = new TreeNode(7);
        root.right.left = new TreeNode(10);
        temp.left.left = new TreeNode(8);


        LeetCode_437 leetCode_437 = new LeetCode_437();
        int a = leetCode_437.pathSum(root,18);
        System.out.println(a);
    }

}
