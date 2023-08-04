package pl.wdylewski.rickmorty.dto;

import java.util.List;

public class CharacterDTO {

  private Long id;
  private String name;
  private String status;
  private String species;
  private String type;
  private String gender;
  private LocationDTO origin;
  private LocationDTO location;
  private String image;
  private List<String> episode;
  private String url;
  private String created;

  public CharacterDTO() {
  }

  public CharacterDTO(Long id, String name, String status, String species, String type,
      String gender,
      LocationDTO origin, LocationDTO location, String image, List<String> episode, String url,
      String created) {
    this.id = id;
    this.name = name;
    this.status = status;
    this.species = species;
    this.type = type;
    this.gender = gender;
    this.origin = origin;
    this.location = location;
    this.image = image;
    this.episode = episode;
    this.url = url;
    this.created = created;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getSpecies() {
    return species;
  }

  public void setSpecies(String species) {
    this.species = species;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public LocationDTO getOrigin() {
    return origin;
  }

  public void setOrigin(LocationDTO origin) {
    this.origin = origin;
  }

  public LocationDTO getLocation() {
    return location;
  }

  public void setLocation(LocationDTO location) {
    this.location = location;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public List<String> getEpisode() {
    return episode;
  }

  public void setEpisode(List<String> episode) {
    this.episode = episode;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getCreated() {
    return created;
  }

  public void setCreated(String created) {
    this.created = created;
  }
}
