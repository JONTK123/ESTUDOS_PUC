class Horario {
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
                if(this.s == 59){
                    this.s = 0;
                    this.m++;
                } else {
                    this.s++;
                }
            } else if (isValida(this.h, (byte) (this.m + 1), this.s)) {
                if (this.m == 59) {
                    this.m = 0;
                    this.h++;
                } else {
                    this.m++;
                }
            } else if (isValida((byte) (this.h + 1), this.m, this.s)) {
                if(this.h == 23) {
                    this.h = 0;
                    this.m = 0;
                    this.s = 0;
                } else {
                this.h++;
                this.m = 0;
                this.s = 0;
                }

            } else {
                throw new Exception("Horário inválido");
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
            } else if (isValida(this.h, (byte) (this.m - 1), this.s)) {
                this.m--;
            } else if (isValida((byte) (this.h - 1), this.m, this.s)) {
                this.h--;
            } else {
                throw new Exception("Horário inválido");
            }
        }
    }

    public int diferenca(Horario NovaInstancia) throws Exception {
        if (NovaInstancia == null) throw new Exception("Horario Invalido");

        int thisSegundos = this.h * 3600 + this.m * 60 + this.s;
        int hSegundos = NovaInstancia.h * 3600 + NovaInstancia.m * 60 + NovaInstancia.s;

        return Math.abs(thisSegundos - hSegundos);
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            Horario h1 = new Horario((byte) 10, (byte) 30, (byte) 40);
            Horario h2 = new Horario((byte) 5, (byte) 2, (byte) 50);

            System.out.println(h1.toString());
            System.out.println(h2.toString());

            h1.adiante(10);
            System.out.println(h1.toString());

            h1.adiante(20);
            System.out.println(h1.toString());

            h1.adiante(30);
            System.out.println(h1.toString());
            
            System.out.println(h1.equals(h2));

            h1.atrase(5);
            System.out.println(h1.toString());

            System.out.println(h1.diferenca(h2));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}