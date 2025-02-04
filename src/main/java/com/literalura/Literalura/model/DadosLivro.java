package com.literalura.Literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosLivro (
        @JsonAlias("title") String nomeLivro,
        @JsonAlias("authors") List<DadosAuthor> author,
        @JsonAlias("languages") String idioma) {
}
