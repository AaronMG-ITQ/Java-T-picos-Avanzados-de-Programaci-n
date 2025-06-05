package com.mycompany.fabricacigarrillos;

import Cerrojo.Cerrojo_1;
import Grafico.Fumando;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FabricaCigarrillos {

    public static void main(String[] args) {
        
        Cerrojo_1 ms = new Cerrojo_1();
        Fumando ls_2 = new Fumando();
        
        ls_2.setVisible(true);
        

        Runnable agente =() ->{
            boolean a = false;
            while(true){
                while(true){
                    ms.cerrojo.lock();
                    a=true;
                    try {
                        while(ms.cerillas_ns || ms.papel_ns || ms.tabaco_ns){
                            ms.hayIngredientes.await();
                        }


                        ms.Ingredientes();
                        ms.hayIngredientes.signalAll();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(FabricaCigarrillos.class.getName()).log(Level.SEVERE, null, ex);
                    }finally{
                        if(a){
                            ms.cerrojo.unlock();
                        }
                    }
                }
            }
        };
        
        Runnable fumadores_c =() ->{
            boolean b = false;
            while(true){
                
                try {
                ms.cerrojo.lock();
                b= true;
                    while(!ms.tabaco_ns && !ms.papel_ns){
                        ms.hayIngredientes.await();
                    }
                    ms.recoger();
                    ms.hayIngredientes.signalAll();

                } catch (InterruptedException ex) {
                    Logger.getLogger(FabricaCigarrillos.class.getName()).log(Level.SEVERE, null, ex);
                }finally{
                    if(b){
                        ms.cerrojo.unlock();
                    }
                }
                
            }
        };
        
        Runnable fumadores_t =() ->{
            boolean b = false;
            while(true){
                
                try {
                ms.cerrojo.lock();
                b= true;
                    while(!ms.papel_ns && !ms.cerillas_ns){
                        ms.hayIngredientes.await();
                    }
                    ms.recoger();
                    ms.hayIngredientes.signalAll();

                } catch (InterruptedException ex) {
                    Logger.getLogger(FabricaCigarrillos.class.getName()).log(Level.SEVERE, null, ex);
                }finally{
                    if(b){
                        ms.cerrojo.unlock();
                    }
                }
                
            }
        };
        
        Runnable fumadores_p =() ->{
            boolean b = false;
            while(true){
                
                try {
                ms.cerrojo.lock();
                b= true;
                    while(!ms.cerillas_ns && !ms.tabaco_ns){
                        ms.hayIngredientes.await();
                    }
                    ms.recoger();
                    ms.hayIngredientes.signalAll();

                } catch (InterruptedException ex) {
                    Logger.getLogger(FabricaCigarrillos.class.getName()).log(Level.SEVERE, null, ex);
                }finally{
                    if(b){
                        ms.cerrojo.unlock();
                    }
                }
                
            }
        };
        
        Thread Cerillos = new Thread(fumadores_c, "Carmen");
        Thread MariAna = new Thread(fumadores_t, "Tailer");
        Thread Papel = new Thread(fumadores_p, "Pablo");
        
        Thread Proveedor = new Thread(agente);
        
        Proveedor.start();
        Cerillos.start();
        MariAna.start();
        Papel.start();

    }
}
