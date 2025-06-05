/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LogicaDamas;

import Tablero.TableroDamasInglesas;
import java.awt.Color;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ControlPrincipal implements ActionListener{
    
    public ControlPrincipal(){
        Tablero_Game();
        TableroDamasInglesas ZonaDeJuego = new TableroDamasInglesas();
        ZonaDeJuego.setVisible(true);
        BotonAccion();
    }
    
    
    private String [][] Tableros = new String[8][8];
    private String [] PosicionValido = new String[2];
    private String [] PosicionValidoDama = new String[150];
    private String AntiguaPos = null;
    private String NuevaPos = null;
    private String ActualPos;
    private char Turno = 'A';
    private String MovValido = null;
    private int l=0;
    private int Rojo=12; 
    private int Negro=12;
    private String Comido = null;
    
    private void Tablero_Game(){
        for(int i=0 ; i<8 ;i++){
            for(int j=0; j<8; j++){
                Tableros[i][j]="";
            }
        }
        
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if((i+j)%2 == 1){
                    if(i<3){
                        Tableros[i][j] = "Ficha_RP";
                    }else if(i > 4){
                        Tableros[i][j] = "Ficha_NP";
                    }
                
                }
            }
        }
        
        
        
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                System.out.print(Tableros[i][j] + "\t");
            }
            
            System.out.println();
        }
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(Turno == 'A'){
            ActualPos = PosicionBoton(e.getSource());
            
            if(FichaNegra(ActualPos)){
                AntiguaPos = ActualPos;
            }else if(AntiguaPos != null){
                NuevaPos = ActualPos;
                if(VerificarMovimientoNegras(AntiguaPos,NuevaPos)){
                    Mover(AntiguaPos, NuevaPos);
                    Dama_N(NuevaPos);
                    AntiguaPos = null;
                    NuevaPos = null;
                    Turno = (Turno == 'A') ? 'B' : 'A';
                }else if(VerificarComidaN(AntiguaPos,NuevaPos)){
                    Mover(AntiguaPos, NuevaPos);
                    Comidos(AntiguaPos,ActualPos);
                    AntiguaPos = null;
                    NuevaPos = null;
                    Turno = 'A';
                }
                
            }
            
            if(VerificarDamaNegra(ActualPos)){
                AntiguaPos = ActualPos;
            }else if(AntiguaPos != null){
                NuevaPos = ActualPos;
                if(VerificarMovDama(AntiguaPos,NuevaPos)){
                    Mover(AntiguaPos, NuevaPos);
                    Dama_N(NuevaPos);
                    AntiguaPos = null;
                    NuevaPos = null;
                    Turno = (Turno == 'A') ? 'B' : 'A';
                }
            }
        }else if(Turno == 'B'){
            ActualPos = PosicionBoton(e.getSource());
            
            if(FichaRoja(ActualPos)){
                AntiguaPos = ActualPos;
            }else if(AntiguaPos != null){
                NuevaPos = ActualPos;
                if(VerificarMovimientoRojas(AntiguaPos,NuevaPos)){
                    Mover(AntiguaPos, NuevaPos);
                    AntiguaPos = null;
                    NuevaPos = null;
                    Turno = (Turno == 'A') ? 'B' : 'A';
                } else if(VerificarComidaR(AntiguaPos,NuevaPos)){
                    Mover(AntiguaPos, NuevaPos);
                    Comidos_2(AntiguaPos,ActualPos);
                    Negro = Negro-1;
                    AntiguaPos = null;
                    NuevaPos = null;
                    Turno = 'B';
                }
            }
        }
        
        
    }
    
    
    //Mueve las fichas tanto logicas como graficas------------------------------
    
    public void Mover(String PosA, String PosN){
        MoverGrafico(PosA,PosN);
        MoverFicha(PosA,PosN); 
        
        
        System.out.print("""
                         ---------------------------------------------------
                         """);
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                System.out.print(Tableros[i][j] + "\t");
            }
            
            System.out.println();
        }
        System.out.print("La cantidad de fichas rojas son : "+ Rojo);
        System.out.print("La cantidad de fichas negras son : "+ Negro);
        
        System.out.print("---------------------------------------------------"+ "\t");
    }
  
    private void MoverGrafico(String PosA, String PosN){
        boton(PosN).setIcon(boton(PosA).getIcon());
        boton(PosA).setIcon(null);
        
    }
    
    private String MoverFicha(String PosA, String PosN){
        
        int iV = Character.getNumericValue(PosA.charAt(0));
        int jV = Character.getNumericValue(PosA.charAt(1));
        
        
        int iN = Character.getNumericValue(PosN.charAt(0));
        int jN = Character.getNumericValue(PosN.charAt(1));
        
        Tableros[iN][jN] = Tableros[iV][jV];
        Tableros[iV][jV] = "";
        return "";   
    }
    
    //--------------------------------------------------------------------------
    
    //Es necesario para que los botones funcionen-------------------------------
    
    private void BotonAccion(){
        TableroDamasInglesas.A00.addActionListener(this);
        TableroDamasInglesas.A10.addActionListener(this);
        TableroDamasInglesas.A20.addActionListener(this);
        TableroDamasInglesas.A30.addActionListener(this);
        TableroDamasInglesas.A40.addActionListener(this);
        TableroDamasInglesas.A50.addActionListener(this);
        TableroDamasInglesas.A60.addActionListener(this);
        TableroDamasInglesas.A70.addActionListener(this);
        
        TableroDamasInglesas.B01.addActionListener(this);
        TableroDamasInglesas.B11.addActionListener(this);
        TableroDamasInglesas.B21.addActionListener(this);
        TableroDamasInglesas.B31.addActionListener(this);
        TableroDamasInglesas.B41.addActionListener(this);
        TableroDamasInglesas.B51.addActionListener(this);
        TableroDamasInglesas.B61.addActionListener(this);
        TableroDamasInglesas.B71.addActionListener(this);
       
        TableroDamasInglesas.C02.addActionListener(this);
        TableroDamasInglesas.C12.addActionListener(this);
        TableroDamasInglesas.C22.addActionListener(this);
        TableroDamasInglesas.C32.addActionListener(this);
        TableroDamasInglesas.C42.addActionListener(this);
        TableroDamasInglesas.C52.addActionListener(this);
        TableroDamasInglesas.C62.addActionListener(this);
        TableroDamasInglesas.C72.addActionListener(this);
        
        TableroDamasInglesas.D03.addActionListener(this);
        TableroDamasInglesas.D13.addActionListener(this);
        TableroDamasInglesas.D23.addActionListener(this);
        TableroDamasInglesas.D33.addActionListener(this);
        TableroDamasInglesas.D43.addActionListener(this);
        TableroDamasInglesas.D53.addActionListener(this);
        TableroDamasInglesas.D63.addActionListener(this);
        TableroDamasInglesas.D73.addActionListener(this);
       
        TableroDamasInglesas.E04.addActionListener(this);
        TableroDamasInglesas.E14.addActionListener(this);
        TableroDamasInglesas.E24.addActionListener(this);
        TableroDamasInglesas.E34.addActionListener(this);
        TableroDamasInglesas.E44.addActionListener(this);
        TableroDamasInglesas.E54.addActionListener(this);
        TableroDamasInglesas.E64.addActionListener(this);
        TableroDamasInglesas.E74.addActionListener(this);
        
        TableroDamasInglesas.F05.addActionListener(this);
        TableroDamasInglesas.F15.addActionListener(this);
        TableroDamasInglesas.F25.addActionListener(this);
        TableroDamasInglesas.F35.addActionListener(this);
        TableroDamasInglesas.F45.addActionListener(this);
        TableroDamasInglesas.F55.addActionListener(this);
        TableroDamasInglesas.F65.addActionListener(this);
        TableroDamasInglesas.F75.addActionListener(this);
        
        TableroDamasInglesas.G06.addActionListener(this);
        TableroDamasInglesas.G16.addActionListener(this);
        TableroDamasInglesas.G26.addActionListener(this);
        TableroDamasInglesas.G36.addActionListener(this);
        TableroDamasInglesas.G46.addActionListener(this);
        TableroDamasInglesas.G56.addActionListener(this);
        TableroDamasInglesas.G66.addActionListener(this);
        TableroDamasInglesas.G76.addActionListener(this);
        
        TableroDamasInglesas.H07.addActionListener(this);
        TableroDamasInglesas.H17.addActionListener(this);
        TableroDamasInglesas.H27.addActionListener(this);
        TableroDamasInglesas.H37.addActionListener(this);
        TableroDamasInglesas.H47.addActionListener(this);
        TableroDamasInglesas.H57.addActionListener(this);
        TableroDamasInglesas.H67.addActionListener(this);
        TableroDamasInglesas.H77.addActionListener(this);
    }
    
    //--------------------------------------------------------------------------
    
    
    //Se obtiene las coordenadas tanto por los botonoes como logicas------------
 
    private JButton boton(String posicion){
        if(posicion.equals("00")){
            return TableroDamasInglesas.A00;
        }else if(posicion.equals("01")){
            return TableroDamasInglesas.B01;
        }else if(posicion.equals("02")){
            return TableroDamasInglesas.C02;
        }else if(posicion.equals("03")){
            return TableroDamasInglesas.D03;
        }else if(posicion.equals("04")){
            return TableroDamasInglesas.E04;
        }else if(posicion.equals("05")){
            return TableroDamasInglesas.F05;
        }else if(posicion.equals("06")){
            return TableroDamasInglesas.G06;
        }else if(posicion.equals("07")){
            return TableroDamasInglesas.H07;
        }else if(posicion.equals("10")){
            return TableroDamasInglesas.A10;
        }else if(posicion.equals("11")){
            return TableroDamasInglesas.B11;
        }else if(posicion.equals("12")){
            return TableroDamasInglesas.C12;
        }else if(posicion.equals("13")){
            return TableroDamasInglesas.D13;
        }else if(posicion.equals("14")){
            return TableroDamasInglesas.E14;
        }else if(posicion.equals("15")){
            return TableroDamasInglesas.F15;
        }else if(posicion.equals("16")){
            return TableroDamasInglesas.G16;
        }else if(posicion.equals("17")){
            return TableroDamasInglesas.H17;
        }else if(posicion.equals("20")){
            return TableroDamasInglesas.A20;
        }else if(posicion.equals("21")){
            return TableroDamasInglesas.B21;
        }else if(posicion.equals("22")){
            return TableroDamasInglesas.C22;
        }else if(posicion.equals("23")){
            return TableroDamasInglesas.D23;
        }else if(posicion.equals("24")){
            return TableroDamasInglesas.E24;
        }else if(posicion.equals("25")){
            return TableroDamasInglesas.F25;
        }else if(posicion.equals("26")){
            return TableroDamasInglesas.G26;
        }else if(posicion.equals("27")){
            return TableroDamasInglesas.H27;
        }else if(posicion.equals("30")){
            return TableroDamasInglesas.A30;
        }else if(posicion.equals("31")){
            return TableroDamasInglesas.B31;
        }else if(posicion.equals("32")){
            return TableroDamasInglesas.C32;
        }else if(posicion.equals("33")){
            return TableroDamasInglesas.D33;
        }else if(posicion.equals("34")){
            return TableroDamasInglesas.E34;
        }else if(posicion.equals("35")){
            return TableroDamasInglesas.F35;
        }else if(posicion.equals("36")){
            return TableroDamasInglesas.G36;
        }else if(posicion.equals("37")){
            return TableroDamasInglesas.H37;
        }else if(posicion.equals("40")){
            return TableroDamasInglesas.A40;
        }else if(posicion.equals("41")){
            return TableroDamasInglesas.B41;
        }else if(posicion.equals("42")){
            return TableroDamasInglesas.C42;
        }else if(posicion.equals("43")){
            return TableroDamasInglesas.D43;
        }else if(posicion.equals("44")){
            return TableroDamasInglesas.E44;
        }else if(posicion.equals("45")){
            return TableroDamasInglesas.F45;
        }else if(posicion.equals("46")){
            return TableroDamasInglesas.G46;
        }else if(posicion.equals("47")){
            return TableroDamasInglesas.H47;
        }else if(posicion.equals("50")){
            return TableroDamasInglesas.A50;
        }else if(posicion.equals("51")){
            return TableroDamasInglesas.B51;
        }else if(posicion.equals("52")){
            return TableroDamasInglesas.C52;
        }else if(posicion.equals("53")){
            return TableroDamasInglesas.D53;
        }else if(posicion.equals("54")){
            return TableroDamasInglesas.E54;
        }else if(posicion.equals("55")){
            return TableroDamasInglesas.F55;
        }else if(posicion.equals("56")){
            return TableroDamasInglesas.G56;
        }else if(posicion.equals("57")){
            return TableroDamasInglesas.H57;
        }else if(posicion.equals("60")){
            return TableroDamasInglesas.A60;
        }else if(posicion.equals("61")){
            return TableroDamasInglesas.B61;
        }else if(posicion.equals("62")){
            return TableroDamasInglesas.C62;
        }else if(posicion.equals("63")){
            return TableroDamasInglesas.D63;
        }else if(posicion.equals("64")){
            return TableroDamasInglesas.E64;
        }else if(posicion.equals("65")){
            return TableroDamasInglesas.F65;
        }else if(posicion.equals("66")){
            return TableroDamasInglesas.G66;
        }else if(posicion.equals("67")){
            return TableroDamasInglesas.H67;
        }else if(posicion.equals("70")){
            return TableroDamasInglesas.A70;
        }else if(posicion.equals("71")){
            return TableroDamasInglesas.B71;
        }else if(posicion.equals("72")){
            return TableroDamasInglesas.C72;
        }else if(posicion.equals("73")){
            return TableroDamasInglesas.D73;
        }else if(posicion.equals("74")){
            return TableroDamasInglesas.E74;
        }else if(posicion.equals("75")){
            return TableroDamasInglesas.F75;
        }else if(posicion.equals("76")){
            return TableroDamasInglesas.G76;
        }else if(posicion.equals("77")){
            return TableroDamasInglesas.H77;
        }
        
        return null;
    }
    
    private String PosicionBoton(Object boton){
        if(boton == TableroDamasInglesas.A00){
            return "00";
        }else if(boton == TableroDamasInglesas.B01){
            return "01";
        }else if(boton == TableroDamasInglesas.C02){
            return "02";
        }else if(boton == TableroDamasInglesas.D03){
            return "03";
        }else if(boton == TableroDamasInglesas.E04){
            return "04";
        }else if(boton == TableroDamasInglesas.F05){
            return "05";
        }else if(boton == TableroDamasInglesas.G06){
            return "06";
        }else if(boton == TableroDamasInglesas.H07){
            return "07";
        }else if(boton == TableroDamasInglesas.A10){
            return "10";
        }else if(boton == TableroDamasInglesas.B11){
            return "11";
        }else if(boton == TableroDamasInglesas.C12){
            return "12";
        }else if(boton == TableroDamasInglesas.D13){
            return "13";
        }else if(boton == TableroDamasInglesas.E14){
            return "14";
        }else if(boton == TableroDamasInglesas.F15){
            return "15";
        }else if(boton == TableroDamasInglesas.G16){
            return "16";
        }else if(boton == TableroDamasInglesas.H17){
            return "17";
        }else if(boton == TableroDamasInglesas.A20){
            return "20";
        }else if(boton == TableroDamasInglesas.B21){
            return "21";
        }else if(boton == TableroDamasInglesas.C22){
            return "22";
        }else if(boton == TableroDamasInglesas.D23){
            return "23";
        }else if(boton == TableroDamasInglesas.E24){
            return "24";
        }else if(boton == TableroDamasInglesas.F25){
            return "25";
        }else if(boton == TableroDamasInglesas.G26){
            return "26";
        }else if(boton == TableroDamasInglesas.H27){
            return "27";
        }else if(boton == TableroDamasInglesas.A30){
            return "30";
        }else if(boton == TableroDamasInglesas.B31){
            return "31";
        }else if(boton == TableroDamasInglesas.C32){
            return "32";
        }else if(boton == TableroDamasInglesas.D33){
            return "33";
        }else if(boton == TableroDamasInglesas.E34){
            return "34";
        }else if(boton == TableroDamasInglesas.F35){
            return "35";
        }else if(boton == TableroDamasInglesas.G36){
            return "36";
        }else if(boton == TableroDamasInglesas.H37){
            return "37";
        }else if(boton == TableroDamasInglesas.A40){
            return "40";
        }else if(boton == TableroDamasInglesas.B41){
            return "41";
        }else if(boton == TableroDamasInglesas.C42){
            return "42";
        }else if(boton == TableroDamasInglesas.D43){
            return "43";
        }else if(boton == TableroDamasInglesas.E44){
            return "44";
        }else if(boton == TableroDamasInglesas.F45){
            return "45";
        }else if(boton == TableroDamasInglesas.G46){
            return "46";
        }else if(boton == TableroDamasInglesas.H47){
            return "47";
        }else if(boton == TableroDamasInglesas.A50){
            return "50";
        }else if(boton == TableroDamasInglesas.B51){
            return "51";
        }else if(boton == TableroDamasInglesas.C52){
            return "52";
        }else if(boton == TableroDamasInglesas.D53){
            return "53";
        }else if(boton == TableroDamasInglesas.E54){
            return "54";
        }else if(boton == TableroDamasInglesas.F55){
            return "55";
        }else if(boton == TableroDamasInglesas.G56){
            return "56";
        }else if(boton == TableroDamasInglesas.H57){
            return "57";
        }else if(boton == TableroDamasInglesas.A60){
            return "60";
        }else if(boton == TableroDamasInglesas.B61){
            return "61";
        }else if(boton == TableroDamasInglesas.C62){
            return "62";
        }else if(boton == TableroDamasInglesas.D63){
            return "63";
        }else if(boton == TableroDamasInglesas.E64){
            return "64";
        }else if(boton == TableroDamasInglesas.F65){
            return "65";
        }else if(boton == TableroDamasInglesas.G66){
            return "66";
        }else if(boton == TableroDamasInglesas.H67){
            return "67";
        }else if(boton == TableroDamasInglesas.A70){
            return "70";
        }else if(boton == TableroDamasInglesas.B71){
            return "71";
        }else if(boton == TableroDamasInglesas.C72){
            return "72";
        }else if(boton == TableroDamasInglesas.D73){
            return "73";
        }else if(boton == TableroDamasInglesas.E74){
            return "74";
        }else if(boton == TableroDamasInglesas.F75){
            return "75";
        }else if(boton == TableroDamasInglesas.G76){
            return "76";
        }else if(boton == TableroDamasInglesas.H77){
            return "77";
        }
        
        return null;
    }
    
    //--------------------------------------------------------------------------
    
    
    //Saber si la ficha seleccionada es del color respectivo--------------------
    
    private boolean FichaNegra(String posicion){
        int x = Character.getNumericValue(posicion.charAt(1));
        int y = Character.getNumericValue(posicion.charAt(0));
        
        if(!Tableros[y][x].equals("")){
            
            return(Tableros[y][x].charAt(6) == 'N')? true : false;
        }
        
        return false;
    }
    
    private boolean FichaRoja(String posicion){
        int x = Character.getNumericValue(posicion.charAt(1));
        int y = Character.getNumericValue(posicion.charAt(0));
        
        if(!Tableros[y][x].equals("")){
            return (Tableros[y][x].charAt(6) == 'R')? true : false;
        }
        
        return false;
    }
    
    //--------------------------------------------------------------------------
    
    
    // Saber si el movimiento del peon es valido en caso de las fichas negras---
    
    private String MovimientoNegras(String posicion){
        l = 0;
        int x = Character.getNumericValue(posicion.charAt(1));
        int y = Character.getNumericValue(posicion.charAt(0));
        
        if(x >= 1 && x <= 6){
            if(Tableros[y-1][x+1].equals("")){
                
                MovValido = (y-1) + "" + (x+1);
                PosicionValido[l] = MovValido;
                l++;
                
            }
            
            if(Tableros[y-1][x-1].equals("")){
                    
                MovValido = (y-1) + "" + (x-1);
                PosicionValido[l] = MovValido;
                l++;
                    
            }
        }
        
        if(x == 0){
            if(Tableros[y-1][x+1].equals("")){
                
                MovValido = (y-1) + ""+ (x+1);
                PosicionValido[l] = MovValido;
                l++;
                
            }
        }else if(x == 7){
            if(Tableros[y-1][x-1].equals("")){
                    
                MovValido = (y-1) + "" + (x-1);
                PosicionValido[l] = MovValido;
                l++;
                    
            }
        }
 
        return null;
    }
    
    public boolean VerificarMovimientoNegras(String posicion, String PosN){
        MovimientoNegras(posicion);
        
        if(PosicionValido != null){
            for(int o=0; o<PosicionValido.length; o++){
                if(PosicionValido[o].equals(PosN)){
                    return true;
                }
            }
        }
        return false;
    }
    
    //--------------------------------------------------------------------------
    
    
    // Saber si el movimiento del peon es valido en caso de las fichas rojas----
    
    private String MovimientoRojas(String posicion){
        l=0;
        int x = Character.getNumericValue(posicion.charAt(1));
        int y = Character.getNumericValue(posicion.charAt(0));
        
        if(x >= 1 && x <=6){
            if(Tableros[y+1][x-1].equals("")){
                
                MovValido = (y+1) + "" + (x-1);
                PosicionValido[l] = MovValido;
                l++;
                
            }
            
            if(Tableros[y+1][x+1].equals("")){
                
                MovValido = (y+1) + "" + (x+1);
                PosicionValido[l] = MovValido;
                l++;
                
            }
        }
        
        if(x == 0){
            if(Tableros[y+1][x+1].equals("")){
                
                MovValido = (y+1)+ "" + (x+1);
                PosicionValido[l] = MovValido;
                l++;
                
            }
        }else if(x == 7){
            if(Tableros[y+1][x-1].equals("")){

                MovValido = (y+1) + "" + (x-1);
                PosicionValido[l] = MovValido;
                l++;
                
            }
        }
            
        return null;
    }
    
    public boolean VerificarMovimientoRojas(String posicion, String PosN){
        MovimientoRojas(posicion);
        
        if(PosicionValido != null){
            for(int q = 0; q<PosicionValido.length; q++){
                if(PosicionValido[q].equals(PosN)){
                    return true;
                }
            }
        }
        return false;
    }
    
    //--------------------------------------------------------------------------
    
    
    //Comer fichas rojas--------------------------------------------------------
    
    private String ComerFichaRoja(String posicion, String posicionActual){
        l=0;
        
        int x = Character.getNumericValue(posicion.charAt(1));
        int y = Character.getNumericValue(posicion.charAt(0));
        
        int xN = Character.getNumericValue(posicionActual.charAt(1));
        int yN = Character.getNumericValue(posicionActual.charAt(0));
        
        if(x >= 1 && x <= 6){
            if(Tableros[y-1][x+1].equals("Ficha_RP")){
                if(Tableros[y-2][x+2].equals("")){
                    MovValido = (y-2) + "" + (x+2);
                    PosicionValido[l] = MovValido;
                    l++;
                    Comido = (yN+1) + "" + (xN-1);
                }
            }else if(Tableros[y-1][x-1].equals("Ficha_RP")){
                if(Tableros[y-2][x-2].equals("")){
                    MovValido = (y-2) + "" + (x-2);
                    Comido = (yN+1) + "" + (xN+1);
                    PosicionValido[l] = MovValido;
                    l++;
                }      
            }
        }
        
        if(x == 0){
            if(Tableros[y-1][x+1].equals("Ficha_RP")){
                if(Tableros[y-2][x+2].equals("")){
                    MovValido = (y-2) + "" + (x+2);
                    Comido = (yN+1) + "" + (xN-1);
                    PosicionValido[l] = MovValido;
                    l++;
                }
            }
        }else if(x == 7){
            if(Tableros[y-1][x-1].equals("Ficha_RP")){
                if(Tableros[y-2][x-2].equals("")){
                    MovValido = (y-2) + "" + (x-2);
                    Comido = (yN+1) + "" + (xN+1);
                    PosicionValido[l] = MovValido;
                    l++;
                }     
            }
        }
        
        return null;
    }
    
    public boolean VerificarComidaN(String posicion, String PosN){
        ComerFichaRoja(posicion,PosN);
        
        if(PosicionValido != null){
            for(int t=0; t<PosicionValido.length; t++){
                if(PosicionValido[t].equals(PosN)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private String Comidos(String AntiguaPosicion, String PosN){
        ComerFichaRoja(AntiguaPosicion,PosN);
        
        boton(Comido).setIcon(null);
        Rojo = Rojo-1;
        
        int p = Character.getNumericValue(Comido.charAt(1));
        int q = Character.getNumericValue(Comido.charAt(0));
        
        Tableros [q][p] = "";
        
        return null;
    }
    
    //--------------------------------------------------------------------------
    
    
    //Comer fichas negras-------------------------------------------------------
    
    private String ComerFichaNegra(String posicion, String PosN){
        l=0;
        
        int x = Character.getNumericValue(posicion.charAt(1));
        int y = Character.getNumericValue(posicion.charAt(0));
        
        int xN = Character.getNumericValue(PosN.charAt(1));
        int yN = Character.getNumericValue(PosN.charAt(0));
        
        if(x >= 1 && x <= 6){
            if(Tableros[y+1][x+1].equals("Ficha_NP")){
                if(Tableros[y+2][x+2].equals("")){
                    MovValido = (y+2) + "" + (x+2);
                    Comido = (yN-1) + "" + (xN-1);
                    PosicionValido[l] = MovValido;
                    l++;
                }
            }else if(Tableros[y+1][x-1].equals("Ficha_NP")){
                if(Tableros[y+2][x-2].equals("")){
                    MovValido = (y+2) + "" + (x-2);
                    Comido = (yN-1) + "" +(xN+1);
                    PosicionValido[l] = MovValido;
                    l++;
                }
            }
        }
        
        if(x == 0 ){
            if(Tableros[y+1][x+1].equals("Ficha_NP")){
                if(Tableros[y+2][x+2].equals("")){
                    MovValido = (y+2) + "" + (x+2);
                    Comido = (yN-1) + "" + (xN-1);
                    PosicionValido[l] = MovValido;
                    l++;
                }
            }
        }else if(x == 7){
            if(Tableros[y+1][x-1].equals("Ficha_NP")){
                if(Tableros[y+2][x-2].equals("")){
                    MovValido = (y+2) + "" + (x-2);
                    Comido = (yN-1) + "" +(xN+1);
                    PosicionValido[l] = MovValido;
                    l++;
                }
            }
        }
        
        return null;
    }
    
    public boolean VerificarComidaR(String posicion, String PosN){
        ComerFichaNegra(posicion,PosN);
        
        if(PosicionValido != null){
            for(int t = 0; t<PosicionValido.length; t++){
                if(PosicionValido[t].equals(PosN)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private String Comidos_2 (String AntiguaPosicion, String PosN){
        ComerFichaRoja(AntiguaPosicion,PosN);
        
        boton(Comido).setIcon(null);
        
        int p = Character.getNumericValue(Comido.charAt(1));
        int q = Character.getNumericValue(Comido.charAt(0));
        
        Tableros [q][p] = "";
        
        return null;
    }
    
    //--------------------------------------------------------------------------
    
    
    //De ficha a dama-----------------------------------------------------------
    
    private String Dama_N(String posicion){
        int x = Character.getNumericValue(posicion.charAt(1));
        int y = Character.getNumericValue(posicion.charAt(0));
        
        if(y == 0 && x >=0 && x<=7){
            if(Tableros[y][x].equals("Ficha_NP") ){
                Tableros[y][x] = "Ficha_DD";
                boton(posicion).setIcon(new javax.swing.ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Primera unidad/DamasIng_Def/JuegoDeMesaInglesas/src/Imagenes/Dama Negras.png"));
            }
        }
        return null;
    }
    
    //--------------------------------------------------------------------------
    
    
    //Movimiento Damas----------------------------------------------------------
    
    //Damas Negras--------------------------------------------------------------
    
    public boolean VerificarDamaNegra(String posicion){
        int x = Character.getNumericValue(posicion.charAt(1));
        int y = Character.getNumericValue(posicion.charAt(0));
        
        if(!Tableros[y][x].equals("")){
            
            return(Tableros[y][x].charAt(6) == 'D')? true : false;
        }
        return false;
    }
    
    private String MovimientoDamaNegra(String posicion){
        int iz=0;
        
        int x = Character.getNumericValue(posicion.charAt(1));
        int y = Character.getNumericValue(posicion.charAt(0));
        
        if(x == 0 && y == 0){
            for(int q = 0; q<7 ; q++){
                if(Tableros[y][x+q].equals("")){
                    MovValido = (y) + "" + (x+q);
                    PosicionValidoDama[iz] = MovValido;
                    iz++;
                }
            }
            
            for(int q=0 ; q<7; q++){
                if(Tableros[y+q][x].equals("")){
                    MovValido = (y+q) + "" + (x);
                    PosicionValidoDama[iz] = MovValido;
                    iz++;
                }
            }
        }
        
        if(x == 0 && y == 7){
            for(int q = 0; q<7 ; q++){
                if(Tableros[y][x+q].equals("")){
                    MovValido = (y) + "" + (x+q);
                    PosicionValidoDama[iz] = MovValido;
                    iz++;
                }
            }
            
            for(int q=0 ; q<7; q++){
                if(Tableros[y-q][x].equals("")){
                    MovValido = (y-q) + "" + (x);
                    PosicionValidoDama[iz] = MovValido;
                    iz++;
                }
            }
        }
        
        if(x == 7 && y == 7){
            for(int q = 0; q<7 ; q++){
                if(Tableros[y][x-q].equals("")){
                    MovValido = (y) + "" + (x-q);
                    PosicionValidoDama[iz] = MovValido;
                    iz++;
                }
            }
            
            for(int q=0 ; q<7; q++){
                if(Tableros[y-q][x].equals("")){
                    MovValido = (y-q) + "" + (x);
                    PosicionValidoDama[iz] = MovValido;
                    iz++;
                }
            }
        }
        
        if(x == 7 && y == 0){
            for(int q = 0; q<7 ; q++){
                if(Tableros[y][x-q].equals("")){
                    MovValido = (y) + "" + (x-q);
                    PosicionValidoDama[iz] = MovValido;
                    iz++;
                }
            }
            
            for(int q=0 ; q<7; q++){
                if(Tableros[y+q][x].equals("")){
                    MovValido = (y+q) + "" + (x);
                    PosicionValidoDama[iz] = MovValido;
                    iz++;
                }
            }
        }
        
        if(x<=6 && x>=1 && y<=6 && y>=1){
            for(int r =0; r<7; r++){
                if(Tableros[y][x+r].equals("")){
                    MovValido = (y) + "" +(x+r);
                    PosicionValidoDama[iz] = MovValido;
                    iz++;
                }
                
                if(Tableros[y+r][x].equals("")){
                    MovValido = (y+r) + "" +(x);
                    PosicionValidoDama[iz] = MovValido;
                    iz++;
                }
            }
        }
        
        if(y == 0 && x<=6 && x>=1 || y == 7 && x<=6 && x>=1){
            for(int r =0; r<7; r++){
                if(Tableros[y][x+r].equals("")){
                    MovValido = (y) + "" +(x+r);
                    PosicionValidoDama[iz] = MovValido;
                    iz++;
                }
                
                if(Tableros[y+r][x].equals("")){
                    MovValido = (y+r) + "" +(x);
                    PosicionValidoDama[iz] = MovValido;
                    iz++;
                }
            }
        }
        
        if(x == 0 && y<=6 && y>=1 || x == 7 && y<=6 && y>=1){
            for(int r =0; r<7; r++){
                if(Tableros[y][x+r].equals("")){
                    MovValido = (y) + "" +(x+r);
                    PosicionValidoDama[iz] = MovValido;
                    iz++;
                }
                
                if(Tableros[y+r][x].equals("")){
                    MovValido = (y+r) + "" +(x);
                    PosicionValidoDama[iz] = MovValido;
                    iz++;
                }
            }
        }
        
        
        return null;
    }
    
    public boolean VerificarMovDama(String posicion, String PosN){
        MovimientoDamaNegra(posicion);
        
        if(PosicionValidoDama != null){
            for(int o=0; o<PosicionValidoDama.length; o++){
                if(PosicionValidoDama[o].equals(PosN)){
                    return true;
                }
            }
        }
        return false;
    }
}
