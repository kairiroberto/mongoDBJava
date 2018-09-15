/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaappmongodb.controle;

import javaappmongodb.model.dao.Aluno;
import java.util.Date;
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
				int ano = Integer.parseInt(a.getNascimeto().trim().substring(7, 11));
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
			int ano = Integer.parseInt(getAlunos().get(0).getNascimeto().trim().substring(7, 11));
			maxIdade = d.getYear() + 1900 - ano;
			for (Aluno a : getAlunos())
			{
				ano = Integer.parseInt(a.getNascimeto().trim().substring(7, 11));
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
			int ano = Integer.parseInt(getAlunos().get(0).getNascimeto().trim().substring(7, 11));
			minIdade = d.getYear() + 1900 - ano;
			for (Aluno a : getAlunos())
			{
				ano = Integer.parseInt(a.getNascimeto().trim().substring(7, 11));
				int idade = d.getYear() + 1900 - ano;
				if (idade < minIdade)
				{
					minIdade = idade;
				}
			}
		}
		return minIdade;
	}

}
