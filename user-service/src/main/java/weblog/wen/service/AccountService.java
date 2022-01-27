package weblog.wen.service;

import weblog.wen.entity.ServerResult;
import weblog.wen.entity.User;

/**
 * @author wenhx
 * @Date 2022/1/25 15:40
 * @Description 账号操作相关接口
 */

public interface AccountService {

    public ServerResult queryAccount(User user);
}
