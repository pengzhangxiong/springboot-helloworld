package fun.caspar.web.controller;

import fun.caspar.model.User;
import fun.caspar.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("用户信息管理")
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    IUserService iUserService;

    @ApiOperation("Hello测试")
    @GetMapping("/{id}")
    @ResponseBody
    public User hello(@PathVariable("id") Integer id) {
        User user = new User();
        user.setId(id);
        user.setUsername("哈哈哈");
        user.setPassword("6666666");
        return user;
    }

    @ApiOperation("获取列表")
    @GetMapping("/list")
    @ResponseBody
    public List<User> list() {
        return iUserService.list();
    }

    @ApiOperation("通过用户名获取用户列表")
    @ApiImplicitParam(name = "username", value = "用户名", dataType = "String", paramType = "path")
    @GetMapping("/list/{username}")
    @ResponseBody
    public List<User> findByUsername(@PathVariable("username") String username) {
        return iUserService.findByUsername(username);
    }

    @ApiOperation("通过用户名获取单个用户信息")
    @ApiImplicitParam(name = "username", value = "用户名", dataType = "String", paramType = "path")
    @GetMapping("/get/{username}")
    @ResponseBody
    public User findUser(@PathVariable("username") String username) {
        return iUserService.findUser(username);
    }

    @ApiOperation("通过用户id获取用户信息")
    @ApiImplicitParam(name = "id", value = "用户ID", dataType = "Integer", paramType = "path")
    @GetMapping("getById/{id}")
    @ResponseBody
    public User getUser(@PathVariable("id") Integer id) {
        return iUserService.getUser(id);
    }

    @ApiOperation("新增用户")
    @ApiImplicitParams({@ApiImplicitParam(name = "username", value = "用户名", dataType = "String", paramType = "form"), @ApiImplicitParam(name = "password", value = "密码", dataType = "String", paramType = "form")})
    @PostMapping("save")
    public String sava(String username, String password) {
        boolean bs = iUserService.sava(username, password) > 0;
        return bs ? "SUCCES" : "FLASE";
    }

    @ApiOperation("删除用户")
    @ApiImplicitParam(name = "id", value = "用户ID", dataType = "Integer")
    @DeleteMapping("delete")
    public String delete(Integer id) {
        boolean bs = iUserService.delete(id) > 0;
        return bs ? "SUCCES" : "FLASE";
    }
}
