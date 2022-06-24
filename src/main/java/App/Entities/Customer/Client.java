package App.Entities.Customer;

public class Client {

    private String nome;
    private String sobrenome;
    private int dataDeNasc;
    private String cpf;

    public Client(String nome, String sobrenome, int dataDeNasc, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataDeNasc = dataDeNasc;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public int getDataDeNasc() {
        return dataDeNasc;
    }

    public String getCpf() {
        return cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setDataDeNasc(int dataDeNasc) {
        this.dataDeNasc = dataDeNasc;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
