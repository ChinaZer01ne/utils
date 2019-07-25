package com.github.web.jwt;

import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.crypto.MacSigner;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * JWT数据结构包括三部分
 *      1、Header：、
 *              JWT的头部承载两部分信息：token类型和采用的加密算法。
 *      2、Payload ：
 *              载荷就是存放有效信息的地方。
 *              有效信息包含三个部分
 *              1.标准中注册的声明
 *              2.公共的声明
 *              3.私有的声明
 *      3、Signature
 *              jwt的第三部分是一个签证信息，这个签证信息由三部分组成：
 *              header (base64后的)
 *              payload (base64后的)
 *              secret
 *              这个部分需要base64加密后的header和base64加密后的payload使用.连接组成的字符串，然后通过header中声明的加密方式进行加盐secret组合加密，然后就构成了jwt的第三部分。
 *              密钥secret是保存在服务端的，服务端会根据这个密钥进行生成token和进行验证，所以需要保护好。
 *              这个部分需要base64加密后的header和base64加密后的payload使用.连接组成的字符串，然后通过header中声明的加密方式进行加盐secret组合加密，然后就构成了jwt的第三部分。
 *              密钥secret是保存在服务端的，服务端会根据这个密钥进行生成token和进行验证，所以需要保护好。
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/25 15:55
 */
public class JwtUtil {

    /**
     * 创建token
     * @return java.lang.String
     * @throws
     */
    public static String createJWT() {

        //Map<String, Object> claims = new HashMap<>();
        //claims.put("claims", "test");

        Map<String, Object> payloadMap = new HashMap<>();
        payloadMap.put("payload", "test");

        SignatureAlgorithm key = SignatureAlgorithm.HS256;
        JwtBuilder builder = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                //.setClaims(claims)    // claims和payloadMap只能取其一
                .setPayload(JSONObject.toJSONString(payloadMap))  //携带一些参数，比如用户id之类的
                //.setSubject("bbb")    //代表这个JWT的主体，即它的所有人，这个是一个json格式的字符串，可以存放什么userid，roldid之类的，作为什么用户的唯一标志。
                                        // setSubject相当于在Claims中添加，如果想两者共同使用，setClaims要在setSubject之前
                .signWith(key,"!@#123qwe"); // 加密方式：会自动在header中设置alg属性,后边的字符串是盐，如果太过简单会直接报错

        return builder.compact();
    }

    /**
     * 解密：确保数据不会被篡改
     * @param jsonWebToken :
     * @return io.jsonwebtoken.Claims
     * @throws
     */
    public static Claims parseJWT(String jsonWebToken) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey("!@#123qwe")
                    .parseClaimsJws(jsonWebToken).getBody();
            return claims;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args) {
        String token = JwtUtil.createJWT();
        System.out.println(token);
        String[] split = token.split("\\.");
        System.out.println(split.length);
        byte[] decode1 = Base64.getDecoder().decode(split[0].getBytes());
        byte[] decode2 = Base64.getDecoder().decode(split[1].getBytes());
        System.out.println(new String(decode1));
        System.out.println(new String(decode2));

        System.out.println(parseJWT(token));
    }
}
