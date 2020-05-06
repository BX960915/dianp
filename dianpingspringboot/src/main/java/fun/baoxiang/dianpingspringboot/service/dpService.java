package fun.baoxiang.dianpingspringboot.service;

import fun.baoxiang.dianpingspringboot.dao.dpDAO;
import fun.baoxiang.dianpingspringboot.entity.Category;
import fun.baoxiang.dianpingspringboot.entity.dp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public class dpService {
    @Autowired
    dpDAO dpdao;
    @Autowired
    CategoryService categoryService;
    public void deletdpbyid(int id){
        dpdao.deleteById(id);
    }

    public void add(dp dp) {
        dpdao.save(dp);
    }

    public List<dp> list() {
        return dpdao.findAll();
    }

    public List<dp> listBydpid(int dpid) {
        return dpdao.findAllByDpidLike(dpid);
    }

    public List<dp> listByauther(String auther) {
        return dpdao.findAllByAutherLike(auther);
    }

    public List<dp> listByCid(int cid) {
        return dpdao.findAllByCidLike(cid);
    }

}

