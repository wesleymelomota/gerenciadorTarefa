package com.sistema.gerenciador.tarefa.gerenciadorTarefa.controller;

import com.sistema.gerenciador.tarefa.gerenciadorTarefa.DTO.ListaDto;
import com.sistema.gerenciador.tarefa.gerenciadorTarefa.model.Item;
import com.sistema.gerenciador.tarefa.gerenciadorTarefa.model.Lista;
import com.sistema.gerenciador.tarefa.gerenciadorTarefa.service.ListaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/listas")
public class ListaController  {

    private final ListaService service;
    public ListaController(ListaService service){
        this.service=service;
    }

    @GetMapping
    public List<Lista> obterListas(){
        return service.obterTodasListas();
    }
    @PostMapping
    public Integer criarListaTarefa(@RequestBody ListaDto lista){
        return service.salvarLista(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lista> obterListaTarefa(@PathVariable Integer id){
        return service.encontrarTarefaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/{id}/itens")
    public ResponseEntity<List<Item>> obterItensOrdenados(@PathVariable Integer id) {
        List<Item> itensOrdenados = service.obterItensOrdenadosPorPrioridade(id);
        return ResponseEntity.ok(itensOrdenados);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLista(@PathVariable Integer id){
        service.deletarLista(id);
        return ResponseEntity.noContent().build();
    }

}
