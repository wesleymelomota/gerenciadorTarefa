package com.sistema.gerenciador.tarefa.gerenciadorTarefa;

/*import com.sistema.gerenciador.tarefa.gerenciadorTarefa.controller.ListaController;
import com.sistema.gerenciador.tarefa.gerenciadorTarefa.service.ListaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;*/
import com.sistema.gerenciador.tarefa.gerenciadorTarefa.controller.ListaController;
import com.sistema.gerenciador.tarefa.gerenciadorTarefa.service.ListaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


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
}
