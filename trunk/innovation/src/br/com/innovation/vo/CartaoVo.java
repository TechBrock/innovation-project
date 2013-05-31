package br.com.innovation.vo;

import java.io.Serializable;

public class CartaoVo implements Serializable {
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		/**
		 * 
		 */
			
		private Integer bandeira;
		private String numero;
		
		
		public Integer getBandeira() {
			return bandeira;
		}
		public void setBandeira(Integer bandeira) {
			this.bandeira = bandeira;
		}
		public String getNumero() {
			return numero;
		}
		public void setNumero(String numero) {
			this.numero = numero;
		}
	}


