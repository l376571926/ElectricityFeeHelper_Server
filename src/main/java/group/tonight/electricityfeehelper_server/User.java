package group.tonight.electricityfeehelper_server;

import javax.persistence.*;

@Entity
@Table(name = "t_user")//手动指定表名
public class User {

    @Id
    @GeneratedValue
    @Column(name = "t_id")//手动指定当前字段对应数据库中字段名
    private Long id;

    @Column(name = "t_name")
    private String name;

    @Column(name = "t_phone")
    private String phone;

    @Column(name = "t_password")
    private String password;

    @Column(name = "t_age")
    private int age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
