package fun.baoxiang.dianpingspringboot.service;

import fun.baoxiang.dianpingspringboot.dao.pinglunDAO;
import fun.baoxiang.dianpingspringboot.entity.pinglun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class pinglunService {
    @Autowired
    pinglunDAO pinglundao;
    public void add(pinglun pinglun) {
        pinglundao.save(pinglun);
    }
    public List<pinglun> listBydpid(int dpid) {
        return pinglundao.findAllByDpidLike(dpid);
    }

    public pinglun findbuplid(int plid) {
        return pinglundao.findById(plid).get();
    }

    public List<pinglun> listByplid(int plid) {
        return pinglundao.findAllByplidLike(plid);
    }

    public void deletpinglunbyplid(int plid) {
        pinglundao.deleteById(plid);
    }
}
