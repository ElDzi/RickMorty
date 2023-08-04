package pl.wdylewski.rickmorty.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.wdylewski.rickmorty.dto.CharacterDTO;
import pl.wdylewski.rickmorty.exception.CharacterNotFoundException;
import pl.wdylewski.rickmorty.service.CharacterService;

@RestController
@RequestMapping("/api/character")
public class CharacterController {

  private final CharacterService characterService;

  public CharacterController(CharacterService characterService) {
    this.characterService = characterService;
  }

  @GetMapping("/download")
  public ResponseEntity<?> getCharacterByName(@RequestParam String characterName) {
    try {
      CharacterDTO characterDTO = characterService.findCharacterByName(characterName);
      return ResponseEntity.ok(characterDTO);
    } catch (CharacterNotFoundException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}
