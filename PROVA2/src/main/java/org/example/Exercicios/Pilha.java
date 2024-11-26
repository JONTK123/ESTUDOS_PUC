//Pilhas são capazes de armazenar valores (que poderiam ser de qualquer tipo, a
//princípio). Elas se caracterizam por uma característica muito peculiar: não permitem
//que se recupere dela ou que se remova dela o dado que quiser, na hora que quiser.
//Só se pode recuperar dela a última coisa que nela foi guardade, assim como só se
//pode remover dela a última coisa que foi guardada. E é por isso que se costuma
//dizer que pilhas seguem a disciplina LIFO (last in, first out). Elas têm uma
//quantidade enorme de aplicações, as quais teremos oportunidade de discutir
//oportunamente. O exercício consiste em escrever uma classe chamada Pilha, cujas
//instâncias descrevam pilhas, como acima descritas.
//O exercício consiste em escrever uma classe genérica (capaz de guardar o que quer
//        de se decida guardar) chamada Pilha, cujas instâncias descrevam pilhas, como acima
//descritas.
// Inclua um atributo chamado elemento que seja um vetor para armazenar cada
//item que se decida guardar na pilha, bem como um atributo chamado ultimo,
//inicialmente valendo -1, com o propósito de indicar em que posição do vetor
//elemento se encontra guardado o último item guardado.
//         Escreva um construtor que, sem receber parâmetros, inicia a instância à qual se
//refere para que seja uma pilha vazia com capacidade de armazenar até 10 itens.
// Escreva outro construtor que, recebendo como parâmetro um número natural,
//que indicará a capacidade de armazenamento da pilha, inicia a instância à qual
//se refere para que seja uma pilha vazia com capacidade de armazenar uma
//quantidade de itens exatamente igual à recebida como parâmetro.
// Escreva um método de instância chamado guardeUmItem que, sem produzir
//retorno e recebendo um valor, promove a inclusão deste na pilha.
//         Escreva um método de instância chamado getUmItem que, sem receber
//parâmetros, recupere e retorne o último valor armazenado na pilha.

package org.example.Exercicios;

public class Pilha<X> {
    Object elem[];
    int ultimo = -1;

    public Pilha() {
        this.elem = new Object[10];
    }

    public Pilha(int n) throws Exception {
        if (n <= 0) {
            throw new Exception("Tamanho inválido");
        }
        this.elem = new Object[n];
    }

    public Pilha(Pilha<X> outro) {
        if (outro == null) {
            throw new IllegalArgumentException("Conjunto não pode ser nulo");
        }

        this.elem = new Object[outro.elem.length];
        this.ultimo = outro.ultimo;

        for (int i = 0; i < outro.elem.length - 1; i++) {
            if (outro.elem[i] instanceof Cloneable) {
                Clonador<X> clonador = new Clonador<X>();
                this.elem[i] = clonador.clone(outro.elem[i]);
            } else {
                this.elem[i] = outro.elem[i];
            }
        }
    }

    //Clonamos pois o objeto passado como parametro pode ser modificado fora da pilha
    public void guardeUmItem(X x) throws Exception {
        if (x == null) {
            throw new Exception("Item ausente");
        }

        // -1 pois o array comeca com 0 ate 9, portanto o ultimo elemento na verdade eh o 9 vector.length - 1
        while (true) {
            if (this.ultimo < this.elem.length - 1) {
                this.ultimo++;
            } else {
                break;
            }
        }

//        for (int i = 0; i < this.elem.length - 1; i++) {
//            this.ultimo = i;
//        }

        if (x instanceof Cloneable) {
            Clonador<X> clonador = new Clonador<X>();
            this.elem[this.ultimo] = clonador.clone(x);
        } else {
            this.elem[this.ultimo] = x;
        }
    }

    public X getUmItem() {
        for (int i = 0; i < this.elem.length - 1; i++) {
            if (i == this.ultimo) {
                if (this.elem[i] instanceof Cloneable) {
                    Clonador<X> clonador = new Clonador<X>();
                    return clonador.clone((this.elem[i]));
                } else {
                    return this.elem[i];
                }
            }
        }
        return null;
    }

    //Removemos o ultimo elemento da pilha
    //Poderiamos simplesmente verificar se this.ultimo > 0 indicando q existem elementos na lista, mas sla pensei aassim memo
    public void removaUmItem() {
        for (int i = 0; i < this.elem.length - 1; i++) {
            if (i == this.ultimo) {
                this.elem[i] = null;
                this.ultimo--;
            }
        }
    }

    //+1 pois estamos todo esse tempo trabalhando com o ultimo elemento, entao para pegar todos eh ultimo + 1
    public int getTamanho() {
        return this.ultimo + 1;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < this.elem.length - 1; i++) {
            s += this.elem[i] + " ";
        }
        return s;
    }

    @Override
    public int hashCode() {
        int ret = 666;
        for (int i = 0; i < this.elem.length - 1; i++) {
            ret = 13 * ret + this.elem[i].hashCode();
        }
        return ret;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;

        Pilha<X> p = (Pilha<X>) obj;

        if (this.ultimo != p.ultimo) return false;
        for (int i = 0; i < this.elem.length - 1; i++) {
            if (!this.elem[i].equals(p.elem[i])) return false;
        }
        return true;
    }

    @Override
    public Object clone() {
        Pilha<X> ret = null;
        try {
            ret = new Pilha<X>(this);
        } catch (Exception e) {}
        return ret;
    }
}























//
//public class Pilha <X> {
//    Object elem[];
//    int ultimo = -1;
//
//    public Pilha() {
//        this.elem = new Object[10];
//    }
//
//    public Pilha(int n) throws Exception {
//        if (n <= 0) {
//            throw new Exception("Tamanho inválido");
//        }
//
//        this.elem = new Object[n];
//    }
//
//    public void guardeUmItem(X x) throws Exception {
//        if (x == null) {
//            throw new Exception("Item ausente");
//        }
//        if (this.ultimo < this.elem.length) {
//            this.ultimo++;
//            if (x instanceof Cloneable) {
//                this.elem[this.ultimo] = (new Clonador<X>()).clone(x);
//            } else {
//                this.elem[this.ultimo] = x;
//            }
//        } else {
//            throw new Exception("Pilha cheia");
//        }
//    }
//
//    public X getUmItem() throws Exception {
//        if (this.ultimo >= 0) {
//            if (this.elem[this.ultimo] instanceof Cloneable) {
//                return (new Clonador<X>()).clone((X) this.elem[this.ultimo]);
//            } else {
//                return (X) this.elem[this.ultimo];
//            }
//        } else {
//            throw new Exception("Pilha vazia");
//        }
//    }
//
//    public void removaUmItem() throws Exception {
//        if (this.ultimo >= 0) {
//            this.elem[this.ultimo] = null;
//            this.ultimo--;
//        } else {
//            throw new Exception("Pilha vazia");
//        }
//    }
//
//    public int getTamanho() {
//        return this.ultimo + 1;
//    }
//
//    @Override
//    public String toString() {
//        String s = "";
//        for (int i = 0; i <= this.ultimo; i++) {
//            s += this.elem[i] + " ";
//        }
//        return s;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (obj == this) return true;
//        if (obj == null) return false;
//        if (obj.getClass() != this.getClass()) return false;
//        Pilha<X> p = (Pilha<X>) obj;
//        if (this.ultimo != p.ultimo) return false;
//        for (int i = 0; i <= this.ultimo; i++) {
//            if (!this.elem[i].equals(p.elem[i])) return false;
//        }
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int ret = 6;
//        ret = 13 * ret + ((Integer) this.ultimo).hashCode();
//        for (int i = 0; i <= this.ultimo; i++) {
//            ret = 13 * ret + this.elem[i].hashCode();
//        }
//        return ret;
//    }
//
//    public Pilha(Pilha<X> pilha) throws Exception {
//        if (pilha == null)
//            throw new Exception("Modelo ausente");
//
//        this.elem = new Object[pilha.elem.length];
//        this.ultimo = pilha.ultimo;
//
//        for (int i = 0; i <= this.ultimo; i++)
//            this.elem[i] = pilha.elem[i];
//    }
//
//    public Object clone() {
//        Pilha<X> ret = null;
//        try {
//            ret = new Pilha<X>(this);
//        } catch (Exception e) {
//        }
//
//        return ret;
//    }
//}
