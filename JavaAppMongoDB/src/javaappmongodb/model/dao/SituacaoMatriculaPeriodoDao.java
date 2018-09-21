/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaappmongodb.model.dao;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Edvania
 */
public class SituacaoMatriculaPeriodoDao extends Conexao {
    
    private List<SituacaoMatriculaPeriodo> situacaoMatriculaPeriodos = new ArrayList<SituacaoMatriculaPeriodo>();
    private DBCollection colecaoSituacaoMatriculaPeriodo;
    private DBCursor cursorSituacaoMatriculaPeriodo;
    private SituacaoMatriculaPeriodo situacaoMatriculaPeriodo;
    
    public SituacaoMatriculaPeriodoDao(String ip, String banco, String porta) {
        super(ip, banco, porta);
    }
    
    public DBCollection getColecaoSituacaoMatriculaPeriodo() {
        colecaoSituacaoMatriculaPeriodo = getDb().getCollection("SituacaoMatriculaPeriodo");
        return colecaoSituacaoMatriculaPeriodo;
    }

    public DBCursor getCursorSituacaoMatriculaPeriodo() {
        cursorSituacaoMatriculaPeriodo = getColecaoSituacaoMatriculaPeriodo().find();
        return cursorSituacaoMatriculaPeriodo;
    }

    public List<SituacaoMatriculaPeriodo> getSituacaoMatriculaPeriodos() {
        if (situacaoMatriculaPeriodos.size() == 0) {
            getCursorSituacaoMatriculaPeriodo();
            while (cursorSituacaoMatriculaPeriodo.hasNext()) {
                String objeto = cursorSituacaoMatriculaPeriodo.next().toString();
                String[] objeto1 = objeto.split(",");
                String descricao = (objeto1[1].trim().replace("}", "").split(":"))[1];
                String id = (objeto1[2].trim().replace("}", "").split(":"))[1];
                SituacaoMatriculaPeriodo situacaoMatriculaPeriodo = new SituacaoMatriculaPeriodo(
                        id, descricao
                );
                situacaoMatriculaPeriodos.add(situacaoMatriculaPeriodo);
            }
            cursorSituacaoMatriculaPeriodo.close();
        }
        return situacaoMatriculaPeriodos;
    }

    public SituacaoMatriculaPeriodo getSituacaoMatriculaPeriodo(String id) {
        for (SituacaoMatriculaPeriodo s : getSituacaoMatriculaPeriodos()) {
            if (s.getId().equals(id)) {
                return s;
            }
        }
        return null;
    }
    
    public void imprimir() {
        for (SituacaoMatriculaPeriodo a : getSituacaoMatriculaPeriodos()) {
            System.out.println(a);
        }
    }
    
}
