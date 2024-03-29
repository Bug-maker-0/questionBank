package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author yangcheng <yangcheng03@kuaishou.com>
 * Created on 2021-07-18
 */

/**
 * returnMode == 3   可行性缺口补助
 * returnMode == 1   政府付费
 * returnMode == 2   使用者付费

 **/

/**
 * 通过curl 爬取PPP网站数据
 */
public class Curl {

    static String url;


    public static void main(String[] args) {

        //dist_province字段：代表省份
        //dist_city字段：代表城市

        // 北京市 110000
        // 天津市 120000
        // 河北省 130000
        // 山西省 140000
        // 内蒙古自治区 150000

        // 辽宁省 210000
        // 吉林省 220000
        //黑龙江省 230000

        //上海市 310000
        //江苏省 320000
        //浙江省 330000
        //安徽省 340000
        //福建省 350000
        //江西省 360000
        //山东省 370000

        //河南省 410000
        //湖北省 420000
        //湖南省 430000
        //广东省 440000
        //广西壮族自治区 450000
        //海南省 460000

        //重庆市 500000
        //四川省 510000
        //贵州省 520000
        //云南省 530000
        //西藏自治区 540000

        //陕西省 610000
        //甘肃省 620000
        //青海省 630000
        //宁夏回族自治区 640000
        //新疆维吾尔自治区 650000
        //新疆生产建设兵团 660000
        //  本级  sameLevel

        int[] province = {110000,120000,130000,140000,150000,
                210000,220000,230000,
                310000,320000,330000,340000,350000,360000,370000,
                410000,420000,430000,440000,450000,460000,
                500000,510000,520000,530000,540000,
                610000,620000,630000,640000,650000,660000};

        String[] sum = {"001","002","003","004","005","006","007","008","009","010"
                ,"011","012","013","014","015","016","017","018","019"};

        //河南省-各个市编号
        String[] distCity = {"410100","410200","410300","410400","410500"
                        ,"410600","410700","410800","410900","411000"
                        ,"411100","411200","411300","411400","411500"
                        ,"411600","411700"};


        for (int j = 0; j < distCity.length; j++) {
            city(null, distCity[j], null);
        }


    }

    public static void city(String province1, String distCity,String sum) {
        String[] shi = {"curl","https://www.cpppc.org:8082/api/pub/project/search",
                "-H" ,"Connection: keep-alive" ,
                "-H" , "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_16_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.102 Safari/537.36",
                "-H" , "Content-Type: application/json",
                "-H" , "Accept: */*",
                "-H" , "Origin: https://www.cpppc.org:8082",
                "-H" , "Sec-Fetch-Site: same-origin",
                "-H" , "Sec-Fetch-Mode: cors",
                "-H" , "Sec-Fetch-Dest: empty",
                "-H" , "Referer: https://www.cpppc.org:8082/inforpublic/homepage.html",
                "-H" , "Accept-Language: zh-CN,zh;q=0.9",
                "--data-binary" , "{\"name\":\"\",industry: \"\",\"min\":0,\"max\":10000000000000000,"
                + "\"pageNumber\":1,\"size\":10000,\"status\":[\"1\",\"2\",\"3\"],\"level\":\"\",\"start\":\"\","
                + "\"end\":\"\",\"dist_province\":\"410000\",\"dist_city\":\"" + distCity + "\",\"dist_code\":\"\",\"nlpVO\":{},"
                + "\"created_date_order\":\"desc\"}",
                "--compressed"};


//        String[] shi = {"curl","https://www.cpppc.org:8082/api/pub/project/search",
//                "-H" ,"Connection: keep-alive" ,
//                "-H" , "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_16_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.102 Safari/537.36",
//                "-H" , "Content-Type: application/json",
//                "-H" , "Accept: */*",
//                "-H" , "Origin: https://www.cpppc.org:8082",
//                "-H" , "Sec-Fetch-Site: same-origin",
//                "-H" , "Sec-Fetch-Mode: cors",
//                "-H" , "Sec-Fetch-Dest: empty",
//                "-H" , "Referer: https://www.cpppc.org:8082/inforpublic/homepage.html",
//                "-H" , "Accept-Language: zh-CN,zh;q=0.9",
//                "--data-binary" , "{\"name\":\"\",\"industry\":\"\",\"min\":0,\"max\":10000000000000000,\"pageNumber\":1,"
//                + "\"size\":1000,\"status\":[\"1\",\"2\",\"3\"],\"level\":\"\",\"start\":\"\",\"end\":\"\","
//                + "\"dist_province\":\"" + province1 + "\",\"dist_city\":\"\",\"dist_code\":\"\",\"nlpVO\":{},"
//                + "\"created_date_order\":\"desc\"}",
//                "--compressed"};

        //获取省下面市的数据
        String str = execCurl(shi).replaceAll("%", "%%");

        JSONObject obj = new JSONObject(str).getJSONObject("data");
        //获取json里的数据
        JSONArray hits = obj.getJSONArray("hits");

        //2015-2019各年的总项目金额
        BigDecimal sum2014 = new BigDecimal(0);
        BigDecimal sum2015 = new BigDecimal(0);
        BigDecimal sum2016 = new BigDecimal(0);
        BigDecimal sum2017 = new BigDecimal(0);
        BigDecimal sum2018 = new BigDecimal(0);
        BigDecimal sum2019 = new BigDecimal(0);
        BigDecimal sum2020 = new BigDecimal(0);
        BigDecimal sum2021 = new BigDecimal(0);
        BigDecimal allSum2021Beforre = new BigDecimal(0);
        BigDecimal allSum2021After = new BigDecimal(0);



        //2015-2019各年执行阶段的总项目金额
        BigDecimal zhixing2014 = new BigDecimal(0);
        BigDecimal zhixing2015 = new BigDecimal(0);
        BigDecimal zhixing2016 = new BigDecimal(0);
        BigDecimal zhixing2017 = new BigDecimal(0);
        BigDecimal zhixing2018 = new BigDecimal(0);
        BigDecimal zhixing2019 = new BigDecimal(0);


        //2015-2019各年项目个数
        int zong2014 = 0;
        int zong2015 = 0;
        int zong2016 = 0;
        int zong2017 = 0;
        int zong2018 = 0;
        int zong2019 = 0;
        int zong2020 = 0;
        int zong2021 = 0;
        int allProjectCount = 0;
        int allProject2021After = 0;
        int allProject = 0;

        //2015-2019各年执行阶段的项目个数
        int num2014 = 0;
        int num2015 = 0;
        int num2016 = 0;
        int num2017 = 0;
        int num2018 = 0;
        int num2019 = 0;

        String province = "";

        String city = "";
        //所属行业
        String industryRequiredName = "";

        if (hits.length() <= 0) {
            System.out.println("市：" + distCity + "\t所属行业：" + sum + "\t项目个数：0");
            System.out.println();
            return;
        }

        for (int i = 0; i < hits.length(); i++) {
            JSONObject code = hits.getJSONObject(i);
            String uid = code.getString("proj_rid");

            //每条数据的creating_uid
            //            System.out.println( i + 1 + "：" + uid);

            url = pingjie(uid);
            if(url == null) {
                continue;
            }
            //curl 每个具体数据的链接，只需要修改url即可
            String[] juti = {"curl" , "--location" , "--request" , "GET" , url ,
                    "--header", "Connection: keep-alive",
                    "--header", "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_16_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.102 Safari/537.36",
                    "--header", "Content-Type: application/json",
                    "--header", "Accept: */*",
                    "--header", "Sec-Fetch-Site: same-origin",
                    "--header", "Sec-Fetch-Mode: cors",
                    "--header", "Sec-Fetch-Dest: empty",
                    "--header", "Referer: https://www.cpppc.org:8082/inforpublic/homepage.html",
                    "--header", "Accept-Language: zh-CN,zh;q=0.9"};

            //获取每一条数据
            String str1 = execCurl(juti);
            JSONObject obj1 = new JSONObject(str1).getJSONObject("data");

            //省份
            province = obj1.getString("distProvinceName");
            //城市
            city = obj1.getString("distCityName");
            //所在行业-前缀
            industryRequiredName = obj1.getString("industryRequiredName");
            //所在行业-后缀
            String industryOptionalName = obj1.getString("industryOptionalName");
            //项目开始时间
            String startTime = obj1.getString("startTime");
            String Year = startTime.substring(0,4);

            int YearInt = Integer.parseInt(Year);

            Integer status = obj1.getInt("projStatus");

            //回报机制
            Integer returnMode = obj1.getInt("returnMode");

            String returnStr = "";

            if (returnMode == 1) {
                returnStr = "政府付费";
            } else if (returnMode == 2) {
                returnStr = "使用者付费";
            } else if (returnMode == 3) {
                returnStr = "可行性缺口补助";
            } else {
                returnStr = "returnMode == " + returnMode;
            }

            //项目金额  单位为分
            BigDecimal investCount = obj1.getBigDecimal("investCount");

            //项目阶段
            String proStatus = "";
//            if(status == 1){
//                proStatus = "准备阶段";
//            } else if (status == 2) {
//                proStatus = "采购阶段";
//            } else if (status == 3) {
//                proStatus = "执行阶段";
//                if (Year.equals("2015")){
//                    num2015++;
//                    zhixing2015 = zhixing2015.add(investCount);
//                } else if (Year.equals("2016")) {
//                    num2016++;
//                    zhixing2016 = zhixing2016.add(investCount);
//                } else if (Year.equals("2017")) {
//                    num2017++;
//                    zhixing2017 = zhixing2017.add(investCount);
//                } else if (Year.equals("2018")) {
//                    num2018++;
//                    zhixing2018 = zhixing2018.add(investCount);
//                } else if (Year.equals("2019")) {
//                    num2019++;
//                    zhixing2019 = zhixing2019.add(investCount);
//                } else if (Year.equals("2014")) {
//                    num2014++;
//                    zhixing2014 = zhixing2014.add(investCount);
//                }
//            }
            if(YearInt <= 2021) {
                allProjectCount++;
                allProject++;
                allSum2021Beforre = allSum2021Beforre.add(investCount);
            } else {
                allProject2021After++;
                allProject++;
                allSum2021After = allSum2021After.add(investCount);
            }
//            if(Year.equals("2015")){
//                zong2015++;
//                sum2015 = sum2015.add(investCount);
//            } else if (Year.equals("2016")) {
//                zong2016++;
//                sum2016 = sum2016.add(investCount);
//            } else if (Year.equals("2017")) {
//                zong2017++;
//                sum2017 = sum2017.add(investCount);
//            } else if (Year.equals("2018")) {
//                zong2018++;
//                sum2018 = sum2018.add(investCount);
//            } else if (Year.equals("2019")) {
//                zong2019++;
//                sum2019 = sum2019.add(investCount);
//            } else if (Year.equals("2014")) {
//                zong2014++;
//                sum2014 = sum2014.add(investCount);
//            } else if (Year.equals("2020")) {
//                zong2020++;
//                sum2020 = sum2020.add(investCount);
//            } else if (Year.equals("2021")) {
//                zong2021++;
//                sum2021 = sum2021.add(investCount);
//            }
//            String suoshu = "所属行业：";
//            System.out.print("省份：" + province  + "\t城市：" + city + "\t\t第" + (i + 1) + "个" + "\t项目阶段：" + proStatus
//                    + "\t\t" + "发起时间：" + Year + "\t项目总投资：" + investCount
//                    + "\t\t回报机制：");
//            System.out.printf("%-15s\t",returnStr);
//            System.out.println("所属行业：" + industryRequiredName + "-" + industryOptionalName);
        }

        //该字段investCount，单位为分
        BigDecimal divide = new BigDecimal(1000000);

//        sum2014 = sum2014.divide(divide);
//        sum2015 = sum2015.divide(divide);
//        sum2016 = sum2016.divide(divide);
//        sum2017 = sum2017.divide(divide);
//        sum2018 = sum2018.divide(divide);
//        sum2019 = sum2019.divide(divide);
//        sum2020 = sum2020.divide(divide);
//        sum2021 = sum2021.divide(divide);

        allSum2021Beforre = allSum2021Beforre.divide(divide);
        allSum2021After = allSum2021After.divide(divide);

//        zhixing2014 = zhixing2014.divide(divide);
//        zhixing2015 = zhixing2015.divide(divide);
//        zhixing2016 = zhixing2016.divide(divide);
//        zhixing2017 = zhixing2017.divide(divide);
//        zhixing2018 = zhixing2018.divide(divide);
//        zhixing2019 = zhixing2019.divide(divide);

//        System.out.println("项目个数：" + num2014 + "\t2014年执行阶段投资：" + zhixing2014 + "万元");
//        System.out.println("项目个数：" + num2015 + "\t2015年执行阶段投资：" + zhixing2015 + "万元");
//        System.out.println("项目个数：" + num2016 + "\t2016年执行阶段投资：" + zhixing2016 + "万元");
//        System.out.println("项目个数：" + num2017 + "\t2017年执行阶段投资：" + zhixing2017 + "万元");
//        System.out.println("项目个数：" + num2018 + "\t2018年执行阶段投资：" + zhixing2018 + "万元");
//        System.out.println("项目个数：" + num2019 + "\t2019年执行阶段投资：" + zhixing2019 + "万元");
//
//        System.out.println();
//
//        System.out.println("项目个数：" + zong2014 + "\t2014年总投资：" + sum2014 + "万元");
//        System.out.println("项目个数：" + zong2015 + "\t2015年总投资：" + sum2015 + "万元");
//        System.out.println("项目个数：" + zong2016 + "\t2016年总投资：" + sum2016 + "万元");
//        System.out.println("项目个数：" + zong2017 + "\t2017年总投资：" + sum2017 + "万元");
//        System.out.println("项目个数：" + zong2018 + "\t2018年总投资：" + sum2018 + "万元");
//        System.out.println("项目个数：" + zong2019 + "\t2019年总投资：" + sum2019 + "万元");
//        System.out.println("项目个数：" + zong2020 + "\t2019年总投资：" + sum2020 + "万元");
//        System.out.println("项目个数：" + zong2021 + "\t2019年总投资：" + sum2021 + "万元");

//        System.out.println("省：" + province + "\t总项目数：" + allProject);
//        System.out.println("省："+ province + "\t2021年12月前的项目个数：" + allProjectCount + "\t2021年12月前总投资：" + allSum2021Beforre + "万元");
//        System.out.println("省："+ province + "\t2021年12月后的项目个数：" + allProject2021After + "\t2021年12月后总投资：" + allSum2021After + "万元");
//        System.out.println();

//        System.out.println("所属行业：" + industryRequiredName + "\t总项目数：" + allProject);
//        System.out.println("所属行业："+ industryRequiredName + "\t2021年12月前的项目个数：" + allProjectCount + "\t2021年12月前总投资：" + allSum2021Beforre + "万元");
//        System.out.println("所属行业："+ industryRequiredName + "\t2021年12月后的项目个数：" + allProject2021After + "\t2021年12月后总投资：" + allSum2021After + "万元");
//        System.out.println();

        System.out.println(city + "\t" + allProjectCount + "\t" + allSum2021Beforre);


        //        System.out.println(province + "-" + city + "\t总项目数：" + allProject);
//        System.out.println("市："+ city + "\t所属行业："+ industryRequiredName + "\t2021年12月前的项目个数：" + allProjectCount + "\t2021年12月前总投资：" + allSum2021Beforre + "万元");
//        System.out.println("市："+ city + "\t所属行业："+ industryRequiredName + "\t2021年12月后的项目个数：" + allProject2021After + "\t2021年12月后总投资：" + allSum2021After + "万元");
//        System.out.println();
    }

    public static String execCurl(String[] cmds){
        ProcessBuilder process = new ProcessBuilder(cmds);
        Process p;
        try {
            p = process.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
                builder.append(System.getProperty("line.separator"));
            }
            return builder.toString();

        } catch (IOException e) {
            System.out.print("error");
            e.printStackTrace();
        }
        return null;
    }

    public static String pingjie(String rid){
        if(rid != null) {
            url = "https://www.cpppc.org:8082/api/pub/project/detail/" + rid;
            return url;
        }
        return null;
    }
}

