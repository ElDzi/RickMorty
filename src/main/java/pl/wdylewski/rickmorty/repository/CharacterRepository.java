package pl.wdylewski.rickmorty.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wdylewski.rickmorty.model.Character;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {

  Boolean existsByName(String name);
// Boolean existsByIdAndName(Long id, String name);

  Optional<Character> findByName(String name);
// Optional<List<Character>> findAllByName(String name);

}
