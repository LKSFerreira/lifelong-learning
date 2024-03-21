package com.github.lksferreira.apiresttodotask.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.lksferreira.apiresttodotask.model.TaskModel;
import com.github.lksferreira.apiresttodotask.repository.ITaskRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private ITaskRepository taskRepository;

    @Operation(summary = "Stefanini - Task Gupy", description = "Retorna uma tarefa com base no UUID fornecido via parâmetro pela URI", tags = {
            "Stefanini - GET BY ID" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = ResponseEntity.class))),
            @ApiResponse(responseCode = "400", description = "Invalid Login Data supplied", content = @Content),
            @ApiResponse(responseCode = "401", description = "Invalid Authentication supplied", content = @Content),
            @ApiResponse(responseCode = "403", description = "Invalid Authorization supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Login or Password not found", content = @Content) })
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/{id}")
    public ResponseEntity<?> getTaskById(
            @Parameter(description = "Identificador Único Universal - 32 dígitos hexadecimais", example = "98765432-abcdef-1234-5678-abcdef987654") @PathVariable(name = "id") UUID id) {
        var taskFound = taskRepository.findById(id).orElse(null);
        if (taskFound == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(taskFound);
    }

    @Operation(summary = "Stefanini - Task Gupy", description = "Persiste uma nova tarefa via Request Body", tags = {
            "Stefanini - POST" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = ResponseEntity.class))),
            @ApiResponse(responseCode = "400", description = "Invalid Login Data supplied", content = @Content),
            @ApiResponse(responseCode = "401", description = "Invalid Authentication supplied", content = @Content),
            @ApiResponse(responseCode = "403", description = "Invalid Authorization supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Login or Password not found", content = @Content) })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/")
    public ResponseEntity<TaskModel> create(@RequestBody TaskModel task) {
        taskRepository.save(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

    @Operation(summary = "Stefanini - Task Gupy", description = "Retorna todas as tarefas", tags = {
            "Stefanini - GET ALL" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = ResponseEntity.class))),
            @ApiResponse(responseCode = "400", description = "Invalid Login Data supplied", content = @Content),
            @ApiResponse(responseCode = "401", description = "Invalid Authentication supplied", content = @Content),
            @ApiResponse(responseCode = "403", description = "Invalid Authorization supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Login or Password not found", content = @Content) })
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/")
    public ResponseEntity<?> getAll() {
        var tasks = taskRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(tasks);
    }
}
