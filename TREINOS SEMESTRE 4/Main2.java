class Data {
    private byte dia, mes;
    private short ano;

    private static boolean isBissexto(short ano) {
        // Calendário Juliano
        if (ano < 1582) {
            return ano % 4 == 0;
        }

        // Calendário Gregoriano
        if (ano % 400 == 0) return true;
        if (ano % 4 == 0 && ano % 100 != 0) return true;
        return false;
    }

    private static boolean isValida(byte dia, byte mes, short ano) {
        if (ano < -45) return false; // antes do Calendário Juliano
        if (ano == 0) return false; // não existiu ano 0; do ano 1ac foi direto para o ano 1dc
        if (ano == 1582 && mes == 10 && dia >= 5 && dia <= 14) return false; // dias cortados do calendário pelo Papa Gregório

        if (dia < 1 || dia > 31 || mes < 1 || mes > 12) return false;

        if (dia > 30 && (mes == 4 || mes == 6 || mes == 9 || mes == 11)) return false;
        if (dia > 29 && mes == 2) return false;
        if (dia > 28 && mes == 2 && !Data.isBissexto(ano)) return false;

        return true;
    }

    public Data(byte dia, byte mes, short ano) throws Exception {
        if (!Data.isValida(dia, mes, ano))
            throw new Exception("Data inválida");

        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public void setDia(byte dia) throws Exception {
        if (!Data.isValida(dia, this.mes, this.ano))
            throw new Exception("Dia inválido");

        this.dia = dia;
    }

    public byte getDia() {
        return this.dia;
    }

    public void setMes(byte mes) throws Exception {
        if (!Data.isValida(this.dia, mes, this.ano))
            throw new Exception("Mês inválido");

        this.mes = mes;
    }

    public byte getMes() {
        return this.mes;
    }

    public void setAno(short ano) throws Exception {
        if (!Data.isValida(this.dia, this.mes, ano))
            throw new Exception("Ano inválido");

        this.ano = ano;
    }

    public short getAno() {
        return this.ano;
    }

    // Todos os casos -> +1 dia normal, +1 mês bissexto?, +1 mês 30 e 31, +1 ano
    // Verificar a possibilidade de passar o mês, considerando o dia 1. Assim como
    // verificar o próximo ano considerando dia 1 e mês 1
    public void avanceUmDia() throws Exception {
        if (isValida((byte) (this.dia + 1), this.mes, this.ano)) {
            this.dia++;
        } else if (this.mes == 2) {
            // Se o ano for bissexto e o dia for 28 de fevereiro, avança para 29
            if (isBissexto(this.ano) && this.dia == 28) {
                this.dia++;
            }
            // Se o dia for 29 (em ano bissexto) ou 28 (em ano não bissexto), avança para 1º de março
            else if ((isBissexto(this.ano) && this.dia == 29 || (!isBissexto(this.ano) && this.dia == 28))) {
                this.dia = 1;
                this.mes++;
            }
        } else if (isValida((byte) 1, (byte) (this.mes + 1), this.ano)) {
            this.dia = 1;
            this.mes++;
        } else if (isValida((byte) 1, (byte) 1, (short) (this.ano + 1))) {
            this.dia = 1;
            this.mes = 1;
            this.ano++;
        }
    }

    // Todos os casos -> -1 dia normal, -1 mês bissexto?, -1 mês 30, -1 mês 31, -1 ano
    // Verificar a possibilidade de retroceder o mês, considerando o dia 30 E 31. Assim como 
    // verificar o ano anterior considerando o dia 31 e mês 12
    public void retrocedeUmDia() throws Exception {
        if (isValida((byte) (this.dia - 1), this.mes, this.ano)) {
            this.dia--;
        } else if (this.mes == 3) {
            if (isBissexto(this.ano) && this.dia == 1) {
                this.dia = 29;
                this.mes = 2;
            } else if ((!isBissexto(this.ano) && this.dia == 1)) {
                this.dia = 28;
                this.mes = 2;
            }
        } else if (isValida((byte) 31, (byte) (this.mes - 1), this.ano)) {
            this.dia = 31;
            this.mes--;
        } else if (isValida((byte) 30, (byte) (this.mes - 1), this.ano)) {
            this.dia = 30;
            this.mes--;
        } else if (isValida((byte) 31, (byte) 12, (short) (this.ano - 1))) {
            this.dia = 31;
            this.mes = 12;
            this.ano--;
        }
    }

    //Constructor da classe Data possui um "Throw Exception" entao, ao instanciar essa classe, precisamos lançar isso também
    //Tipo do getter é Data pois ele retorna um objeto da classe Data ( uma data literalmente com dia/mes/ano )
    //Throws exception pelo q entendi, eh q esse método AINDA pode tratar essa exception...
    public Data getDiaSeguinte() throws Exception {
        Data diaSeguinte = new Data(this.dia, this.mes, this.ano);
        diaSeguinte.avanceUmDia();
        return diaSeguinte;
    }

    public Data getDiaAnterior() throws Exception {
        Data diaAnterior= new Data(this.dia, this.mes, this.ano);
        diaAnterior.retrocedeUmDia();
        return diaAnterior;
    }

    //Simplesmente chamar a função avanceUmDia por uma quantidade de vezes -> For
    public void avanceVariosDias(int qts) throws Exception {
        for (int i=0; i<qts; i++) {

    //This se refere á instancia da classe Data. Como essa função esta sendo chamada dentro da classe Data,
    // nao precisamos passar nada. Pois o this se refere a instancia da classe Data
            this.avanceUmDia(); 
        }
    }

    public void retrocederVariosDias(int qts) throws Exception{
        for (int i=0; i<qts; i++) {
            this.retrocedeUmDia();
        }
    }

    public Data getAvanceVariosDias(int qtd) throws Exception {
        Data diaSeguinte = new Data(this.dia, this.mes, this.ano);
        diaSeguinte.avanceVariosDias(qtd);
        return diaSeguinte;
    }

    
    public Data getRetrocedaVariosDias(int qtd) throws Exception {
        Data diaAnterior = new Data(this.dia, this.mes, this.ano);
        diaAnterior.avanceVariosDias(qtd);
        return diaAnterior;
    }

}

public class Main {
    public static void main(String[] args) {
        try {
            // Teste 1: Data inicial válida
            Data data1 = new Data((byte) 28, (byte) 2, (short) 2024);
            System.out.println("Data inicial: " + data1.getDia() + "/" + data1.getMes() + "/" + data1.getAno());
            
            // Avançar um dia em ano bissexto
            data1.avanceUmDia();
            System.out.println("Data após avançar um dia: " + data1.getDia() + "/" + data1.getMes() + "/" + data1.getAno());

            // Retroceder um dia
            data1.retrocedeUmDia();
            System.out.println("Data após retroceder um dia: " + data1.getDia() + "/" + data1.getMes() + "/" + data1.getAno());

            // Avançar vários dias
            data1.avanceVariosDias(5);
            System.out.println("Data após avançar 5 dias: " + data1.getDia() + "/" + data1.getMes() + "/" + data1.getAno());

            // Retroceder vários dias
            data1.retrocederVariosDias(3);
            System.out.println("Data após retroceder 3 dias: " + data1.getDia() + "/" + data1.getMes() + "/" + data1.getAno());

            // Teste 2: Data no final do mês
            Data data2 = new Data((byte) 30, (byte) 4, (short) 2024);
            System.out.println("Data inicial: " + data2.getDia() + "/" + data2.getMes() + "/" + data2.getAno());

            // Avançar um dia
            data2.avanceUmDia();
            System.out.println("Data após avançar um dia: " + data2.getDia() + "/" + data2.getMes() + "/" + data2.getAno());

            // Retroceder um dia
            data2.retrocedeUmDia();
            System.out.println("Data após retroceder um dia: " + data2.getDia() + "/" + data2.getMes() + "/" + data2.getAno());

            // Teste 3: Data no final do ano
            Data data3 = new Data((byte) 31, (byte) 12, (short) 2023);
            System.out.println("Data inicial: " + data3.getDia() + "/" + data3.getMes() + "/" + data3.getAno());

            // Avançar um dia
            data3.avanceUmDia();
            System.out.println("Data após avançar um dia: " + data3.getDia() + "/" + data3.getMes() + "/" + data3.getAno());

            // Retroceder um dia
            data3.retrocedeUmDia();
            System.out.println("Data após retroceder um dia: " + data3.getDia() + "/" + data3.getMes() + "/" + data3.getAno());

            // Teste 4: Data no início do ano
            Data data4 = new Data((byte) 1, (byte) 1, (short) 2023);
            System.out.println("Data inicial: " + data4.getDia() + "/" + data4.getMes() + "/" + data4.getAno());

            // Avançar vários dias
            data4.avanceVariosDias(31);
            System.out.println("Data após avançar 31 dias: " + data4.getDia() + "/" + data4.getMes() + "/" + data4.getAno());

            // Retroceder vários dias
            data4.retrocederVariosDias(15);
            System.out.println("Data após retroceder 15 dias: " + data4.getDia() + "/" + data4.getMes() + "/" + data4.getAno());

            // Teste 5: Data no início do mês
            Data data5 = new Data((byte) 1, (byte) 5, (short) 2024);
            System.out.println("Data inicial: " + data5.getDia() + "/" + data5.getMes() + "/" + data5.getAno());

            // Avançar vários dias
            data5.avanceVariosDias(31);
            System.out.println("Data após avançar 31 dias: " + data5.getDia() + "/" + data5.getMes() + "/" + data5.getAno());

            // Retroceder vários dias
            data5.retrocederVariosDias(30);
            System.out.println("Data após retroceder 30 dias: " + data5.getDia() + "/" + data5.getMes() + "/" + data5.getAno());

            // Teste 6: Data inválida (deve lançar uma exceção)
            try {
                Data data6 = new Data((byte) 31, (byte) 4, (short) 2024);
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }

            // Teste 7: Teste de métodos getDiaSeguinte e getDiaAnterior
            Data data7 = new Data((byte) 15, (byte) 3, (short) 2024);
            System.out.println("Data inicial: " + data7.getDia() + "/" + data7.getMes() + "/" + data7.getAno());

            Data diaSeguinte = data7.getDiaSeguinte();
            System.out.println("Dia seguinte: " + diaSeguinte.getDia() + "/" + diaSeguinte.getMes() + "/" + diaSeguinte.getAno());

            Data diaAnterior = data7.getDiaAnterior();
            System.out.println("Dia anterior: " + diaAnterior.getDia() + "/" + diaAnterior.getMes() + "/" + diaAnterior.getAno());

        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }

         try {
            // Teste 8: Avançar vários dias
            Data data3 = new Data((byte) 10, (byte) 6, (short) 2024);
            System.out.println("Data inicial: " + data3.getDia() + "/" + data3.getMes() + "/" + data3.getAno());

            Data novaData = data3.getAvanceVariosDias(15);
            System.out.println("Data após avançar 15 dias: " + novaData.getDia() + "/" + novaData.getMes() + "/" + novaData.getAno());

        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }

        try {
            // Teste 9: Retroceder vários dias
            Data data4 = new Data((byte) 25, (byte) 12, (short) 2024);
            System.out.println("Data inicial: " + data4.getDia() + "/" + data4.getMes() + "/" + data4.getAno());

            Data novaData = data4.getRetrocedaVariosDias(10);
            System.out.println("Data após retroceder 10 dias: " + novaData.getDia() + "/" + novaData.getMes() + "/" + novaData.getAno());

        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
