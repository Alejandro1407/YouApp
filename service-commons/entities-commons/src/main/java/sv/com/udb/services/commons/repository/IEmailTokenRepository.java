package sv.com.udb.services.commons.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sv.com.udb.services.commons.entities.EmailToken;

import java.util.List;
import java.util.Optional;

public interface IEmailTokenRepository
      extends JpaRepository<EmailToken, Integer> {
   List<EmailToken> getEmailTokenByUserId(String principalId);

   Optional<EmailToken> getEmailTokenByToken(String token);
}
