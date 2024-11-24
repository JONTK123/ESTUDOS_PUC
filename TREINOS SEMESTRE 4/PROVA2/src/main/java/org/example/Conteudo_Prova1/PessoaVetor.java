package org.example.Conteudo_Prova1;

public class PessoaVetor implements Cloneable {
    private Pessoa[] vetor;
    private int ultimo = -1;

    // Método isValida para validar os dados do vetor de pessoas
    public static boolean isValida(Pessoa[] vetor) {
        if (vetor == null || vetor.length == 0) {
            return false;
        }
        for (Pessoa p : vetor) {
            if (p == null) {
                return false;
            }
        }
        return true;
    }

    // Construtor da classe PessoaVetor
    public PessoaVetor(Pessoa[] vetor) throws Exception {
        if (!PessoaVetor.isValida(vetor)) {
            throw new Exception("Dados inválidos");
        }
        this.vetor = new Pessoa[vetor.length];
        for (int i = 0; i < vetor.length; i++) {
            this.vetor[i] = (Pessoa) vetor[i].clone(); // Clonando cada pessoa do vetor
        }
        this.ultimo = vetor.length - 1;
    }

    // Construtor de cópia
    public PessoaVetor(PessoaVetor original) throws Exception {
        if (original == null || !PessoaVetor.isValida(original.vetor)) {
            throw new Exception("Dados inválidos");
        }
        this.vetor = new Pessoa[original.vetor.length];
        for (int i = 0; i < original.vetor.length; i++) {
            this.vetor[i] = (Pessoa) original.vetor[i].clone(); // Clonando cada pessoa do vetor original
        }
        this.ultimo = original.ultimo;
    }

    // Método para adicionar uma pessoa
    public void adicionarPessoa(Pessoa pessoa) throws Exception {
        if (pessoa == null) {
            throw new Exception("Pessoa ausente");
        }
        if (this.ultimo < this.vetor.length - 1) {
            this.ultimo++;
            this.vetor[this.ultimo] = (Pessoa) pessoa.clone();
        } else {
            throw new Exception("Vetor cheio");
        }
    }

    // Método para obter uma pessoa baseada na posição
    public Pessoa getUmaPessoa(int posicao) throws Exception {
        if (posicao < 0 || posicao > this.ultimo) {
            throw new Exception("Posição inválida");
        }
        return (Pessoa) this.vetor[posicao].clone();
    }

    // Getter para o vetor
    public Pessoa[] getVetor() {
        Pessoa[] clone = new Pessoa[this.vetor.length];
        for (int i = 0; i < this.vetor.length; i++) {
            clone[i] = (Pessoa) this.vetor[i].clone(); // Clonando para não expor a referência direta
        }
        return clone;
    }

    // Método equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        PessoaVetor pv = (PessoaVetor) obj;
        if (this.vetor.length != pv.vetor.length) {
            return false;
        }
        for (int i = 0; i < this.vetor.length; i++) {
            if (!this.vetor[i].equals(pv.vetor[i])) {
                return false;
            }
        }
        return true;
    }

    // Método hashCode
    @Override
    public int hashCode() {
        int ret = 1;
        for (Pessoa p : this.vetor) {
            ret = ret * 2 + p.hashCode();
        }
        return ret;
    }

    // Método compareTo
    public int compareTo(PessoaVetor pv) {
        int minLength = Math.min(this.vetor.length, pv.vetor.length);
        for (int i = 0; i < minLength; i++) {
            int compare = this.vetor[i].compareTo(pv.vetor[i]);
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(this.vetor.length, pv.vetor.length); // Se um vetor for maior, retorna o comparativo
    }

    // Método toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vetor de Pessoas:\n");
        for (Pessoa p : this.vetor) {
            sb.append(p.toString()).append("\n");
        }
        return sb.toString();
    }

    // Método clone
    @Override
    public Object clone() {
        PessoaVetor ret = null;
        try {
            ret = new PessoaVetor(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    // Método main para teste
    public static void main(String[] args) {
        try {
            // Criando pessoas para testar o vetor
            Horario h1 = new Horario((byte) 1, (byte) 1, (byte) 1);
            Pessoa p1 = new Pessoa("Nome1", "123.456.789-10", h1);
            Pessoa p2 = new Pessoa("Nome2", "123.456.789-11", h1);

            // Criando vetor de pessoas
            Pessoa[] vetorPessoas = {p1, p2};
            PessoaVetor pessoaVetor = new PessoaVetor(vetorPessoas);

            System.out.println(pessoaVetor.toString()); // Exibe o vetor de pessoas

            // Adicionando uma pessoa
            Pessoa p3 = new Pessoa("Nome3", "123.456.789-12", h1);
            pessoaVetor.adicionarPessoa(p3);
            System.out.println("Após adicionar uma pessoa:\n" + pessoaVetor.toString());

            // Obtendo uma pessoa pela posição
            Pessoa pessoaObtida = pessoaVetor.getUmaPessoa(1);
            System.out.println("Pessoa obtida na posição 1: " + pessoaObtida);

            // Clonando o vetor
            PessoaVetor cloneVetor = (PessoaVetor) pessoaVetor.clone();
            System.out.println("Vetor clonado:\n" + cloneVetor.toString());

            // Comparando
            System.out.println("Igualdade entre os vetores: " + pessoaVetor.equals(cloneVetor));
            System.out.println("Comparação entre os vetores: " + pessoaVetor.compareTo(cloneVetor));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}