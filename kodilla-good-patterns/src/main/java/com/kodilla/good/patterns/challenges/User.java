package com.kodilla.good.patterns.challenges;

public class User {
    private String name;
    private String nickname;

    public User(String name, String nickname) {
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return  "(" + name + ")" + nickname;
    }
}
