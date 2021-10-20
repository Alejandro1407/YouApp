package sv.com.udb.services.authentication.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sv.com.udb.services.authentication.entities.OAuthRegistrationType;
import sv.com.udb.services.authentication.enums.IOAuthRegistrationType;

import java.util.List;

public interface IOAuthRegistrationRepository
      extends JpaRepository<OAuthRegistrationType, Integer> {
   @Query("SELECT o FROM oauth_registration_type o")
   @EntityGraph(value = "oauth_registration",
                type = EntityGraph.EntityGraphType.LOAD)
   List<OAuthRegistrationType> findAllWithPrincipal();
}
