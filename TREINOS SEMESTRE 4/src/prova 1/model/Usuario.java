package prova1.model;


//Quando fazemos interfaces, todos os métodos são abstratos e públicos, mas isso esta implicito
//Aqui apenas declaramos os metodos ou constantes para que as classes que implementarem essa interface possam modifica-la como quiserem
public interface Usuario {

    String getLogin();
    //OU public abstract String getLogin();

    void setLogin(String login);

    String getSenha();
    void setSenha(String senha);
}