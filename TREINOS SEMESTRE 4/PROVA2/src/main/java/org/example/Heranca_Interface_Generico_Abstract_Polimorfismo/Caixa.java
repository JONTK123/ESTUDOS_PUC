package org.example.Heranca_Interface_Generico_Abstract_Polimorfismo;

//Exemplo classe generica simples
//Classes genericas so aceitam outras classes como parametro
public class Caixa<X> implements Cloneable {
    //X pode ser qualquer classe
    private X x;

    public boolean isValida(X coisa) {
        if(coisa == null) { return false; }
        return true;
    }

    public Caixa() {
        this.x = null;
    }

    public Caixa(X x) {
        if(!isValida(x)) { throw new IllegalArgumentException("xixi coco"); }
        this.x = x;
    }

    //Construtor de copia, criando uma nova instancia a partir da original
    //So eh necessario clonar se um atributo for de outra classe ou se for um objeto mutavel ( como um array)
    //Como nao sabemos se X eh uma classe ou um objeto mutavel, eh necessario clonar
    //Mas nao eh tao simples assim pois o compilador nao sabe se o X eh uma classe que possui o metodo clone
    //Por isso criamos uma nova classe Clonadora
    public Caixa(Caixa<X> x) {
        if(!isValida(x.x)) { throw new IllegalArgumentException("xixi coco"); }

        if(x.x instanceof Cloneable) {
            try {
                Clonador<X> clonador = new Clonador<X>();
                this.x = clonador.clone(x.x);
                // ou this.x = clonador.clone(x.getCoisa()); //Se getCoisa for um metodo que retorna o atributo
                // ou this.x = clonador.clone(x.getXixi()); Se xixi for atributo de outra classe
            } catch (Exception e) {}
        } else {
            this.x = x.x;
        }
    }

    //Noa sabemos se x sera uma classe ou um tipo primitivo. Entao eh necessario verifficar e entao clonar ou nao
    public void setCoisa(X x) {
        if (!isValida(x)) {
            throw new IllegalArgumentException("Valor inválido (nulo)");
        }

        if (x instanceof Cloneable) {
            try {
                Clonador<X> clonador = new Clonador<>();
                this.x = clonador.clone(x);
            } catch (Exception e) {
                throw new RuntimeException("Erro ao clonar o objeto", e);
            }
        } else {
            this.x = x;
        }
    }

    //Noa sabemos se x sera uma classe ou um tipo primitivo. Entao eh necessario verifficar e entao clonar ou nao
    public X getCoisa() {
        if (this.x instanceof Cloneable) {
            try {
                Clonador<X> clonador = new Clonador<>();
                return clonador.clone(this.x); // Retornamos uma cópia do objeto se ele for Cloneable
            } catch (Exception e) {
                throw new RuntimeException("Erro ao clonar o objeto", e);
            }
        }
        return this.x; // Caso contrário, retornamos diretamente (imutáveis ou primitivos)
    }


    @Override
    public String toString() {
        return ("Caixa{" + "coisa" + this.x+ "}");
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null) return false;
        if(this.getClass() != obj.getClass()) return false;

        Caixa<X> c = (Caixa<X>) obj;
        
        if(this.x != c.x) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int ret = 666;
        ret = ret * 7 + this.x.hashCode();
        return ret;
    }

    @Override
    public Object clone() {
        Caixa<X> ret = null;
        try {
            ret = new Caixa<X> (this);
        } catch (Exception e) {}

        return ret;
    }
}

