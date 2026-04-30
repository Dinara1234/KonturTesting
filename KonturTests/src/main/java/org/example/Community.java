package org.example;

public class Community {
    private String name;
    private String description;

    // Пустой конструктор обязателен для чтения из XML!
    public Community() {
    }

    public Community(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Переопределяем toString, чтобы в логах было красиво видно, какие данные подставились
    @Override
    public String toString() {
        return "Community{name='" + name + "', description='" + description + "'}";
    }
}
