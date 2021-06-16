package team.sun.integration.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClaims;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;

/**
 * Jwt相关工具类
 *
 * @author TaoYu MaYing
 */
public final class JwtUtils {

    /**
     * JWT Token 签发机构
     */
    private static final String JWT_TOKEN_PRODUCTION_MECHANISM = "SiHan Technology";
    /**
     * 默认的密钥
     */
    private static final String SIGNING_KEY = "SiHan Technology SIGNING_KEY";

    private JwtUtils() {
    }

    /**
     * 生成JWT Token，默认一周后的凌晨12点过期
     *
     * @param payload 载荷
     * @return Jwt Token
     */
    public static String generateToken(Map<String, Object> payload) {
        return generateToken(payload, Date.from(LocalDateTime.of(LocalDate.now(), LocalTime.MIN)
                .plusWeeks(1).atZone(ZoneId.systemDefault()).toInstant()));
    }

    /**
     * 生成JWT Token
     *
     * @param payload    载荷
     * @param expiration 过期时间
     * @return Jwt Token
     */
    public static String generateToken(Map<String, Object> payload, Date expiration) {
        return generateToken(payload, expiration, SignatureAlgorithm.HS256, SIGNING_KEY);
    }

    /**
     * 生成JWT Token
     *
     * @param payload            载荷
     * @param expiration         过期时间
     * @param signatureAlgorithm 算法
     * @param signingKey         密钥
     * @return Jwt Token
     */
    public static String generateToken(Map<String, Object> payload, Date expiration,
                                       SignatureAlgorithm signatureAlgorithm,
                                       String signingKey) {
        Claims claims = new DefaultClaims();
        claims.setIssuer(JWT_TOKEN_PRODUCTION_MECHANISM);
        claims.setExpiration(expiration);
        claims.putAll(payload);
        return Jwts.builder()
                .setClaims(claims)
                .signWith(signatureAlgorithm, signingKey)
                .compact();
    }

    /**
     * 解析JWT Token
     *
     * @param token JWT Token
     * @return 载荷 or Null --> ToKen超时
     */
    public static Claims parseToken(String token) {
        return parseToken(SIGNING_KEY, token);
    }

    /**
     * 解析JWT Token
     *
     * @param signingKey 签名
     * @param token      JWT Token
     * @return 载荷 or Null --> ToKen超时
     */
    public static Claims parseToken(String signingKey, String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(signingKey)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            return null;
        }
    }

}