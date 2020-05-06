package fun.baoxiang.dianpingspringboot.service;

import fun.baoxiang.dianpingspringboot.dao.CategoryDAO;
import fun.baoxiang.dianpingspringboot.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    CategoryDAO categoryDAO;
    public Category get(int id) {
        Category c= categoryDAO.findById(id).orElse(null);
        return c;
    }
}
