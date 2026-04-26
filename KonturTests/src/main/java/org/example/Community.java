package org.example;

public class Community {
    private String name;
    private String description;

    public Community(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
