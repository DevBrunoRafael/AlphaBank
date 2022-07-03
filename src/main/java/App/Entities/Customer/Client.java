package App.Entities.Customer;

public class Client {

    private String name;
    private String lastName;
    private String birthDate; // implementar lógica de calc
    private String cpf;

    public Client(String name, String lastName, String birthDate, String cpf) {
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "\nNome: " + this.name +
                "\nSobrenome: " + this.lastName +
                "\nDt Nascimento: " + this.birthDate +
                "\nCPF: " + this.cpf;
    }
}
