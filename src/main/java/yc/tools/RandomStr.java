package yc.tools;

import java.util.Random;

/**
 * @author yangcheng <yangcheng03@kuaishou.com>
 * Created on 2022-04-18
 */
public class RandomStr {

    public static String createRandomStr2(int length){
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(2);
            long result = 0;
            switch (number) {
//                case 0:
//                    result = Math.round(Math.random()*25+65);
//                    stringBuffer.append(String.valueOf((char)result));
//                    break;
                case 0:
                    result = Math.round(Math.random()*25+97);
                    stringBuffer.append(String.valueOf((char)result));
                    break;
                case 1:
                    stringBuffer.append(String.valueOf(new Random().nextInt(10)));
                    break;
            }
        }
        return stringBuffer.toString();
    }

    static int a = 1;
    static int b = 2;
    public static void main(String[] args) {


        String c ="3";
        System.out.println(a+b+c);
    }

}
