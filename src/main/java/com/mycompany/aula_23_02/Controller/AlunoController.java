/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aula_23_02.Controller;

import com.mycompany.aula_23_02.Model.Aluno;
import com.mycompany.aula_23_02.Model.DAOAluno;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Android
 */
public class AlunoController {

    private static DAOAluno dao = null;

    public AlunoController() {
        if (dao == null) {
            dao = new DAOAluno();
        }
    }

    public void carregaAlunos() throws FileNotFoundException {
        dao.carregaAlunos();
    }

    public boolean salvar(String nome, String ra) throws IOException {
        Aluno aluno = new Aluno(nome, ra);
        return dao.cadastra(aluno);

    }

    // Gera o modelo de dados para o jTable
    public void gerarTableModel(JTable tabelaAlunos) {
        DefaultTableModel modelo = (DefaultTableModel) tabelaAlunos.getModel();
        Object[] objetos = new Object[2];// quantidade de colunas
        // obter a listagem de alunos
        List<Aluno> alunos = dao.listaAlunos();
        // Para cada aluno da lista colocar o nome e ra dentro de vetor objetos
        for (Aluno aluno : alunos) {
            objetos[0] = aluno.getNome();
            objetos[1] = aluno.getRa();
            modelo.addRow(objetos);
        }

    }

    
    public void deletarAluno(JTable tabelaAlunos, int rowIndex, Aluno aluno) {
        DefaultTableModel modelo = (DefaultTableModel) tabelaAlunos.getModel();
        modelo.removeRow(rowIndex);
        dao.removeAluno(aluno);
        
    }

}
