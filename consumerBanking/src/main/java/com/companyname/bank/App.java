package com.companyname.bank;

import java.util.HashMap;
import java.util.Random;
// import cn.hutool.core.date.DateTime;
import com.alibaba.fastjson.JSON;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Random random = new Random();
        System.out.println(random.nextInt(100));
        System.out.println( "Hello World!" );

        Util.printMessage("引入其他文件中的函数--->>>>>");

        HashMap a = new HashMap();
        a.put("name", "1111");

        String text = JSON.toJSONString(a); //序列化

        System.out.println("text: " + text);
    }
}
