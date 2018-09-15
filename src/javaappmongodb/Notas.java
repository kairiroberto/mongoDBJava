package javaappmongodb;

public class Notas
{
	
	String matricula;
	String frequencia;
	String professores;
	String media;
	String disciplina;
	String situacao;

	public Notas(String matricula, String frequencia, String professores, String media, String disciplina, String situacao)
	{
		this.matricula = matricula;
		this.frequencia = frequencia;
		this.professores = professores;
		this.media = media;
		this.disciplina = disciplina;
		this.situacao = situacao;
	}
	
	@Override
	public String toString()
	{
		// TODO: Implement this method
		String retorno =
			"matricula= " + matricula +
			", frequencia= " + frequencia +
			", professores= " + professores +
			", media= " + media +
			", disciplina= " + disciplina +
			", situacao= " + situacao
			;
		//return super.toString();
		return retorno;
	}
	
}
