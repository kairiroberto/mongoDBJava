package javaappmongodb.model.dao;

public class Disciplina
{
	
	String id;
	String descricao;
	String ch;

	public Disciplina(String id, String descricao, String ch)
	{
		this.id = id;
		this.descricao = descricao;
		this.ch = ch;
	}
	
        @Override
	public String toString()
	{
		// TODO: Implement this method
		String retorno =
		"id= " + id +
		", descrição= " + descricao +
		", ch= " + ch
		;
		//return super.toString();
		return retorno;
	}
}
