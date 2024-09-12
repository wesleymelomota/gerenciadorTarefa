package com.sistema.gerenciador.tarefa.gerenciadorTarefa;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sistema.gerenciador.tarefa.gerenciadorTarefa.DTO.ItemDto;
import com.sistema.gerenciador.tarefa.gerenciadorTarefa.DTO.ListaDto;
import com.sistema.gerenciador.tarefa.gerenciadorTarefa.Enums.EstadoItem;
import com.sistema.gerenciador.tarefa.gerenciadorTarefa.controller.ListaController;
import com.sistema.gerenciador.tarefa.gerenciadorTarefa.model.Item;
import com.sistema.gerenciador.tarefa.gerenciadorTarefa.model.Lista;
import com.sistema.gerenciador.tarefa.gerenciadorTarefa.service.ListaService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@RunWith(SpringRunner.class)
@WebMvcTest(ListaController.class)
public class ListaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ListaService listaService;

    @Test
    void deveRetornarTodasListas() throws Exception {
        mockMvc.perform(get("/api/listas"))
                .andExpect(status().isOk());
    }
    @Test
    public void shouldCreateNewList() throws Exception {
        Item item1 = new Item();
        item1.setTitulo("tarefa");
        item1.setDescricao("fazer tarefa");
        item1.setPrioridade(false);
        item1.setEstado(EstadoItem.CONCLUIDO);
        Item item2 = new Item();
        item2.setTitulo("tarefa 2");
        item2.setDescricao("fazer tarefa 2");
        item2.setPrioridade(false);
        item2.setEstado(EstadoItem.CONCLUIDO);
        ItemDto itemDto = new ItemDto(1, "outra tarefa", "fazer tarefa", false, EstadoItem.PENDENTE);

        List<Item> itens = new ArrayList<>();
        List<ItemDto> itensDto = new ArrayList<>();

        itensDto.add(itemDto);
        itens.add(item1);
        itens.add(item2);
        ListaDto listaDto = new ListaDto(1, "Tafera 2", itensDto);
        Lista newLista = new Lista(1,"Tarefas", itens);

        ObjectMapper mapper = new ObjectMapper();

        when(listaService.salvarLista(any(ListaDto.class))).thenReturn(1);

        mockMvc.perform(post("/api/listas")
                .content(mapper.writeValueAsString(listaDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());


    }
}
