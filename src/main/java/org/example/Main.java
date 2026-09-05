package org.example;
import model.*;
import model.Estado;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Estado amazonas = new Estado();
        Cidade manaus = new Cidade();
        Pessoa pessoa = new Pessoa();

        amazonas.setNome("Amazonas");
        amazonas.setSigla("Am");

        manaus.setNome("Manaus");
        manaus.setEstado(amazonas);

        pessoa.setNome("Joao");
        pessoa.setEmail("joao@gmail.com");
        pessoa.setFone("234234-234");
        pessoa.setCidade(manaus);

        System.out.println("---Estado---");
        System.out.println("Nome: " + amazonas.getNome());
        System.out.println("Sigla: " + amazonas.getSigla());

        System.out.println("---Cidade---");
        System.out.println("Nome: " + manaus.getNome());
        System.out.println("Estado: " + manaus.getEstado().getNome());

        System.out.println("---Pessoa---");
        System.out.println("Nome: " + pessoa.getNome());
        System.out.println("Email: " + pessoa.getEmail());
        System.out.println("Fone: " + pessoa.getFone());

        System.out.println("Cidade: " + pessoa.getCidade().getNome());
        System.out.println("Estado: " + pessoa.getCidade().getEstado().getNome());


    }
}
