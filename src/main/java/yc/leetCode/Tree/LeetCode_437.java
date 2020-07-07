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
        if(root == null)
            return result.size();
        list.add(root.val);
        sum -= root.val;
        if(sum == 0 && root.left == null && root.right == null)
            result.add(new ArrayList<Integer>(list));
        pathSum(root.left,sum);
        pathSum(root.right,sum);
        list.remove(list.size()-1);
        return result.size();
    }

    public static void main(String[] args) {

    }

}
