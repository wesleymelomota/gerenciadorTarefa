package com.sistema.gerenciador.tarefa.gerenciadorTarefa.repository;

import com.sistema.gerenciador.tarefa.gerenciadorTarefa.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Itens extends JpaRepository<Item, Integer> {

    Item findByid(Integer id);
}
