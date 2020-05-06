package fun.baoxiang.dianpingspringboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "dpuser")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", length = 12)
    private int id;
    @Column(name = "用户名", unique = true,length = 12)
    private String username;
    @Column(name = "密码", nullable = false )
    private String password;
    public void setGender(String gender) {
        this.gender = gender;
    }
    @Column(name = "性别")
    private String gender;
    @Column(name = "简介", length = 120)
    private String jianjie;
    @Column(name = "居住的")
    private String address;
    @Column(name = "盐")
    private String salt;
    @Column(name = "邮箱")
    public String email;
    @Column(name = "是否禁用")
    private boolean enabled;
    @Column(name="头像")
    private String img;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getGender() {
        return gender;
    }
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getJianjie() {
        return jianjie;
    }

    public void setJianjie(String jianjie) {
        this.jianjie = jianjie;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
