package com.mycompany.filosofospensadores;

import Monitor_1.Monitor;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FilosofosPensadores {

    public static void main(String[] args) {
        
        Monitor Mon= new Monitor();
        
        Runnable tarea = () ->{
            try {
                while(true){
                    Mon.Pensar();

                    Mon.tomar();

                    Mon.comer();

                    Mon.dejar();
                }
                
            } catch (InterruptedException ex) {
                System.out.println("Filósofo fue interrumpido.");
            }
        };
        
        
        Thread Filo_1 = new Thread(tarea,"Filosofo_1");
        Thread Filo_2 = new Thread(tarea,"Filosofo_2");
        Thread Filo_3 = new Thread(tarea,"Filosofo_3");
        Thread Filo_4 = new Thread(tarea,"Filosofo_4");
        Thread Filo_5 = new Thread(tarea,"Filosofo_5");
        
        Filo_1.start();
        Filo_2.start();
        Filo_3.start();
        Filo_4.start();
        Filo_5.start();
        
    }
}
