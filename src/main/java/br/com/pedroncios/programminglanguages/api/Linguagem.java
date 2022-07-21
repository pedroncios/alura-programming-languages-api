package br.com.pedroncios.programminglanguages.api;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="linguagens")
public class Linguagem {
    
    @Id
    private String id;
    private String nome;
    private String imagem;
    private int rank;    
    
    public Linguagem(String nome, String imagem, int rank) {
        this.nome = nome;
        this.imagem = imagem;
        this.rank = rank;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    
    public String getImagem() {
        return imagem;
    }
    
    public int getRank() {
        return rank;
    }    
}
