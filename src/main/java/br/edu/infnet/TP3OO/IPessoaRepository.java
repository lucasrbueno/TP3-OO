package br.edu.infnet.TP3OO;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IPessoaRepository extends JpaRepository<Pessoa, Integer> {
    
}
