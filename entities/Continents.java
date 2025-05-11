package org.example.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "continents")
@NamedQueries({
        @NamedQuery(name = "Continents.findByName",
                query = "SELECT c FROM Continents c WHERE c.name = :name")
})
public class Continents {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "name", nullable = false)
  private String name;

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
}
