package bg.softuni.spring.fundamentals.mobileLeLe.models.views;

import bg.softuni.spring.fundamentals.mobileLeLe.models.entities.Model;
import bg.softuni.spring.fundamentals.mobileLeLe.models.entities.User;
import bg.softuni.spring.fundamentals.mobileLeLe.models.entities.enums.Engine;
import bg.softuni.spring.fundamentals.mobileLeLe.models.entities.enums.Transmission;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OfferDetailsView {

    private Long id;

    private String description;

    private Engine engine;

    private String imageUrl;

    private int mileage;

    private BigDecimal price;

    private Transmission transmission;

    private int year;

    private LocalDateTime created;

    private LocalDateTime modified;

    private Model model;

    private User seller;

    public OfferDetailsView() {
    }



}
