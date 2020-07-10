package com.lmFreire.cursomc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String nome;
}
