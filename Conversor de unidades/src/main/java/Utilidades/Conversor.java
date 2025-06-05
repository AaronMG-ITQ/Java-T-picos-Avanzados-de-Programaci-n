
package Utilidades;

import Interfaz.ConversorUnidades;
import static Interfaz.ConversorUnidades.MedidaSele;
import static Interfaz.ConversorUnidades.NumeroP;
import static Interfaz.ConversorUnidades.Resultado;
import static Interfaz.ConversorUnidades.UnidadC;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;



public class Conversor {
    public Conversor(){
        ConversorUnidades con = new ConversorUnidades();
        con.setVisible(true);
        accionboton();
    }
    
    
    
    private void Controlador(Double b){ 
        
        if(MedidaSele.getSelectedItem().toString() == "Kilometros"){
            Kilometro(b);
        }else if(MedidaSele.getSelectedItem().toString() == "Metros"){
            Metro(b);
        }else if(MedidaSele.getSelectedItem().toString() == "Decimetros"){
            Decimetro(b);
        }else if(MedidaSele.getSelectedItem().toString() == "Centimetros"){
            Centimetro(b);
        }else if(MedidaSele.getSelectedItem().toString() == "Milimetros"){
            Milimetro(b);
        }else if(MedidaSele.getSelectedItem().toString() == "Micrometros"){
            Micrometro(b);
        }else if(MedidaSele.getSelectedItem().toString() == "Nanometros"){
            Nanometro(b);
        }else if(MedidaSele.getSelectedItem().toString() == "Angstrom"){
            Angstro(b);
        }else if(MedidaSele.getSelectedItem().toString() == "Legua"){
            Leguas(b);
        }else if(MedidaSele.getSelectedItem().toString() == "Milla"){
            Millas(b);
        }else if(MedidaSele.getSelectedItem().toString() == "Estadio"){
            Estadios(b);
        }else if(MedidaSele.getSelectedItem().toString() == "Mano"){
            Manos(b);
        }else if(MedidaSele.getSelectedItem().toString() == "Yarda"){
            Yardas(b);
        }else if(MedidaSele.getSelectedItem().toString() == "Pie"){
            Pies(b);
        }else if(MedidaSele.getSelectedItem().toString() == "Pulgada"){
            Pulgadas(b);
        }
        
    }
    
    private void accionboton(){
        ConversorUnidades.Ejecutar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                double b = Double.parseDouble(NumeroP.getText());
                Controlador(b);
            }
        });
    }
    private double Kilometro (double b){
        if(UnidadC.getSelectedItem().toString().equals("Kilometros")){
            double a = 1;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Metros")){
            double a = 0.001;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Decimetros")){
            double a = 0.0001;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Centimetros")){
            double a = 0.00001;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Milimetros")){
            double a = 0.000001;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Micrometros")){
            double a = 0.000000001;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Nanometros")){
            double a = 0.000000000001;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Angstrom")){
            double a = 0.0000000000001;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Legua")){
            double a = 4.82803;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Milla")){
            double a = 1.60934;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Estadio")){
            double a = 0.20117;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Mano")){
            double a = 9842.5196;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Yarda")){
            double a = 0.0009144;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Pie")){
            double a = 0.0003048;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Pulgada")){
            double a = 0.0000254;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }
        // double a = 1.61;
        return 0;
    }
    
    private double Metro (double b){
        if(UnidadC.getSelectedItem().toString().equals("Kilometros")){
            double a = 1000;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Metros")){
            double a = 1;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Decimetros")){
            double a = 0.1;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Centimetros")){
            double a = 0.01;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Milimetros")){
            double a = 0.001;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Micrometros")){
            double a = 0.000001;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Nanometros")){
            double a = 0.000000001;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Angstrom")){
            double a = Math.pow(10, -10);
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Legua")){
            double a = 4828.03;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Milla")){
            double a = 1609.34;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Estadio")){
            double a = 0.00001;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Mano")){
            double a = 0.000001;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Yarda")){
            double a = 0.9144;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Pie")){
            double a = 0.3048;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Pulgada")){
            double a = 0.0254;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }
        
        return 0;
    }
    
    private double Decimetro (double b){
        
        if(UnidadC.getSelectedItem().toString().equals("Kilometros")){
            double a = 10000;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Metros")){
            double a = 10;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Decimetros")){
            double a = 1;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Centimetros")){
            double a = 0.1;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Milimetros")){
            double a = 0.01;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Micrometros")){
            double a = 0.00001;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Nanometros")){
            double a = 0.00000001;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Angstrom")){
            double a = 0.000000001;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Legua")){
            double a = 48280.3;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Milla")){
            double a = 16093.4;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Estadio")){
            double a = 0.00001;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Mano")){
            double a = 0.000001;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Yarda")){
            double a = 9.144;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Pie")){
            double a = 3.048;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Pulgada")){
            double a = 0.254;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }
        
        return 0;
    }
    
    private double Centimetro (double b){
        
        if(UnidadC.getSelectedItem().toString().equals("Kilometros")){
            double a = 100000;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Metros")){
            double a = 100;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Decimetros")){
            double a = 10;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Centimetros")){
            double a = 1;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Milimetros")){
            double a = 0.1;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Micrometros")){
            double a = 0.0001;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Nanometros")){
            double a = Math.pow(10, -7);
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Angstrom")){
            double a = Math.pow(10, -8);
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Legua")){
            double a = 482803;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Milla")){
            double a = 160934;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Estadio")){
            double a = 0.00001;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Mano")){
            double a = 0.000001;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Yarda")){
            double a = 91.44;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Pie")){
            double a = 30.48;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Pulgada")){
            double a = 2.54;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }
        return 0;
    }
    
    private double Milimetro (double b){
        
        if(UnidadC.getSelectedItem().toString().equals("Kilometros")){
            double a = 1000000;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Metros")){
            double a = 1000;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Decimetros")){
            double a = 100;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Centimetros")){
            double a = 10;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Milimetros")){
            double a = 1;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Micrometros")){
            double a = 0.001;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Nanometros")){
            double a = Math.pow(10, -6);
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Angstrom")){
            double a = Math.pow(10, -7);
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Legua")){
            double a = 4.828e+6;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Milla")){
            double a = 1.609e+6;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Estadio")){
            double a = 0.00001;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Mano")){
            double a = 0.000001;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Yarda")){
            double a = 914.4;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Pie")){
            double a = 304.8;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Pulgada")){
            double a = 25.4;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }
        return 0;
    }
    
    private double Micrometro (double b){
        
        if(UnidadC.getSelectedItem().toString().equals("Kilometros")){
            double a = 1000000000;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Metros")){
            double a = 1000000;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Decimetros")){
            double a = 100000;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Centimetros")){
            double a = 10000;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Milimetros")){
            double a = 1000;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Micrometros")){
            double a = 1;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Nanometros")){
            double a = 0.001;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Angstrom")){
            double a = 0.0001;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Legua")){
            double a = 4.828e+9;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Milla")){
            double a = 1.609e+9;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Estadio")){
            double a = 0.00001;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Mano")){
            double a = 0.000001;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Yarda")){
            double a = 914400;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Pie")){
            double a = 304800;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Pulgada")){
            double a = 25400;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }
        return 0;
    }
    
    private double Nanometro (double b){
        
        if(UnidadC.getSelectedItem().toString().equals("Kilometros")){
            double a = Math.pow(10, 12);
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Metros")){
            double a = 1000000000;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Decimetros")){
            double a = 100000000;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Centimetros")){
            double a = 10000000;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Milimetros")){
            double a = 1000000;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Micrometros")){
            double a = 1000;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Nanometros")){
            double a = 1;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Angstrom")){
            double a = 0.1;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Legua")){
            double a = 4.828e+12;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Milla")){
            double a = 1.609e+12;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Estadio")){
            double a = 0.00001;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Mano")){
            double a = 0.000001;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Yarda")){
            double a = 9.144e+8;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Pie")){
            double a = 3.048e+8;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Pulgada")){
            double a = 2.54e+7;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }
        return 0;
    }
    
    private double Angstro (double b){
        
        if(UnidadC.getSelectedItem().toString().equals("Kilometros")){
            double a = Math.pow(10, 13);
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Metros")){
            double a = Math.pow(10, 10);
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Decimetros")){
            double a = Math.pow(10, 9);
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Centimetros")){
            double a = Math.pow(10, 8);
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Milimetros")){
            double a = Math.pow(10, 7);
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Micrometros")){
            double a = Math.pow(10, 4);
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Nanometros")){
            double a = 10;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Angstrom")){
            double a = 1;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Legua")){
            double a = Math.pow(4.828, 13);
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Milla")){
            double a = Math.pow(1.609, 13);
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Estadio")){
            double a = Math.pow(5.4054, -13);
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Mano")){
            double a = Math.pow(9.8425, -9);
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Yarda")){
            double a = Math.pow(9.144, 9);
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Pie")){
            double a = Math.pow(3.048, 9);
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Pulgada")){
            double a = Math.pow(2.54, 8);
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }
        return 0;
    }
    
    private double Leguas (double b){
        if(UnidadC.getSelectedItem().toString().equals("Kilometros")){
            double a = 0.207124;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Metros")){
            double a = 0.000207124;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Decimetros")){
            double a = 2.0712e-5;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Centimetros")){
            double a = 2.0712e-6;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Milimetros")){
            double a = 2.0712e-7;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Micrometros")){
            double a = 2.0712e-10;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Nanometros")){
            double a = 2.0712e-13;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Angstrom")){
            double a = 2.07124e-14;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Legua")){
            double a = 1;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Milla")){
            double a = 0.2887;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Estadio")){
            double a = 0.00001;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Mano")){
            double a = 0.000001;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Yarda")){
            double a = 0.000189394;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Pie")){
            double a = 6.3131e-5;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Pulgada")){
            double a = 5.2609e-6;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }
        
        return 0;
    }
    
    private double Millas (double b){
        
        if(UnidadC.getSelectedItem().toString().equals("Kilometros")){
            double a = 0.621371;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Metros")){
            double a = 0.000621371;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Decimetros")){
            double a = 6.2137e-5;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Centimetros")){
            double a = 6.2137e-6;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Milimetros")){
            double a = 6.2137e-7;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Micrometros")){
            double a = 6.2137e-10;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Nanometros")){
            double a = 6.2137e-13;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Angstrom")){
            double a = 6.2137e-14;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Legua")){
            double a = 3;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Milla")){
            double a = 1;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Estadio")){
            double a = 0.00001;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Mano")){
            double a = 0.000001;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Yarda")){
            double a = 0.000568182;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Pie")){
            double a = 0.000189394;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Pulgada")){
            double a = 1.5783e-5;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }
        
        return 0;
    }
    
    private double Estadios (double b){
        
        if(UnidadC.getSelectedItem().toString().equals("Kilometros")){
            double a = 100000;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Metros")){
            double a = 100;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Decimetros")){
            double a = 10;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Centimetros")){
            double a = 1;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Milimetros")){
            double a = 0.1;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Micrometros")){
            double a = 0.0001;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Nanometros")){
            double a = Math.pow(10, -7);
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Angstrom")){
            double a = Math.pow(10, -8);
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Legua")){
            double a = 482803;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Milla")){
            double a = 160934;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Estadio")){
            double a = 0.00001;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Mano")){
            double a = 0.000001;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Yarda")){
            double a = 91.44;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Pie")){
            double a = 30.48;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Pulgada")){
            double a = 2.54;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }
        return 0;
    }
    
    private double Manos (double b){
        
        if(UnidadC.getSelectedItem().toString().equals("Kilometros")){
            double a = 1000000;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Metros")){
            double a = 1000;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Decimetros")){
            double a = 100;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Centimetros")){
            double a = 10;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Milimetros")){
            double a = 1;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Micrometros")){
            double a = 0.001;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Nanometros")){
            double a = Math.pow(10, -6);
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Angstrom")){
            double a = Math.pow(10, -7);
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Legua")){
            double a = 4.828e+6;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Milla")){
            double a = 1.609e+6;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Estadio")){
            double a = 0.00001;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Mano")){
            double a = 0.000001;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Yarda")){
            double a = 914.4;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Pie")){
            double a = 304.8;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Pulgada")){
            double a = 25.4;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }
        return 0;
    }
    
    private double Yardas (double b){
        
        if(UnidadC.getSelectedItem().toString().equals("Kilometros")){
            double a = 1093.61;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Metros")){
            double a = 1.09361;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Decimetros")){
            double a = 0.109361;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Centimetros")){
            double a = 0.0109361;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Milimetros")){
            double a = 0.00109361;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Micrometros")){
            double a = 1.0936e-6;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Nanometros")){
            double a = 1.0936e-9;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Angstrom")){
            double a = 1.0936e-10;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Legua")){
            double a = 5280;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Milla")){
            double a = 1760;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Estadio")){
            double a = 0.00001;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Mano")){
            double a = 0.000001;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Yarda")){
            double a = 1;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Pie")){
            double a = 0.333333;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Pulgada")){
            double a = 0.0277778;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }
        return 0;
    }
    
    private double Pies (double b){
        
        if(UnidadC.getSelectedItem().toString().equals("Kilometros")){
            double a = 3280.84;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Metros")){
            double a = 3.28084;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Decimetros")){
            double a = 0.328084;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Centimetros")){
            double a = 0.0328084;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Milimetros")){
            double a = 0.00328084;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Micrometros")){
            double a = 3.2808e-6;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Nanometros")){
            double a = 3.2808e-9;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Angstrom")){
            double a = 3.2808e-10;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Legua")){
            double a = 15840;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Milla")){
            double a = 5280;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Estadio")){
            double a = 0.00001;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Mano")){
            double a = 0.000001;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Yarda")){
            double a = 3;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Pie")){
            double a = 1;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Pulgada")){
            double a = 0.0833333;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }
        return 0;
    }
    
    private double Pulgadas (double b){
        
        if(UnidadC.getSelectedItem().toString().equals("Kilometros")){
            double a = 39370.1;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Metros")){
            double a = 39.3701;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Decimetros")){
            double a = 3.93701;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Centimetros")){
            double a = 0.393701;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Milimetros")){
            double a = 0.0393701;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Micrometros")){
            double a = 3.937e-5;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Nanometros")){
            double a = 3.937e-8;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Angstrom")){
            double a = 3.937e-9;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Legua")){
            double a = 190080;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Milla")){
            double a = 63360;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Estadio")){
            double a = Math.pow(5.4054, -13);
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Mano")){
            double a = Math.pow(9.8425, -9);
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Yarda")){
            double a = 36;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Pie")){
            double a = 12;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }else if(UnidadC.getSelectedItem().toString().equals("Pulgada")){
            double a = 1;
            double c= b * a;
            String cc = String.valueOf(c);
            Resultado.setText(cc);
        }
        return 0;
    }
}


/*
legua
milla
estadio
Mano
Yarda
pie
pulgada
*/