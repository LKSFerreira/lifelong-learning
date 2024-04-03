package ferreira.crudrestapidatajpa.models.form;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoForm {

  @NotBlank(message = "O campo nome não pode ser em branco")
  @Size(min = 3, max = 100, message = "O '{validatedValue}' nome deve ter entre {min} e {max} caracteres")
  private String nome;

  @NotBlank(message = "O cpf não pode ser vazio")
  @CPF(message = "'{validatedValue}' não é um cpf válido")
  private String cpf;

  @NotBlank(message = "O bairro não pode ser em branco")
  @Size(min = 3, max = 100, message = "O '{validatedValue}' bairro deve ter entre {min} e {max} caracteres")
  private String bairro;

  @NotNull(message = "A data de nascimento não pode ser em branco")
  @Past(message = "A data de nascimento '{validatedValue}' deve ser anterior a data atual")
  @JsonFormat(pattern = "dd-MM-yyyy") // Jackson para formatar a data
  private LocalDate dataNascimento;
}
