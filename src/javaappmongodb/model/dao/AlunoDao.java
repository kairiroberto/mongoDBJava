package javaappmongodb.model.dao;

import javaappmongodb.model.dao.Aluno;
import java.util.*;
import com.mongodb.*;

public class AlunoDao extends Conexao {

    private Aluno aluno;
    private List<Aluno> alunos = new ArrayList<Aluno>();
    private DBCollection colecaoAluno;
    private DBCursor cursorAluno;

    public AlunoDao(String ip, String banco, String porta) {
        super(ip, banco, porta);
    }

    public DBCollection getColecaoAluno() {
        colecaoAluno = getDb().getCollection("Aluno");
        return colecaoAluno;
    }

    public DBCursor getCursorAluno() {
        cursorAluno = getColecaoAluno().find();
        return cursorAluno;
    }

    public List<Aluno> getAlunos() {
        if (alunos.size() == 0) {
            getCursorAluno();
            while (cursorAluno.hasNext()) {
                String objeto = cursorAluno.next().toString();
                String[] objeto1 = objeto.split(",");
                String curso = (objeto1[1].trim().replace("}", "").split(":"))[1];
                String cidade = (objeto1[2].trim().replace("}", "").split(":"))[1];
                String periodo = (objeto1[3].trim().replace("}", "").split(":"))[1];
                String estado = (objeto1[4].trim().replace("}", "").split(":"))[1];
                String ano = (objeto1[5].trim().replace("}", "").split(":"))[1];
                String situacao = (objeto1[6].trim().replace("}", "").split(":"))[1];
                String sexo = (objeto1[7].trim().replace("}", "").split(":"))[1];
                String data = (objeto1[8].trim().replace("}", "").split(":"))[1];
                String cep = (objeto1[9].trim().replace("}", "").split(":"))[1];
                String id = (objeto1[10].trim().replace("}", "").split(":"))[1];
                Integer idade = (new Date()).getYear() - Integer.parseInt(data.replace("\"", "").trim().substring(6)) + 1900;
                Aluno aluno = new Aluno(
                        id,
                        curso, ano, periodo, situacao,
                        cidade, estado, cep,
                        data, sexo, idade
                );
                alunos.add(aluno);
            }
            cursorAluno.close();
        }
        return alunos;
    }

    public Aluno getAluno(String id) {
        for (Aluno a : getAlunos()) {
            if (a.getId().equals(id)) {
                return a;
            }
        }
        return null;
    }
    
    public void imprimir() {
        for (Aluno a : getAlunos()) {
            System.out.println(a);
        }
    }

}
