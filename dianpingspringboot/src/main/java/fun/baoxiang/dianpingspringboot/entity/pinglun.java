package fun.baoxiang.dianpingspringboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "pinglun")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class pinglun {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "评论编号")
    private int plid;
    @Column(name = "评论内容")
    private String content;
    @Column(name = "所点评的编号")
    private int dpid;
    @Column(name = "是否有效")
    private String value;
    @Column(name = "回复人")
    private  String auther;


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    public int getPlid() {
        return plid;
    }

    public void setPlid(int plid) {
        this.plid = plid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
