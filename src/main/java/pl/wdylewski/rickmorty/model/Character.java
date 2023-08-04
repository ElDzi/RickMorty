package pl.wdylewski.rickmorty.model;


import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rickmorty_characters")
public class Character {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String status;
  private String species;
  private String type;
  private String gender;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "origin_id")
  private Location origin;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "last_known_location_id")
  private Location location;

  private String image;

  @ElementCollection
  @CollectionTable(name = "character_episodes", joinColumns = @JoinColumn(name = "character_id"))
  @Column(name = "episode_url")
  private List<String> episode;

  private String url;
  private String created;

  public Character() {
  }

  public Character(Long id, String name, String status, String species, String type, String gender,
      Location origin, Location location, String image, List<String> episode, String url,
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

  public Location getOrigin() {
    return origin;
  }

  public void setOrigin(Location origin) {
    this.origin = origin;
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
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
