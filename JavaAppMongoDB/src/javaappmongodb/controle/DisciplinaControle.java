/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaappmongodb.controle;

import javaappmongodb.model.dao.DisciplinaDao;

/**
 *
 * @author Edvania
 */
public class DisciplinaControle extends DisciplinaDao {
    
    public DisciplinaControle(String ip, String banco, String porta) {
        super(ip, banco, porta);
    }
    
}
