package br.com.webdzion.twclients.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table
public class Client {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String nome;

  @Column(nullable = false, name = "date_birth")
  @DateTimeFormat(iso = ISO.DATE)
  private LocalDate dateBirth;

  @Column(nullable = false)
  private String profession;

  public Client() {
  }

  public Client(Long id, String nome, LocalDate dateBirth, String profession) {
    this.id = id;
    this.nome = nome;
    this.dateBirth = dateBirth;
    this.profession = profession;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public LocalDate getDateBirth() {
    return dateBirth;
  }

  public void setDateBirth(LocalDate dateBirth) {
    this.dateBirth = dateBirth;
  }

  public String getProfession() {
    return profession;
  }

  public void setProfession(String profession) {
    this.profession = profession;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((nome == null) ? 0 : nome.hashCode());
    result = prime * result + ((dateBirth == null) ? 0 : dateBirth.hashCode());
    result = prime * result + ((profession == null) ? 0 : profession.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Client other = (Client) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (nome == null) {
      if (other.nome != null)
        return false;
    } else if (!nome.equals(other.nome))
      return false;
    if (dateBirth == null) {
      if (other.dateBirth != null)
        return false;
    } else if (!dateBirth.equals(other.dateBirth))
      return false;
    if (profession == null) {
      if (other.profession != null)
        return false;
    } else if (!profession.equals(other.profession))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Client [id=" + id + ", nome=" + nome + ", dateBirth=" + dateBirth + ", profession=" + profession + "]";
  }

  

}
