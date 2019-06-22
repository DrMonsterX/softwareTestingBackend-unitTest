package com.sxd.server.mytime.Controller.UserController;

import com.sxd.server.mytime.Service.UserService.PasswordService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChangePasswordController {
    private final PasswordService passwordService;

    public ChangePasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    //通过id，新密码来修改用户密码，返回结果。0失败，1成功，2用户不存在。
    @RequestMapping(value = "changePassword",method = RequestMethod.GET)
    public int changePassword(Integer userId,String password){
        return passwordService.changePassword(userId,password);
    }
}