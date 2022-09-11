package aplicativos.model;

public class Pessoa {
    private String nome;
    private String cpf;
    private String habilitacao;
    private Aeronave naveAtual;
    
    public Pessoa(String nome, String cpf, String habilitacao) {
        this.nome = nome;
        this.cpf = cpf;
        this.habilitacao = habilitacao;
    }
    public Aeronave getNaveAtual() {
        return naveAtual;
    }
    public void setNaveAtual(Aeronave naveAtual) {
        this.naveAtual = naveAtual;
    }
    public Pessoa(Aeronave naveAtual){
        this.naveAtual = naveAtual;
    }
    public void acelerar(int limite){
        naveAtual.acelerar(limite);
    }
    public String getHabilitacao() {
        return habilitacao;
    }
    public void setHabilitacao(String habilitacao) {
        this.habilitacao = habilitacao;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
   
    @Override
    public String toString() {
        return "Nome: " + nome + " \nNúmero do CPF: " + cpf + "\nNúmero da Habilitação: " + habilitacao;

    }
}
