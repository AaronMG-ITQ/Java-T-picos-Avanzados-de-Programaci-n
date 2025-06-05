package com.mycompany.controldetrafico;

import SemaforoCV.Monitor_CV;
import static java.lang.Math.random;
import static java.lang.StrictMath.random;
import java.util.concurrent.ThreadLocalRandom;

public class ControlDeTrafico {
    public static void main(String[] args) {
        boolean a = true;
        int maximo = 1500;
        int minimo = 2500;
        int n = ThreadLocalRandom.current().nextInt(maximo, minimo);
        String[] direcciones = {"Sur-Norte", "Oeste-Este", "Norte-Sur", "Este-Oeste"};
        
        Monitor_CV as = new Monitor_CV();
        
        Runnable CambiosLuz = () -> {
            try{
                //while(true){
                    as.CambioDeLuz();

                    //Thread.sleep(5000);
                //}
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        };
        
        Thread L = new Thread(CambiosLuz, "Lapapa");
        L.start();
        
        for(int i=0; i<30; i++){
            final String direccion = direcciones[i % direcciones.length];
            
            Thread s = new Thread(()-> {
                try{
                    //Thread.sleep(n);
                    as.semaforo(direccion);
                }catch(InterruptedException e){
                    Thread.currentThread().interrupt();
                }
                
                });
            s.setName("Carro-" + i);
            s.start();

        }
 
        
        
    }
}
