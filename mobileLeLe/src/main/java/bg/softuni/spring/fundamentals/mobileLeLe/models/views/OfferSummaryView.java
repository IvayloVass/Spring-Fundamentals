package bg.softuni.spring.fundamentals.mobileLeLe.models.views;

import bg.softuni.spring.fundamentals.mobileLeLe.models.entities.enums.Engine;
import bg.softuni.spring.fundamentals.mobileLeLe.models.entities.enums.Transmission;

import java.math.BigDecimal;

public class OfferSummaryView {

    private String description;

    private Engine engine;

    private String imageUrl;

    private int mileage;

    private BigDecimal price;

    private Transmission transmission;

    private int year;

    private String model;

    public OfferSummaryView() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
