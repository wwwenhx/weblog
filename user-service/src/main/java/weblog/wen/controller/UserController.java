package weblog.wen.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import weblog.wen.entity.ServerResult;
import weblog.wen.entity.User;
import weblog.wen.utils.JwtUtils;

import java.util.Map;

/**
 * @author wenhx
 * @Date 2022/1/26 10:42
 * @Description 用户操作控制器
 */

@RestController
@RequestMapping("/userService")
public class UserController {

    @RequestMapping("/login")
    public ServerResult Login(@RequestBody Map<String, Object> param){
        User user = new User();
        ServerResult serverResult = ServerResult.defaultSuccess(user);
        return serverResult;
    }

    @RequestMapping("/checkToken")
    public ServerResult checkToken(@RequestHeader Map<String, Object> param){
        Boolean check = JwtUtils.checkToken(param.get("token").toString());
        if(check){
            return ServerResult.defaultSuccess(200);
        }
        else{
            return ServerResult.defaultFailure();
        }
    }

}
