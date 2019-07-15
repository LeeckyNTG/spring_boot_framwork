package com.clover.spring_boot_mybatis.baidu_aip;

import com.baidu.aip.nlp.AipNlp;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    //设置APPID/AK/SK
    public static final String APP_ID = "16774141";
    public static final String API_KEY = "5kcYZzCjq2IahHXAhqxRnoLW";
    public static final String SECRET_KEY = "PuxK0LzuUxjAGiRjIWnLPGzDm75ctGBv";

    public static void main(String[] args) {

        // 初始化一个AipNlp
        AipNlp client = new AipNlp(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 调用接口
        String text = "打电话给10025,10012";
//        JSONObject res = client.lexer(text, null);
//        System.out.println(res.toString(2));

//        // 传入可选参数调用接口
//        HashMap<String, Object> options = new HashMap<String, Object>();
//
//        // 词法分析（定制版）
//        JSONObject res = client.lexerCustom(text, options);
//        System.out.println(res.toString(2));

        List<String> list = new ArrayList<>();
        list.add("10025");
        list.add("10012");

        String text1 = "分区广播";
        String text2 = "终端广播";
        String text3 = "给终端1002510012发起广播";


        for (String str:list){
            if (text3.contains(str)){
                System.out.println(str);
            }
        }

        // 传入可选参数调用接口
        HashMap<String, Object> options = new HashMap<String, Object>();
        options.put("model", "CNN");

        // 短文本相似度
        JSONObject res = client.simnet(text1, text3, options);
        System.out.println(res.toString());


        System.out.println(res.toString(2));


    }
}
