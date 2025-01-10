package com.example.mybackend.Entity;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "friends")
public class Friend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String type;

    @Column(name="createdTime")
    private Date createdTime;

    private String avatarURL;

    // 构造函数、Getter和Setter方法等
    public Friend() {
    }

    public Friend(String friendName, String type, String avatarURL) {
        this.name = friendName;
        this.type = type;
        this.avatarURL = avatarURL;
        Date date = new Date();
        this.createdTime = date;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String friendName) {
        this.name = friendName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }

    public String getAvatarURL() {
        return avatarURL;
    }
}
