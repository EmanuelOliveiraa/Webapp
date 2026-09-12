package org.example;
import model.*;
import model.Estado;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Estado amazonas = new Estado();
        Cidade manaus = new Cidade();


        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();


        amazonas.setNome("Amazonas");
        amazonas.setSigla("Am");

        manaus.setNome("Manaus");
        manaus.setEstado(amazonas);

        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("Joao");
        pessoa1.setEmail("joao@gmail.com");
        pessoa1.setFone("234234-234");
        pessoa1.setCidade(manaus);

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNome("Pedro");
        pessoa2.setEmail("Pedro@gmail.com");
        pessoa2.setFone("234234-001");
        pessoa2.setCidade(manaus);

        Pessoa pessoa3 = new Pessoa();
        pessoa3.setNome("Maria");
        pessoa3.setEmail("Maria@gmail.com");
        pessoa3.setFone("234234-002");
        pessoa3.setCidade(manaus);

        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
        pessoas.add(pessoa3);

        for(Pessoa p : pessoas){
            System.out.println("---Pessoa---");
            System.out.println("Nome: " + p.getNome());
            System.out.println("Email: " + p.getEmail());
            System.out.println("Fone: " + p.getFone());

            System.out.println("Cidade: " + p.getCidade().getNome());
            System.out.println("Estado: " + p.getCidade().getEstado().getNome());
        }


//        System.out.println("---Estado---");
//        System.out.println("Nome: " + amazonas.getNome());
//        System.out.println("Sigla: " + amazonas.getSigla());
//
//        System.out.println("---Cidade---");
//        System.out.println("Nome: " + manaus.getNome());
//        System.out.println("Estado: " + manaus.getEstado().getNome());


    }
}
