package yc.jianZhiOffer;

import java.util.ArrayList;

public class JZ_24 {
    /*输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
    路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。*/

    private ArrayList<ArrayList<Integer>>  result = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root == null)
            return result;
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null)
            result.add(new ArrayList<Integer>(list));
        FindPath(root.left,target);
        FindPath(root.right,target);
        list.remove(list.size()-1);
        return result;
    }

    public int pathSum(TreeNode root,int sum){

        ArrayList<ArrayList<Integer>> path = FindPath(root,sum);
        return result.size();
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

        JZ_24 jz_24 = new JZ_24();
        ArrayList<ArrayList<Integer>> list1 = jz_24.FindPath(tou,18);
        for (ArrayList list:list1
             ) {
            System.out.println();
            for (Object i:list
                 ) {
                System.out.print(i+"，");
            }
        }

        System.out.println();
        System.out.println(jz_24.pathSum(root,18));
    }
}
