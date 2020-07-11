package yc.jianZhiOffer;


import java.util.ArrayList;
/*方法一：由于是二叉搜索树，所以其中序遍历是有序的，
        1、中序遍历的结果 存入链表中
        2、在链表中修改前后指针的指向
* */

public class JZ_26 {
    /*输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
    要求不能创建任何新的结点，只能调整树中结点指针的指向。*/
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null)
            return pRootOfTree;
        ArrayList<TreeNode> list = new ArrayList<>();
        Convert(pRootOfTree,list);
        return Convert(list);
    }

    //中序遍历二叉树
    public void Convert(TreeNode treeNode,ArrayList<TreeNode> list){
        if(treeNode == null)
            return;
        Convert(treeNode.left,list);
        list.add(treeNode);
        Convert(treeNode.right,list);
    }

    //修改指针的指向
    public TreeNode Convert(ArrayList<TreeNode> list){
        for (int i = 0 ; i < list.size() - 1; ++i){
            list.get(i).right = list.get(i+1);
            list.get(i+1).left = list.get(i);
        }
        return list.get(0);
    }

}
