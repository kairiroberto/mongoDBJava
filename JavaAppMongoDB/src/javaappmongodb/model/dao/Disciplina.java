package javaappmongodb.model.dao;

public class Disciplina
{
	
	private String id;
	private String descricao;
	private String ch;

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

    public String getCh() {
        return ch;
    }

    public void setCh(String ch) {
        this.ch = ch;
    }
        
}
