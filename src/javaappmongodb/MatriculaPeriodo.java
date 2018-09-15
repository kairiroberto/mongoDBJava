package javaappmongodb;

public class MatriculaPeriodo
{
	String id;
	String ano;
	String periodo;
	String situacao;
	String aluno;

	public MatriculaPeriodo(String id, String ano, String periodo, String situacao, String aluno)
	{
		this.id = id;
		this.ano = ano;
		this.periodo = periodo;
		this.situacao = situacao;
		this.aluno = aluno;
	}
        
        @Override
	public String toString()
	{
		// TODO: Implement this method
		String retorno =
			"id= " + id +
			", ano= " + ano +
			", periodo= " + periodo +
			", situacao= " + situacao +
			", aluno= " + aluno
			;
		//return super.toString();
		return retorno;
	}
	
}
