// Suponha a existência uma classe Sensor que dispõe de (1) um construtor que,
// recebendo um inteiro que representa o número de seu identificador, inicia
// apropriadamente a instância à qual se refere; e (2) um método (de nome
// getVelocidade) sem parâmetros que retorna um real que indica a velocidade do
// objeto detectado (indicará sempre zero no caso de nada estar sendo detectado).
// Suponha a existência uma classe Camera que dispõe de (1) um construtor que,
// recebendo um inteiro que representa o número de seu identificador, inicia
// apropriadamente a instância à qual se refere; (2) uma função (de nome fotografe)
// que recebe um parâmetro real e sem retorno que, quando executada, faz com que a
// câmera bata uma foto na qual aparecerá no canto inferior direito o horário em que a
// foto foi batida (a câmera tem um relógio interno) e String que vem a esta função
// como parâmetro.
// Pede-se:
//         Derivada da classe Sensor e valendo-se da classe Camera, crie a classe Radar
// para representar um radar como estes que encontramos instalados nas principais
// ruas e avenidas das grandes cidades;
//  Implemente um construtor que recebe como parâmetro 2 números inteiros (um
//                                                                                 deles para o construtor de Sensor e o outro para o construtor de Camera) e um
// número real que representa a velocidade máxima da via na qual o radar vai ser
// instalado, iniciando apropriadamente a instância à qual se refere;
//  Implemente uma função de instância pública, chamada entreEmAcao, que
// coloca em operação de forma ininterrupta uma instância da classe Radar

public class Radar extends Sensor {
    private Camera c;
    private float vm;

    public Radar(int idS, int idC, float velMax) {
        super(idS);
        this.c = new Camera(idC);
        this.vm = velMax;
    }

    public void entreEmAcao() {
        while (true) {
//            float vel = this.getVelocidade();
            float vel = super.getVelocidade();

            if (vel > this.vm) {
                this.c.fotografe(vel);
            }
        }
    }
}

//public class Radar extends Sensor {
//    private Camera c = new Camera(idC);
//    private float vm;
//
//    public Radar (int idS, int idC, float velMax) {
//        super(idS);
//        this.vm=velmax;
//    }
//
//    public void entreEmAcao() {
//        while(true) {
//            float vel = super.getVelocidade();
////            float vel=this.getVelocidade();
//
//            if (vel>this.vm)
//                this.c.fotografe(vel);
//        }
//    }
//}
