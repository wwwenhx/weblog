package weblog.wen.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import weblog.wen.entity.User;

/**
 * @author wenhx
 * @Date 2022/1/25 15:31
 * @Description 数据库账号操作相关接口
 */

public interface AccountMapper {
    public User queryAccount(User user);
}
