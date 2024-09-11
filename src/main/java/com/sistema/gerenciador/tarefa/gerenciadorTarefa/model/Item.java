package com.sistema.gerenciador.tarefa.gerenciadorTarefa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sistema.gerenciador.tarefa.gerenciadorTarefa.DTO.ItemDto;
import com.sistema.gerenciador.tarefa.gerenciadorTarefa.Enums.EstadoItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50)
    private String titulo;
    @Column(length = 250)
    private String descricao;
    private Boolean prioridade;
    @Enumerated(EnumType.STRING)
    private EstadoItem estado;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "lista_id")
    private Lista lista;

    public void alterarEstado(EstadoItem novoEstadoItem){
        this.estado = novoEstadoItem;
    }
    public void destacarItem(){
        this.prioridade = true;
    }
    public void removerDestaque(){
        this.prioridade = false;
    }
    public Item convertItemDto(ItemDto itemDto){
        this.id = itemDto.getId();
        this.prioridade = itemDto.getPrioridade();
        this.estado = itemDto.getEstado();
        this.descricao = itemDto.getDescricao();
        this.titulo = itemDto.getTitulo();
        return this;
    }
}
