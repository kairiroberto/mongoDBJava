/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaappmongodb.controle;

import javaappmongodb.model.dao.ObjetoHadoopDao;

/**
 *
 * @author Edvania
 */
public class ObjetoHadoopControle extends ObjetoHadoopDao {
    
    public ObjetoHadoopControle(String ip, String banco, String porta) {
        super(ip, banco, porta);
    }
    
}
