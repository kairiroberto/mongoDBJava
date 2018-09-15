/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaappmongodb;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MapReduceCommand;
import com.mongodb.MapReduceOutput;
import java.util.ArrayList;
import java.util.List;

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

    public List<Aluno> mapReduce() {
        
        List<Aluno> aluno = new ArrayList<Aluno>();
        String map
                = "function() { "
                    + "var category; "
                    + "if ( this.pages >= 250 ) "
                        + "category = 'Big Books'; "
                    + "else "
                        + "category = 'Small Books'; "
                    + "emit(category, {name: this.name});}";

        String reduce
                = "function(key, values) { "
                    + "var sum = 0; "
                    + "values.forEach(function(doc) { "
                        + "sum += 1; "
                    + "}); "
                    + "return {books: sum};} ";

        colecaoAluno = getDb().getCollection("Aluno");
        MapReduceCommand cmd = new MapReduceCommand(
                colecaoAluno, map, reduce, null, MapReduceCommand.OutputType.INLINE, null
        );
        MapReduceOutput out = colecaoAluno.mapReduce(cmd);
        for (DBObject o : out.results()) {
            System.out.println(o.toString());
        }
        return null;
    }

}
