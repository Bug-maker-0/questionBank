package yc.jianZhiOffer;

import java.util.ArrayList;

public class JZ_19 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList list = new ArrayList();

        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while(true){
            //打印最上面一行
            for(int col = left ; col < right ; ++col){
                list.add(matrix[up][col]);
            }
            //标记上面这行已经被打印
            up++;
            //判断是否越界
            if(up > down)
                break;
            //打印最右边一行
            for(int row = up ; row < down ; ++row){
                list.add(matrix[row][right]);
            }
            //标记右边行被打印
            right--;
            if(left > right)
                break;
            //打印最下面一行
            for(int col = right ; col >= left ; --col){
                list.add(matrix[down][col]);
            }
            //标记下边行被打印
            down--;
            if(up > down)
                break;
            //打印最左边一行
            for(int row = up ; row >= up ; --row){
                list.add(matrix[row][left]);
            }
            //标记左边行被打印
            left++;
            if(left > right)
                break;
        }

        return list;
    }

}
