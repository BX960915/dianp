package fun.baoxiang.dianpingspringboot.service;

import fun.baoxiang.dianpingspringboot.dao.UserDao;
import fun.baoxiang.dianpingspringboot.entity.User;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import java.util.List;


@Service
public class UserService {
    @Autowired
    UserDao userDao;
    //获得用户名
    public User getByusername(String username) {
        return userDao.findByUsername(username);
    }
    //判断账号是否存在
    public boolean isExist(String username) {
        User user = getByusername(username);
        return null != user;
    }
    //获得用户名和密码
    public User getusernameAndpassword(String username, String password) {
        return userDao.getByUsernameAndPassword(username, password);
    }
    //添加账号
    public int register(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        username = HtmlUtils.htmlEscape(username);
        user.setUsername(username);
        if (username.equals("") || password.equals("")) {
            return 0;
        }
        boolean exist = isExist(username);
        if (exist) {
            return 2;
        }
        // 默认生成 16 位盐
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;
        String encodedPassword = new SimpleHash("md5", password, salt, times).toString();
        user.setSalt(salt);
        user.setPassword(encodedPassword);
        userDao.save(user);

        return 1;
    }
    public int upuserdata(User user) {
        userDao.save(user);
        return 1;

    }
    public User findbyid(int id) {
        return userDao.findById(id).get();
    }
    public List<User> list() {
        return userDao.findAll();
    }
    public List<User> listByUsename(String username) {
        return userDao.findAllByUsernameLike(username);
    }
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
