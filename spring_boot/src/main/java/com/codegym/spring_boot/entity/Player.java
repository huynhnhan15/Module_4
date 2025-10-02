package com.codegym.spring_boot.entity;


import jakarta.persistence.*;

@Entity

public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String name;
    private String birthday;
    private int experience;
    private String position;
    private String avatar;

    public Player(String avatar, String birthday, int experience, int id, String name, String position) {
        this.avatar = avatar;
        this.birthday = birthday;
        this.experience = experience;
        this.id = id;
        this.name = name;
        this.position = position;
    }

    public Player() {
    }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getBirthday() { return birthday; }
    public void setBirthday(String birthday) { this.birthday = birthday; }

    public int getExperience() { return experience; }
    public void setExperience(int experience) { this.experience = experience; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public String getAvatar() { return avatar; }
    public void setAvatar(String avatar) { this.avatar = avatar; }
}