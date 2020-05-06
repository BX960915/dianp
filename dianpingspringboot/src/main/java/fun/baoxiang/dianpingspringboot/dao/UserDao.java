package fun.baoxiang.dianpingspringboot.dao;

import fun.baoxiang.dianpingspringboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User,Integer> {
    User findByUsername(String username);
    User getByUsernameAndPassword(String username,String password);
    List<User> findAllByUsernameLike(String username);

}
