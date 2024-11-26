package org.example.Heranca_Interface_Generico_Abstract_Polimorfismo;

public class Data {
    private byte dia, mes;
    private short ano;

    private static boolean isBissexto(short ano) {
        // Calendario Juliano
        if (ano < 1582) {
            return ano % 4 == 0;
        }

        // Calendario Gregoriano
        if (ano % 400 == 0) return true;
        if (ano % 4 == 0 && ano % 100 != 0) return true;
        return false;
    }

    private static boolean isValida(byte dia, byte mes, short ano) {
        if (ano < -45) return false; // antes do Calendario Juliano
        if (ano == 0) return false; // nao existiu ano 0; do ano 1ac foi direto para o ano 1dc
        if (ano == 1582 && mes == 10 && dia >= 5 && dia <= 14) return false; // dias cortados dos calendario pelo Papa Gregorio

        if (dia < 1 || dia > 31 || mes < 1 || mes > 12) return false;

        if (dia > 30 && (mes == 4 || mes == 6 || mes == 9 || mes == 11)) return false;
        if (dia > 29 && mes == 2) return false;
        if (dia > 28 && mes == 2 && !Data.isBissexto(ano)) return false;

        return true;
    }

    public Data(byte dia, byte mes, short ano) throws Exception {
        if (!Data.isValida(dia, mes, ano))
            throw new Exception("Data invalida");

        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public void setDia(byte dia) throws Exception {
        if (!Data.isValida(dia, this.mes, this.ano))
            throw new Exception("Dia invalido");

        this.dia = dia;
    }

    public byte getDia() {
        return this.dia;
    }

    public void setMes(byte mes) throws Exception {
        if (!Data.isValida(this.dia, mes, this.ano))
            throw new Exception("Mes invalido");

        this.mes = mes;
    }

    public byte getMes() {
        return this.mes;
    }

    public void setAno(short ano) throws Exception {
        if (!Data.isValida(this.dia, this.mes, ano))
            throw new Exception("Ano invalido");

        this.ano = ano;
    }

    public short getAno() {
        return this.ano;
    }

    public void avanceUmDia() throws Exception {
        if (this.dia == 31 && this.mes == 12) {
            this.ano++;
            this.dia = 1;
            this.mes = 1;

        } else if (this.dia == 30 && (this.mes == 4 || this.mes == 6 || this.mes == 9 || this.mes == 11)) {
            this.dia = 1;
            this.mes++;

        } else if (this.dia == 31 && (this.mes == 1 || this.mes == 3 || this.mes == 5 || this.mes == 7 || this.mes == 8 || this.mes == 10)) {
            this.dia = 1;
            this.mes++;

        } else if (this.dia == 29 && this.mes == 2 && Data.isBissexto(this.ano)) {
            this.dia = 1;
            this.mes++;

        } else if (this.dia == 28 && this.mes == 2) {
            this.dia = 1;
            this.mes++;

        } else if (isValida((byte) (this.dia + 1), this.mes, this.ano)) {
            this.dia++;

        } else {
            throw new Exception("Data invalida apos o avanco de um dia");
        }
    }

    public void retrocedeUmDia() throws Exception {

        if (this.dia == 1 && this.mes == 1) {
            this.ano--;
            this.dia = 31;
            this.mes = 12;
        }

        else if (this.dia == 1 && (this.mes == 5 || this.mes == 7 || this.mes == 10 || this.mes == 12)) {
            this.dia = 30;
            this.mes--;
        }

        else if (this.dia == 1 && (this.mes == 4 || this.mes == 6 || this.mes == 9 || this.mes == 11 || this.mes == 3)) {
            this.dia = 31;
            this.mes--;
        }

        else if (this.dia == 1 && this.mes == 3 && Data.isBissexto(this.ano)) {
            this.dia = 29;
            this.mes--;
        }

        else if (this.dia == 1 && this.mes == 3) {
            this.dia = 28;
            this.mes--;
        }

        else if (isValida((byte) (this.dia - 1), this.mes, this.ano)) {
            this.dia--;
        } else {
            throw new Exception("Data invalida apos o retrocesso de um dia");
        }
    }
}


