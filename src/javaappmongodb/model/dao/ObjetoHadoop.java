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
public class ObjetoHadoop {

    private Float anoLetivo;
    private Float periodo;
    private Float cep;
    private Float sexo;
    private Float idade;
    private Float frequencia;
    private Float media;
    private String situacao;

    public ObjetoHadoop(Float anoLetivo, Float periodo, Float cep, Float sexo, Float idade, Float frequencia, Float media, String situacao) {
        this.anoLetivo = anoLetivo;
        this.periodo = periodo;
        this.cep = cep;
        this.sexo = sexo;
        this.idade = idade;
        this.frequencia = frequencia;
        this.media = media;
        this.situacao = situacao;
    }

    public Float getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(Float anoLetivo) {
        this.anoLetivo = anoLetivo;
    }

    public Float getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Float periodo) {
        this.periodo = periodo;
    }

    public Float getCep() {
        return cep;
    }

    public void setCep(Float cep) {
        this.cep = cep;
    }

    public Float getSexo() {
        return sexo;
    }

    public void setSexo(Float sexo) {
        this.sexo = sexo;
    }

    public Float getIdade() {
        return idade;
    }

    public void setIdade(Float idade) {
        this.idade = idade;
    }

    public Float getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(Float frequencia) {
        this.frequencia = frequencia;
    }

    public Float getMedia() {
        return media;
    }

    public void setMedia(Float media) {
        this.media = media;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }    

}
