package br.com.lksferreira.todolist.task;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lksferreira.todolist.utils.Utils;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private ITaskRepository taskRepository;

    @GetMapping("/test")
    public String test() throws Exception {
        for (int i = 0; i < 5; i++) {
            System.out.println("-");
        }
        return "sucess";
    }

    @PostMapping(value = "/")
    public ResponseEntity<?> create(@RequestBody TaskModel task, HttpServletRequest request) {

        var currentDate = LocalDateTime.now();

        if (currentDate.isAfter(task.getStartAt()) || currentDate.isAfter(task.getEndAt())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("As datas da tarefa não podem ser menores que a data atual");
        }

        if (task.getStartAt().isAfter(task.getEndAt())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("A data de início deve ser anterior a data de término");
        }

        var idUser = (UUID) request.getAttribute("userId");
        task.setIdUser(idUser);

        var taskCreated = taskRepository.save(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskCreated);
    }

    @GetMapping(value = "/")
    public ResponseEntity<?> getAll(HttpServletRequest request) {
        var tasksList = taskRepository.findByIdUser((UUID) request.getAttribute("userId"));

        return ResponseEntity.ok(tasksList);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@RequestBody TaskModel task, HttpServletRequest request, @PathVariable UUID id) {

        // Busca a tarefa pelo id e pelo id do usuário, para garantir que a tarefa
        // pertence ao usuário

        var idUser = (UUID) request.getAttribute("userId");
        var taskFound = taskRepository.findById(id).orElse(null);

        // Se não encontrar a tarefa, retorna um erro
        if (taskFound == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada");
        }

        System.out.println(taskFound.getIdUser() + " " + idUser);

        if (!taskFound.getIdUser().equals(idUser)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Você não tem permissão para alterar esta tarefa");
        }

        // Se encontrar a tarefa, copia as propriedades não nulas do objeto recebido
        // para o objeto encontrado
        Utils.copyNonNullProperties(task, taskFound);

        var taskUpdated = taskRepository.save(taskFound);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(taskUpdated);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(@PathVariable UUID id, HttpServletRequest request) {

        var idUser = (UUID) request.getAttribute("userId");
        var taskFound = taskRepository.findById(id).orElse(null);

        if (taskFound == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada");
        }

        if (!taskFound.getIdUser().equals(idUser)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Você não tem permissão para alterar esta tarefa");
        }

        return ResponseEntity.ok(taskFound);
    }

}
