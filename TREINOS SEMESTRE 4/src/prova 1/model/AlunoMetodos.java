package prova1.model;

//Uma classe abstrata funciona como mistura entre interface e uma classe comum (pai, super)
//Aqui podemos colocar metodos abstratos e metodos comuns
//Obrigatorio utilizar os metodos e atributos desenvolvidos aqui na classe que herdar essa classe
//Nao existe polimorfismo aqui
public abstract class AlunoMetodos {
    //Essa classe tera parametros mas sera desenvolvida apenas na classe Aluno
    protected String adicionarAluno();
    protected String removerAluno();
}