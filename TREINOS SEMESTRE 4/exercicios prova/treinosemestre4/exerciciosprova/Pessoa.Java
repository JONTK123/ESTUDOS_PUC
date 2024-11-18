// Crie uma classe chamada Pessoa que representa uma pessoa com os seguintes atributos:
// nome (String): Deve conter entre 2 e 50 caracteres, sem números ou caracteres especiais.
// cpf (String): Deve seguir o formato "XXX.XXX.XXX-XX" (ex: "123.456.789-10").
// horarioNascimento (classe Horario): Representa a hora de nascimento da pessoa.
// Alem disso, implemente os metodos que achar necessario, com seus metodos, validacoes e tratamento de excecoes necessarios.

import Horario.java;

public class Pessoa implements Comparable<Pessoa>, Cloneable {
    private String nome;
    private String cpf;
    private Horario horarioNascimento;

    public static boolean isValida(String nome, String cpf, Horario horarioNascimento) { //Static pois quem chama nao eh uma instancia e sim a propria classe
        if(nome.length() < 2 || nome.length() > 50) { return false; }
        if(cpf.length() != 14) { return false; }
        if(!cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) { return false; }
        if(horarioNascimento == null) { return false; }

        return true;
    }

    public Pessoa(String nome, String cpf, Horario horarioNascimento) throws Exception {
        if(!Pessoa.isValida(nome, cpf, horarioNascimento)) { throw new Exception ("xixi coco");}

        this.nome = nome;
        this.cpf = cpf;
        this.horarioNascimento = (Horario) horarioNascimento.clone(); //Criando uma nova instancia de horario utilizando o metodo clone dela
         //this.horarioNascimento = new Horario(horarioNascimento); 
    }

    public String getNome() {
        return this.nome; //Nao precisa de this.nome.clone() pois String eh uma classe Wrapper e ela eh uma especial que permite o Unboxing e Boxing
    }

    public String getCpf() {
        return this.cpf;
    }

    public Horario getHorarioNascimento() { //Retorno pode ser String ou Classe mas independente usar clone para nao alterar o original
        return (Horario) this.horarioNascimento.clone();
    }

    public void setNome(String nome) throws Exception {
        if(!Pessoa.isValida(nome, this.cpf, this.horarioNascimento)) {throw new Exception ("xixi coco");}

        this.nome = nome; //Nao existe necessidade de new String(nome) pois as classes Wrappers sao especiais, permitem o Unboxing e Boxing
    }

    public void setCpf(String cpf) throws Exception {
        if(!Pessoa.isValida(this.nome, cpf, this.horarioNascimento)) {throw new Exception ("xixi coco");}

        this.cpf = cpf;
    }

    public void setHorarioNascimento(Horario horarioNascimento) throws Exception { //Aceita uma nova instancia de horario e retorna uma nova instancia de horario para nao alterar o original
        if(!Pessoa.isValida(this.nome, this.cpf, horarioNascimento)) {throw new Exception ("xixi coco");}

        this.horarioNascimento = new Horario(horarioNascimento);
    }

    @Override
    public String toString() { //Chamar o toString do horarioNascimento
        return( "Nome: " + this.nome + 
                "/nCPF: " + this.cpf +
                "/nHorario de Nascimento: " + this.horarioNascimento.toString());
    }

    @Override
    public int hashCode() { //Os atributos aqui sao de outras classes e por isso possui seus metodos hashCode definidos
        int ret = 1;

        ret = ret * 2 + this.nome.hashCode();
        ret = ret * 2 + this.cpf.hashCode();
        ret = ret * 2 + this.horarioNascimento.hashCode();

        return ret;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {return true;} //Instancia = logo atributos =
        if(obj == null) {return false;} //Instancia inexistente logo atributos !=
        if(this.getClass() != obj.getClass()) {return false;} //Instancias de classes diferentes logo atributos !=

        Pessoa p = (Pessoa) obj;

        if(this.nome != p.nome) {return false;}
        if(this.cpf != p.cpf) {return false;}
        if(this.horarioNascimento != p.horarioNascimento) {return false;}

        return true;
    }

    @Override
    public int compareTo(Pessoa p){ //Usar o metodo compareTo para tipos de outras classes. String excessao pois unico tipo Wrapper que nao existe unboxed
        if(this.nome.compareTo(p.nome) > 0) {return 1;}
        if(this.nome.compareTo(p.nome) < 0) {return -1;}

        if(this.cpf.compareTo(p.cpf) > 0) {return 1;}
        if(this.cpf.compareTo(p.cpf) < 0) {return -1;}

        if(this.horarioNascimento.compareTo(p.horarioNascimento) > 0) {return 1;}
        if(this.horarioNascimento.compareTo(p.horarioNascimento) < 0) {return -1;}
        return 0;
    }

    public Pessoa(Pessoa p) throws Exception {
        if (!Pessoa.isValida(p.nome, p.cpf, p.horarioNascimento)) {throw new Exception ("xixi coco");}

        this.nome = p.nome;
        this.cpf = p.cpf;
        this.horarioNascimento = (Horario) p.horarioNascimento.clone(); //Criando uma nova instancia de horario utilizando o metodo clone dela
        //this.horarioNascimento = new Horario(p.horarioNascimento);
    }

    @Override
    public Object clone() {
        Pessoa ret = null;

        try {
            ret = new Pessoa(this);
        } catch (Exception e) {}
    
    return ret;
    }

    public static void main (String[] args) {
        try {
            Horario h1 = new Horario(1,1,1);
            Pessoa p1 = new Pessoa("Nome", "123.456.789-10", h1);

            System.out.println(p1.toString());

            System.out.println(p1.getNome());
            System.out.println(p1.getCpf());
            System.out.println(p1.getHorarioNascimento());

            p1.setNome("Nome2");
            p1.setCpf("123.456.789-11");

            Horario h2 = new Horario(2,2,2);
            p1.setHorarioNascimento(h2);

            System.out.println(p1.toString());

            Pessoa p2 = new Pessoa("Nome2", "123.456.789-11", h2);
            
            System.out.println(p1.equals(p2));
            System.out.println(p1.compareTo(p2));

            Pessoa p3 = (Pessoa) p1.clone();
            
        } catch (Exception e) {}
    }
}