/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaappmongodb.controle;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MapReduceCommand;
import com.mongodb.MapReduceOutput;
import java.util.ArrayList;
import java.util.List;
import javaappmongodb.model.dao.AlunoDao;

/**
 *
 * @author Edvania
 */
public class AlunoControleMapReduce extends AlunoDao {

    private DBCollection colecaoAluno;
    private DBCursor cursorAluno;

    public AlunoControleMapReduce(String ip, String banco, String porta) {
        super(ip, banco, porta);
    }

    public List<String> mapReduce() {
        colecaoAluno = getDb().getCollection("notas");
        List<String> alunos = new ArrayList<String>();
        String map
                = "function() { "
                    + "var situacao; "
                    + "if ( this.media_final >= 60 ) "
                        + "situacao = 'aprovado'; "
                    + "else "
                        + "situacao = 'reprovado'; "
                    + "emit(situacao, {name: this.matricula_periodo_id});}";

        String reduce
                = "function(key, values) { "
                    + "var sum = 0; "
                    + "values.forEach(function(doc) { "
                        + "sum += 1; "
                    + "}); "
                    + "return {resultado: sum};} ";
        MapReduceCommand cmd1 = new MapReduceCommand(
                colecaoAluno, map, reduce, null, MapReduceCommand.OutputType.INLINE, null
        );
        MapReduceCommand cmd = new MapReduceCommand(colecaoAluno, reduce, reduce, reduce, MapReduceCommand.OutputType.MERGE, null);
        MapReduceOutput out = colecaoAluno.mapReduce(cmd);
        for (DBObject o : out.results()) {
            alunos.add(o.toString());
        }
        return alunos;
    }

}
