package com.sistema.gerenciador.tarefa.gerenciadorTarefa.service;


import com.sistema.gerenciador.tarefa.gerenciadorTarefa.DTO.ItemDto;
import com.sistema.gerenciador.tarefa.gerenciadorTarefa.DTO.ListaDto;
import com.sistema.gerenciador.tarefa.gerenciadorTarefa.DTO.ListaDtoUpdate;
import com.sistema.gerenciador.tarefa.gerenciadorTarefa.model.Item;
import com.sistema.gerenciador.tarefa.gerenciadorTarefa.model.Lista;
import com.sistema.gerenciador.tarefa.gerenciadorTarefa.repository.Listas;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ListaService {

    private Listas repository;

    public ListaService(Listas repository){
        this.repository = repository;
    }

    public Integer salvarLista(ListaDto listaDto){
        Lista lista = new Lista();
        lista.setNome(listaDto.getNome());
        lista.setItens(lista.getItens());
        return repository.save(lista).getId();
    }
    public Integer atualizarLista(Integer id, ListaDtoUpdate listaDto){
        Lista lista = repository.findByid(id);
        lista.setNome(listaDto.getNome());
        return repository.save(lista).getId();
    }
    public List<Item> obterItensOrdenadosPorPrioridade(Integer listaId) {
        return repository.findById(listaId)
                .map(Lista::getItens)
                .map(this::ordenarItensPorPrioridade)
                .orElse(Collections.emptyList());
    }

    private List<Item> ordenarItensPorPrioridade(List<Item> itens) {
        return itens.stream()
                .sorted(Comparator.comparing(Item::getPrioridade).reversed()
                        .thenComparing(Item::getId))
                .collect(Collectors.toList());
    }

    public Optional<Lista> encontrarTarefaPorId(Integer id){
        return repository.findById(id);
    }
    public List<Lista> obterTodasListas(){
        return repository.findAll();
    }

    public void deletarLista(Integer id){
        repository.deleteById(id);
    }

}
