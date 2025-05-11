package org.example.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "countries")
@NamedQueries({
        @NamedQuery(name = "Countries.findByName",
                query = "SELECT c FROM Countries c WHERE c.name LIKE :name")
})
public class Countries {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "code", nullable = false)
  private String code;

  @ManyToOne
  @JoinColumn(name = "continent", nullable = false)
  private Continents continent;

  // Getters & Setters
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Continents getContinent() {
    return continent;
  }

  public void setContinent(Continents continent) {
    this.continent = continent;
  }
}
