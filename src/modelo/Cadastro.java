/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class Cadastro {
    
    private int idcad;
    private String nomecad;
    private String cpf;
    private String cro;
    private String nasc;
    private String cep;
    private String numero;
    private String complemento;
    private String telefone;
    private int alergia;
    private String obs;
    private int numCadastros;
    private int somaCodigos;
    
    public Cadastro() {
    }
    
    public Cadastro(String nomecad, String cpf, String cro,String nasc, String email, String cep, String numero, String complemento, String telefone, int alergia, String obs) {
        this.nomecad = nomecad;
        this.cpf = cpf;
        this.cro = cro;
        this.nasc = nasc;
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
        this.telefone = telefone;
        this.alergia = alergia;
        this.obs = obs;
    }

 public Cadastro(int idcad, String nomecad, String cpf, String cro,String nasc, String email, String cep, String numero, String complemento, String telefone, int alergia, String obs) {
        this.idcad = idcad;     
        this.nomecad = nomecad;
        this.cpf = cpf;
        this.cro = cro;
        this.nasc = nasc;
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
        this.telefone = telefone;
        this.alergia = alergia;
        this.obs = obs;     
    }   
 public Cadastro(int numCadastros, int somaCodigos, int numSexualidade) {
        this.numCadastros = numCadastros;
        this.somaCodigos = somaCodigos; 
    }  
    
    public int getIdCad() {
        return idcad;
    }

    public void setIdCad(int idcad) {
        this.idcad = idcad;
    }

    public String getNomecad() {
        return nomecad;
    }

    public void setNomeCad(String nomecad) {
        this.nomecad = nomecad;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf; 
    }
    
    public String getCro() {
        return cro;
    }

    public void setCro(String cro) {
        this.cro = cro; 
    }

    public String getNasc() {
        return nasc;
    }

    public void setNasc(String nasc) {
        this.nasc = nasc;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public int getAlergia() {
        return alergia;
    }
    
    public void setAlergia(int alergia) {
        this.alergia = alergia;
    }
    
    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
    public int getTotalCadastros() {
        return numCadastros;
    }

    public void setTotalCadastros(int numCadastros) {
        this.numCadastros = numCadastros;
    }

    public int getSomaCodigos() {
        return somaCodigos;
    }

    public void SetSomaCodigos(int somaCodigos) {
        this.somaCodigos = somaCodigos;
    }
}



