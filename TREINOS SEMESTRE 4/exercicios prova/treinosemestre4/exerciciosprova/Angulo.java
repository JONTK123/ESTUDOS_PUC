// Escreva uma classe chamada Angulo. Suas instâncias deverão ser capazes de 
// armazenar um valor angular expresso em graus (este será o único atributo). Todas as 
// validações cabíveis de serem realizadas por seus métodos deverão ser feitas e 
// exceções deverão ser lançadas no caso de incorretudes serem detectadas.
//  Escreva um construtor que, recebendo um valor angular expresso em graus, o 
// armazena internamente;
//  Escreva métodos de instância chamadas getValorEmGraus, getValorEmGrados
// e getValorEmRadianos que, sem receber parâmetros, retornam, respectivamente, 
// o valor angular do objeto expresso em graus, grados e radianos

public class Angulo implements Comparable<Angulo>, Cloneable{
    private double angulo;
    private final double pi = 3.14;

    private static boolean isValida(double angulo) {
        if (angulo < 0 || angulo > 360 ) { return false; }
        return true;
    }

    public Angulo(double angulo) throws Exception {
        if(!Angulo.isValida(angulo)) {
            throw new Exception("Valor de angulo invalido");
        }

        this.angulo = angulo;

        //ou

        //this.setAngulo(angulo);
    }

    public Angulo(Angulo a) throws Exception {
        if (!Angulo.isValida(a.angulo)) {throw new Exception("xixi coco");}

        this.angulo = a.angulo;
    }

    public double getValorEmGraus() {
        return this.angulo;
    }

    public void setAngulo(double angulo) throws Exception {
        if(!Angulo.isValida(angulo)) { throw new Exception("Valor de angulo invalido"); }
        this.angulo = angulo;

        //ou

        //if(angulo < 0 || angulo > 360 ) { throw new Exception'("Valor de angulo invalido"); }
        //this.angulo = angulo;
    }

    public double getValorEmGrados() {
        return this.angulo * 1.1111;
    }

    public void setValorEmGrados(double grados) throws Exception {
        double anguloEmGraus = grados / 1.1111;
        if(!Angulo.isValida(anguloEmGraus)) { throw new Exception("Valor de angulo invalido"); }
            this.angulo = anguloEmGraus;

        // ou

        //if(angulo < 0 || angulo > 360 ) { throw new Exception'("Valor de angulo invalido"); }
        //this.angulo = anguloEmGraus
    }

    public double getValorEmRadianos() {
        return this.angulo * pi / 180;
    }

    public void setValorEmRadianos(double radiano) throws Exception {
        double anguloEmGraus = radiano * 180 / pi;
        if(!Angulo.isValida(anguloEmGraus)) { throw new Exception("Valor de angulo invalido"); }
        this.angulo = anguloEmGraus;

        // ou

        //if(anguloEmGraus < 0 || anguloEmGraus > 360 ) { throw new Exception'("Valor de angulo invalido"); }
        //this.angulo = anguloEmGraus
    }

    @Override
    public String toString() {
        return ("Angulo em graus: " + this.getValorEmGraus() + 
               "\nAngulo em grados: " + this.getValorEmGrados() +
               "\nAngulo em radianos: " + this.getValorEmRadianos());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        Angulo a = (Angulo) obj;

        if(this.angulo != a.angulo ) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int ret = 1;

        ret = ret * 2 + Double.valueOf(this.angulo).hashCode();
        //ret = ret * 2 this.dataNascimento.hashCode();

        return ret;
    }

    @Override
    public int compareTo(Angulo a){
        if(this.angulo > a.angulo) return 1;
        if(this.angulo < a.angulo) return -1;
        return 0;
    }

    @Override
    public Object clone(){
        Object ret = null;
        
        try {
            ret = new Angulo(this);
        } catch (Exception e ){}

        return ret;
    }

    public static void main(String[] args) {

        try {
        Angulo a1 = new Angulo(10);
        Angulo a2 = new Angulo(12);

        System.out.println("\nAngulo em graus: " + a1.getValorEmGraus());
        System.out.println("\nAngulo em grados: " + a1.getValorEmGrados());
        System.out.println("\nAngulo em radianos: " + a1.getValorEmRadianos());
        
        System.out.println("\nOU pode ser escrito assim:");

        System.out.println(a1.toString());

        a1.setAngulo(20);
        a1.setValorEmGrados(22);
        a1.setValorEmRadianos(25);

        System.out.println(a1.toString());

        System.out.println(a1.equals(a2));

        System.out.println(a1.compareTo(a2));

        Angulo a3 = (Angulo) a1.clone();
        a3.setAngulo(30);

        } catch (Exception e) {}
    }
}
