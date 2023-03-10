package pl.coderslab.charity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.donation.DonationRepository;


@Controller
public class HomeController {
    DonationRepository donationRepository;

    @RequestMapping("/")
    public String homeAction(Model model){

//        long sumOfBags = donationRepository.sumQuantity();
        long countDonations = donationRepository.count();
        model.addAttribute("countDonations",countDonations);
//        model.addAttribute("sumOfBags",sumOfBags);
        return "index";
    }


}
