public class Vinho {
    private double preco;
    private String nome;
    private String uva;
    private String pais;
    private int ano;

    public Vinho(double preco, String nome, String uva, String pais, int ano) {
        setPreco(preco);
        setNome(nome);
        setUva(uva);
        setPais(pais);
        setAno(ano);
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUva() {
        return uva;
    }

    public void setUva(String uva) {
        this.uva = uva;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

}
