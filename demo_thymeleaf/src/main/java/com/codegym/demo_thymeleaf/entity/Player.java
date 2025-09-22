package com.codegym.demo_thymeleaf.entity;
public class Player {
    private int id;
    private String name;
    private String birthday;
    private int experience;
    private String position;
    private String avatar;

    public Player() {
    }

    public Player(int id, String name, String birthday, int experience, String position, String avatar) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.experience = experience;
        this.position = position;
        this.avatar = avatar;
    }

    // getter & setter
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