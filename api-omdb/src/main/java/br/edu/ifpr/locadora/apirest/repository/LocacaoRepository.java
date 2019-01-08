package br.edu.ifpr.locadora.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpr.locadora.apirest.models.Locacao;

public interface LocacaoRepository extends JpaRepository<Locacao, Long>{

	Locacao findById(long id);
}
