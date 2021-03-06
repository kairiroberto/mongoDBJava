package javaappmongodb.model.dao;

import javaappmongodb.model.dao.Aluno;
import java.util.*;
import com.mongodb.*;

public class AlunoDao extends Conexao {

    private Aluno aluno;
    private List<Aluno> alunos = new ArrayList<Aluno>();
    private DBCollection colecaoAluno;
    private DBCursor cursorAluno;
    private Map<String, Integer> cidades = new HashMap<String, Integer>();
    private Map<String, List<Aluno>> cidadesAluno = new HashMap<String, List<Aluno>>();
    private Map<String, Double> mediaIdadeCidade = new HashMap<String, Double>();
    private Map<String, Integer> maxIdadeCidade = new HashMap<String, Integer>();
    private Map<String, Integer> minIdadeCidade = new HashMap<String, Integer>();

    public AlunoDao(String ip, String banco, String porta) {
        super(ip, banco, porta);
    }

    public DBCollection getColecaoAluno() {
        colecaoAluno = getDb().getCollection("Aluno");
        return colecaoAluno;
    }

    public DBCursor getCursorAluno() {
        cursorAluno = getColecaoAluno().find();
        return cursorAluno;
    }

    public List<Aluno> getAlunos() {
        if (alunos.size() == 0) {
            getCursorAluno();
            while (cursorAluno.hasNext()) {
                String objeto = cursorAluno.next().toString();
                String[] objeto1 = objeto.split(",");
                String curso = (objeto1[1].trim().replace("}", "").split(":"))[1];
                String cidade = (objeto1[2].trim().replace("}", "").split(":"))[1];
                String periodo = (objeto1[3].trim().replace("}", "").split(":"))[1];
                String estado = (objeto1[4].trim().replace("}", "").split(":"))[1];
                String ano = (objeto1[5].trim().replace("}", "").split(":"))[1];
                String situacao = (objeto1[6].trim().replace("}", "").split(":"))[1];
                String sexo = (objeto1[7].trim().replace("}", "").split(":"))[1];
                String data = (objeto1[8].trim().replace("}", "").split(":"))[1];
                String cep = (objeto1[9].trim().replace("}", "").split(":"))[1];
                String id = (objeto1[10].trim().replace("}", "").split(":"))[1];
                Integer idade = (new Date()).getYear() - Integer.parseInt(data.replace("\"", "").trim().substring(6)) + 1900;
                Aluno aluno = new Aluno(
                        id,
                        curso, ano, periodo, situacao,
                        cidade, estado, cep,
                        data, sexo, idade
                );
                alunos.add(aluno);
            }
            cursorAluno.close();
        }
        return alunos;
    }

    public Aluno getAluno(String id) {
        for (Aluno a : getAlunos()) {
            if (a.getId().equals(id)) {
                return a;
            }
        }
        return null;
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
    
    public void imprimir() {
        for (Aluno a : getAlunos()) {
            System.out.println(a);
        }
    }

}
