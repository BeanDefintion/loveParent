package com.xpj.controller;

import com.xpj.user.domain.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "智障")
@RequestMapping("/ss")
@RestController
public class TestController {

    @ApiOperation(value = "这种")
    @RequestMapping("/selectUser")
    public User selectUser() {
        User user = new User();
        User user2 = user.selectUser();
        return user2;
    }
}
