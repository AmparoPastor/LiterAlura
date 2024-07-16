package com.literalura.Literalura.principal;

import com.literalura.Literalura.model.DadosAuthor;
import com.literalura.Literalura.model.DadosLivro;
import com.literalura.Literalura.service.ConsumoApi;
import com.literalura.Literalura.service.ConverteDados;

import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();
    private final String ENDERECO = "https://gutendex.com/books/";

    public void exibeMenu(){
        var opcao = -1;
        String menu = """
                +-+-BENVINDO A LITERALURA-+-+
                --- Digite uma opção ---
                1.- Procurar livro
                2.- Procurar autor
                3.- Procurar livros pelo idioma publicado
                4.- Listar todos os livros cadastrados
                6;- Listar autores vivos em determinado ano
                0.- Sair
                """;

            while (opcao != 0) {
                System.out.println(menu);

                opcao = leitura.nextInt();
                if (opcao == 1) {
                    System.out.println("Digite o nome do livro: ");
                    var livro = leitura.nextLine();
                    var json = consumo.obterDados
                            (ENDERECO + livro.replace(" ", "%20"));

                    DadosLivro dados = conversor.obterDados(json, DadosLivro.class);
                    System.out.println(dados);

                } else if (opcao == 2) {
                    System.out.println("Digite o nome do autor: ");
                    var author = leitura.nextLine();
                    var json = consumo.obterDados
                            (ENDERECO + author.replace(" ", "%20"));
                    DadosAuthor dados = conversor.obterDados(json, DadosAuthor.class);
                    System.out.println(dados);
                } else if (opcao == 3) {
                    System.out.println("Digite o id: ");
                    var id = leitura.nextLine();
                    var json = consumo.obterDados
                            (ENDERECO + "?ids=" + id);
                    DadosLivro dados = conversor.obterDados(json, DadosLivro.class);
                    System.out.println(dados);

                }
            }
        }
    }


