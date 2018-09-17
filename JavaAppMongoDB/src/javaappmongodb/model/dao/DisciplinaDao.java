package javaappmongodb.model.dao;

import javaappmongodb.model.dao.Disciplina;
import java.util.*;
import com.mongodb.*;

public class DisciplinaDao extends Conexao {

    private List<Disciplina> disciplinas = new ArrayList<Disciplina>();
    private DBCollection colecaoDisciplina;
    private DBCursor cursorDisciplina;

    public DisciplinaDao(String ip, String banco, String porta) {
        super(ip, banco, porta);
    }

    public DBCollection getColecaoDisciplina() {
        colecaoDisciplina = getDb().getCollection("Disciplina");
        return colecaoDisciplina;
    }

    public DBCursor getCursorDisciplina() {
        cursorDisciplina = getColecaoDisciplina().find();
        return cursorDisciplina;
    }

    public List<Disciplina> getDisciplinas() {
        if (disciplinas.size() == 0) {
            getCursorDisciplina();
            while (cursorDisciplina.hasNext()) {
                String objeto = cursorDisciplina.next().toString();
                String[] objeto1 = objeto.split(",");
                String ch = (objeto1[1].trim().replace("}", "").split(":"))[1];
                String descricao = (objeto1[2].trim().replace("}", "").split(":"))[1];
                String id = (objeto1[3].trim().replace("}", "").split(":"))[1];
                Disciplina disciplina = new Disciplina(
                        id, descricao, ch
                );
                disciplinas.add(disciplina);
            }
            cursorDisciplina.close();
        }
        return disciplinas;
    }
    
    public void imprimir() {
        for (Disciplina a : getDisciplinas()) {
            System.out.println(a);
        }
    }

}
