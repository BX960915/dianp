package fun.baoxiang.dianpingspringboot.controller;

import fun.baoxiang.dianpingspringboot.dao.pinglunDAO;
import fun.baoxiang.dianpingspringboot.entity.User;
import fun.baoxiang.dianpingspringboot.entity.pinglun;
import fun.baoxiang.dianpingspringboot.result.Result;
import fun.baoxiang.dianpingspringboot.result.ResultFactory;
import fun.baoxiang.dianpingspringboot.service.dpService;
import fun.baoxiang.dianpingspringboot.service.pinglunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

@RestController
public class PinglunController {
    @Autowired
    pinglunDAO pinglunDAO;
    @Autowired
    pinglunService pinglunservice;
    @CrossOrigin
    @PostMapping(value = "/api/pinglun")
    public Result pinglun(@RequestBody pinglun fabupinglun){
        String content =fabupinglun.getContent();
        content= HtmlUtils.htmlEscape(content);
        int dpid=fabupinglun.getDpid();
        pinglunservice.add(fabupinglun);
        return ResultFactory.buildSuccessResult("CDC");
    }

    @CrossOrigin
    @GetMapping(value = "api/{dpid}/pinglunmsg")
    public List<pinglun> listByUsername(@PathVariable("dpid") int dpid) throws Exception {
        return pinglunservice.listBydpid(dpid);

    }
    @CrossOrigin
    @PostMapping(value = "api/value")
    public Result newvulue(@RequestBody pinglun plvalue) throws Exception {
        int plid = plvalue.getPlid();
        String auther =plvalue.getAuther();
        int dpid =plvalue.getDpid();
        String content=plvalue.getContent();
        String value =plvalue.getValue();

        System.out.println(plvalue);

        pinglun newpl=pinglunservice.findbuplid(plid);
        newpl.setAuther(auther);
        newpl.setContent(content);
        newpl.setDpid(dpid);
        newpl.setValue(value);
        pinglunDAO.save(newpl);
        return ResultFactory.buildSuccessResult("OK");

    }
    @CrossOrigin
    @GetMapping(value = "api/{plid}/plvalue")
    public List<pinglun> listByplid(@PathVariable("plid") int plid) throws Exception {
//        System.out.println(auther);
        return pinglunservice.listByplid(plid);
    }
    @CrossOrigin
    @PostMapping(value = "api/{plid}/delpinglun")
    public Result delpinglun(@PathVariable("plid") int plid) throws Exception {
        pinglunservice.deletpinglunbyplid(plid);
        return ResultFactory.buildSuccessResult("成功");
    }
}
