/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaappmongodb.model.dao;

import com.mongodb.BasicDBObject;
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
    private List<Notas> notas = new ArrayList<Notas>();
    private DBCollection colecaoNotas;
    private DBCursor cursorNotas;

    public ObjetoHadoopDao(String ip, String banco, String porta) {
        super(ip, banco, porta);
    }

    public DBCollection getColecaoNotas() {
        colecaoNotas = getDb().getCollection("Notas");
        return colecaoNotas;
    }

    public DBCursor getCursorNotas() {
        cursorNotas = getColecaoNotas().find();
        return cursorNotas;
    }

    public List<Notas> getNotas() {
        if (notas.size() == 0) {
            getCursorNotas();
            while (cursorNotas.hasNext()) {
                DBObject dbo = (DBObject) cursorNotas.next();
                String matricula = String.valueOf(dbo.get("matricula_periodo_id"));
                String frequencia = String.valueOf(dbo.get("percentual_frequencia"));
                String professor = "";
                if (dbo.get("professores") != null) {
                    professor = String.valueOf(dbo.get("professores"));
                }
                String media = String.valueOf(dbo.get("media_final"));
                String disciplina = String.valueOf(dbo.get("disciplina_id"));
                String situacao = String.valueOf(dbo.get("situacao_id"));
                Notas notasObject = new Notas(
                        matricula, frequencia, professor,
                        media, disciplina, situacao
                );
                notas.add(notasObject);
                //notas.add(instanciarObjeto(cursorNotas.next().toString()));
            }
            cursorNotas.close();
        }
        return notas;
    }

    public List<ObjetoHadoop> getList() {
        if (list.size() == 0) {
            getCursorNotas();
            while (cursorNotas.hasNext()) {
                DBObject dbo = (DBObject) cursorNotas.next();
                Float frequencia = null;
                if (dbo.get("percentual_frequencia") != null) {
                    frequencia = Float.parseFloat(String.valueOf(dbo.get("percentual_frequencia")));
                }
                Float media = null;
                if (dbo.get("media_final") != null) {
                    media = Float.parseFloat(String.valueOf(dbo.get("media_final")));
                }

                String situacaoDescricao = null;
                if (dbo.get("situacao_id") != null) {
                    String situacao = String.valueOf(dbo.get("situacao_id"));
                    BasicDBObject query1 = new BasicDBObject();
                    query1.put("id", Integer.parseInt(situacao));
                    DBCursor results = getDb().getCollection("SituacaoMatriculaPeriodo").find(query1);
                    situacaoDescricao = String.valueOf(results.one().get("descricao"));
                }

                if (dbo.get("matricula_periodo_id") != null) {
                    String matricula_periodo = String.valueOf(dbo.get("matricula_periodo_id"));
                    BasicDBObject query1 = new BasicDBObject();
                    query1.put("id", matricula_periodo);
                    DBCursor results1 = getDb().getCollection("MatriculaPeriodo").find(query1);

                    String aluno_id = null;
                    Float anoLetivo = null;
                    Float periodo = null;
                    Float cep = null;
                    Float sexo = null;
                    Float idade = null;
                    if (results1.hasNext()) {
                        aluno_id = String.valueOf(results1.one().get("aluno_id"));
                        BasicDBObject query2 = new BasicDBObject();
                        query2.put("id", aluno_id);
                        DBCursor results2 = getDb().getCollection("Aluno").find(query2);
                        if (results2.hasNext()) {
                            anoLetivo = Float.parseFloat(String.valueOf(results2.one().get("ano_letivo__ano")));
                            periodo = Float.parseFloat(String.valueOf(results2.one().get("periodo_letivo")));
                            cep = Float.parseFloat(String.valueOf(results2.one().get("cep")).substring(0, 5));
                            sexo = Float.parseFloat("0");
                            if (String.valueOf(results2.one().get("pessoa_fisica__sexo")).equals("M")) {
                                sexo = Float.parseFloat("1");
                            } else if (String.valueOf(results2.one().get("pessoa_fisica__sexo")).equals("F")) {
                                sexo = Float.parseFloat("2");
                            }
                            idade = Float.parseFloat(String.valueOf(results2.one().get("pessoa_fisica__nascimento_data")).substring(6));
                        }
                    }

                    //ObjetoHadoop hadoop = new ObjetoHadoop(anoLetivo, periodo, cep, sexo, idade, frequencia, media, situacao);
                    ObjetoHadoop hadoop = new ObjetoHadoop(null, null, null, null, null, frequencia, media, situacaoDescricao);
                    list.add(hadoop);
                }
            }
            cursorNotas.close();
        }
        return list;
    }

}
