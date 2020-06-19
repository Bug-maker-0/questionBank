package yc.jianZhiOffer;

public class JZ_4 {
    //输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
    // 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
    // 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
    public  TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = new TreeNode(pre[0]);
        build(root, pre, 0, pre.length, in, 0, in.length);
        return root;
    }
    public  void build(TreeNode root, int[] pre, int pleft, int pright, int[] in, int ileft, int iright) {
        int i;
        for (i = ileft; i < iright; ++i) {
            if (in[i] == root.val) {//从中序序列寻找根节点的位置
                break;
            }
        }
        // t是用来记录左子树是否构建完成
        int t = i - ileft;
        if (t > 0) {//子树长度为0时不必生成子问题
            root.left = new TreeNode(pre[pleft + 1]);
            build(root.left, pre, pleft + 1, pleft + 1 + t, in, ileft, i);
        }

        if (pright - pleft - 1 - t > 0) {
            root.right = new TreeNode(pre[pleft + 1 + t]);
            build(root.right, pre, pleft + 1 + t, pright, in, i + 1, iright);
        }
    }
}
