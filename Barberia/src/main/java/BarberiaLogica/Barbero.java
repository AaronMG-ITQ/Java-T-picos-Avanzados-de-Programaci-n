
package BarberiaLogica;

import Grafico.Barberia_Grafico;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;



public class Barbero {

    Semaphore barber = new Semaphore(0);
    Semaphore customer = new Semaphore(0);
    Semaphore mutex = new Semaphore(1);
    int wating = 0;
    Barberia_Grafico graf = new Barberia_Grafico();
    
     public void Corte() throws InterruptedException{
        String id = Thread.currentThread().getName();
        int s = ThreadLocalRandom.current().nextInt(5000, 10000);
        graf.Sillla.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/BarberiaD/BarberoDormilon/src/Chambear.jpg"));
        
        System.out.println("Barbero está cortando el pelo");
        Thread.sleep(s);
        System.out.println("Barbero terminó de cortar el pelo");
    
    }
     
    public void BarberoCorta() throws InterruptedException{
        while(true){
            if(wating == 0){
                System.out.println("El barbero esta durmiendo");
                graf.Sillla.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/BarberiaD/BarberoDormilon/src/Durmiente.jpg"));
                graf.Entrada.setIcon(null);
                mutex.release();
                barber.acquire();
                mutex.acquire();
            }else{
                if(wating > 0){
                    ActualizarSillasLibres();
                    wating--;
                    mutex.release();
                    
                    Corte();
                }else{
                    mutex.release();
                }
                
            }

        }
    }
    
    public void ClienteEspera() throws InterruptedException{
        graf.setVisible(true);
        String id  = Thread.currentThread().getName();
        int ns = ThreadLocalRandom.current().nextInt(15000,50000);
        Thread.sleep(ns);
        
        System.out.println("El " + id + " Llega a la barberia");
        Thread.sleep(3000);
        mutex.acquire();
        if(wating < 4){
            wating++;
            System.out.println("El " + id + "Esta sentado esperando");
            ActualizarSillasClientes();
            {/**if(wating == 1){
                graf.Silla_1.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/BarberiaD/BarberoDormilon/src/Cliente.jpg"));
                graf.Entrada.setIcon(null);
            }else if(wating == 2){
                graf.Silla_2.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/BarberiaD/BarberoDormilon/src/Cliente.jpg"));
                graf.Entrada.setIcon(null);
            }else if(wating == 3){
                graf.Silla_3.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/BarberiaD/BarberoDormilon/src/Cliente.jpg"));
                graf.Entrada.setIcon(null);
            }else if(wating == 4){
                graf.Silla_4.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/BarberiaD/BarberoDormilon/src/Cliente.jpg"));
                graf.Entrada.setIcon(null);
            }**/}
            barber.release();
            mutex.release();
            
            customer.acquire();
            System.out.println(id + "Esta en la silla del barbero");
            
        }else{
            System.out.println("No hay espacio y se fue");
            graf.Entrada.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/BarberiaD/BarberoDormilon/src/MV.jpeg"));
            Thread.sleep(1000);
            graf.Entrada.setIcon(null);
            mutex.release();
        }
        
    }
    
    private void ActualizarSillasClientes() throws InterruptedException{
        graf.Entrada.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/BarberiaD/BarberoDormilon/src/Melenudo.jpg"));
        if(wating == 1){
            Thread.sleep(1000);
            graf.Silla_4.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/BarberiaD/BarberoDormilon/src/Cliente.jpg"));
            graf.Entrada.setIcon(null);
        }
        if(wating == 2){
            Thread.sleep(1000);
            graf.Silla_3.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/BarberiaD/BarberoDormilon/src/Cliente.jpg"));
            graf.Entrada.setIcon(null);
        }
        if(wating == 3){
            Thread.sleep(1000);
            graf.Silla_2.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/BarberiaD/BarberoDormilon/src/Cliente.jpg"));
            graf.Entrada.setIcon(null);
        }
        if(wating == 4){
            Thread.sleep(1000);
            graf.Silla_1.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/BarberiaD/BarberoDormilon/src/Cliente.jpg"));
            graf.Entrada.setIcon(null);
        
        }
    }
    
    private void ActualizarSillasLibres(){
        if(wating == 4)graf.Silla_1.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/BarberiaD/BarberoDormilon/src/Sit.png"));
        if(wating == 3)graf.Silla_2.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/BarberiaD/BarberoDormilon/src/Sit.png"));
        if(wating == 2)graf.Silla_3.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/BarberiaD/BarberoDormilon/src/Sit.png"));
        if(wating == 1)graf.Silla_4.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/BarberiaD/BarberoDormilon/src/Sit.png"));
    }

}
