package dat3.car.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Member {

  @Id
  @Column(updatable = false, nullable = false)
  private String username;
  @NonNull
  private String email;
  @NonNull
  private String password;
  private String firstName;
  @NonNull
  private String lastName;

  @ElementCollection // In the database, Hibernate maps the @ElementCollection to a separate table.
  // Each value of the collection gets stored as a separate record.
  private List<String> favoriteCarColors = new ArrayList<>();

  // Skal med i constructor, oprette et hashmap for hvert nyt medlem
  @ElementCollection
  @MapKeyColumn(name = "description")
  @Column(name="phone_number")
  Map<String, String> phones = new HashMap<>();

  private String street;
  private String city;
  private String zip;
  private boolean approved;
  private int ranking;


  @CreationTimestamp // ikke med i constructor, den bliver automatisk givet af Hibernate
  private LocalDateTime memberCreated;
  @UpdateTimestamp
  private LocalDateTime memberLastEdited;


  public Member(String user, @NonNull String email, @NonNull String password,
                String firstName, @NonNull String lastName, String street, String city,
                String zip, boolean approved, int ranking) {
    this.username = user;
    this.password= password;
    this.email = email;
    this.firstName = firstName;
    this.lastName = lastName;
    this.street = street;
    this.city = city;
    this.zip = zip;
    this.approved = approved;
    this.ranking = ranking;
  }

}
