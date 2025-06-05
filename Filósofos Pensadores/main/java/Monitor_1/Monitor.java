
package Monitor_1;

import Graficos64Bits.Reprecentacion;
import java.awt.Color;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Monitor {
    private int contador=0;
    Reprecentacion aa = new Reprecentacion();
    
    
    private boolean Tenedor_1= false;
    private boolean Tenedor_2= false;
    private boolean Tenedor_3= false;
    private boolean Tenedor_4= false;
    private boolean Tenedor_5= false;

    
    
    public void Pensar() throws InterruptedException{
        aa.setVisible(true);
        
        int maximo = 10000;
        int minimo = 30000;
        int n = ThreadLocalRandom.current().nextInt(maximo, minimo);
        String Nombre = Thread.currentThread().getName();
        System.out.println("El filosofo " + Nombre + "esta pensando");
        System.out.println(n);
        

        try{
                if(Thread.currentThread().getName()=="Filosofo_1"){
                aa.Filo_1.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/Filosofos/FilosofosPensadores/src/imagenes/pen.jpg"));
            }else if(Thread.currentThread().getName()=="Filosofo_2"){
                aa.Filo_2.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/Filosofos/FilosofosPensadores/src/imagenes/pen.jpg"));
            }else if(Thread.currentThread().getName()=="Filosofo_3"){
                aa.Filo_3.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/Filosofos/FilosofosPensadores/src/imagenes/pen.jpg"));
            }else if(Thread.currentThread().getName()=="Filosofo_4"){
                aa.Filo_4.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/Filosofos/FilosofosPensadores/src/imagenes/pen.jpg"));
            }else if(Thread.currentThread().getName()=="Filosofo_5"){
                aa.Filo_5.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/Filosofos/FilosofosPensadores/src/imagenes/pen.jpg"));
            }
            
            Thread.sleep(n);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        
        System.out.println("El filosofo " + Nombre + "Termino de pensar");
        
    }
    
    public synchronized void tomar() throws InterruptedException{
        String Nombre = Thread.currentThread().getName();
        if(Thread.currentThread().getName() == "Filosofo_1"){
            while(Tenedor_1 || Tenedor_5){
                aa.Filo_1.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/Filosofos/FilosofosPensadores/src/imagenes/Esperando.jpg"));
                wait();
                Thread.sleep(5000);
            }
            Tenedor_1=true;
            Tenedor_5=true;
            aa.Tene_1.setBackground(Color.red);
            aa.Tene_5.setBackground(Color.red);
            System.out.println("El Filosofo " + Nombre + " agarro los tenedores tenedor");
            
        }else if(Thread.currentThread().getName() == "Filosofo_2"){
            while(Tenedor_1 || Tenedor_2){
                aa.Filo_2.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/Filosofos/FilosofosPensadores/src/imagenes/Esperando.jpg"));
                wait();
                
                Thread.sleep(5000);
            }
            Tenedor_1=true;
            Tenedor_2=true;
            aa.Tene_1.setBackground(Color.red);
            aa.Tene_2.setBackground(Color.red);
            System.out.println("El Filosofo " + Nombre + " agarro los tenedores tenedor");
            
        }else if(Thread.currentThread().getName() == "Filosofo_3"){
            while(Tenedor_3 || Tenedor_2){
                aa.Filo_3.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/Filosofos/FilosofosPensadores/src/imagenes/Esperando.jpg"));
                wait();
                
                Thread.sleep(5000);
            }
            Tenedor_3=true;
            Tenedor_2=true;
            aa.Tene_3.setBackground(Color.red);
            aa.Tene_2.setBackground(Color.red);
            System.out.println("El Filosofo " + Nombre + " agarro los tenedores tenedor");
            
        }else if(Thread.currentThread().getName() == "Filosofo_4"){
            while(Tenedor_3 || Tenedor_4){
                aa.Filo_4.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/Filosofos/FilosofosPensadores/src/imagenes/Esperando.jpg"));
                wait();
                
                Thread.sleep(5000);
            }
            Tenedor_3=true;
            Tenedor_4=true;
            aa.Tene_3.setBackground(Color.red);
            aa.Tene_4.setBackground(Color.red);
            System.out.println("El Filosofo " + Nombre + " agarro los tenedores tenedor");
            
        }else if(Thread.currentThread().getName() == "Filosofo_5"){
            while(Tenedor_5 || Tenedor_4){
                aa.Filo_5.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/Filosofos/FilosofosPensadores/src/imagenes/Esperando.jpg"));
                wait();
                
                Thread.sleep(5000);
            }
            Tenedor_5=true;
            Tenedor_4=true;
            aa.Tene_5.setBackground(Color.red);
            aa.Tene_4.setBackground(Color.red);
            System.out.println("El Filosofo " + Nombre + " agarro los tenedores tenedor");
            
        }
    }
    
    public void comer() throws InterruptedException{
        int maximo = 5000;
        int minimo = 10000;
        int ns = ThreadLocalRandom.current().nextInt(maximo, minimo);
        String Nombre = Thread.currentThread().getName();
        System.out.println("El filosofo " + Nombre + "esta comiendo");
        System.out.println(ns);
        if(Thread.currentThread().getName() == "Filosofo_1"){
                aa.Filo_1.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/Filosofos/FilosofosPensadores/src/imagenes/comiendo.jpg"));
            }else if(Thread.currentThread().getName() == "Filosofo_2"){
                aa.Filo_2.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/Filosofos/FilosofosPensadores/src/imagenes/comiendo.jpg"));
            }else if(Thread.currentThread().getName() == "Filosofo_3"){
                aa.Filo_3.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/Filosofos/FilosofosPensadores/src/imagenes/comiendo.jpg"));
            }else if(Thread.currentThread().getName() == "Filosofo_4"){
                aa.Filo_4.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/Filosofos/FilosofosPensadores/src/imagenes/comiendo.jpg"));
            }else if(Thread.currentThread().getName() == "Filosofo_5"){
                aa.Filo_5.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/Filosofos/FilosofosPensadores/src/imagenes/comiendo.jpg"));
            }
        
        try{
            Thread.sleep(ns);
            
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        
        System.out.println("El filosofo " + Nombre + "Termino de comer");
        
        
    }
    
    public synchronized void dejar() throws InterruptedException{
        String Nombre = Thread.currentThread().getName();
        if(Thread.currentThread().getName() == "Filosofo_1"){
            Tenedor_1=false;
            Tenedor_5=false;
            aa.Tene_1.setBackground(Color.green);
            aa.Tene_5.setBackground(Color.green);
            System.out.println("El Filosofo " + Nombre + " dejo los tenedores tenedor");
            notify();
            
        }else if(Thread.currentThread().getName() == "Filosofo_2"){
            Tenedor_1=false;
            Tenedor_2=false;
            aa.Tene_1.setBackground(Color.green);
            aa.Tene_2.setBackground(Color.green);
            System.out.println("El Filosofo " + Nombre + " dejo los tenedores tenedor");
            notify();
            
        }else if(Thread.currentThread().getName() == "Filosofo_3"){
            Tenedor_3=false;
            Tenedor_2=false;
            aa.Tene_3.setBackground(Color.green);
            aa.Tene_2.setBackground(Color.green);
            System.out.println("El Filosofo " + Nombre + " dejo los tenedores tenedor");
            notify();
            
        }else if(Thread.currentThread().getName() == "Filosofo_4"){
            Tenedor_3=false;
            Tenedor_4=false;
            aa.Tene_3.setBackground(Color.green);
            aa.Tene_4.setBackground(Color.green);
            System.out.println("El Filosofo " + Nombre + " dejo los tenedores tenedor");
            notify();
            
        }else if(Thread.currentThread().getName() == "Filosofo_5"){
            Tenedor_5=false;
            Tenedor_4=false;
            aa.Tene_5.setBackground(Color.green);
            aa.Tene_4.setBackground(Color.green);
            System.out.println("El Filosofo " + Nombre + " dejo los tenedores tenedor");
            notify();
            
        }
    }
        
}
