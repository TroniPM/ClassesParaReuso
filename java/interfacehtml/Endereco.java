package com.tronipm.java.interfacehtml;

public class Endereco {
	private String rua, bairro, uf, cep;

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Endereco(String rua, String bairro, String uf, String cep) {
		super();
		this.rua = rua;
		this.bairro = bairro;
		this.uf = uf;
		this.cep = cep;
	}
}
