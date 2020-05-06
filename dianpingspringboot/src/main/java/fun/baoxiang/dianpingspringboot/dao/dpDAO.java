package fun.baoxiang.dianpingspringboot.dao;

import fun.baoxiang.dianpingspringboot.entity.Category;
import fun.baoxiang.dianpingspringboot.entity.dp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;
import java.util.List;

public interface dpDAO extends JpaRepository<dp, Integer> {
    dp findByTitle(String title);

    dp getByTitleAndXiangqing(String title, String xiangqing);

    List<dp> findAllByDpidLike(int dpid);

    List<dp> findAllByAutherLike(String auther);

    List<dp> findAllByCidLike(int cid);

    //    List<dp> findAllByTitleLikeOrAuthorLike(String keyword1, String keyword2);


}
