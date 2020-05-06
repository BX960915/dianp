package fun.baoxiang.dianpingspringboot.controller;

import fun.baoxiang.dianpingspringboot.entity.User;
import fun.baoxiang.dianpingspringboot.result.Result;
import fun.baoxiang.dianpingspringboot.result.ResultFactory;
import fun.baoxiang.dianpingspringboot.service.UserService;
import fun.baoxiang.dianpingspringboot.service.dpService;
import fun.baoxiang.dianpingspringboot.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.HtmlUtils;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class AdminController {
    @Autowired
    UserService userService;
    @Autowired
    dpService dpService;
    @CrossOrigin
    @PostMapping("api/covers")
    public String coversUpload(MultipartFile file) throws Exception {
        String folder = "D:/workspace/img";
        File imageFolder = new File(folder);
        File f = new File(imageFolder, StringUtils.getRandomString(6) + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        try {
            file.transferTo(f);
            String imgURL = "http://localhost:8089/api/file/" + f.getName();
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
    @CrossOrigin
    @PostMapping(value = "api/{dpid}/deldp")
    public Result deldp(@PathVariable("dpid") int dpid) throws Exception {
        dpService.deletdpbyid(dpid);
        return ResultFactory.buildSuccessResult("成功");
    }
    @CrossOrigin
    @GetMapping(value = "api/{username}/usermsg")
    public List<User> listByUsername(@PathVariable("username") String username) throws Exception {
//        System.out.println(username);
        return userService.listByUsename(username);
    }
    @CrossOrigin
    @PostMapping(value = "api/edituser")
    public Result edituser(@RequestBody User user) {
//    public Result edituser(@RequestBody int id, String email,String address ,String jianjie, String gender ) {
        int id = user.getId();
        String img = user.getImg();
        String email = user.getEmail();
        String address = user.getAddress();
        String jianjie = user.getJianjie();
        String gender = user.getGender();
        System.out.println(email);
        User newuser = userService.findbyid(id);
        newuser.setImg(img);
        newuser.setAddress(address);
        newuser.setEmail(email);
        newuser.setGender(gender);
        newuser.setJianjie(jianjie);
        int status = userService.upuserdata(newuser);
        switch (status) {
            case 0:
                return ResultFactory.buildFailResult("用户名和密码不能为空");
            case 1:
                return ResultFactory.buildSuccessResult("注册成功");
            case 2:
                return ResultFactory.buildFailResult("用户已存在");
        }
        return ResultFactory.buildFailResult("未知错误");
    }
}
