/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Tela.Caddentista;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;


public class UsuarioDao {
    private ConexaoBanco conexao;
    
    public UsuarioDao()
    {
        this.conexao = new ConexaoBanco();
    }
    public boolean LoginUsuario(String Usuario, String Senha) {
        String sql = "SELECT * FROM tb_usuario WHERE login=? and senha=?";
        boolean checkUser = false;
        try
        {
            if(conexao.conectar())
            {
                PreparedStatement sentenca = conexao.getConnection().prepareStatement(sql);
                sentenca.setString(1,Usuario);
                sentenca.setString(2, Senha);
                ResultSet rs = sentenca.executeQuery();
                if(rs.next()){
                    JOptionPane.showMessageDialog(null, "Usuário válido");
                    checkUser = true;
                    Caddentista novoFrame = new Caddentista();
                    novoFrame.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Dados Inválidos ");
                    checkUser = false;
                }
                sentenca.close();
                this.conexao.getConnection().close();
            }
        }
        catch(SQLException ex)
        {
           throw new RuntimeException(ex);
        }
        return checkUser;
    }
    
}
