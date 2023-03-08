package pl.coderslab.charity.donation;

import pl.coderslab.charity.category.Category;
import pl.coderslab.charity.institution.Institution;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "donation")
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity;
    @OneToMany
    @JoinColumn(name = "category_id")
    private List<Category> categories = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "institution_id")
    private Institution institution;

    private String street;

    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private String pickUpComment;
}
