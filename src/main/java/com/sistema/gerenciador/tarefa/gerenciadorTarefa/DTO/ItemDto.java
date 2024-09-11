package com.sistema.gerenciador.tarefa.gerenciadorTarefa.DTO;

import com.sistema.gerenciador.tarefa.gerenciadorTarefa.Enums.EstadoItem;
import lombok.Data;

@Data
public class ItemDto {
    private Integer id;
    private String titulo;
    private String descricao;
    private Boolean prioridade;
    private EstadoItem estado;

}
