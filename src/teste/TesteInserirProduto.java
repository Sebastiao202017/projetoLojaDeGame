
package teste;
import dao.ProdutoDAO;
import modelo.Produto;


public class TesteInserirProduto {
    public static void main(String[] args) {
        Produto p = new Produto();
        p.setNome("ZELDA");
        p.setCategoria("CAMPANHA");
        p.setGenero("INFANTIL");
        p.setValor(00);
        
        String msg = new ProdutoDAO().inserir(p);
        System.out.println(msg);
    }
}
