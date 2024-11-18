// Representa um sensor que detecta objetos e mede sua velocidade
public class Sensor {
    private int id; // Identificador do sensor

    // Construtor: inicializa o identificador do sensor
    public Sensor(int id) {
        this.id = id;
    }

    // Método que retorna a velocidade do objeto detectado (0.0 caso nada seja detectado)
    public float getVelocidade() {
        // Implementação fictícia, retornando 0.0 como padrão
        return 0.0f;
    }
}
