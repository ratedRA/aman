package com;

public class DestOrika {

    private String name;
    private String age;
    private String replicate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getReplicate() {
        return replicate;
    }

    public void setReplicate(String replicate) {
        this.replicate = replicate;
    }

    @Override
    public String toString() {
        return "DestOrika{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", gender=" + replicate +
                '}';
    }
}
