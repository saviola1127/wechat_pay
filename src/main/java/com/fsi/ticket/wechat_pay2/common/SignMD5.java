package com.fsi.ticket.wechat_pay2.common;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.UUID;

import org.springframework.security.crypto.password.PasswordEncoder;

public class SignMD5 implements PasswordEncoder {
    public static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format(Configure.HEX_FORMAT, b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

    @Override
    public String encode(CharSequence charSequence) {
        try {
            MessageDigest crypt = MessageDigest.getInstance(Configure.MD5);
            crypt.reset();
            crypt.update(charSequence.toString().getBytes(Configure.CHARTSET_UTF8));
            return byteToHex(crypt.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return Configure.EMPTY;
    }

    @Override
    public boolean matches(CharSequence charSequence, String encodedPassword) {
        return encode(charSequence).equals(encodedPassword);
    }

    public String createNonceStr() {
        return UUID.randomUUID().toString().replaceAll(Configure.MIDDLE_LINE,Configure.EMPTY);
    }

    public String createTimeStamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }

}
