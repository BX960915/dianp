package fun.baoxiang.dianpingspringboot.dao;

import fun.baoxiang.dianpingspringboot.entity.pinglun;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface pinglunDAO extends JpaRepository<pinglun,Integer> {

    List<pinglun> findAllByDpidLike(int dpid);

    List<pinglun> findAllByplidLike(int plid);
}
