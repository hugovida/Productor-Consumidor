/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productor.consumidor;

import java.util.Random;

/**
 *
 * @author usuario
 */
public class Consumidor implements Runnable {
    private Buffer buffer;
    private Random random;

    public Consumidor(Buffer buffer) {
        this.buffer = buffer;
        random = new Random();
    }

    @Override
    public void run() {
        for (int i = 1; i <= 30; i++) {
            try {
                Thread.sleep(random.nextInt(2000)); // Espera entre 0 y 2 segundos
                int dato = buffer.extraer();
                // Puedes hacer lo que quieras con el dato extraído aquí
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}
