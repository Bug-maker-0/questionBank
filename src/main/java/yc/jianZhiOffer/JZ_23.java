package yc.jianZhiOffer;

public class JZ_23 {
    /*输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
    如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。*/
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0)
            return false;
        return temp(sequence,0,sequence.length-1);

    }

    private boolean temp(int[] sequence, int start, int end){
        if(start >= end)
            return true;
        int root = sequence[end];
        int i = 0;
        //判断左子树是否都小于根节点
        for (i = start; i < end; i++) {
            if(sequence[i] > root)
                break;
        }
        //判断右子树是否都大于根节点
        int j = i;
        for( ;j < end; j++){
            if(sequence[j] < root)
                return false;
        }
        return (temp(sequence,start,i-1)&&temp(sequence,j,end-1));
    }


    public static void main(String[] args) {
        int[] sequence = {5,7,6,9,11,10,8};
        JZ_23 jz_23 = new JZ_23();

        System.out.println(jz_23.VerifySquenceOfBST(sequence));
    }
}
