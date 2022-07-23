package bg.softuni.spring.fundamentals.mobileLeLe.models.dtos.brand;

import bg.softuni.spring.fundamentals.mobileLeLe.models.entities.Model;

import java.util.ArrayList;
import java.util.List;

public class BrandDto {

    private String name;
    private List<Model> models;

    public String getName() {
        return name;
    }

    public BrandDto setName(String name) {
        this.name = name;
        return this;
    }

    public List<Model> getModels() {
        return models;
    }

    public BrandDto setModels(List<Model> models) {
        this.models = models;
        return this;
    }

    public BrandDto addModel(Model model) {
        if (this.models == null) {
            this.models = new ArrayList<>();
        }
        this.models.add(model);
        return this;
    }
}
