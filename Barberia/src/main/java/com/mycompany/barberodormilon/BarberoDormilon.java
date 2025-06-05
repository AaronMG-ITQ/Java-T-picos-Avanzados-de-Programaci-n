
package com.mycompany.barberodormilon;

import BarberiaLogica.Barbero;

public class BarberoDormilon {

    public static void main(String[] args) {
        
        Barbero bar = new Barbero();
        
        Runnable chamba =() ->{
            try{
                bar.BarberoCorta();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        };
        
        Runnable corte =() ->{
            try{
                
                bar.ClienteEspera();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        };
        
        Thread Barbero = new Thread (chamba, "Yian");
        
        
        for(int i=0; i<50; i++){
            Thread t = new Thread(corte);
            t.setName("Cliente-" + i);
            t.start();
        }
        

        
        
        Barbero.start();
        
     
    }
}
