package bg.softuni.spring.fundamentals.mobileLeLe.services.impl;

import bg.softuni.spring.fundamentals.mobileLeLe.models.entities.Offer;
import bg.softuni.spring.fundamentals.mobileLeLe.models.views.OfferSummaryView;
import bg.softuni.spring.fundamentals.mobileLeLe.repositories.OfferRepository;
import bg.softuni.spring.fundamentals.mobileLeLe.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public void persistOffer() {
        //ToDo
    }

    @Override
    public List<OfferSummaryView> getAllOffers() {
        return offerRepository.findAll()
                .stream()
                .map(this::map)
                .collect(Collectors.toList());

    }

    private OfferSummaryView map(Offer offer) {
        //ToDo
        return new OfferSummaryView();
    }
}
