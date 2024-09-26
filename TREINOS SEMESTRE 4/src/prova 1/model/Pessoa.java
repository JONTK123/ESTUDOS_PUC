package prova1.model;

public class Pessoa {

    //Protected significa que so a classe que criou o atributo e quem herdar pode usar
    protected String CPF;

    public Pessoa(String CPF) {
        this.CPF = CPF;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public int calcularIdade() {
        return 0;
    }

    //Metodo para testar o super e protected
    protected void mostrarNome() {
        System.out.println("Método da classe Pessoa");
    }

    @Override
    public String toString() {
        return "CPF: " + this.CPF;
    }

    //Aqui falta clone
}
