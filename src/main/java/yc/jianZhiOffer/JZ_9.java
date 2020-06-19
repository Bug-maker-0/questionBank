package yc.jianZhiOffer;

public class JZ_9 {
    //一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
    public int JumpFloorII(int target) {

        if(target <= 1)
            return target;
        return 2*JumpFloorII(target-1);
    }

    public int JumpFloorII_1(int target) {

        if(target == 0 || target == 1)
            return 1;
        int a = 1,b = 0;
        for (int i = 2; i <= target ; ++i) {
                b = a << 1;
                a = b;
        }
        return b;
    }
}
/*解题思路
链接：https://www.nowcoder.com/questionTerminal/22243d016f6b47f2a6928b4313c85387?answerType=1&f=discussion
来源：牛客网
对于方法一中的：f[n] = f[n-1] + f[n-2] + ... + f[0]

那么f[n-1] 为多少呢？

f[n-1] = f[n-2] + f[n-3] + ... + f[0]

所以一合并，f[n] = 2*f[n-1]，初始条件f[0] = f[1] = 1

所以可以采用递归，记忆化递归，动态规划，递推。具体详细过程，可查看青蛙跳台阶。
*
* */
