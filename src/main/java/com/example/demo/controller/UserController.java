package com.example.demo.controller;

//import com.example.demo.entity.SysUser;
import com.example.demo.entity.SysUser;
import com.example.demo.repository.UserRepository;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api")
//接口模块描述信息
@Api("用户模块接口")
public class UserController {
    @Autowired
    private UserRepository userRepository;

//    @GetMapping("/getUser")
//    //接口描述信息
//    @ApiOperation(value = "获取用户详情")
//    @ApiImplicitParams({
//            //给Swagger-UI中的输入框中设置默认值
//            @ApiImplicitParam(name = "id",value = "用户id",defaultValue = "123456")
//    })
//    public SysUser getUserDetail(@ApiParam(value = "用户id",required = true) @RequestParam String id) {
////        return userService.getUserInfo(id);
//        return "1";
//    }

    @ApiOperation("查询当前所有用户")
    @GetMapping("/sysUser")
    private List<SysUser> list() {
        return userRepository.findAll();
    }

    @ApiOperation("新增user")
    @PostMapping(value = "/sysUser")
    private SysUser add(SysUser sysUser) {
        return userRepository.save(sysUser);
    }

    @ApiOperation("根据ID查用户")
//    @ApiImplicitParam(name = "id", value = "id", required = true)
    @GetMapping(value = "/sysUser/{id}")
    public SysUser getUser(@PathVariable("id") Integer id) {
        return  userRepository.findById(id).orElse(null);
    }

    @ApiOperation("更新用户")
    @PutMapping(value = "/sysUser")
    public SysUser updateUser(SysUser sysUser) {
        return userRepository.save(sysUser);
    }

}
