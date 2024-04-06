/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aula_23_02.Model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Android
 */
public class DAOAluno {
    private List<Aluno> alunos = new ArrayList<Aluno>();

    public void carregaAlunos() throws FileNotFoundException {
        FileReader arquivo = new FileReader("alunos.txt");
        Scanner leitor = new Scanner(arquivo);

        // enquanto houver linhas no arquivo
        while (leitor.hasNext()) {
            // leia os dados do aluno
            String dados = leitor.nextLine();
            // separar nome do ra, utilizando o - como separador
            String[] info = dados.split("-");

            // fazer como Jake.. pegar os dados do aluno
            String nome = info[0];
            String ra = info[1] + "-" + info[2];

            // montar o "Frankie" ..aluno
            Aluno aluno = new Aluno(nome, ra);

            // cadastrar no Array
            alunos.add(aluno);

        }
    }

    public boolean cadastra(Aluno novo) throws IOException {
        cadastraEmArq(novo);
        return alunos.add(novo);

    }

    public void cadastraEmArq(Aluno novo) throws IOException {
        FileWriter file = new FileWriter("alunos.txt");
        PrintWriter writer = new PrintWriter(file);
        writer.print(novo);
        writer.close();
        file.close();

    }

    public List<Aluno> listaAlunos() {
        return alunos;
    }

    public boolean editaAluno(Aluno antigo, Aluno novo) {
        if (alunos.contains(antigo)) {
            int posicao = alunos.indexOf(antigo);
            alunos.set(posicao, novo);
            return true;
        }
        return false;
    }

    public boolean removeAluno(Aluno aluno) {
        return alunos.remove(aluno);
    }
}
