package javaappmongodb;

import java.util.*;
import com.mongodb.*;
import com.mongodb.util.JSON;
import netscape.javascript.JSObject;

public class NotasDao extends Conexao {

    private List<Notas> notas = new ArrayList<Notas>();
    private DBCollection colecaoNotas;
    private DBCursor cursorNotas;

    public NotasDao(String ip, String banco, String porta) {
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

    public void imprimir() {
        for (Notas a : getNotas()) {
            System.out.println(a);
        }
    }

    private Notas instanciarObjeto(String toString) {
        String objeto = toString;
        String[] objeto1 = objeto.split(",");
        String matricula = (objeto1[1].trim().split(":"))[1];
        String frequencia = (objeto1[2].trim().split(":"))[1];
        String professor = "";
        //professor = (objeto1[3].trim().split(":"))[1];
        String media = "";
        //media = (objeto1[4].trim().split(":"))[1];
        String disciplina = "";
        //disciplina = (objeto1[5].trim().split(":"))[1];
        String situacao = "";
        //situacao = (objeto1[6].trim().split(":"))[1];
        Notas nota = new Notas(
                matricula, frequencia, professor,
                media, disciplina, situacao
        );
        return nota;
    }

}
