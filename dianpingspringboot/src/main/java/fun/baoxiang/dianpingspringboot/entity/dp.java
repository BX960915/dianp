package fun.baoxiang.dianpingspringboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "dp")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class dp {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "点评编号")
    private int dpid;
    @Column(name = "标题",length = 12)
    private String title;
    @Column(name = "详情")
    private String xiangqing;
    @Column(name = "发布人")
    private String auther;

    @Column(name = "分类")
    private int cid;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    public int getDpid() {
        return dpid;
    }

    public void setDpid(int dpid) {
        this.dpid = dpid;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getXiangqing() {
        return xiangqing;
    }

    public void setXiangqing(String xiangqing) {
        this.xiangqing = xiangqing;
    }
}
