package Cerrojo;

import Grafico.Fumando;
import static Grafico.Fumando.Agente;
import static Grafico.Fumando.hay_Cerillos;
import java.awt.Color;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Cerrojo_1 {
    
    Fumando ls = new Fumando();
    
    public boolean cerillas_ns = false;
    public boolean tabaco_ns = false;
    public boolean papel_ns = false;
    public boolean fumandoMariana = false;
    
    public final ReentrantLock cerrojo = new ReentrantLock();
    public final Condition hayIngredientes = cerrojo.newCondition();
    
    public void Ingredientes() throws InterruptedException{
        Agente.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/FabricaCigarros/FC/FabricaCigarrillos/src/chill.png"));
        Thread.sleep(2000);
        Agente.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/FabricaCigarros/FC/FabricaCigarrillos/src/elegir.jpg"));
        
        int num_1 = ThreadLocalRandom.current().nextInt( 1, 4);
        int num_2;
        
        do{
            num_2 = ThreadLocalRandom.current().nextInt( 1, 4);
        }while(num_2 == num_1);
        
        
        if(num_1 == 1 || num_2 == 1){
            cerillas_ns = true;
            Thread.sleep(2000);
            System.out.println("Se entregara cerillas");
            ls.cerilloyos.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/FabricaCigarros/FC/FabricaCigarrillos/src/cerillosss.jpg")); 
        }
        
        if(num_1 == 2 || num_2 == 2){
            tabaco_ns = true;
            Thread.sleep(2000);
            System.out.println("Se entregara tabaco");
            ls.Tabacoco.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/FabricaCigarros/FC/FabricaCigarrillos/src/tabacoo.jpg"));
        }
        
        if(num_1 == 3 || num_2 == 3){
            papel_ns = true;
            Thread.sleep(2000);
            System.out.println("Se entregara papel");
            ls.Papepel.setText("Papel");
        }
        Thread.sleep(2000);
        Agente.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/FabricaCigarros/FC/FabricaCigarrillos/src/chill.png"));
        
    }
    
    public void recoger() throws InterruptedException{
        String id = Thread.currentThread().getName();
        
        if(tabaco_ns == true && papel_ns == true && id.equals("Carmen")){
            fumandoMariana = true;
            Thread.sleep(5000);
            ls.Papepel.setText(null);
            ls.Tabacoco.setIcon(null);
            System.out.println(id + " este haciendo un cigarrillo");
            hay_Cerillos.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/FabricaCigarros/FC/FabricaCigarrillos/src/haciendo.jpg"));
            Thread.sleep(1500);
            hay_Cerillos.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/FabricaCigarros/FC/FabricaCigarrillos/src/fumador.jpg"));
            System.out.println(id + " se esta fumando el cigarrillo");
            Thread.sleep(2500);
            hay_Cerillos.setIcon(null);
            System.out.println(id + " termino");
            Liberacion();
        }
        
        if(cerillas_ns == true && tabaco_ns == true && id.equals("Pablo")){
            fumandoMariana = true;
            Thread.sleep(5000);
            ls.cerilloyos.setIcon(null);
            ls.Tabacoco.setIcon(null);
            ls.hay_Papel.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/FabricaCigarros/FC/FabricaCigarrillos/src/haciendo.jpg"));
            System.out.println(id + " este haciendo un cigarrillo");
            Thread.sleep(1500);
            ls.hay_Papel.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/FabricaCigarros/FC/FabricaCigarrillos/src/fumador.jpg"));
            System.out.println(id + " se esta fumando el cigarrillo");
            Thread.sleep(2500);
            ls.hay_Papel.setIcon(null);
            System.out.println(id + " termino");
            Liberacion();
        }
        
        if(papel_ns == true && cerillas_ns == true && id.equals("Tailer")){
            fumandoMariana = true;
            Thread.sleep(5000);
            ls.Papepel.setText(null);
            ls.cerilloyos.setIcon(null);
            ls.hay_Tabacaco.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/FabricaCigarros/FC/FabricaCigarrillos/src/haciendo.jpg"));
            System.out.println(id + " este haciendo un cigarrillo");
            Thread.sleep(1500);
            ls.hay_Tabacaco.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/FabricaCigarros/FC/FabricaCigarrillos/src/fumador.jpg"));
            System.out.println(id + "se esta fumando el cigarrillo");
            Thread.sleep(2500);
            ls.hay_Tabacaco.setIcon(null);
            System.out.println(id + " termino");
            Liberacion();
        }
        
        
    }
    
    public void Liberacion(){
        cerillas_ns = tabaco_ns = papel_ns = fumandoMariana = false;
    }
    
     
    
    
}
