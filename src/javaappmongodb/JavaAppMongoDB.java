/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaappmongodb;

import javaappmongodb.model.dao.DisciplinaDao;
import javaappmongodb.model.dao.MatriculaPeriodoDao;
import javaappmongodb.model.dao.NotasDao;
import javaappmongodb.controle.AlunoControle;
import javaappmongodb.controle.AlunoControleMapReduce;

/**
 *
 * @author Edvania
 */
public class JavaAppMongoDB {
    
    //mongoimport --db SUAP_Exemplo --collection Aluno --file /home/eliezio/Aluno.json --jsonArray

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String ip = "localhost";
        String porta = "27017";
        String banco = "dados_ifrn";
        AlunoControle aluno = new AlunoControle(ip, banco, porta);
        DisciplinaDao disciplina = new DisciplinaDao(ip, banco, porta);
        NotasDao notas = new NotasDao(ip, banco, porta);
        MatriculaPeriodoDao matriculaPeriodo = new MatriculaPeriodoDao(ip, banco, porta);
        //notas.imprimir();
        aluno.imprimir();
        //disciplina.imprimir();
        //matriculaPeriodo.imprimir();
        //notas.imprimir();
        /*
        AlunoControleMapReduce alunos = new AlunoControleMapReduce(ip, banco, porta);
        for (String s : alunos.mapReduce()) {
            System.out.println(s);
        }
        */
    }
    
}
