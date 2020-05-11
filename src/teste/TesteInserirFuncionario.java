
package teste;
import dao.FuncionarioDAO;
import modelo.Funcionario;


public class TesteInserirFuncionario {
    public static void main(String[] args) {
        Funcionario p = new Funcionario();
        p.setNome("JUNIOR");
        p.setEmail("IRINEUSIMAOLIVEIRA@GMAIL.COM");
        p.setSenha("12345678910");
        
        String msg = new FuncionarioDAO().inserir(p);
        System.out.println(msg);
    }
}
