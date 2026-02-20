package desafio.praticando;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import desafio.praticando.models.Tarefa;

public class AppTarefa {
    public void executar() throws StreamWriteException, DatabindException, IOException {
        Tarefa tarefa = new Tarefa();
        tarefa.setDescricao("Acordar às 07h");
        tarefa.setConcluida(false);
        tarefa.setPessoaResponsavel("LKSFerreira");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("tarefa.json"), tarefa);

        var tarefaLida = objectMapper.readValue(new File("tarefa_in.json"), Tarefa.class);
        System.out.println(tarefaLida);
    }
}
