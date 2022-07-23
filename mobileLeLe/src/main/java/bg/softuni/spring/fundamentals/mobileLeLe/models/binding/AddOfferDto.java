package bg.softuni.spring.fundamentals.mobileLeLe.models.binding;

import bg.softuni.spring.fundamentals.mobileLeLe.models.entities.enums.Engine;
import bg.softuni.spring.fundamentals.mobileLeLe.models.entities.enums.Transmission;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class AddOfferDto {

    @NotNull
    @Min(1)
    private Long modelId;

    @NotNull
    private Engine engine;

    @NotNull
    @Positive
    private BigDecimal price;

    @NotNull
    @Min(1900)
    private int year;

    @Positive
    private Integer mileage;

    @NotBlank
    private String description;

    @NotNull
    private Transmission transmission;

    @NotBlank
    private String imageUrl;

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
