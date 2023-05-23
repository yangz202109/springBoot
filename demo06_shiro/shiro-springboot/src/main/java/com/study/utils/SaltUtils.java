package com.study.utils;

import java.util.Random;

/**
 * @auther shkstart
 * @create 2021-11-17-17:08
 */
public class SaltUtils {
    /*
    * 生成salt的静态方法
    *
    * */

    public static String getSalt(int n){
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()".toCharArray();

        // StringBuffer是字符数组
        StringBuffer sb=new StringBuffer();

        for (int i = 0; i < n; i++) {
            char aChar = chars[new Random().nextInt(chars.length)];
            sb.append(aChar);
        }

        return sb.toString();
    }

   /* public static void main(String[] args) {
        System.out.println(getSalt(5));
    }*/
}
