package yc.jianZhiOffer;

public class JZ_48 {
    /*给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
    其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
    不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）*/
    public int[] multiply(int[] A) {

        int [] B = new int[A.length];
        int i = 0 , j = 0 ;
        while(j < B.length){
            B[j] = 1;
            for(i = 0; i < A.length; i++){
                //判断i和j是否相等 相等乘与1
                if(i == j) {
                    B[j] *= 1;
                }else {
                    B[j] *= A[i];
                }
            }
            ++j;
        }
        return B;
    }

    public int[] multiply1(int[] A) {
        if(A.length == 0) return new int[0];
        int [] B = new int[A.length];
        int tmp = 0;
        B[0] = 1;
        for (int i = 1; i < A.length; i++) {
            B[i] = B[i-1] * A[i-1];
        }
        for (int i = A.length - 2; i >= 0; i--){
            tmp *= A[i+1];
            B[i] *= tmp;
        }
        return B;
    }


    public static void main(String[] args) {
        int[] A = {1,2,3,4,5};
        JZ_48 jz_48 = new JZ_48();
        int[] b = jz_48.multiply(A);
        int[] c = jz_48.multiply(A);
        for (int i:c
             ) {
            System.out.println(i);
        }
    }
}
