package br.edu.infnet.TP3OO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CEP {
    @JsonProperty
    private String cep;

    @JsonProperty
    private String logradouro;

    @JsonProperty
    private String bairro;

    @JsonProperty
    private String localidade;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    @Override
    public String toString() {
        return "CEP{" + "cep=" + cep + ", logradouro=" + logradouro + ", bairro=" + bairro + ", localidade=" + localidade + '}';
    }

 
	    
}