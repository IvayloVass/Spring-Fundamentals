package bg.softuni.spring.fundamentals.mobileLeLe.services;


import bg.softuni.spring.fundamentals.mobileLeLe.models.binding.AddOfferDto;
import bg.softuni.spring.fundamentals.mobileLeLe.models.views.OfferDetailsView;
import bg.softuni.spring.fundamentals.mobileLeLe.models.views.OfferSummaryView;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface OfferService {

    void persistOffer();

    List<OfferSummaryView> getAllOffers();

    OfferDetailsView findById(Long id);

    void deleteOffer(Long id);

    void addOffer(AddOfferDto addOfferDto, UserDetails userDetails);
}
