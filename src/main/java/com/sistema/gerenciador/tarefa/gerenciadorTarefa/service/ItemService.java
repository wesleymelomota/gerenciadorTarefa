package com.sistema.gerenciador.tarefa.gerenciadorTarefa.service;

import com.sistema.gerenciador.tarefa.gerenciadorTarefa.DTO.ItemDto;
import com.sistema.gerenciador.tarefa.gerenciadorTarefa.model.Item;
import com.sistema.gerenciador.tarefa.gerenciadorTarefa.model.Lista;
import com.sistema.gerenciador.tarefa.gerenciadorTarefa.repository.Itens;
import com.sistema.gerenciador.tarefa.gerenciadorTarefa.repository.Listas;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private final Itens repository;
    private final Listas listaRepository;
    public ItemService(Itens repository, Listas listaRepository){
        this.listaRepository = listaRepository;
        this.repository = repository;
    }
    public Integer salvarItem(ItemDto itemDto) {
        Item item = new Item();
        item.setDescricao(itemDto.getDescricao());
        item.setEstado(itemDto.getEstado());
        item.setTitulo(itemDto.getTitulo());
        item.setPrioridade(itemDto.getPrioridade());
        repository.save(item);
        return item.getId();
    }
    public Integer adicionarItemLista(Integer idLista, ItemDto itemDto)  {
        Lista listaTarefa = listaRepository.findById(idLista).orElseThrow();
        Item item = new Item();
        item.setLista(listaTarefa);
        return repository.save(item.convertItemDto(itemDto)).getId();
    }
    public Item editarItem(Integer itemId, Item itemAtualizado){
        Item item = repository.findById(itemId).orElseThrow();
        item.setTitulo(itemAtualizado.getTitulo());
        item.setDescricao(itemAtualizado.getDescricao());
        item.setEstado(itemAtualizado.getEstado());
        item.setPrioridade(itemAtualizado.getPrioridade());
        return repository.save(item);
    }
    public void deleteItem(Integer id){
        repository.deleteById(id);
    }
    public Item procurarItem(Integer id){
        return repository.findByid(id);
    }

}
