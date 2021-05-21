package br.com.arena.arena;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ContatoRepository extends CrudRepository<Contato, Long>{
    List<Contato> findAll();
}
      