package me.jcala.xmarket.server.entity.document;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 *用户信息封装类
 */
@Document(collection = "user")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    private String username;//用户名
    private String password;//用户密码
    private String school;//所在学校名称
    private String phone;//手机号
    @Field("avatar_url") private String avatar_url;//头像地址
}
