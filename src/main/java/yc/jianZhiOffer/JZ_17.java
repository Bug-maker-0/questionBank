package yc.jianZhiOffer;

public class JZ_17 {
    //输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）

    public boolean HasSubtree(TreeNode A, TreeNode B) {
        //特例 A树和B树为空时 直接返回false
        if(A == null || B == null)
            return false;

        //判断 A树和B树的根节点 左节点 右节点是否相等
        if(A.val == B.val && (help(A.left,B.left) && help(A.right,B.right))){
            return true;
        }
        //判断A的左子树是否包含B树 判断A的右子树是否包含B树
        return HasSubtree(A.left,B)||HasSubtree(A.right,B);
    }

    public boolean help(TreeNode A,TreeNode B){

        if(B == null)
            return true;
        if(A == null)
            return false;
        if(A.val == B.val) {
            return help(A.left, B.left) && help(A.right, B.right);
        } else{
            return false;
        }

    }
}
