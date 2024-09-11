package com.sistema.gerenciador.tarefa.gerenciadorTarefa.DTO;

import com.sistema.gerenciador.tarefa.gerenciadorTarefa.model.Item;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class ListaDto {
    private Integer id;
    private String nome;
    private List<ItemDto> itens = new ArrayList<>();
}
