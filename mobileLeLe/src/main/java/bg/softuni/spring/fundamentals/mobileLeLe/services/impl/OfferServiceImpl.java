package bg.softuni.spring.fundamentals.mobileLeLe.services.impl;

import bg.softuni.spring.fundamentals.mobileLeLe.models.entities.Offer;
import bg.softuni.spring.fundamentals.mobileLeLe.models.entities.enums.Engine;
import bg.softuni.spring.fundamentals.mobileLeLe.models.entities.enums.Transmission;
import bg.softuni.spring.fundamentals.mobileLeLe.models.views.OfferSummaryView;
import bg.softuni.spring.fundamentals.mobileLeLe.repositories.ModelRepository;
import bg.softuni.spring.fundamentals.mobileLeLe.repositories.OfferRepository;
import bg.softuni.spring.fundamentals.mobileLeLe.repositories.UserRepository;
import bg.softuni.spring.fundamentals.mobileLeLe.services.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final ModelRepository modelRepository;
    private final UserRepository userRepository;

    private final ModelMapper mapper;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository, ModelRepository modelRepository, UserRepository userRepository, ModelMapper mapper) {
        this.offerRepository = offerRepository;
        this.modelRepository = modelRepository;
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public void persistOffer() {

        if (offerRepository.count() == 0) {
            Offer offer = new Offer(Engine.ELECTRIC, 96000,
                    new BigDecimal(63550), Transmission.AUTOMATIC, 2020, LocalDateTime.now());
            offer.setModel(modelRepository.findById(1L).orElse(null));
            offer.setDescription("In perfect condition, difficultly recognizable than new! Very economical choose. The engine has pretty" +
                    "good acceleration power! You can check it in every authorize service by your choice. Go ahead and by it");
            offer.setImageUrl("https://hr.cdn.mazda.media/b7d691aff1a0461e951185828bf25739/685e55a2e6344819badc42e0adee0d25.jpg?rnd=4ae933");
            offer.setSeller(userRepository.findByUsername("super@duper").orElse(null));

            offerRepository.save(offer);
        }
    }

    @Override
    public List<OfferSummaryView> getAllOffers() {
        return offerRepository.findAll()
                .stream()
                .map(this::map)
                .collect(Collectors.toList());

    }

    private OfferSummaryView map(Offer offer) {
        OfferSummaryView offerSummaryView = this.mapper.map(offer, OfferSummaryView.class);
        offerSummaryView.setModel(offer.getModel().getName());
        return offerSummaryView;
    }
}
