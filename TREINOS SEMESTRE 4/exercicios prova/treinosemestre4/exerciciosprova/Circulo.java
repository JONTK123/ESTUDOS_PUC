// Escreva uma classe chamada Circulo. Suas instâncias deverão ser capazes de 
// armazenar as coordenadas do centro, bem como o valor do raio de um círculo. 
// Todas as validações cabíveis de serem realizadas por seus métodos deverão ser 
// feitas e exceções deverão ser lançadas no caso de incorretudes serem detectadas.
//  Escreva um construtor que, recebendo números reais expressando as 
// coordenadas e o valor do raio de um círculo, armazena essas informações 
// internamente.
//  Escreva um método chamado getComprimento que, recebendo um objeto da 
// classe Angulo, retorna o comprimento do arco do círculo com aquela varredura 
// angular.
//  Escreva um método chamado getArea que, recebendo um objeto da classe 
// Angulo, retorna a área do setor do círculo com aquela varredura angular.
//  Escreva um métido chamado setCentro que, recebendo como parâmetro dois 
// números reais expressando as coordenadas do círculo, armazena estas 
// informações internamente.
//  Escreva um métido chamado setRaio que, recebendo como parâmetro um 
// número real expressando o raio do círculo, armazena esta informação 
// internamente.
//  Crie os métodos padrão necessários e cabíveis

public class Circulo implements Comparable<Circulo>, Cloneable {
    private double x;
    private double y;
    private double raio;
    public final double pi = 3.14;

    private static boolean isValida(double x, double y, double raio) throws Exception {
        if(x < 0 || y < 0 || raio < 0) { return false; }
        return true;
    }

    public Circulo(double x, double y, double raio) throws Exception {
        if(!Circulo.isValida(x,y,raio)) { throw new Exception ("xixi coco");} 

        this.x = x;
        this.y = y;
        this.raio = raio;
    }

    public Circulo(Circulo c) throws Exception {
        if(!Circulo.isValida(c.x,c.y,c.raio)) { throw new Exception ("xixi coco");}

        this.x = c.x;
        this.y = c.y;
        this.raio = c.raio;
    }

    public double getComprimento() {
        return this.raio * 2 * pi;
    }

    public void setComprimento(double comprimento) throws Exception {
        double raio = comprimento / (2*pi);
        if(!Circulo.isValida(this.x, this.y, raio)) { throw new Exception ("xixi coco");}
        this.raio = raio;
    }

    public double getArea() {
        return pi * (this.raio * this.raio);
    }

    public void setCentro(double x, double y) throws Exception {
        if(!Angulo.isValida(x,y,this.raio)) { throw new Exception ("xixi coco");}
        this.x = x;
        this.y = y;
    }

    public void setRaio(double raio) throws Exception {
        if(!Angulo.isValida(this.x, this.y, raio)) { throw new Exception ("xixi coco");}
        this.raio = raio;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getRaio() {
        return this.raio;
    }

    @Override
    public String toString() {
        return ( "X: " + this.x + "Y: " + this.y + "Raio: " + this.raio);
    }

    @Override
    public int hashCode() {
        int ret = 666;

        ret = ret * 7 + Double.valueOf(this.x).hashCode();
        ret = ret * 7 + Double.valueOf(this.y).hashCode();
        ret = ret * 7 + Double.valueOf(this.raio).hashCode();

        return ret;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        if(this.getClass() != obj.getClass()) return false;

        Circulo c = (Circulo) obj;

        if(this.x != c.x) return false;
        if(this.y != c.y) return false;
        if(this.raio != c.raio) return false;

        return true;
    }

    @Override
    public Object clone() {
        Circulo ret = null;

        try {
            ret = new Circulo(this);
        } catch (Exception e) {}

        return ret;
    } 

    @Override
    public int compareTo(Circulo c) {
        if(this.raio > c.raio) return 1;
        if(this.raio < c.raio) return -1;
        return 0;
    }


    public static void main(String[] args) {
        try {
            Circulo c1 = new Circulo(1,1,1);
            Circulo c2 = new Circulo(2,2,2);
            Circulo c3 = new Circulo(3,3,3);

            System.out.println(c1.getComprimento());
            c1.setComprimento(10);

            System.out.println(c1.getArea());

            c1.setCentro(10,10);

            c1.setRaio(10);

            System.out.println(c1.getX());
            System.out.println(c1.getY());

            System.out.println(c1.getRaio());

            System.out.println(c1.toString());

            System.out.println(c1.equals(c2));

            Circulo c4 = (Circulo) c1.clone();
            c4.setCentro(10, 1);


        } catch (Exception e) { }
    }
}