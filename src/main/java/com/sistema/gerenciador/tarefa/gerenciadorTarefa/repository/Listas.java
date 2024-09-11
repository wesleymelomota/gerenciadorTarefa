package com.sistema.gerenciador.tarefa.gerenciadorTarefa.repository;

import com.sistema.gerenciador.tarefa.gerenciadorTarefa.model.Item;
import com.sistema.gerenciador.tarefa.gerenciadorTarefa.model.Lista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Listas extends JpaRepository<Lista, Integer> {
    Lista findByid(Integer id);
}
