package com.literalura.Literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosApi(@JsonAlias("count") Integer registros,
                       @JsonAlias("results") ArrayList<DadosLivro> livros) {
}
