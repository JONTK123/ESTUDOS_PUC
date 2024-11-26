package org.example.Heranca_Interface_Generico_Abstract_Polimorfismo;

import java.util.Arrays;

public class Conjunto<X> implements Cloneable {
    //private X[] elem; // Array de elementos genéricos //Formato nao recomendado pois nao eh possivel instanciar um array de um tipo generico
    private Object elem[]; // Array de elementos genéricos //Formato recomendado
    private int qtd;  // Quantidade de elementos armazenados

    // Construtor padrão
    public Conjunto() {
        //this.elem = (X[]) new Object[10]; // Formato nao recomendado pois precisa de um cast estranho
        this.elem = new Object[10]; // Formato recomendado
        this.qtd = 0;
    }

    // Construtor com capacidade inicial
    public Conjunto(int capacidadeInicial) {
        if (capacidadeInicial <= 0) {
            throw new IllegalArgumentException("Capacidade inicial deve ser maior que zero");
        }
        //this.elem = (X[]) new Object[capacidadeInicial]; // Formato nao recomendado
        this.elem = new Object[capacidadeInicial];
        this.qtd = 0;
    }

    // Construtor de cópia
    //Inicializamos o array de elementos com o tamanho do array de elementos do conjunto passado como parametro
    //E copiamos os elementos do conjunto passado como parametro para o array de elementos do novo conjunto
    //(X[]) new Object[outro.elem.length] - Inicializa o array de elementos do novo conjunto com o tamanho do array de elementos do conjunto passado como parametro
    public Conjunto(Conjunto<X> outro) throws Exception {
        if (outro == null) {
            throw new IllegalArgumentException("Conjunto não pode ser nulo");
        }

        this.qtd = outro.qtd;
        //this.elem = (X[]) new Object[outro.elem.length];
        this.elem = new Object[outro.elem.length];

        for (int i = 0; i < outro.qtd; i++) {
            if (outro.elem[i] instanceof Cloneable) {
                Clonador<X> clonador = new Clonador<>();
                this.elem[i] = clonador.clone((X) outro.elem[i]);
            } else {
                this.elem[i] = outro.elem[i];
            }
        }
    }

    // Adiciona um elemento ao conjunto
    //Clonando o elemento antes de adicionar ao conjunto, para ter um novo endereco
    public void inclua(X x) throws Exception {
        if (x == null) {
            throw new Exception("Elemento ausente");
        }

        Object[] onde = this.ondeEsta(x);
        boolean achou = (Boolean) onde[0];
        int posicao = (Integer) onde[1];

        if (achou) {
            throw new Exception("Elemento repetido");
        }

        if (this.qtd == this.elem.length) {
            this.redimensioneSe(2 * this.elem.length);
        }

        for (int i = this.qtd - 1; i >= posicao; i--) {
            this.elem[i + 1] = this.elem[i];
        }

        if (x instanceof Cloneable) {
            Clonador<X> clonador = new Clonador<>();
            this.elem[posicao] = clonador.clone(x);
        } else {
            this.elem[posicao] = x;
        }

        this.qtd++;
    }

    // Remove um elemento do conjunto
    public void remova(X x) throws Exception {
        if (x == null) {
            throw new Exception("Elemento ausente");
        }

        Object[] onde = this.ondeEsta(x);
        boolean achou = (Boolean) onde[0];
        int posicao = (Integer) onde[1];

        if (!achou) {
            throw new Exception("Elemento não encontrado");
        }

        for (int i = posicao; i < this.qtd - 1; i++) {
            this.elem[i] = this.elem[i + 1];
        }

        this.elem[this.qtd - 1] = null; // Remove referência
        this.qtd--;
    }

    // Retorna um elemento pelo índice
    // Clonando o elemento antes de retornar, para ter um novo endereco
    public X getElemento(int posicao) throws Exception {
        if (posicao < 0 || posicao >= this.qtd) {
            throw new Exception("Posição inválida");
        }

        if (this.elem[posicao] instanceof Cloneable) {
            Clonador<X> clonador = new Clonador<>();
            return clonador.clone((X) this.elem[posicao]);
        } else {
            return (X) this.elem[posicao];
        }
    }

    // Retorna um array com os elementos do conjunto
    // Clonando os elementos antes de retornar, para ter um novo endereco
    @SuppressWarnings("unchecked")
    public X[] getElem() {
        X[] clonedArray = (X[]) new Object[this.qtd];
        for (int i = 0; i < this.qtd; i++) {
            if (this.elem[i] instanceof Cloneable) {
                Clonador<X> clonador = new Clonador<>();
                clonedArray[i] = clonador.clone((X) this.elem[i]);
            } else {
                clonedArray[i] = (X) this.elem[i];
            }
        }
        return clonedArray;
    }

    // Retorna o tamanho do conjunto
    public int tamanho() {
        return this.qtd;
    }

    // Verifica se o conjunto está vazio
    public boolean vazio() {
        return this.qtd == 0;
    }

    // Redimensiona o array interno
    private void redimensioneSe(int novaCapacidade) {
        this.elem = Arrays.copyOf(this.elem, novaCapacidade);
    }

    // Encontra a posição de um elemento e se ele está no conjunto
    private Object[] ondeEsta(X x) {
        for (int i = 0; i < this.qtd; i++) {
            if (this.elem[i].equals(x)) {
                return new Object[]{true, i};
            }
        }

        return new Object[]{false, this.qtd};
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Conjunto{");
        for (int i = 0; i < this.qtd; i++) {
            sb.append(this.elem[i]);
            if (i < this.qtd - 1) {
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int ret = 666;
        ret = ret * 7 + Arrays.hashCode(this.elem);
        ret = ret * 7 + Integer.hashCode(this.qtd);

        return ret;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;

        Conjunto<X> outro = (Conjunto<X>) obj;

        if (this.qtd != outro.qtd) return false;
        for (int i = 0; i < this.qtd; i++) {
            if (!this.elem[i].equals(outro.elem[i])) {
                return false;
            }
        }

        return true;
    }

    @Override
    public Object clone() {
        Conjunto<X> ret = null;
        try {
            ret = new Conjunto<>(this); // Construtor de cópia
        } catch (Exception e) {}

        return ret;
    }
}