package dao;

import conexao.Conexao;
import java.sql.*;
import java.util.ArrayList;
import modelo.Produto;

public class ProdutoDAO {
    Connection con = null;
    public ProdutoDAO(){
        con = new Conexao().conectar();
    }
    
    public String inserir(Produto p){
        String status = "Produto inserido com sucesso!";
        String sql = "INSERT INTO lista_produto (nome, categoria, genero, valor) values (?,?,?,?)";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, p.getNome());
            ps.setString(2, p.getCategoria());
            ps.setString(3, p.getGenero());
            ps.setDouble(4, p.getValor());
            
            int n = ps.executeUpdate();
            if(n == 0){
                status = "Erro ao inserir";
            }
        }catch(Exception e){
            status = e.getMessage();
        }
        return status;
    }

    public ArrayList<Produto> listar(){
        ArrayList<Produto> produtos = new ArrayList();
        try{
            String sql = "SELECT * FROM lista_produto";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Produto p = new Produto();
                p.setCodigo(rs.getInt(1));
                p.setNome(rs.getString(2));
                p.setCategoria(rs.getString(3));
                p.setGenero(rs.getString(4));
                p.setValor(rs.getDouble(5));
                
                produtos.add(p);
            }
            return produtos;
        }catch(Exception e){
            return null;
        }
    }
    public String atualizar(Produto p){
        String status = "Produto atualizado com sucesso!";
        String sql = "UPDATE lista_produto SET nome = ?, categoria = ?, genero = ?, valor = ? WHERE codigo = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, p.getNome());
            ps.setString(2, p.getCategoria());
            ps.setString(3, p.getGenero());
            ps.setDouble(4, p.getValor());
            ps.setInt(5, p.getCodigo());
            
            ps.executeUpdate();
            
        }catch(Exception e){
            status = e.getMessage();
        }
        return status;
    }
    
    public String excluir(Produto p){
        String status = "Produto excluido com sucesso!";
        try{
            String sql = "DELETE FROM lista_produto WHERE codigo = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, p.getCodigo());
            ps.executeUpdate();
        }catch(Exception e){
            status = e.getMessage();
        }
        return status;
    }
}
