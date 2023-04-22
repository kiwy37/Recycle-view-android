package com.example.tema_1_android;

public class Animal {
    private String name;
    private String continent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public Animal(String name, String continent) {
        this.name = name;
        this.continent = continent;
    }
}
