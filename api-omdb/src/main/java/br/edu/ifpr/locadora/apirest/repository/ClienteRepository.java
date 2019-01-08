package br.edu.ifpr.locadora.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpr.locadora.apirest.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	Cliente findById(long id);
}
