package br.com.webdzion.twclients.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.webdzion.twclients.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
  
}
