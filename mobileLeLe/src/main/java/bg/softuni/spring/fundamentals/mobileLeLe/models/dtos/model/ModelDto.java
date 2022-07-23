package bg.softuni.spring.fundamentals.mobileLeLe.models.dtos.model;

public class ModelDto {

    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public ModelDto setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ModelDto setName(String name) {
        this.name = name;
        return this;
    }
}
