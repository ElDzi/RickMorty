package pl.wdylewski.rickmorty.response;

import java.util.List;
import pl.wdylewski.rickmorty.model.Character;

public class CharacterResponse {

  private ResponseInfo info;

  private List<Character> results;

  public ResponseInfo getInfo() {
    return info;
  }

  public void setInfo(ResponseInfo info) {
    this.info = info;
  }

  public List<Character> getResults() {
    return results;
  }

  public void setResults(List<Character> results) {
    this.results = results;
  }
}
