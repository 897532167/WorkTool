package com.example.study.utils

import org.jetbrains.annotations.TestOnly
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.*


/**
 * Created by xhu_ww on 2018/6/15.
 * description:
 */
object TokenUtil {

    fun uuid(): String {
        return UUID.randomUUID().toString()
    }

    /**
     * MD5 + salt
     */
    fun authToken(uuid: String): String {

        val sb = StringBuilder(16)
        sb.append(Random().nextInt(99999999)).append(Random().nextInt(99999999))
        val len = sb.length
        if (len < 16) {
            for (i in 0 until 16 - len) {
                sb.append("0")
            }
        }
        val salt = sb.toString()
        val MD5_Salt = this.md5Hex(uuid + salt)!!
        val cs = CharArray(48)

        var i = 0
        while (i < 48) {
            cs[i] = MD5_Salt.toCharArray()[i / 3 * 2]
            val c = salt[i / 3]
            cs[i + 1] = c
            cs[i + 2] = MD5_Salt.toCharArray()[i / 3 * 2 + 1]
            i += 3
        }
        return String(cs)
    }

    private fun md5Hex(src: String): String? {
        return try {
            val md5 = MessageDigest.getInstance("MD5")
            val bs = md5.digest(src.toByteArray())

            val sb = StringBuilder(bs.size * 2)
            for (b in bs) {
                sb.append(String.format("%02x", b.toInt() and 0xff))
            }

            sb.toString()
        } catch (e: Exception) {
            null
        }
    }


    /**
     * normal MD5
     */
    fun MD5(input: String): String {
        var md5: MessageDigest
        try {
            md5 = MessageDigest.getInstance("MD5")
        } catch (e: NoSuchAlgorithmException) {
            return "check jdk"
        } catch (e: Exception) {
            e.printStackTrace()
            return ""
        }

        val charArray = input.toCharArray()
        val byteArray = ByteArray(charArray.size)

        for (i in charArray.indices)
            byteArray[i] = charArray[i].toByte()
        val md5Bytes = md5!!.digest(byteArray)
        val hexValue = StringBuffer()
        for (i in md5Bytes.indices) {
            val `val` = md5Bytes[i].toInt() and 0xff
            if (`val` < 16)
                hexValue.append("0")
            hexValue.append(Integer.toHexString(`val`))
        }
        return hexValue.toString()
    }

    fun verify(password: String, md5: String): Boolean {
        val cs1 = CharArray(32)
        val cs2 = CharArray(16)
        var i = 0
        while (i < 48) {
            cs1[i / 3 * 2] = md5[i]
            cs1[i / 3 * 2 + 1] = md5[i + 2]
            cs2[i / 3] = md5[i + 1]
            i += 3
        }
        val salt = String(cs2)
        return md5Hex(password + salt).equals(String(cs1))
    }

}