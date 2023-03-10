package pl.coderslab.charity.donation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.category.Category;

@Repository
public interface DonationRepository extends JpaRepository<Donation,Long> {

//    @Query(value = "SELECT sum(quantity) FROM Donation")
//    public Long sumQuantity();
}
