package fun.baoxiang.dianpingspringboot.dao;

import fun.baoxiang.dianpingspringboot.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDAO extends JpaRepository<Category, Integer> {
}
