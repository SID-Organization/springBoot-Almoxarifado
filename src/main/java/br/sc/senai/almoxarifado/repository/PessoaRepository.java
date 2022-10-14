package br.sc.senai.almoxarifado.repository;

import br.sc.senai.almoxarifado.model.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    boolean existsByMatricula(String matricula);
    void deleteByMatricula(String matricula);
    Optional<Pessoa> findByMatricula(String matricula);
}