package bg.softuni.spring.fundamentals.mobileLeLe.services;


import bg.softuni.spring.fundamentals.mobileLeLe.models.views.OfferSummaryView;

import java.util.List;

public interface OfferService {

    void persistOffer();

    List<OfferSummaryView> getAllOffers();
}
