/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Cadastro;


public class CadastroDao implements DaoGenerica<Cadastro>{

    private ConexaoBanco conexao;
    
    public CadastroDao()
    {
        this.conexao = new ConexaoBanco();
    }

    @Override
    public void inserir(Cadastro cadastro) {
        //string com a consulta que será executada no banco
        String sql = "INSERT INTO tb_dentista1 (id_dentista, nome, cpf, cro, cep, numero_casa, complemento_casa, telefone, alergia, observacao, data_criacao, data_alteracao) \n" +
                 "VALUES (?,?,?,?,?,?,?,?,?,?, current_timestamp(), current_timestamp());";

    try
    {
        //tenta realizar a conexão, se retornar verdadeiro entra no IF
        if(this.conexao.conectar())
        {
            //prepara a sentença com a consulta da string
            PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);

            //subtitui as interrogações da consulta, pelo valor específico
            sentenca.setInt(1,cadastro.getIdCad());
            sentenca.setString(2,cadastro.getNomecad());
            sentenca.setString(3,cadastro.getCpf());
            sentenca.setString(4,cadastro.getCro());
            sentenca.setString(5,cadastro.getCep());
            sentenca.setString(6,cadastro.getNumero());
            sentenca.setString(7,cadastro.getComplemento());
            sentenca.setString(8,cadastro.getTelefone());
            sentenca.setInt(9,cadastro.getAlergia());
            sentenca.setString(10,cadastro.getObs());

            sentenca.execute(); //executa o comando no banco
            sentenca.close(); //fecha a sentença
            this.conexao.getConnection().close(); //fecha a conexão com o banco
        }
    }
    catch(SQLException ex)
    {
       throw new RuntimeException(ex);
    }
    }

    @Override
    public void alterar(Cadastro cadastro) {
        String sql = "UPDATE tb_dentista1 SET nome = ?, cpf = ?, cro = ?, cep = ?, numero_casa = ?, complemento_casa = ?, telefone = ?, alergia = ?,observacao = ?, data_alteracao = current_timestamp() where id_dentista = ?";
        
        try
        {
            if(this.conexao.conectar())
            {
                try (PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql)) {
                    sentenca.setString(1,cadastro.getNomecad());
                    sentenca.setString(2,cadastro.getCpf());
                    sentenca.setString(3,cadastro.getCro());
                    sentenca.setString(4,cadastro.getCep());
                    sentenca.setString(5,cadastro.getNumero());
                    sentenca.setString(6,cadastro.getComplemento());
                    sentenca.setString(7,cadastro.getTelefone());
                    sentenca.setInt(8,cadastro.getAlergia());
                    sentenca.setString(9,cadastro.getObs());
                    sentenca.setInt(10, cadastro.getIdCad());
                    sentenca.execute(); //executa o comando no banco
                }
                this.conexao.getConnection().close();
            }
        }
        catch(SQLException ex)
        {
           throw new RuntimeException(ex);
        }
    }

    public void excluirID(int id) {
        String sql = "DELETE FROM tb_dentista1 WHERE id_dentista = ?";
        
        try
        {
            if(this.conexao.conectar())
            {
                try (PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql)) {
                    sentenca.setInt(1, id);
                    
                    sentenca.execute();
                }
                this.conexao.getConnection().close();
            }
        }
        catch(SQLException ex)
        {
           throw new RuntimeException(ex);
        }
    }

    @Override
   public ArrayList<Cadastro> consultar() {
    ArrayList<Cadastro> lista_pacientes = new ArrayList<Cadastro>();
    String sql = "SELECT c.id_dentista, c.nome, c.cpf, c.cro, c.cep, c.numero_casa, c.complemento_casa, c.telefone, c.alergia, c.observacao " + 
                 "FROM tb_dentista1 AS c";
                 
    
    try {
        if (this.conexao.conectar()) {
            // Recebe o resultado da consulta
            try (PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql)) {
                // Recebe o resultado da consulta
                ResultSet resultadoSentenca = sentenca.executeQuery();
                
                // Percorre cada linha do resultado
                while (resultadoSentenca.next()) {
                    // Resgata o valor de cada linha, selecionando pelo nome de cada coluna da tabela Cadastro
                    Cadastro cadastro = new Cadastro();
                    cadastro.setIdCad(resultadoSentenca.getInt("id_dentista"));
                    cadastro.setNomeCad(resultadoSentenca.getString("nome"));
                    cadastro.setCpf(resultadoSentenca.getString("cpf"));
                    cadastro.setCro(resultadoSentenca.getString("cro"));
                    cadastro.setCep(resultadoSentenca.getString("cep"));
                    cadastro.setNumero(resultadoSentenca.getString("numero_casa"));
                    cadastro.setComplemento(resultadoSentenca.getString("complemento_casa"));
                    cadastro.setTelefone(resultadoSentenca.getString("telefone"));
                    cadastro.setAlergia(resultadoSentenca.getInt("alergia"));
                    cadastro.setObs(resultadoSentenca.getString("observacao"));
                    // Adiciona cada tupla na lista_pacientes que será retornada para a janela Cadastro
                    lista_pacientes.add(cadastro);
                }
            }
            this.conexao.getConnection().close();
        }
        
        return lista_pacientes;
    } catch (SQLException ex) {
       throw new RuntimeException(ex);
    }
}


    @Override
    public void excluirID() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<Cadastro> consultar(String trim) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
public ArrayList<Cadastro> dashboard() {
        
        ArrayList<Cadastro> ListarDashBoard = new ArrayList<Cadastro>();
        String sql = "select count(id_dentista) as numcad, sum(id_dentista) as sumcad from tb_dentista1;";
        
        try
        {
            if(this.conexao.conectar())
            {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                //recebe o resultado da consulta
                 ResultSet resultadoSentenca = sentenca.executeQuery();

                //percorrer cada linha do resultado
                while(resultadoSentenca.next()) 
                {
                    //resgata o valor de cada linha, selecionando pelo nome de cada coluna da tabela Escola
                    Cadastro cadastro = new Cadastro();
                    cadastro.setTotalCadastros(resultadoSentenca.getInt("numcad"));
                    cadastro.SetSomaCodigos(resultadoSentenca.getInt("sumcad"));
                    
                    ListarDashBoard.add(cadastro);
                }

                sentenca.close();
                this.conexao.getConnection().close();
            }
            
            return ListarDashBoard;
        }
        catch(SQLException ex)
        {
           throw new RuntimeException(ex);
        }
    }
    
}


