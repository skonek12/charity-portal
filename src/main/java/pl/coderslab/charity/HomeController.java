package pl.coderslab.charity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.category.CategoryRepository;
import pl.coderslab.charity.donation.DonationRepository;
import pl.coderslab.charity.institution.InstitutionRepository;


@Controller
public class HomeController {
    DonationRepository donationRepository;
    InstitutionRepository institutionRepository;
    CategoryRepository categoryRepository;

    public HomeController(DonationRepository donationRepository, InstitutionRepository institutionRepository, CategoryRepository categoryRepository) {
        this.donationRepository = donationRepository;
        this.institutionRepository = institutionRepository;
        this.categoryRepository = categoryRepository;
    }

    @RequestMapping("/")
    public String homeAction(Model model){

        long sumOfBags = donationRepository.sumQuantity();
        long countDonations = donationRepository.count();
        model.addAttribute("countDonations",countDonations);
        model.addAttribute("sumOfBags",sumOfBags);
        return "index";
    }


}
