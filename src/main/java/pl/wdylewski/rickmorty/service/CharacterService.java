package pl.wdylewski.rickmorty.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.wdylewski.rickmorty.dto.CharacterDTO;
import pl.wdylewski.rickmorty.dto.LocationDTO;
import pl.wdylewski.rickmorty.exception.CharacterNotFoundException;
import pl.wdylewski.rickmorty.model.Character;
import pl.wdylewski.rickmorty.model.Location;
import pl.wdylewski.rickmorty.repository.CharacterRepository;
import pl.wdylewski.rickmorty.response.CharacterResponse;

@Service
public class CharacterService {

  private final RestTemplate restTemplate;
  private final CharacterRepository characterRepository;
  private final String API_BASE_URL = "https://rickandmortyapi.com/api/character";

  public CharacterService(CharacterRepository characterRepository, RestTemplate restTemplate) {
    this.characterRepository = characterRepository;
    this.restTemplate = restTemplate;

  }

  public static CharacterDTO mapToDTO(Character character) {
    CharacterDTO characterDTO = new CharacterDTO();
    characterDTO.setId(character.getId());
    characterDTO.setName(character.getName());
    characterDTO.setStatus(character.getStatus());
    characterDTO.setSpecies(character.getSpecies());
    characterDTO.setType(character.getType());
    characterDTO.setGender(character.getGender());
    characterDTO.setOrigin(mapToDTO(character.getOrigin()));
    characterDTO.setLocation(mapToDTO(character.getLocation()));
    characterDTO.setImage(character.getImage());
    characterDTO.setEpisode(character.getEpisode());
    characterDTO.setUrl(character.getUrl());
    characterDTO.setCreated(character.getCreated());
    return characterDTO;
  }

  public static LocationDTO mapToDTO(Location location) {
    LocationDTO locationDTO = new LocationDTO();
    locationDTO.setId(location.getId());
    locationDTO.setName(location.getName());
    locationDTO.setUrl(location.getUrl());
    return locationDTO;
  }

  public void updateDatabase() {
    List<Character> allCharacters = getAllCharacters();
    System.out.println("Found " + allCharacters.size() + " characters.");

    allCharacters.forEach(this::saveIfNotExist);
  }

  //przykładowo postać Young Jerry posiada dwa rekordy z osobymi ID 822 oraz 825, przez co usunąłem sprawdzenie również po ID w repository
  private void saveIfNotExist(Character character) {
    if (!characterRepository.existsByName(character.getName())) {
      System.out.println("Saving character #" + character.getId() + ": " + character.getName());

      characterRepository.save(character);
    }
  }

  public List<Character> getAllCharacters() {
    List<Character> allCharacters = new ArrayList<>();
    String nextPageUrl = API_BASE_URL;

    while (nextPageUrl != null) {
      ResponseEntity<CharacterResponse> response = restTemplate.exchange(nextPageUrl,
          HttpMethod.GET, null, CharacterResponse.class);
      if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
        CharacterResponse characterResponse = response.getBody();
        allCharacters.addAll(characterResponse.getResults());

        if (characterResponse.getInfo() != null && characterResponse.getInfo().getNext() != null) {
          nextPageUrl = characterResponse.getInfo().getNext();
        } else {
          nextPageUrl = null;
        }
      } else {
        throw new RuntimeException("Failed to fetch characters from the API.");
      }
    }

    return allCharacters;
  }

  public CharacterDTO findCharacterByName(String name) {
    Optional<Character> optionalCharacter = characterRepository.findByName(name);
    Character character = optionalCharacter.orElseThrow(
        () -> new CharacterNotFoundException("Character not found: " + name));
    return mapToDTO(character);
  }
}
