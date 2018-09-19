/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaappmongodb.model.dao;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Edvania
 */
public class ObjetoHadoopDao extends Conexao {

    private List<ObjetoHadoop> list = new ArrayList<ObjetoHadoop>();
    private DBCollection dBCollectionNotas;
    private DBCursor dBCursorNotas;
    private DBCollection dBCollectionAluno;
    private DBCursor dBCursorAluno;

    public ObjetoHadoopDao(String ip, String banco, String porta) {
        super(ip, banco, porta);
    }

    public DBCollection getdBCollectionNotas() {
        dBCollectionNotas = getDb().getCollection("notas");
        return dBCollectionNotas;
    }

    public DBCursor getdBCursorNotas() {
        dBCursorNotas = getdBCollectionNotas().find();
        return dBCursorNotas;
    }

    public DBCollection getdBCollectionAluno() {
        dBCollectionAluno = getDb().getCollection("aluno");
        return dBCollectionAluno;
    }

    public DBCursor getdBCursorAluno() {
        dBCursorAluno = getdBCollectionAluno().find();
        return dBCursorAluno;
    }

    public List<ObjetoHadoop> getList() {
        if (list.size() == 0) {
            while (dBCursorNotas.hasNext()) {
                DBObject dbo = (DBObject) dBCursorNotas.next();
                Float anoLetivo;
                Float periodo;
                Float cep;
                Float sexo;
                Float idade;
                Float frequencia = Float.parseFloat(String.valueOf(dbo.get("percentual_frequencia")));
                Float media = Float.parseFloat(String.valueOf(dbo.get("media_final")));
                String situacao = String.valueOf(dbo.get("situacao_id"));
            }
        }
        return list;
    }

}
