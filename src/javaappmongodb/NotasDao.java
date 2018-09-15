package javaappmongodb;

import java.util.*;
import com.mongodb.*;

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

}
