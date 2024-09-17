import java.util.Vector;

class Horario implements Comparable <Horario>, Cloneable {
    byte h, m, s;

    private static boolean isValida(byte h, byte m, byte s) {
        if (h < 0 || h > 23) return false;
        else if (m < 0 || m > 59) return false;
        else if (s < 0 || s > 59) return false;

        return true;
    }

    public Horario(byte h, byte m, byte s) {
        if (!isValida(h, m, s)) throw new IllegalArgumentException("Horário inválido");
        this.h = h;
        this.m = m;
        this.s = s;
    }

    public byte getH() {
        return h;
    }

    public byte getM() {
        return m;
    }

    public byte getS() {
        return s;
    }

    public void setH(byte h) {
        if (!isValida(h, this.m, this.s)) throw new IllegalArgumentException("Horário inválido");
        this.h = h;
    }

    public void setM(byte m) {
        if (!isValida(this.h, m, this.s)) throw new IllegalArgumentException("Horário inválido");
        this.m = m;
    }

    public void setS(byte s) {
        if (!isValida(this.h, this.m, s)) throw new IllegalArgumentException("Horário inválido");
        this.s = s;
    }

    @Override
    public String toString() {
        return (this.h < 10 ? "0" : "") +
                this.h + ":" +
                (this.m < 10 ? "0" : "") +
                this.m + ":" +
                (this.s < 10 ? "0" : "") +
                this.s;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;

        Horario d = (Horario) obj;

        if (d.h != this.h) return false;
        if (d.m != this.m) return false;
        if (d.s != this.s) return false;

        return true;
    }

    public void adiante(int qtdSegundos) throws Exception {
        if (qtdSegundos <= 0) {
            throw new Exception("Quantidade de segundos inválida");
        }

        for (int i = 0; i < qtdSegundos; i++) {
            if (isValida(this.h, this.m, (byte) (this.s + 1))) {
                this.s++;
            } else if (isValida(this.h, (byte) (this.m + 1), this.s)) {
                this.m++;
                this.s = 0;
            } else if (isValida((byte) (this.h + 1), this.m, this.s)) {
                this.h++;
                this.m = 0;
                this.s = 0;
            } else { // Mudança de dia 23:59:59
                this.h = 0;
                this.m = 0;
                this.s = 0;
            }
        }
    }

    public void atrase(int qtdSegundos) throws Exception {
        if (qtdSegundos <= 0) {
            throw new Exception("Quantidade de segundos inválida");
        }

        for (int i = 0; i < qtdSegundos; i++) {
            if (isValida(this.h, this.m, (byte) (this.s - 1))) {
                this.s--;
            } else if (isValida(this.h, (byte) (this.m - 1), (byte) 59)) {
                this.m--;
                this.s = 59;
            } else if (isValida((byte) (this.h - 1), (byte) 59, (byte) 59)) {
                this.h--;
                this.m = 59;
                this.s = 59;
            } else { // Mudança de dia
                this.h = 23;
                this.m = 59;
                this.s = 59;
            }
        }
    }

    public int diferenca(Horario NovaInstancia) throws Exception {
        if (NovaInstancia == null) throw new Exception("Horário inválido");

        int thisSegundos = this.h * 3600 + this.m * 60 + this.s;
        int hSegundos = NovaInstancia.h * 3600 + NovaInstancia.m * 60 + NovaInstancia.s;

        return Math.abs(thisSegundos - hSegundos);
    }

    @Override
    public int compareTo (Horario h) {
        if (this.h > h.h) return 1;
        else if (this.h < h.h) return -1;
        else if (this.m > h.m) return 1;
        else if (this.m < h.m) return -1;
        else if (this.s > h.s) return 1;
        else if (this.s < h.s) return -1;
        else
        return 0;
    }

    // @Override
    // public Horario clone() {
    //     try {
    //         return (Horario) super.clone(); //Retorna uma copia da instancia da classe Horario usando metodo clone da super classe Object
    //     } catch (CloneNotSupportedException e) {
    //         throw new AssertionError();
    //     }
    // }

    // Construtor de cópia
    public Horario(Horario modelo) throws Exception {
        if (modelo == null) throw new Exception("Modelo ausente");

        this.h = modelo.h;
        this.m = modelo.m;
        this.s = modelo.s;
    }

    @Override
    public Horario clone() {
        try {
            return new Horario(this); // Usa o construtor de cópia para criar uma cópia
        } catch (Exception e) {
            throw new AssertionError("Clonagem falhou", e); // Nunca deve ocorrer se this não for null
        }
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            // Caso 1: Horário inicial
            Horario h1 = new Horario((byte) 10, (byte) 30, (byte) 40);
            System.out.println("Caso 1: " + h1.toString()); // Esperado: 10:30:40

            // Caso 2: Adiantando 10 segundos
            h1.adiante(10);
            System.out.println("Caso 2: " + h1.toString()); // Esperado: 10:30:50

            // Caso 3: Adiantando 20 segundos
            h1.adiante(20);
            System.out.println("Caso 3: " + h1.toString()); // Esperado: 10:31:10

            // Caso 4: Adiantando 30 segundos
            h1.adiante(30);
            System.out.println("Caso 4: " + h1.toString()); // Esperado: 10:31:40

            // Caso 5: Atrasando 5 segundos
            h1.atrase(5);
            System.out.println("Caso 5: " + h1.toString()); // Esperado: 10:31:35

            // Caso 6: Criando outro horário
            Horario h2 = new Horario((byte) 5, (byte) 2, (byte) 50);
            System.out.println("Caso 6: " + h2.toString()); // Esperado: 05:02:50

            // Caso 7: Verificando igualdade
            System.out.println("Caso 7: " + h1.equals(h2)); // Esperado: false

            // Caso 8: Diferença entre horários
            System.out.println("Caso 8: " + h1.diferenca(h2)); // Esperado: diferença em segundos

            // Caso 9: Adiantando para mudança de dia
            Horario h3 = new Horario((byte) 23, (byte) 59, (byte) 50);
            h3.adiante(10);
            System.out.println("Caso 9: " + h3.toString()); // Esperado: 00:00:00

            // Caso 10: Atrasando para mudança de dia
            Horario h4 = new Horario((byte) 0, (byte) 0, (byte) 10);
            h4.atrase(20);
            System.out.println("Caso 10: " + h4.toString()); // Esperado: 23:59:50

            // Caso 11: Adiantando para mudança de dia
            Horario h5 = new Horario((byte) 23, (byte) 59, (byte) 50);
            h5.adiante(10);
            System.out.println("Caso 11: " + h5.toString()); // Esperado: 00:00:00

            // Caso 12: Comparando horários
            Horario h6 = new Horario((byte) 10, (byte) 30, (byte) 40);
            Horario h7 = new Horario((byte) 10, (byte) 30, (byte) 40);
            System.out.println("Caso 12: " + h6.compareTo(h7)); // Esperado: 0

            // Caso 13: Testando clone
            Horario h8 = new Horario((byte) 10, (byte) 30, (byte) 40);
            Vector<Horario> horarios = new Vector<Horario>();

            horarios.add(h8.clone());

            h8.setH((byte) 20);

            System.out.println("Caso 13: " + horarios.get(0).toString()); // Esperado: 10:30:40

            // Caso 14: Testando clone 2.0
            Horario h9 = new Horario((byte) 15, (byte) 45, (byte) 30);
            Horario h10 = h9.clone();
            Horario h11 = h9;
            h9.setM((byte) 50);

            System.out.println("Caso 14: " + h10.toString()); // Esperado: 15:45:30
            System.out.println("Caso 14: " + h9.toString());  // Esperado: 15:50:30


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}

// 