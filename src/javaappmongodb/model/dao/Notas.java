package javaappmongodb.model.dao;

public class Notas
{
	
	private String matricula;
	private String frequencia;
	private String professores;
	private String media;
	private String disciplina;
	private String situacao;

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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(String frequencia) {
        this.frequencia = frequencia;
    }

    public String getProfessores() {
        return professores;
    }

    public void setProfessores(String professores) {
        this.professores = professores;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
	
}
