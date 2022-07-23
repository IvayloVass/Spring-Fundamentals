package bg.softuni.spring.fundamentals.mobileLeLe.web;

import bg.softuni.spring.fundamentals.mobileLeLe.models.binding.AddOfferDto;
import bg.softuni.spring.fundamentals.mobileLeLe.services.BrandService;
import bg.softuni.spring.fundamentals.mobileLeLe.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/offers")
public class OfferController {

    private final OfferService offerService;
    private final BrandService brandService;

    @Autowired
    public OfferController(OfferService offerService, BrandService brandService) {
        this.offerService = offerService;
        this.brandService = brandService;
    }

    @ModelAttribute("addOfferDto")
    public AddOfferDto addOfferDto() {
        return new AddOfferDto();
    }

    @GetMapping("/all")
    public String allOffers(Model model) {
        model.addAttribute("offers", offerService.getAllOffers());
        return "offers";
    }

    @GetMapping("/{id}/details")
    public String getAllOffers(@PathVariable Long id, Model model) {
        model.addAttribute("offer", offerService.findById(id));
        // ToDo create and map appropriate OfferDetailView and add thymeleaf attributes to details template
        return "details";
    }

    @GetMapping("/add")
    public String addOffer(Model model) {
        if (!model.containsAttribute("addOfferModel")){
            model.addAttribute("addOfferModel",new AddOfferDto());
        }
        model.addAttribute("brands", brandService.getAllBrands());
        return "offer-add";
    }

    @PostMapping("/add")
    public String addOffer(@Valid AddOfferDto addOfferDto,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes,
                           @AuthenticationPrincipal UserDetails userDetails) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addOfferDto", addOfferDto)
                    .addFlashAttribute("org.springframework.validation.BindingResult.addOfferDto", bindingResult);
            return "redirect:/offers/add";
        }
        offerService.addOffer(addOfferDto, userDetails);
        return "redirect:/offers/all";
    }


}
