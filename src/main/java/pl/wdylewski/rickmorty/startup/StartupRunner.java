package pl.wdylewski.rickmorty.startup;

import java.util.Arrays;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.wdylewski.rickmorty.service.CharacterService;

@Component
public class StartupRunner implements CommandLineRunner {

  private final CharacterService characterService;

  public StartupRunner(CharacterService characterService) {
    this.characterService = characterService;
  }

  @Override
  public void run(String... args) throws Exception {
    if (args.length > 0 && Arrays.asList(args).contains("--downloadCharacters")) {
      System.out.println("Starting downloading characters from API");
      characterService.updateDatabase();
      System.out.println("Finished downloading characters from API");
    }
  }
}
