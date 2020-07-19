package com.lmFreire.cursomc.dto;

import com.lmFreire.cursomc.domain.Cliente;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@NoArgsConstructor
@Getter@Setter
public class ClienteDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Preenchimento obrigatorio")
    @Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres")
    private String nome;

    @NotEmpty(message = "Preenchimento obrigatorio")
    @Email(message = "Email inválido")
    private String email;

    public ClienteDTO(Cliente obj) {
        id = obj.getId();
        nome = obj.getNome();
        email = obj.getEmail();
    }
}
