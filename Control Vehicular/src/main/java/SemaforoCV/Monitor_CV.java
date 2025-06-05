package SemaforoCV;

import Grafico.LaCalle;
import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;


public class Monitor_CV {
    Timer ls = new Timer();        
    LaCalle ms = new LaCalle();
    String LuzV = "Sur-Norte";
    String LuzV2 = "Norte-Sur";
    int contadorSur = 0;
    int contadorNorte =0;
    int contadorEste = 0;
    int contadorOeste = 0;
    
    
    public synchronized void semaforo(String direccion) throws InterruptedException{
        try{
            ms.setVisible(true);
            
            if(!direccion.equals(LuzV) && direccion.equals("Sur-Norte")){
                contadorSur = contadorSur + 1;
            }
            else if(!direccion.equals(LuzV2) && direccion.equals("Norte-Sur")){
                contadorNorte = contadorNorte + 1;
            }
            else if(!direccion.equals(LuzV) && direccion.equals("Oeste-Este")){
                contadorOeste = contadorOeste + 1;
            }
            else if(!direccion.equals(LuzV2) && direccion.equals("Este-Oeste")){
                contadorEste = contadorEste + 1;
            }

            
            while(!direccion.equals(LuzV) && !direccion.equals(LuzV2)){             
                wait();
            } 
            
            String id = Thread.currentThread().getName();
            
            
            
            System.out.println("Los autos " + id + " Estan crusando de " + direccion);
            
            if(direccion.equals(LuzV)){               
                if(direccion.equals("Sur-Norte")){
                    if(contadorSur > 0){
                        contadorSur = contadorSur - 1;
                    }
                }
                if(direccion.equals("Oeste-Este")){
                    if(contadorOeste > 0 ){
                        contadorOeste = contadorOeste - 1;
                    }
                }
            }
            
            if(direccion.equals(LuzV2)){
                if(direccion.equals("Norte-Sur")){
                    if(contadorNorte > 0){
                        contadorNorte = contadorNorte - 1;
                    }
                }
                if(direccion.equals("Este-Oeste")){
                    if(contadorEste > 0){
                        contadorEste = contadorEste - 1;
                    }
                }
            }
            
            ms.S_N.setText(String.valueOf(contadorSur));
            ms.N_S.setText(String.valueOf(contadorNorte));
            ms.O_E.setText(String.valueOf(contadorOeste));
            ms.E_O.setText(String.valueOf(contadorEste));
            
            Thread.sleep(3000);
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }finally{
            notifyAll();
        }
        
    }
    
    public synchronized void CambioDeLuz() throws InterruptedException{
        /**LuzV = LuzV.equals("Sur-Norte")? "Oeste-Este" : "Sur-Norte";**/
        
        ms.Sema_1.setBackground(Color.GREEN);
        
        ls.scheduleAtFixedRate(new TimerTask(){
            @Override
            synchronized public void run() {
                if (LuzV.equals("Sur-Norte") || LuzV.equals("Norte-Sur")) {
                    LuzV = "Oeste-Este";
                    LuzV2 = "Este-Oeste";
                    ms.Calle_3.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/ControlT/ControlDelTrafico/ControlDeTraficoMex/src/lleguamos.jpg"));
                    ms.Calle_1.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/ControlT/ControlDelTrafico/ControlDeTraficoMex/src/vamonos.jpg"));
                    ms.Calle_5.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/ControlT/ControlDelTrafico/ControlDeTraficoMex/src/lleguamos.jpg"));
                    ms.Calle_7.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/ControlT/ControlDelTrafico/ControlDeTraficoMex/src/vamonos.jpg"));
                    ms.Calle_4.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/ControlT/ControlDelTrafico/ControlDeTraficoMex/src/EnRojo.jpg"));
                    ms.Calle_6.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/ControlT/ControlDelTrafico/ControlDeTraficoMex/src/EnRojo.jpg"));
                    ms.Calle_2.setIcon(null);
                    ms.Calle_8.setIcon(null);
                    ms.Sema_1.setBackground(Color.red);
                    ms.Sema_2.setBackground(Color.GREEN);
                    notifyAll();
                } else if(LuzV.equals("Oeste-Este") || LuzV.equals("Este-Oeste")) {
                    LuzV = "Sur-Norte";
                    LuzV2 = "Norte-Sur";
                    ms.Calle_4.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/ControlT/ControlDelTrafico/ControlDeTraficoMex/src/lleguamos.jpg"));
                    ms.Calle_2.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/ControlT/ControlDelTrafico/ControlDeTraficoMex/src/vamonos.jpg"));
                    ms.Calle_6.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/ControlT/ControlDelTrafico/ControlDeTraficoMex/src/lleguamos.jpg"));
                    ms.Calle_8.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/ControlT/ControlDelTrafico/ControlDeTraficoMex/src/vamonos.jpg"));
                    ms.Calle_3.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/ControlT/ControlDelTrafico/ControlDeTraficoMex/src/EnRojo.jpg"));
                    ms.Calle_5.setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Tercera Unidad/ControlT/ControlDelTrafico/ControlDeTraficoMex/src/EnRojo.jpg"));
                    ms.Calle_1.setIcon(null);
                    ms.Calle_7.setIcon(null);
                    ms.Sema_2.setBackground(Color.red);
                    ms.Sema_1.setBackground(Color.GREEN);
                    notifyAll();
                }
                
                System.out.println("La luz verde ahora esta en " + LuzV);
                notifyAll();
            }
            
        }, 0, 5000);
        
        
        System.out.println("La luz verde ahora esta en " + LuzV);
        notifyAll();
    }
}
