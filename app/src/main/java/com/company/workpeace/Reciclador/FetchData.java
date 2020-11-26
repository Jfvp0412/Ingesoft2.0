package com.company.workpeace.Reciclador;

import java.io.Serializable;

public class FetchData implements Serializable {

    String name,address,lang,skills;
    String age;

    public FetchData(){

    }

    public FetchData(String name, String address, String lang, String skills, String age) {
        this.name = name;
        this.address = address;
        this.lang = lang;
        this.skills = skills;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
