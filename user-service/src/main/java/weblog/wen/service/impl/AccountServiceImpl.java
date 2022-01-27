package weblog.wen.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import weblog.wen.entity.ServerResult;
import weblog.wen.entity.User;
import weblog.wen.mapper.AccountMapper;
import weblog.wen.service.AccountService;
import weblog.wen.utils.JwtUtils;

/**
 * @author wenhx
 * @Date 2022/1/25 15:41
 * @Description 账号操作相关实现类
 */

@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public ServerResult queryAccount(User user) {
        User account = accountMapper.queryAccount(user);
        if (account.getName().equals(user.getName()) && account.getPassword().equals(user.getPassword())){
            String token = JwtUtils.getToken(user);
            user.setToken(token);
            return ServerResult.defaultSuccess(user);
        }
        else{
            return ServerResult.failure(500,"账号或密码错误");
        }
    }
}
