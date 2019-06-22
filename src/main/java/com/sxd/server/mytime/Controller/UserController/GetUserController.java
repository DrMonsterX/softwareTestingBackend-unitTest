package com.sxd.server.mytime.Controller.UserController;

import com.sxd.server.mytime.Entity.User;
import com.sxd.server.mytime.Service.UserService.GetUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetUserController {
    private final GetUserService getUserService;

    public GetUserController(GetUserService getUserService) {
        this.getUserService = getUserService;
    }


    //通过id查询用户数据，返回用户信息
    //若id不存在则返回null
    @RequestMapping(value = "checkLogin",method = RequestMethod.GET)
    public User getUser(Integer userId){
        return getUserService.getUser(userId);
    }
}
