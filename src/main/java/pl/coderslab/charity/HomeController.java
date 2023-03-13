package pl.coderslab.charity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.w3c.dom.stylesheets.LinkStyle;
import pl.coderslab.charity.category.CategoryRepository;
import pl.coderslab.charity.donation.DonationRepository;
import pl.coderslab.charity.institution.Institution;
import pl.coderslab.charity.institution.InstitutionRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;


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
        long countOfDonations = donationRepository.count();
        model.addAttribute("countOfDonations",countOfDonations);
        long sumOfBags = donationRepository.sumQuantity();
        model.addAttribute("sumOfBags",sumOfBags);

        long countOfInstututions = institutionRepository.findAll().size();
        model.addAttribute("countOfInstututions",countOfInstututions);

        List<Institution> institutions = institutionRepository.findAll();
        HashMap<Institution,Institution> institutionHashMap = new HashMap<>();
//        Institution[][] institutionArray = new Institution[][];
        for (int i = 0; i < institutions.size(); i++) {
            if(institutions.size()%2 == 0) {
                institutionHashMap.put(institutions.get(i),institutions.get(i+1));
            }
        }
        model.addAttribute("institutionHashMap",institutionHashMap);


        return "index";
    }


}
