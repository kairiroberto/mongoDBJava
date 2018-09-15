package javaappmongodb;

import java.util.*;
import com.mongodb.*;

public class MatriculaPeriodoDao extends Conexao {

    private List<MatriculaPeriodo> matriculas = new ArrayList<MatriculaPeriodo>();
    private DBCollection colecaoMatricula;
    private DBCursor cursorMatricula;

    public MatriculaPeriodoDao(String ip, String banco, String porta) {
        super(ip, banco, porta);
    }

    public DBCollection getColecaoMatricula() {
        colecaoMatricula = getDb().getCollection("MatriculaPeriodo");
        return colecaoMatricula;
    }

    public DBCursor getCursorMatricula() {
        cursorMatricula = getColecaoMatricula().find();
        return cursorMatricula;
    }

    public List<MatriculaPeriodo> getMatriculas() {
        if (matriculas.size() == 0) {
            getCursorMatricula();
            while (cursorMatricula.hasNext()) {
                String objeto = cursorMatricula.next().toString();
                String[] objeto1 = objeto.split(",");
                String ano = (objeto1[1].trim().replace("}", "").split(":"))[1];
                String situaca = (objeto1[2].trim().replace("}", "").split(":"))[1];
                String id = (objeto1[3].trim().replace("}", "").split(":"))[1];
                String periodo = (objeto1[4].trim().replace("}", "").split(":"))[1];
                String aluno = (objeto1[5].trim().replace("}", "").split(":"))[1];
                MatriculaPeriodo matriculaPeriodo = new MatriculaPeriodo(
                        id, ano, periodo, situaca, aluno
                );
                matriculas.add(matriculaPeriodo);
            }
            cursorMatricula.close();
        }
        return matriculas;
    }
    
    public void imprimir() {
        for (MatriculaPeriodo a : getMatriculas()) {
            System.out.println(a);
        }
    }

}
