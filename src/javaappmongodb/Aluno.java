package javaappmongodb;

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
	
}
