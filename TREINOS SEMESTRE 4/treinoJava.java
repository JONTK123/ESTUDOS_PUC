//Classe
public class Data {
    private int dia;
    private int mes;
    private int ano;

//Construtor
public Data(int dia, int mes, int ano) {
    this.dia = dia;
    this.mes = mes;
    this.ano = ano;
}

//Getters
public int getDia() {
    return dia;
}

//Setters
public void setDia(int dia) {
    this.dia = dia;
}

public static boolean validarData(int dia, int mes, int ano) {
    if (mes < 1 || mes > 12) {
        return false;
    }
}

public static void main(String[] args) {
    Data data1 = new Data(12,8,2023);
    System.out.println(data1.getDia());}

    System.out.println(data.validarData(12,8,2023));
}