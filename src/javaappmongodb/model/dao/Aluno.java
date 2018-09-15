package javaappmongodb.model.dao;

public class Aluno
{
	String id;
	String curso;
	String anoLetivo;
	String periodo;
	String situacao;
	String cidade;
	String estado;
	String cep;
	String nascimeto;
	String sexo;
	Integer idade;

	public Aluno(String id, String curso, String anoLetivo, String periodo, String situacao, String cidade, String estado, String cep, String nascimeto, String sexo, Integer idade)
	{
		this.id = id;
		this.curso = curso;
		this.anoLetivo = anoLetivo;
		this.periodo = periodo;
		this.situacao = situacao;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.nascimeto = nascimeto;
		this.sexo = sexo;
		this.idade = idade;
	}

	@Override
	public String toString()
	{
		// TODO: Implement this method
		String retorno =
		"id= " + id +
		", curso= " + curso +
		", ano= " + anoLetivo +
			", periodo= " + periodo +
			", situacao= " + situacao +
			", cidade= " + cidade +
			", estado= " + estado +
			", cep= " + cep +
			", data= " + nascimeto +
			", sexo= " + sexo +
                        ", idade= " + idade
		;
		//return super.toString();
		return retorno;
	}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(String anoLetivo) {
        this.anoLetivo = anoLetivo;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNascimeto() {
        return nascimeto;
    }

    public void setNascimeto(String nascimeto) {
        this.nascimeto = nascimeto;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
        
        
	
}
