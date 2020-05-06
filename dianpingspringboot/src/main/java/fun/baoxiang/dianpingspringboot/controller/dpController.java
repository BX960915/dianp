package fun.baoxiang.dianpingspringboot.controller;


import fun.baoxiang.dianpingspringboot.entity.dp;
import fun.baoxiang.dianpingspringboot.result.Result;
import fun.baoxiang.dianpingspringboot.result.ResultFactory;
import fun.baoxiang.dianpingspringboot.service.dpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class dpController {
    @Autowired
    dpService dpservice;
    @CrossOrigin
    @PostMapping(value = "api/dp")
    public Result onSubmit(@RequestBody dp fabudp) {
//        String title = fabudp.getTitle();
//        title = HtmlUtils.htmlEscape(title);
//        String xiangqing = fabudp.getXiangqing();
//        xiangqing = HtmlUtils.htmlEscape(xiangqing);
//        String auther = fabudp.getAuther();
//        auther = HtmlUtils.htmlEscape(auther);
        dpservice.add(fabudp);

        return ResultFactory.buildSuccessResult("ddsc");
    }

    @CrossOrigin
    @GetMapping(value = "/api/dps")
    public List<dp> list() throws Exception {
//        System.out.println("chakam");
        return dpservice.list();

    }

    @CrossOrigin
    @GetMapping(value = "api/{dpid}/dpmsg")
    public List<dp> listByUsername(@PathVariable("dpid") int dpid) throws Exception {
//        System.out.println(dpid);
        return dpservice.listBydpid(dpid);

    }
    @CrossOrigin
    @GetMapping(value = "api/{auther}/mydpmsg")
    public List<dp> listByUsername(@PathVariable("auther") String auther) throws Exception {
//        System.out.println(auther);
        return dpservice.listByauther(auther);
    }
    @CrossOrigin
    @GetMapping(value = "api/{cid}/dps")
    public List<dp> listByCid(@PathVariable("cid") int cid) throws Exception {
//        System.out.println(auther);
        if (0 != cid) {
//            System.out.println("cid"+cid);
            return dpservice.listByCid(cid);
        } else {
            return list();
        }
//        return dpservice.listByCid(cid);
    }

//    @GetMapping("/api/{cid}/dps")
//
//    public List<dp> listByCategory(@PathVariable("cid") int cid) throws Exception {
//        if (0 != cid) {
//            System.out.println("cid"+cid);
//            return dpservice.listBycid(cid);
//        } else {
//            return list();
//        }
//    }
}
