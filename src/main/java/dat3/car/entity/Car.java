package dat3.car.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity // identifies the class as an entity class
// @Table(name = "AUTHORS", schema = "STORE") = rødt
public class Car {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment the primary key
  @Column(name="id", updatable = false, nullable = false)
  private Integer id;
  @Column(name="car_brand", length=50, nullable = false)
  private String brand;
  @Column(name="car_model", length=60, nullable = false)
  private String model;
  @Column(name = "rental_price_day")
  private double pricePrDay;
  @Column(name = "max_discount")
  private Integer bestDiscount;
  @CreationTimestamp // ikke med i constructor, den bliver automatisk givet af Hibernate
  private LocalDateTime carCreated;
  @UpdateTimestamp
  private LocalDateTime carLastEdited;

/*
When a new entity gets persisted, Hibernate gets the current timestamp from the JVM (Java Virtual machine)
and sets it as the value of the attribute annotated with @CreationTimestamp.
OBS: Only in INSERT statement!

@UpdateTimestamp gets changed in a similar way with every SQL Update statement.
OBS: only changed with every SQL-UPDATE statement!
 */

  public Car(){} // public no-ark constructor

  public Car(@NonNull String brand, @NonNull String model, double pricePrDay, Integer bestDiscount) {
    this.brand = brand;
    this.model = model;
    this.pricePrDay = pricePrDay;
    this.bestDiscount = bestDiscount;
  }
}
