/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaappmongodb.controle;

import javaappmongodb.model.dao.Aluno;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javaappmongodb.model.dao.AlunoDao;

/**
 *
 * @author Edvania
 */
public class AlunoControle extends AlunoDao {

    private int masculino = 0;
    private int feminino = 0;
    private double mediaIdade = 0;
    private int maxIdade = 0;
    private int minIdade = 0;
    private Map<String, Integer> cidades = new HashMap<String, Integer>();
    private Map<String, List<Aluno>> cidadesAluno = new HashMap<String, List<Aluno>>();
    private Map<String, Double> mediaIdadeCidade = new HashMap<String, Double>();
    private Map<String, Integer> maxIdadeCidade = new HashMap<String, Integer>();
    private Map<String, Integer> minIdadeCidade = new HashMap<String, Integer>();

    public AlunoControle(String ip, String banco, String porta) {
        super(ip, banco, porta);
    }
    
    public int getMasculino()
	{
		if (masculino == 0)
		{
			for (Aluno aluno : getAlunos())
			{
				if (aluno.getSexo().contains("M"))
                                {
                                    masculino++;
                                } else {
                                }
			}
		}
		return masculino;
	}

	public int getFeminino()
	{
		if (feminino == 0)
		{
			for (Aluno aluno : getAlunos())
			{
				if (aluno.getSexo().contains("F"))
				{
					feminino++;
				}
			}
		}
		return feminino;
	}

	public double getMediaIdade()
	{
		if (mediaIdade == 0.0)
		{
			Date d = new Date();
			int somador = 0;
			for (Aluno a : getAlunos())
			{
				int ano = Integer.parseInt(a.getNascimento().trim().substring(7, 11));
				somador = somador + (d.getYear() + 1900 - ano);
			}
			mediaIdade = somador / getAlunos().size();
		}
		return mediaIdade;
	}

	public int getMaxIdade()
	{
		if (maxIdade == 0)
		{
			Date d = new Date();
			int ano = Integer.parseInt(getAlunos().get(0).getNascimento().trim().substring(7, 11));
			maxIdade = d.getYear() + 1900 - ano;
			for (Aluno a : getAlunos())
			{
				ano = Integer.parseInt(a.getNascimento().trim().substring(7, 11));
				int idade = d.getYear() + 1900 - ano;
				if (idade > maxIdade)
				{
					maxIdade = idade;
				}
			}
		}
		return maxIdade;
	}

	public int getMinIdade()
	{
		if (minIdade == 0)
		{
			Date d = new Date();
			int ano = Integer.parseInt(getAlunos().get(0).getNascimento().trim().substring(7, 11));
			minIdade = d.getYear() + 1900 - ano;
			for (Aluno a : getAlunos())
			{
				ano = Integer.parseInt(a.getNascimento().trim().substring(7, 11));
				int idade = d.getYear() + 1900 - ano;
				if (idade < minIdade)
				{
					minIdade = idade;
				}
			}
		}
		return minIdade;
	}
        
        public Map<String, Integer> getCidades() {
        if (cidades.size() == 0) {
            for (Aluno aluno : getAlunos()) {
                if (!cidades.containsKey(aluno.getCidade())) {
                    cidades.put(aluno.getCidade(), 1);
                } else {
                    cidades.put(aluno.getCidade(), cidades.get(aluno.getCidade()) + 1);
                }
            }
        }
        return cidades;
    }

    public Map<String, Double> getMediaIdadeCidade() {
        if (mediaIdadeCidade.size() == 0) {
            Date d = new Date();
            for (Aluno a : getAlunos()) {
                Double idade = d.getYear() + 1900 - Double.parseDouble(a.getNascimento().trim().substring(7, 11));
                if (!mediaIdadeCidade.containsKey(a.getCidade())) {
                    mediaIdadeCidade.put(a.getCidade(), idade);
                } else {
                    Double somador = mediaIdadeCidade.get(a.getCidade()) + idade;
                    mediaIdadeCidade.put(a.getCidade(), somador);
                }
            }
            for (String key : mediaIdadeCidade.keySet()) {
                Double media = mediaIdadeCidade.get(key) / getCidades().get(key);
                mediaIdadeCidade.put(key, media);
            }
        }
        return mediaIdadeCidade;
    }

    public Map<String, Integer> getMaxIdadeCidade() {
        if (maxIdadeCidade.size() == 0) {
            Date d = new Date();
            for (Aluno a : getAlunos()) {
                Integer idade = d.getYear() + 1900 - Integer.parseInt(a.getNascimento().trim().substring(7, 11));
                if (!maxIdadeCidade.containsKey(a.getCidade())) {
                    maxIdadeCidade.put(a.getCidade(), idade);
                } else {
                    if (idade > maxIdadeCidade.get(a.getCidade())) {
                        maxIdadeCidade.put(a.getCidade(), idade);
                    }
                }
            }
        }
        return maxIdadeCidade;
    }

    public Map<String, Integer> getMinIdadeCidade() {
        if (minIdadeCidade.size() == 0) {
            Date d = new Date();
            for (Aluno a : getAlunos()) {
                Integer idade = d.getYear() + 1900 - Integer.parseInt(a.getNascimento().trim().substring(7, 11));
                if (!minIdadeCidade.containsKey(a.getCidade())) {
                    minIdadeCidade.put(a.getCidade(), idade);
                } else {
                    if (idade < minIdadeCidade.get(a.getCidade())) {
                        minIdadeCidade.put(a.getCidade(), idade);
                    }
                }
            }
        }
        return minIdadeCidade;
    }

}
