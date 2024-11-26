package org.example.Conteudo_Prova1;

//Exemplo de uma classe contendo todo conteudo da prova 1 ( tirando GUI, regex, classe teclado )
//Quando implementar cada metodo Obrigatorio
public class Pessoa implements Comparable<Pessoa>, Cloneable {
    private String nome;
    private String cpf;
    private Horario horarioNascimento;

    public static boolean isValida(String nome, String cpf, Horario horarioNascimento) {
        if (nome.length() < 2 || nome.length() > 50) {
            return false;
        }
        if (cpf.length() != 14) {
            return false;
        }
        if (!cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
            return false;
        }
        if (horarioNascimento == null) {
            return false;
        }
        return true;
    }

    public Pessoa(String nome, String cpf, Horario horarioNascimento) throws Exception {
        if (!Pessoa.isValida(nome, cpf, horarioNascimento)) {
            throw new Exception("Dados inválidos");
        }
        this.nome = nome;
        this.cpf = cpf;
        this.horarioNascimento = (Horario) horarioNascimento.clone();
    }

    public String getNome() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public Horario getHorarioNascimento() {
        return (Horario) this.horarioNascimento.clone();
    }

    public void setNome(String nome) throws Exception {
        if (!Pessoa.isValida(nome, this.cpf, this.horarioNascimento)) {
            throw new Exception("Dados inválidos");
        }
        this.nome = nome;
    }

    public void setCpf(String cpf) throws Exception {
        if (!Pessoa.isValida(this.nome, cpf, this.horarioNascimento)) {
            throw new Exception("Dados inválidos");
        }
        this.cpf = cpf;
    }

    public void setHorarioNascimento(Horario horarioNascimento) throws Exception {
        if (!Pessoa.isValida(this.nome, this.cpf, horarioNascimento)) {
            throw new Exception("Dados inválidos");
        }
        this.horarioNascimento = (Horario) horarioNascimento.clone();
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome +
                "\nCPF: " + this.cpf +
                "\nHorario de Nascimento: " + this.horarioNascimento.toString();
    }

    @Override
    public int hashCode() {
        int ret = 1;
        ret = ret * 2 + this.nome.hashCode();
        ret = ret * 2 + this.cpf.hashCode();
        ret = ret * 2 + this.horarioNascimento.hashCode();
        return ret;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Pessoa p = (Pessoa) obj;
        if (!this.nome.equals(p.nome)) {
            return false;
        }
        if (!this.cpf.equals(p.cpf)) {
            return false;
        }
        return this.horarioNascimento.equals(p.horarioNascimento);
    }

    @Override
    public int compareTo(Pessoa p) {
        int nomeCompare = this.nome.compareTo(p.nome);
        if (nomeCompare != 0) {
            return nomeCompare;
        }
        int cpfCompare = this.cpf.compareTo(p.cpf);
        if (cpfCompare != 0) {
            return cpfCompare;
        }
        return this.horarioNascimento.compareTo(p.horarioNascimento);
    }

    /**
     * Constructs a new Pessoa as a copy of the specified person.
     *
     * @param p the person to copy
     * @throws Exception if the given person is not valid
     */
    public Pessoa(Pessoa p) throws Exception {
        if (!Pessoa.isValida(p.nome, p.cpf, p.horarioNascimento)) {
            throw new Exception("Dados inválidos");
        }
        this.nome = p.nome;
        this.cpf = p.cpf;
        this.horarioNascimento = (Horario) p.horarioNascimento.clone();
    }

    /**
     * Creates and returns a copy of this person.
     *
     * @return a clone of this person
     */
    @Override
    public Object clone() {
        Pessoa ret = null;
        try {
            ret = new Pessoa(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    public static void main(String[] args) {
        try {
            Horario h1 = new Horario((byte) 1, (byte) 1, (byte) 1);
            Pessoa p1 = new Pessoa("Nome", "123.456.789-10", h1);

            System.out.println(p1.toString());

            System.out.println(p1.getNome());
            System.out.println(p1.getCpf());
            System.out.println(p1.getHorarioNascimento());

            p1.setNome("Nome2");
            p1.setCpf("123.456.789-11");

            Horario h2 = new Horario((byte) 2, (byte) 2, (byte) 2);
            p1.setHorarioNascimento(h2);

            System.out.println(p1.toString());

            Pessoa p2 = new Pessoa("Nome2", "123.456.789-11", h2);

            System.out.println(p1.equals(p2));
            System.out.println(p1.compareTo(p2));

            Pessoa p3 = (Pessoa) p1.clone();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}