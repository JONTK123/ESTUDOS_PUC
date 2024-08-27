public class Horario
{
    byte h,m,s;

    private static isValida(byte h, byte m, byte s) {
        if (h<0 || h>23) return false;
        if (m<0 || m>59) return false;
        if (s<=0 || s>59) return false;
    }

    public Horario(byte h, byte m, byte s){
        if (isValida(h,m,s)) throw new exception("Horário inválido");
        this.h=h;
        this.m=m;
        this.s=s;
    }

    public byte getH(){
        return h;
    }

    public byte getM(){
        return m;
    }

    public byte getS(){
        return s;
    }

    public void setH(byte h){
        if (isValida(h,this.m,this.s)) throw new exception("Horário inválido");
        this.h=h;
    }

    public void setM(byte m){
        if (isValida(this.h,m,this.s)) throw new exception("Horário inválido");
        this.m=m;
    }

    public void setS(byte s){
        if (isValida(this.h,this.m,s)) throw new exception("Horário inválido");
        this.s=s;
    }

    @override
    public String toString () {
        return (this.h<10?"0":"") +
                this.h + ":" +
                (this.m<10?"0":"") +
                this.m + ":" +
                (this.s<10?"0":"") +
                this.s;
    }

    @Override
    public boolean equals (Object obj){ 
        if (obj==this) return true; 
        if (obj==null) return false; 
        if (obj.getClass()!=this.getClass()) return false;

        Horario d = (Horario)obj; 
        
        if (d.Horario!=this.h) return false;
        if (d.Horario!=this.m) return false;
        if (d.Horario!=this.s) return false;
    }

    public void adiante (int qtdSegundos) throw Exception
    {
        dar exceção se qtdSegundos<=0
        ...
    }
    public void atrase (int qtdSegundos) throw Exception
    {
        dar exceção se qtdSegundos<=0
        ...
    }
    public int diferença (Horario h) throws Exception
    {
        // dar exceção se h for null
        // retornar quantos segundo há entre this e h
    }

}