
package modelo;

public class Produto {
     private int codigo;
     private String nome;
     private String categoria;
     private String genero;
     private double valor;
     
     public int getCodigo() {
         return codigo;
     }
     
     public void setCodigo(int codigo) {
         this.codigo = codigo;
     }
     
     public String getNome() {
         return nome;
     }
     
     public void setNome(String nome) {
         this.nome = nome;
     }
     
     public String getCategoria () {
         return categoria;
     }
     
     public void setCategoria(String categoria) {
         this.categoria = categoria;
     }
     
     public String getGenero() {
         return genero;
     }
     
     public void setGenero(String genero) {
         this.genero = genero;
     }
     
     public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
