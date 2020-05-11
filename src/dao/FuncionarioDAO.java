package dao;

import conexao.Conexao;
import java.sql.*;
import java.util.ArrayList;
import modelo.Funcionario;

public class FuncionarioDAO {
    Connection con = null;
    public FuncionarioDAO(){
        con = new Conexao().conectar();
    }
    
    public String inserir(Funcionario p){
        String status = "Funcionario inserido com sucesso!";
        String sql = "INSERT INTO tb_login_funcionario (nome, email, senha) values (?,?,?)";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, p.getNome());
            ps.setString(2, p.getEmail());
            ps.setString(3, p.getSenha());
            
            int n = ps.executeUpdate();
            if(n == 0){
                status = "Erro ao inserir";
            }
        }catch(Exception e){
            status = e.getMessage();
        }
        return status;
    }

    public ArrayList<Funcionario> listar(){
        ArrayList<Funcionario> funcionarios = new ArrayList();
        try{
            String sql = "SELECT * FROM tb_login_funcionario";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Funcionario p = new Funcionario();
                p.setCpf(rs.getInt(1));
                p.setNome(rs.getString(2));
                p.setEmail(rs.getString(3));
                p.setSenha(rs.getString(4));
                
                funcionarios.add(p);
            }
            return funcionarios;
        }catch(Exception e){
            return null;
        }
    }
    public String atualizar(Funcionario p){
        String status = "Funcionario atualizado com sucesso!";
        String sql = "UPDATE tb_login_funcionario SET nome = ?, email = ?, senha = ? WHERE cpf = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, p.getNome());
            ps.setString(2, p.getEmail());
            ps.setString(3, p.getSenha());
            ps.setInt(4, p.getCpf());
            
            ps.executeUpdate();
            
        }catch(Exception e){
            status = e.getMessage();
        }
        return status;
    }
    
    public String excluir(Funcionario p){
        String status = "Funcionario excluido com sucesso!";
        try{
            String sql = "DELETE FROM tb_login_funcionario WHERE codigo = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, p.getCpf());
            ps.executeUpdate();
        }catch(Exception e){
            status = e.getMessage();
        }
        return status;
    }
}
