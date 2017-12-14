package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import models.Aposta;
import models.Cenario;
import models.Validador;

public class Sistema {
	
	private int caixa;
	private double taxa;
	private HashMap<Integer, HashSet<Aposta>> apostas;
	private ArrayList<Cenario> cenarios;
	
	public Sistema(int caixa, double taxa) {
		Validador.validarNotNegativeInteger("Erro na inicializacao: Caixa nao pode ser inferior a 0", caixa);
		Validador.validarNotNegativeDouble("Erro na inicializacao: Taxa nao pode ser inferior a 0", taxa);
		
		this.caixa = caixa;
		this.taxa = taxa;
		this.apostas = new HashMap<>();
		this.cenarios = new ArrayList<>();
	}

	public int getCaixa() {
		return this.caixa;
	}

	public void setCaixa(int caixa) {
		this.caixa = caixa;
	}
	
	public int cadastrarCenario(String descricao) {
		this.cenarios.add(new Cenario(this.cenarios.size() + 1, descricao));
		this.apostas.put(this.cenarios.size(), new HashSet<>());
		return this.cenarios.size();
	}
	
	public String exibirCenario(int cenario) {
		Validador.validarNotNegativeInteger("Erro na consulta de cenario: Cenario invalido", cenario);
		Validador.validarLessEqualThan("Erro na consulta de cenario: Cenario nao cadastrado",
				                  this.cenarios.size(), cenario);
		
		return this.cenarios.get(cenario - 1).toString();
	}
	
	public String listarCenarios() {
		String representacaoTextual = "";
		
		for(int i = 0; i < this.cenarios.size(); i++) {
			representacaoTextual += this.cenarios.get(i).toString() + System.lineSeparator();
		}
		
		return representacaoTextual;
	}
	
	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		if (!this.cenarios.get(cenario - 1).getFinalizacao()) {
			
			if(previsao.toUpperCase().equals("VAI ACONTECER")) {
				this.apostas.get(cenario).add(new Aposta(apostador, valor, true));
			} 
			
			else if (previsao.toUpperCase().equals("N VAI ACONTECER")){
				this.apostas.get(cenario).add(new Aposta(apostador, valor, false));
			}
			
			else {
				throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao invalida");
			}
		}
	}
	
	public int valorTotalDeApostas(int cenario) {
		int totalApostas = 0;
		
		for(Aposta aposta : this.apostas.get(cenario)) {
			totalApostas += aposta.getValor();			
		}
		
		return totalApostas;
	}
	
	public int totalDeApostas(int cenario) {
		return this.apostas.get(cenario).size();
	}
	
	public String listarApostas(int cenario) {
		String representacaoTextual = "";
		
		for(Aposta aposta : this.apostas.get(cenario)) {
			representacaoTextual += aposta.toString() + System.lineSeparator();
		}
		
		return representacaoTextual;
	}
	
	public void encerrarCenario(int cenario, boolean ocorrencia) {
		this.cenarios.get(cenario - 1).setFinalizacao(true);
		this.cenarios.get(cenario - 1).setOcorrencia(ocorrencia);
	}
	
	private int totalApostasPerdedoras(int cenario) {
		int total = 0;
		
		if (this.cenarios.get(cenario - 1).getFinalizacao()) {
			for(Aposta aposta : this.apostas.get(cenario)) {
				if (aposta.getPrevisao() != this.cenarios.get(cenario - 1).getOcorrencia()) {
					total += aposta.getValor();
				}
			}
		}
		
		return total;
	}
	
	public int lucroCenario(int cenario) {
		return (int) Math.floor(this.totalApostasPerdedoras(cenario) * this.taxa);
	}
	
	public int rateioCenario(int cenario) {
		return this.totalApostasPerdedoras(cenario) - this.lucroCenario(cenario);
	}
	
}
