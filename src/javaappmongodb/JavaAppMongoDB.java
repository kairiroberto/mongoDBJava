/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaappmongodb;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaappmongodb.model.dao.DisciplinaDao;
import javaappmongodb.model.dao.MatriculaPeriodoDao;
import javaappmongodb.model.dao.NotasDao;
import javaappmongodb.controle.AlunoControle;

/**
 *
 * @author Edvania
 */
public class JavaAppMongoDB {
    
    //mongoimport --db SUAP_Exemplo --collection Aluno --file /home/eliezio/Aluno.json --jsonArray

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            //Process exec = Runtime.getRuntime().exec("C:\\Program Files\\MongoDB\\Server\\3.2\\bin\\mongod.exe --dbpath C:\\data\\db");
            new JFPrincipal().setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(JavaAppMongoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
