/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaappmongodb.model.dao;

/**
 *
 * @author Edvania
 */
public class SituacaoMatriculaPeriodo {
    
    private String id;
    private String descricao;

    public SituacaoMatriculaPeriodo(String id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        String retorno =
		"id= " + id +
		", descrição= " + descricao
		;
        //return super.toString(); //To change body of generated methods, choose Tools | Templates.
        return retorno;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
