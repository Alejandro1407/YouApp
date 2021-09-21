package sv.com.udb.youapplogic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sv.com.udb.youapplogic.entities.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
}
