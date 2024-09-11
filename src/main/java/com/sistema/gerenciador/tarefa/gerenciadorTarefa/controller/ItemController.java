package com.sistema.gerenciador.tarefa.gerenciadorTarefa.controller;

import com.sistema.gerenciador.tarefa.gerenciadorTarefa.DTO.ItemDto;
import com.sistema.gerenciador.tarefa.gerenciadorTarefa.model.Item;
import com.sistema.gerenciador.tarefa.gerenciadorTarefa.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemController {
    private final ItemService service;
    public ItemController(ItemService service){
        this.service = service;
    }
    @PostMapping("/{idLista}")
    public Integer adicionarItem(@PathVariable Integer idLista, @RequestBody ItemDto itemDto){
        return service.adicionarItemLista(idLista, itemDto);
    }
    @PutMapping("/{itemId}")
    public Item editarItem(@PathVariable Integer itemId, @RequestBody Item item){
        return service.editarItem( itemId, item);
    }
    @DeleteMapping("/{id}")
    public void deletarItem(@PathVariable Integer id){
        service.deleteItem(id);
    }

    @GetMapping("/{id}")
    public Item obterItemPorId(@PathVariable Integer id){
        return service.procurarItem(id);
    }
}
