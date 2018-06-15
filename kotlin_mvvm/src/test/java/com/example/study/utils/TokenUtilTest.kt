package com.example.study.utils

import org.jetbrains.annotations.TestOnly
import org.junit.Assert.*

/**
 * Created by xhu_ww on 2018/6/15.
 * description:
 */
class TokenUtilTest {
    @TestOnly
    public fun main() {
        val plaintext = "DingSai";
        //  plaintext = "123456";
        System.out.println("原始：$plaintext");
        System.out.println("普通MD5后：" + TokenUtil.MD5(plaintext));

        // 获取加盐后的MD5值
        val ciphertext = TokenUtil.authToken(plaintext);
        System.out.println("加盐后MD5：$ciphertext");
        System.out.println("是否是同一字符串:" + TokenUtil.verify(plaintext, ciphertext));

//        for (String temp : tempSalt) {
//            System.out.println("是否是同一字符串:" + MD5Util.verify(plaintext, temp));
//        }
    }
}