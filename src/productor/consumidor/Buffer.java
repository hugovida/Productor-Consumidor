/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productor.consumidor;

/**
 *
 * @author usuario
 */
public class Buffer {
    private int[] datos;
    private int capacidad;
    private int contador;
    private int inicio;
    private int fin;

    public Buffer(int capacidad) {
        this.capacidad = capacidad;
        datos = new int[capacidad];
        contador = 0;
        inicio = 0;
        fin = 0;
    }

    public synchronized void insertar(int dato) {
        while (contador == capacidad) {
            try {
                System.out.println("Buffer lleno. El productor espera.");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        datos[fin] = dato;
        fin = (fin + 1) % capacidad;
        contador++;

        System.out.println("Productor inserta: " + dato);
        notify();
    }

    public synchronized int extraer() {
        while (contador == 0) {
            try {
                System.out.println("Buffer vacío. El consumidor espera.");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int dato = datos[inicio];
        inicio = (inicio + 1) % capacidad;
        contador--;

        System.out.println("Consumidor extrae: " + dato);
        notify();
        
        return dato;
    }
}


