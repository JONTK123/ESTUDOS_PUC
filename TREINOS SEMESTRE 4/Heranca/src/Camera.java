// Representa uma câmera que pode tirar fotos e registrar informações
public class Camera {
    private int id; // Identificador da câmera

    // Construtor: inicializa o identificador da câmera
    public Camera(int id) {
        this.id = id;
    }

    // Método que tira uma foto com a velocidade informada
    // O horário em que a foto foi tirada será simulado
    public void fotografe(float velocidade) {
        // Simula o horário atual usando a biblioteca java.time
        String horario = java.time.LocalTime.now().toString();

        // Simula a captura de uma foto, exibindo a velocidade e o horário
        System.out.println("Foto batida com velocidade: " + velocidade + " km/h às " + horario);
    }
}
