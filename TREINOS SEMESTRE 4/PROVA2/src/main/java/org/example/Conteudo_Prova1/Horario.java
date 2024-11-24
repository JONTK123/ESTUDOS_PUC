package org.example.Conteudo_Prova1;

public class Horario implements Comparable<Horario>, Cloneable {
    private byte h;
    private byte m;
    private byte s;

    private static boolean isValida(byte h, byte m, byte s) {
        return h >= 0 && h <= 23 && m >= 0 && m <= 59 && s >= 0 && s <= 59;
    }

    public Horario(byte h, byte m, byte s) {
        if (!isValida(h, m, s)) {
            throw new IllegalArgumentException("Horário inválido");
        }
        this.h = h;
        this.m = m;
        this.s = s;
    }

    public byte getH() {
        return h;
    }

    public void setH(byte h) {
        if (!isValida(h, this.m, this.s)) {
            throw new IllegalArgumentException("Horário inválido");
        }
        this.h = h;
    }

    public byte getM() {
        return m;
    }

    public void setM(byte m) {
        if (!isValida(this.h, m, this.s)) {
            throw new IllegalArgumentException("Horário inválido");
        }
        this.m = m;
    }

    public byte getS() {
        return s;
    }

    public void setS(byte s) {
        if (!isValida(this.h, this.m, s)) {
            throw new IllegalArgumentException("Horário inválido");
        }
        this.s = s;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", h, m, s);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Horario horario = (Horario) obj;
        return h == horario.h && m == horario.m && s == horario.s;
    }

    @Override
    public int hashCode() {
        int result = Byte.hashCode(h);
        result = 31 * result + Byte.hashCode(m);
        result = 31 * result + Byte.hashCode(s);
        return result;
    }

    public void adiante(int segundos) throws Exception {
        if (segundos <= 0) {
            throw new Exception("Quantidade de segundos inválida");
        }
        for (int i = 0; i < segundos; i++) {
            if (isValida(h, m, (byte) (s + 1))) {
                s++;
            } else if (isValida(h, (byte) (m + 1), (byte) 0)) {
                m++;
                s = 0;
            } else if (isValida((byte) (h + 1), (byte) 0, (byte) 0)) {
                h++;
                m = 0;
                s = 0;
            } else {
                h = 0;
                m = 0;
                s = 0;
            }
        }
    }

    public void atrase(int segundos) throws Exception {
        if (segundos <= 0) {
            throw new Exception("Quantidade de segundos inválida");
        }
        for (int i = 0; i < segundos; i++) {
            if (isValida(h, m, (byte) (s - 1))) {
                s--;
            } else if (isValida(h, (byte) (m - 1), (byte) 59)) {
                m--;
                s = 59;
            } else if (isValida((byte) (h - 1), (byte) 59, (byte) 59)) {
                h--;
                m = 59;
                s = 59;
            } else {
                h = 23;
                m = 59;
                s = 59;
            }
        }
    }

    public int diferenca(Horario outro) throws Exception {
        if (outro == null) {
            throw new Exception("Horário inválido");
        }
        int totalSegundosThis = this.h * 3600 + this.m * 60 + this.s;
        int totalSegundosOutro = outro.h * 3600 + outro.m * 60 + outro.s;
        return Math.abs(totalSegundosThis - totalSegundosOutro);
    }

    @Override
    public int compareTo(Horario outro) {
        int compareH = Byte.compare(this.h, outro.h);
        if (compareH != 0) return compareH;
        int compareM = Byte.compare(this.m, outro.m);
        if (compareM != 0) return compareM;
        return Byte.compare(this.s, outro.s);
    }

    @Override
    public Horario clone() {
        try {
            return (Horario) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}