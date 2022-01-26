package weblog.wen.utils;

import io.jsonwebtoken.*;
import weblog.wen.entity.ServerResult;
import weblog.wen.entity.User;

import java.util.Date;
import java.util.UUID;

/**
 * @author wenhx
 * @Date 2022/1/26 10:05
 * @Description
 */

public class JwtUtils {

    private static final String secretKey = "wen";

    private static long time = 1000*60*60*24;

    /**
     * @author wenhx
     * @Date 2022/1/26 12:22
     * @Description: 生成jwt令牌
     */
    public static String getToken(User user){
        long timeMillis = System.currentTimeMillis();
        Date now = new Date(timeMillis);
        String token = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,secretKey)
                .claim("uid",user.getId())
                .setId(UUID.randomUUID().toString())
                .setSubject(user.getName())
                .setIssuedAt(now)
                .setExpiration(new Date(System.currentTimeMillis()+time))
                .compact();
        return token;
    }

    /**
     * @author wenhx
     * @Date 2022/1/26 14:26
     * @Description: 验证token
     */
    public static boolean checkToken(String token){
        JwtParser jwtParser = Jwts.parser();
        if (token == null){
            return false;
        }
        try {
            jwtParser.setSigningKey(secretKey).parseClaimsJws(token);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * @author wenhx
     * @Date 2022/1/26 14:29
     * @Description: 解析token。获取claims
     */
    public static ServerResult tokenParse(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
        return ServerResult.defaultSuccess(claims);
    }
}
