package br.com.cadastrooficina.model.bean;

import java.util.Date;

public class VeiculoNaoEntregueCom {
	
	private Date previsaoEntrega1;
	private Date previsaoEnrega2;

	
	
	
	public VeiculoNaoEntregueCom() {
		super();
	
	}
	public Date getPrevisaoEntrega1() {
		return previsaoEntrega1;
	}
	public void setPrevisaoEntrega1(Date previsaoEntrega1) {
		this.previsaoEntrega1 = previsaoEntrega1;
	}
	public Date getPrevisaoEnrega2() {
		return previsaoEnrega2;
	}
	public void setPrevisaoEnrega2(Date previsaoEnrega2) {
		this.previsaoEnrega2 = previsaoEnrega2;
	}
}
