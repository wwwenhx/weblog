package weblog.wen.entity;

import lombok.Data;

/**
 * @author wenhx
 * @Date 2022/1/26 12:57
 * @Description user实体类
 */

@Data
public class User {
    private int id;
    private String name;
    private String phone;
    private String email;
    private String password;
    private String token;
}
