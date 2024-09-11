package com.sistema.gerenciador.tarefa.gerenciadorTarefa.exceptionsCustom;

public class NotFoundEx extends Exception{

    @Override
    public String getMessage(){
        return "Não encontrado!";
    }
}
