
package Logica;

import Graficos.LaberintoDF;
import com.mycompany.laberintodelfauno.LaberintoDelFauno;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;


public class ControlLaberinto implements ActionListener{
    
    public  ControlLaberinto(){
        ButtonGroup group = new ButtonGroup();
        IniciarLaberinto();
        LaberintoDF pggp = new LaberintoDF();
        pggp.setVisible(true);
        BotonAccion();
        
        group.add(LaberintoDF.Ent);
        group.add(LaberintoDF.Par);
        group.add(LaberintoDF.Sal);
        group.add(LaberintoDF.Ejecutar);
    }
    
    private String[][] Laberintos = new String[20][20];
    private String Pos;
    private String PosBot;
    private String PosSalida;
    
    
    
    
    private void IniciarLaberinto(){
        for(int i=0; i<20; i++){
            Laberintos[i][0] = "V";
            Laberintos[i][19] = "V";
        }
        
        for(int j = 0; j<20; j++){
            Laberintos[0][j] = "V";
            Laberintos[19][j] = "V";
        }
        
        for(int i=1; i<19; i++){
            for(int j=1; j<19; j++){
                Laberintos[i][j] = "G";
            }
        }
        
        for(int i=0; i<20; i++){
            for(int j=0; j<20; j++){
                System.out.print(Laberintos[i][j] + "\t");
            }
            System.out.println();
        }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if(LaberintoDF.Par.isSelected()){
            Pos = PosicionBoton(e.getSource());
            ColocarParedes(Pos);
            ColocarParedesGrafico(Pos);
        }
        if(LaberintoDF.Ent.isSelected()){
            Pos = PosicionBoton(e.getSource());
            ColocarEntrada(Pos);
        }
        if(LaberintoDF.Sal.isSelected()){
            Pos = PosicionBoton(e.getSource());
            ColocarSalida(Pos);
        }
        if(LaberintoDF.Ejecutar.isSelected()){
            movimientosBot(PosBot, PosSalida);
        }
        
        
        
        play(Pos);
        
    }
    
    //Necesario para que los botones funcionen----------------------------------
    private void BotonAccion(){
        LaberintoDF.z00.addActionListener(this);
        LaberintoDF.z01.addActionListener(this);
        LaberintoDF.z02.addActionListener(this);
        LaberintoDF.z03.addActionListener(this);
        LaberintoDF.z04.addActionListener(this);
        LaberintoDF.z05.addActionListener(this);
        LaberintoDF.z06.addActionListener(this);
        LaberintoDF.z07.addActionListener(this);
        LaberintoDF.z08.addActionListener(this);
        LaberintoDF.z09.addActionListener(this);    //10
        LaberintoDF.z0a.addActionListener(this);
        LaberintoDF.z0b.addActionListener(this);
        LaberintoDF.z0c.addActionListener(this);
        LaberintoDF.z0d.addActionListener(this);
        LaberintoDF.z0e.addActionListener(this);
        LaberintoDF.z0f.addActionListener(this);
        LaberintoDF.z0g.addActionListener(this);
        LaberintoDF.z0h.addActionListener(this);
        LaberintoDF.z0i.addActionListener(this);
        LaberintoDF.z0j.addActionListener(this);    //20
        
        LaberintoDF.z10.addActionListener(this);
        LaberintoDF.z11.addActionListener(this);
        LaberintoDF.z12.addActionListener(this);
        LaberintoDF.z13.addActionListener(this);
        LaberintoDF.z14.addActionListener(this);
        LaberintoDF.z15.addActionListener(this);
        LaberintoDF.z16.addActionListener(this);
        LaberintoDF.z17.addActionListener(this);
        LaberintoDF.z18.addActionListener(this);
        LaberintoDF.z19.addActionListener(this);    //10
        LaberintoDF.z1a.addActionListener(this);
        LaberintoDF.z1b.addActionListener(this);
        LaberintoDF.z1c.addActionListener(this);
        LaberintoDF.z1d.addActionListener(this);
        LaberintoDF.z1e.addActionListener(this);
        LaberintoDF.z1f.addActionListener(this);
        LaberintoDF.z1g.addActionListener(this);
        LaberintoDF.z1h.addActionListener(this);
        LaberintoDF.z1i.addActionListener(this);
        LaberintoDF.z1j.addActionListener(this);    //20
        
        LaberintoDF.z20.addActionListener(this);
        LaberintoDF.z21.addActionListener(this);
        LaberintoDF.z22.addActionListener(this);
        LaberintoDF.z23.addActionListener(this);
        LaberintoDF.z24.addActionListener(this);
        LaberintoDF.z25.addActionListener(this);
        LaberintoDF.z26.addActionListener(this);
        LaberintoDF.z27.addActionListener(this);
        LaberintoDF.z28.addActionListener(this);
        LaberintoDF.z29.addActionListener(this);    //10
        LaberintoDF.z2a.addActionListener(this);
        LaberintoDF.z2b.addActionListener(this);
        LaberintoDF.z2c.addActionListener(this);
        LaberintoDF.z2d.addActionListener(this);
        LaberintoDF.z2e.addActionListener(this);
        LaberintoDF.z2f.addActionListener(this);
        LaberintoDF.z2g.addActionListener(this);
        LaberintoDF.z2h.addActionListener(this);
        LaberintoDF.z2i.addActionListener(this);
        LaberintoDF.z2j.addActionListener(this);    //20
        
        LaberintoDF.z30.addActionListener(this);
        LaberintoDF.z31.addActionListener(this);
        LaberintoDF.z32.addActionListener(this);
        LaberintoDF.z33.addActionListener(this);
        LaberintoDF.z34.addActionListener(this);
        LaberintoDF.z35.addActionListener(this);
        LaberintoDF.z36.addActionListener(this);
        LaberintoDF.z37.addActionListener(this);
        LaberintoDF.z38.addActionListener(this);
        LaberintoDF.z39.addActionListener(this);    //10
        LaberintoDF.z3a.addActionListener(this);
        LaberintoDF.z3b.addActionListener(this);
        LaberintoDF.z3c.addActionListener(this);
        LaberintoDF.z3d.addActionListener(this);
        LaberintoDF.z3e.addActionListener(this);
        LaberintoDF.z3f.addActionListener(this);
        LaberintoDF.z3g.addActionListener(this);
        LaberintoDF.z3h.addActionListener(this);
        LaberintoDF.z3i.addActionListener(this);
        LaberintoDF.z3j.addActionListener(this);    //20
        
        LaberintoDF.z40.addActionListener(this);
        LaberintoDF.z41.addActionListener(this);
        LaberintoDF.z42.addActionListener(this);
        LaberintoDF.z43.addActionListener(this);
        LaberintoDF.z44.addActionListener(this);
        LaberintoDF.z45.addActionListener(this);
        LaberintoDF.z46.addActionListener(this);
        LaberintoDF.z47.addActionListener(this);
        LaberintoDF.z48.addActionListener(this);
        LaberintoDF.z49.addActionListener(this);    //10
        LaberintoDF.z4a.addActionListener(this);
        LaberintoDF.z4b.addActionListener(this);
        LaberintoDF.z4c.addActionListener(this);
        LaberintoDF.z4d.addActionListener(this);
        LaberintoDF.z4e.addActionListener(this);
        LaberintoDF.z4f.addActionListener(this);
        LaberintoDF.z4g.addActionListener(this);
        LaberintoDF.z4h.addActionListener(this);
        LaberintoDF.z4i.addActionListener(this);
        LaberintoDF.z4j.addActionListener(this);    //20
        
        LaberintoDF.z50.addActionListener(this);
        LaberintoDF.z51.addActionListener(this);
        LaberintoDF.z52.addActionListener(this);
        LaberintoDF.z53.addActionListener(this);
        LaberintoDF.z54.addActionListener(this);
        LaberintoDF.z55.addActionListener(this);
        LaberintoDF.z56.addActionListener(this);
        LaberintoDF.z57.addActionListener(this);
        LaberintoDF.z58.addActionListener(this);
        LaberintoDF.z59.addActionListener(this);    //10
        LaberintoDF.z5a.addActionListener(this);
        LaberintoDF.z5b.addActionListener(this);
        LaberintoDF.z5c.addActionListener(this);
        LaberintoDF.z5d.addActionListener(this);
        LaberintoDF.z5e.addActionListener(this);
        LaberintoDF.z5f.addActionListener(this);
        LaberintoDF.z5g.addActionListener(this);
        LaberintoDF.z5h.addActionListener(this);
        LaberintoDF.z5i.addActionListener(this);
        LaberintoDF.z5j.addActionListener(this);    //20
        
        LaberintoDF.z60.addActionListener(this);
        LaberintoDF.z61.addActionListener(this);
        LaberintoDF.z62.addActionListener(this);
        LaberintoDF.z63.addActionListener(this);
        LaberintoDF.z64.addActionListener(this);
        LaberintoDF.z65.addActionListener(this);
        LaberintoDF.z66.addActionListener(this);
        LaberintoDF.z67.addActionListener(this);
        LaberintoDF.z68.addActionListener(this);
        LaberintoDF.z69.addActionListener(this);    //10
        LaberintoDF.z6a.addActionListener(this);
        LaberintoDF.z6b.addActionListener(this);
        LaberintoDF.z6c.addActionListener(this);
        LaberintoDF.z6d.addActionListener(this);
        LaberintoDF.z6e.addActionListener(this);
        LaberintoDF.z6f.addActionListener(this);
        LaberintoDF.z6g.addActionListener(this);
        LaberintoDF.z6h.addActionListener(this);
        LaberintoDF.z6i.addActionListener(this);
        LaberintoDF.z6j.addActionListener(this);    //20
        
        LaberintoDF.z70.addActionListener(this);
        LaberintoDF.z71.addActionListener(this);
        LaberintoDF.z72.addActionListener(this);
        LaberintoDF.z73.addActionListener(this);
        LaberintoDF.z74.addActionListener(this);
        LaberintoDF.z75.addActionListener(this);
        LaberintoDF.z76.addActionListener(this);
        LaberintoDF.z77.addActionListener(this);
        LaberintoDF.z78.addActionListener(this);
        LaberintoDF.z79.addActionListener(this);    //10
        LaberintoDF.z7a.addActionListener(this);
        LaberintoDF.z7b.addActionListener(this);
        LaberintoDF.z7c.addActionListener(this);
        LaberintoDF.z7d.addActionListener(this);
        LaberintoDF.z7e.addActionListener(this);
        LaberintoDF.z7f.addActionListener(this);
        LaberintoDF.z7g.addActionListener(this);
        LaberintoDF.z7h.addActionListener(this);
        LaberintoDF.z7i.addActionListener(this);
        LaberintoDF.z7j.addActionListener(this);    //20
        
        LaberintoDF.z80.addActionListener(this);
        LaberintoDF.z81.addActionListener(this);
        LaberintoDF.z82.addActionListener(this);
        LaberintoDF.z83.addActionListener(this);
        LaberintoDF.z84.addActionListener(this);
        LaberintoDF.z85.addActionListener(this);
        LaberintoDF.z86.addActionListener(this);
        LaberintoDF.z87.addActionListener(this);
        LaberintoDF.z88.addActionListener(this);
        LaberintoDF.z89.addActionListener(this);    //10
        LaberintoDF.z8a.addActionListener(this);
        LaberintoDF.z8b.addActionListener(this);
        LaberintoDF.z8c.addActionListener(this);
        LaberintoDF.z8d.addActionListener(this);
        LaberintoDF.z8e.addActionListener(this);
        LaberintoDF.z8f.addActionListener(this);
        LaberintoDF.z8g.addActionListener(this);
        LaberintoDF.z8h.addActionListener(this);
        LaberintoDF.z8i.addActionListener(this);
        LaberintoDF.z8j.addActionListener(this);    //20
        
        LaberintoDF.z90.addActionListener(this);
        LaberintoDF.z91.addActionListener(this);
        LaberintoDF.z92.addActionListener(this);
        LaberintoDF.z93.addActionListener(this);
        LaberintoDF.z94.addActionListener(this);
        LaberintoDF.z95.addActionListener(this);
        LaberintoDF.z96.addActionListener(this);
        LaberintoDF.z97.addActionListener(this);
        LaberintoDF.z98.addActionListener(this);
        LaberintoDF.z99.addActionListener(this);    //10
        LaberintoDF.z9a.addActionListener(this);
        LaberintoDF.z9b.addActionListener(this);
        LaberintoDF.z9c.addActionListener(this);
        LaberintoDF.z9d.addActionListener(this);
        LaberintoDF.z9e.addActionListener(this);
        LaberintoDF.z9f.addActionListener(this);
        LaberintoDF.z9g.addActionListener(this);
        LaberintoDF.z9h.addActionListener(this);
        LaberintoDF.z9i.addActionListener(this);
        LaberintoDF.z9j.addActionListener(this);    //20
        
        LaberintoDF.za0.addActionListener(this);
        LaberintoDF.za1.addActionListener(this);
        LaberintoDF.za2.addActionListener(this);
        LaberintoDF.za3.addActionListener(this);
        LaberintoDF.za4.addActionListener(this);
        LaberintoDF.za5.addActionListener(this);
        LaberintoDF.za6.addActionListener(this);
        LaberintoDF.za7.addActionListener(this);
        LaberintoDF.za8.addActionListener(this);
        LaberintoDF.za9.addActionListener(this);    //10
        LaberintoDF.zaa.addActionListener(this);
        LaberintoDF.zab.addActionListener(this);
        LaberintoDF.zac.addActionListener(this);
        LaberintoDF.zad.addActionListener(this);
        LaberintoDF.zae.addActionListener(this);
        LaberintoDF.zaf.addActionListener(this);
        LaberintoDF.zag.addActionListener(this);
        LaberintoDF.zah.addActionListener(this);
        LaberintoDF.zai.addActionListener(this);
        LaberintoDF.zaj.addActionListener(this);    //20
       
        LaberintoDF.zb0.addActionListener(this);
        LaberintoDF.zb1.addActionListener(this);
        LaberintoDF.zb2.addActionListener(this);
        LaberintoDF.zb3.addActionListener(this);
        LaberintoDF.zb4.addActionListener(this);
        LaberintoDF.zb5.addActionListener(this);
        LaberintoDF.zb6.addActionListener(this);
        LaberintoDF.zb7.addActionListener(this);
        LaberintoDF.zb8.addActionListener(this);
        LaberintoDF.zb9.addActionListener(this);    //10
        LaberintoDF.zba.addActionListener(this);
        LaberintoDF.zbb.addActionListener(this);
        LaberintoDF.zbc.addActionListener(this);
        LaberintoDF.zbd.addActionListener(this);
        LaberintoDF.zbe.addActionListener(this);
        LaberintoDF.zbf.addActionListener(this);
        LaberintoDF.zbg.addActionListener(this);
        LaberintoDF.zbh.addActionListener(this);
        LaberintoDF.zbi.addActionListener(this);
        LaberintoDF.zbj.addActionListener(this);    //20
        
        LaberintoDF.zc0.addActionListener(this);
        LaberintoDF.zc1.addActionListener(this);
        LaberintoDF.zc2.addActionListener(this);
        LaberintoDF.zc3.addActionListener(this);
        LaberintoDF.zc4.addActionListener(this);
        LaberintoDF.zc5.addActionListener(this);
        LaberintoDF.zc6.addActionListener(this);
        LaberintoDF.zc7.addActionListener(this);
        LaberintoDF.zc8.addActionListener(this);
        LaberintoDF.zc9.addActionListener(this);    //10
        LaberintoDF.zca.addActionListener(this);
        LaberintoDF.zcb.addActionListener(this);
        LaberintoDF.zcc.addActionListener(this);
        LaberintoDF.zcd.addActionListener(this);
        LaberintoDF.zce.addActionListener(this);
        LaberintoDF.zcf.addActionListener(this);
        LaberintoDF.zcg.addActionListener(this);
        LaberintoDF.zch.addActionListener(this);
        LaberintoDF.zci.addActionListener(this);
        LaberintoDF.zcj.addActionListener(this);    //20
        
        LaberintoDF.zd0.addActionListener(this);
        LaberintoDF.zd1.addActionListener(this);
        LaberintoDF.zd2.addActionListener(this);
        LaberintoDF.zd3.addActionListener(this);
        LaberintoDF.zd4.addActionListener(this);
        LaberintoDF.zd5.addActionListener(this);
        LaberintoDF.zd6.addActionListener(this);
        LaberintoDF.zd7.addActionListener(this);
        LaberintoDF.zd8.addActionListener(this);
        LaberintoDF.zd9.addActionListener(this);    //10
        LaberintoDF.zda.addActionListener(this);
        LaberintoDF.zdb.addActionListener(this);
        LaberintoDF.zdc.addActionListener(this);
        LaberintoDF.zdd.addActionListener(this);
        LaberintoDF.zde.addActionListener(this);
        LaberintoDF.zdf.addActionListener(this);
        LaberintoDF.zdg.addActionListener(this);
        LaberintoDF.zdh.addActionListener(this);
        LaberintoDF.zdi.addActionListener(this);
        LaberintoDF.zdj.addActionListener(this);    //20
        
        LaberintoDF.ze0.addActionListener(this);
        LaberintoDF.ze1.addActionListener(this);
        LaberintoDF.ze2.addActionListener(this);
        LaberintoDF.ze3.addActionListener(this);
        LaberintoDF.ze4.addActionListener(this);
        LaberintoDF.ze5.addActionListener(this);
        LaberintoDF.ze6.addActionListener(this);
        LaberintoDF.ze7.addActionListener(this);
        LaberintoDF.ze8.addActionListener(this);
        LaberintoDF.ze9.addActionListener(this);    //10
        LaberintoDF.zea.addActionListener(this);
        LaberintoDF.zeb.addActionListener(this);
        LaberintoDF.zec.addActionListener(this);
        LaberintoDF.zed.addActionListener(this);
        LaberintoDF.zee.addActionListener(this);
        LaberintoDF.zef.addActionListener(this);
        LaberintoDF.zeg.addActionListener(this);
        LaberintoDF.zeh.addActionListener(this);
        LaberintoDF.zei.addActionListener(this);
        LaberintoDF.zej.addActionListener(this);    //20
        
        LaberintoDF.zf0.addActionListener(this);
        LaberintoDF.zf1.addActionListener(this);
        LaberintoDF.zf2.addActionListener(this);
        LaberintoDF.zf3.addActionListener(this);
        LaberintoDF.zf4.addActionListener(this);
        LaberintoDF.zf5.addActionListener(this);
        LaberintoDF.zf6.addActionListener(this);
        LaberintoDF.zf7.addActionListener(this);
        LaberintoDF.zf8.addActionListener(this);
        LaberintoDF.zf9.addActionListener(this);    //10
        LaberintoDF.zfa.addActionListener(this);
        LaberintoDF.zfb.addActionListener(this);
        LaberintoDF.zfc.addActionListener(this);
        LaberintoDF.zfd.addActionListener(this);
        LaberintoDF.zfe.addActionListener(this);
        LaberintoDF.zff.addActionListener(this);
        LaberintoDF.zfg.addActionListener(this);
        LaberintoDF.zfh.addActionListener(this);
        LaberintoDF.zfi.addActionListener(this);
        LaberintoDF.zfj.addActionListener(this);    //20
        
        LaberintoDF.zg0.addActionListener(this);
        LaberintoDF.zg1.addActionListener(this);
        LaberintoDF.zg2.addActionListener(this);
        LaberintoDF.zg3.addActionListener(this);
        LaberintoDF.zg4.addActionListener(this);
        LaberintoDF.zg5.addActionListener(this);
        LaberintoDF.zg6.addActionListener(this);
        LaberintoDF.zg7.addActionListener(this);
        LaberintoDF.zg8.addActionListener(this);
        LaberintoDF.zg9.addActionListener(this);    //10
        LaberintoDF.zga.addActionListener(this);
        LaberintoDF.zgb.addActionListener(this);
        LaberintoDF.zgc.addActionListener(this);
        LaberintoDF.zgd.addActionListener(this);
        LaberintoDF.zge.addActionListener(this);
        LaberintoDF.zgf.addActionListener(this);
        LaberintoDF.zgg.addActionListener(this);
        LaberintoDF.zgh.addActionListener(this);
        LaberintoDF.zgi.addActionListener(this);
        LaberintoDF.zgj.addActionListener(this);    //20
        
        LaberintoDF.zh0.addActionListener(this);
        LaberintoDF.zh1.addActionListener(this);
        LaberintoDF.zh2.addActionListener(this);
        LaberintoDF.zh3.addActionListener(this);
        LaberintoDF.zh4.addActionListener(this);
        LaberintoDF.zh5.addActionListener(this);
        LaberintoDF.zh6.addActionListener(this);
        LaberintoDF.zh7.addActionListener(this);
        LaberintoDF.zh8.addActionListener(this);
        LaberintoDF.zh9.addActionListener(this);    //10
        LaberintoDF.zha.addActionListener(this);
        LaberintoDF.zhb.addActionListener(this);
        LaberintoDF.zhc.addActionListener(this);
        LaberintoDF.zhd.addActionListener(this);
        LaberintoDF.zhe.addActionListener(this);
        LaberintoDF.zhf.addActionListener(this);
        LaberintoDF.zhg.addActionListener(this);
        LaberintoDF.zhh.addActionListener(this);
        LaberintoDF.zhi.addActionListener(this);
        LaberintoDF.zhj.addActionListener(this);    //20
        
        LaberintoDF.zi0.addActionListener(this);
        LaberintoDF.zi1.addActionListener(this);
        LaberintoDF.zi2.addActionListener(this);
        LaberintoDF.zi3.addActionListener(this);
        LaberintoDF.zi4.addActionListener(this);
        LaberintoDF.zi5.addActionListener(this);
        LaberintoDF.zi6.addActionListener(this);
        LaberintoDF.zi7.addActionListener(this);
        LaberintoDF.zi8.addActionListener(this);
        LaberintoDF.zi9.addActionListener(this);    //10
        LaberintoDF.zia.addActionListener(this);
        LaberintoDF.zib.addActionListener(this);
        LaberintoDF.zic.addActionListener(this);
        LaberintoDF.zid.addActionListener(this);
        LaberintoDF.zie.addActionListener(this);
        LaberintoDF.zif.addActionListener(this);
        LaberintoDF.zig.addActionListener(this);
        LaberintoDF.zih.addActionListener(this);
        LaberintoDF.zii.addActionListener(this);
        LaberintoDF.zij.addActionListener(this);    //20
        
        LaberintoDF.zj0.addActionListener(this);
        LaberintoDF.zj1.addActionListener(this);
        LaberintoDF.zj2.addActionListener(this);
        LaberintoDF.zj3.addActionListener(this);
        LaberintoDF.zj4.addActionListener(this);
        LaberintoDF.zj5.addActionListener(this);
        LaberintoDF.zj6.addActionListener(this);
        LaberintoDF.zj7.addActionListener(this);
        LaberintoDF.zj8.addActionListener(this);
        LaberintoDF.zj9.addActionListener(this);    //10
        LaberintoDF.zja.addActionListener(this);
        LaberintoDF.zjb.addActionListener(this);
        LaberintoDF.zjc.addActionListener(this);
        LaberintoDF.zjd.addActionListener(this);
        LaberintoDF.zje.addActionListener(this);
        LaberintoDF.zjf.addActionListener(this);
        LaberintoDF.zjg.addActionListener(this);
        LaberintoDF.zjh.addActionListener(this);
        LaberintoDF.zji.addActionListener(this);
        LaberintoDF.zjj.addActionListener(this);    //20
        
        LaberintoDF.Ejecutar.addActionListener(this);
        LaberintoDF.Par.addActionListener(this);
        LaberintoDF.Ent.addActionListener(this);
        LaberintoDF.Sal.addActionListener(this);
    }
    //--------------------------------------------------------------------------
    
    //Obtencion de coordenadas--------------------------------------------------
    private JButton boton(String posicion){
        //---------------------------------
        if(posicion.equals("00")){
            return LaberintoDF.z00;
        }else if(posicion.equals("01")){
            return LaberintoDF.z01;
        }else if(posicion.equals("02")){
            return LaberintoDF.z02;
        }else if(posicion.equals("03")){
            return LaberintoDF.z03;
        }else if(posicion.equals("04")){
            return LaberintoDF.z04;
        }else if(posicion.equals("05")){
            return LaberintoDF.z05;
        }else if(posicion.equals("06")){
            return LaberintoDF.z06;
        }else if(posicion.equals("07")){
            return LaberintoDF.z07;
        }else if(posicion.equals("08")){
            return LaberintoDF.z08;
        }else if(posicion.equals("09")){
            return LaberintoDF.z09;
        }else if(posicion.equals("0a")){
            return LaberintoDF.z0a;
        }else if(posicion.equals("0b")){
            return LaberintoDF.z0b;
        }else if(posicion.equals("0c")){
            return LaberintoDF.z0c;
        }else if(posicion.equals("0d")){
            return LaberintoDF.z0d;
        }else if(posicion.equals("0e")){
            return LaberintoDF.z0e;
        }else if(posicion.equals("0f")){
            return LaberintoDF.z0f;
        }else if(posicion.equals("0g")){
            return LaberintoDF.z0g;
        }else if(posicion.equals("0h")){
            return LaberintoDF.z0h;
        }else if(posicion.equals("0i")){
            return LaberintoDF.z0i;
        }else if(posicion.equals("0j")){
            return LaberintoDF.z0j;
        }
        //---------------------------------
        else if(posicion.equals("10")){
            return LaberintoDF.z10;
        }else if(posicion.equals("11")){
            return LaberintoDF.z11;
        }else if(posicion.equals("12")){
            return LaberintoDF.z12;
        }else if(posicion.equals("13")){
            return LaberintoDF.z13;
        }else if(posicion.equals("14")){
            return LaberintoDF.z14;
        }else if(posicion.equals("15")){
            return LaberintoDF.z15;
        }else if(posicion.equals("16")){
            return LaberintoDF.z16;
        }else if(posicion.equals("17")){
            return LaberintoDF.z17;
        }else if(posicion.equals("18")){
            return LaberintoDF.z18;
        }else if(posicion.equals("19")){
            return LaberintoDF.z19;
        }else if(posicion.equals("26") || posicion.equals("1a")){
            return LaberintoDF.z1a;
        }else if(posicion.equals("111") || posicion.equals("1b")){
            return LaberintoDF.z1b;
        }else if(posicion.equals("112") || posicion.equals("1c")){
            return LaberintoDF.z1c;
        }else if(posicion.equals("113") || posicion.equals("1d")){
            return LaberintoDF.z1d;
        }else if(posicion.equals("114") || posicion.equals("1e")){
            return LaberintoDF.z1e;
        }else if(posicion.equals("115") || posicion.equals("1f")){
            return LaberintoDF.z1f;
        }else if(posicion.equals("116") || posicion.equals("1g")){
            return LaberintoDF.z1g;
        }else if(posicion.equals("117") || posicion.equals("1h")){
            return LaberintoDF.z1h;
        }else if(posicion.equals("118") || posicion.equals("1i")){
            return LaberintoDF.z1i;
        }else if(posicion.equals("119") || posicion.equals("1j")){
            return LaberintoDF.z1j;
        }
        //--------------------------------
        else if(posicion.equals("20")){
            return LaberintoDF.z20;
        }else if(posicion.equals("21")){
            return LaberintoDF.z21;
        }else if(posicion.equals("22")){
            return LaberintoDF.z22;
        }else if(posicion.equals("23")){
            return LaberintoDF.z23;
        }else if(posicion.equals("24")){
            return LaberintoDF.z24;
        }else if(posicion.equals("25")){
            return LaberintoDF.z25;
        }else if(posicion.equals("26")){
            return LaberintoDF.z26;
        }else if(posicion.equals("27")){
            return LaberintoDF.z27;
        }else if(posicion.equals("28")){
            return LaberintoDF.z28;
        }else if(posicion.equals("29")){
            return LaberintoDF.z29;
        }else if(posicion.equals("2a") || posicion.equals("210")){
            return LaberintoDF.z2a;
        }else if(posicion.equals("2b") || posicion.equals("211")){
            return LaberintoDF.z2b;
        }else if(posicion.equals("2c") || posicion.equals("212")){
            return LaberintoDF.z2c;
        }else if(posicion.equals("2d") || posicion.equals("213")){
            return LaberintoDF.z2d;
        }else if(posicion.equals("2e") || posicion.equals("214")){
            return LaberintoDF.z2e;
        }else if(posicion.equals("2f") || posicion.equals("215")){
            return LaberintoDF.z2f;
        }else if(posicion.equals("2g") || posicion.equals("216")){
            return LaberintoDF.z2g;
        }else if(posicion.equals("2h") || posicion.equals("217")){
            return LaberintoDF.z2h;
        }else if(posicion.equals("2i") || posicion.equals("218")){
            return LaberintoDF.z2i;
        }else if(posicion.equals("2j") || posicion.equals("219")){
            return LaberintoDF.z2j;
        }
        //--------------------------------
        else if(posicion.equals("30")){
            return LaberintoDF.z30;
        }else if(posicion.equals("31")){
            return LaberintoDF.z31;
        }else if(posicion.equals("32")){
            return LaberintoDF.z32;
        }else if(posicion.equals("33")){
            return LaberintoDF.z33;
        }else if(posicion.equals("34")){
            return LaberintoDF.z34;
        }else if(posicion.equals("35")){
            return LaberintoDF.z35;
        }else if(posicion.equals("36")){
            return LaberintoDF.z36;
        }else if(posicion.equals("37")){
            return LaberintoDF.z37;
        }else if(posicion.equals("38")){
            return LaberintoDF.z38;
        }else if(posicion.equals("39")){
            return LaberintoDF.z39;
        }else if(posicion.equals("3a") || posicion.equals("310")){
            return LaberintoDF.z3a;
        }else if(posicion.equals("3b") || posicion.equals("311")){
            return LaberintoDF.z3b;
        }else if(posicion.equals("3c") || posicion.equals("312")){
            return LaberintoDF.z3c;
        }else if(posicion.equals("3d") || posicion.equals("313")){
            return LaberintoDF.z3d;
        }else if(posicion.equals("3e") || posicion.equals("314")){
            return LaberintoDF.z3e;
        }else if(posicion.equals("3f") || posicion.equals("315")){
            return LaberintoDF.z3f;
        }else if(posicion.equals("3g") || posicion.equals("316")){
            return LaberintoDF.z3g;
        }else if(posicion.equals("3h") || posicion.equals("317")){
            return LaberintoDF.z3h;
        }else if(posicion.equals("3i") || posicion.equals("318")){
            return LaberintoDF.z3i;
        }else if(posicion.equals("3j") || posicion.equals("319")){
            return LaberintoDF.z3j;
        }
        //--------------------------------
        else if(posicion.equals("40")){
            return LaberintoDF.z40;
        }else if(posicion.equals("41")){
            return LaberintoDF.z41;
        }else if(posicion.equals("42")){
            return LaberintoDF.z42;
        }else if(posicion.equals("43")){
            return LaberintoDF.z43;
        }else if(posicion.equals("44")){
            return LaberintoDF.z44;
        }else if(posicion.equals("45")){
            return LaberintoDF.z45;
        }else if(posicion.equals("46")){
            return LaberintoDF.z46;
        }else if(posicion.equals("47")){
            return LaberintoDF.z47;
        }else if(posicion.equals("48")){
            return LaberintoDF.z48;
        }else if(posicion.equals("49")){
            return LaberintoDF.z49;
        }else if(posicion.equals("4a") || posicion.equals("410")){
            return LaberintoDF.z4a;
        }else if(posicion.equals("4b") || posicion.equals("411")){
            return LaberintoDF.z4b;
        }else if(posicion.equals("4c") || posicion.equals("412")){
            return LaberintoDF.z4c;
        }else if(posicion.equals("4d") || posicion.equals("413")){
            return LaberintoDF.z4d;
        }else if(posicion.equals("4e") || posicion.equals("414")){
            return LaberintoDF.z4e;
        }else if(posicion.equals("4f") || posicion.equals("415")){
            return LaberintoDF.z4f;
        }else if(posicion.equals("4g") || posicion.equals("416")){
            return LaberintoDF.z4g;
        }else if(posicion.equals("4h") || posicion.equals("417")){
            return LaberintoDF.z4h;
        }else if(posicion.equals("4i") || posicion.equals("418")){
            return LaberintoDF.z4i;
        }else if(posicion.equals("4j") || posicion.equals("419")){
            return LaberintoDF.z4j;
        }
        //--------------------------------
        else if(posicion.equals("50")){
            return LaberintoDF.z50;
        }else if(posicion.equals("51")){
            return LaberintoDF.z51;
        }else if(posicion.equals("52")){
            return LaberintoDF.z52;
        }else if(posicion.equals("53")){
            return LaberintoDF.z53;
        }else if(posicion.equals("54")){
            return LaberintoDF.z54;
        }else if(posicion.equals("55")){
            return LaberintoDF.z55;
        }else if(posicion.equals("56")){
            return LaberintoDF.z56;
        }else if(posicion.equals("57")){
            return LaberintoDF.z57;
        }else if(posicion.equals("58")){
            return LaberintoDF.z58;
        }else if(posicion.equals("59")){
            return LaberintoDF.z59;
        }else if(posicion.equals("5a") || posicion.equals("510")){
            return LaberintoDF.z5a;
        }else if(posicion.equals("5b") || posicion.equals("511")){
            return LaberintoDF.z5b;
        }else if(posicion.equals("5c") || posicion.equals("512")){
            return LaberintoDF.z5c;
        }else if(posicion.equals("5d") || posicion.equals("513")){
            return LaberintoDF.z5d;
        }else if(posicion.equals("5e") || posicion.equals("514")){
            return LaberintoDF.z5e;
        }else if(posicion.equals("5f") || posicion.equals("515")){
            return LaberintoDF.z5f;
        }else if(posicion.equals("5g") || posicion.equals("516")){
            return LaberintoDF.z5g;
        }else if(posicion.equals("5h") || posicion.equals("517")){
            return LaberintoDF.z5h;
        }else if(posicion.equals("5i") || posicion.equals("518")){
            return LaberintoDF.z5i;
        }else if(posicion.equals("5j") || posicion.equals("519")){
            return LaberintoDF.z5j;
        }
        //--------------------------------
        else if(posicion.equals("60")){
            return LaberintoDF.z60;
        }else if(posicion.equals("61")){
            return LaberintoDF.z61;
        }else if(posicion.equals("62")){
            return LaberintoDF.z62;
        }else if(posicion.equals("63")){
            return LaberintoDF.z63;
        }else if(posicion.equals("64")){
            return LaberintoDF.z64;
        }else if(posicion.equals("65")){
            return LaberintoDF.z65;
        }else if(posicion.equals("66")){
            return LaberintoDF.z66;
        }else if(posicion.equals("67")){
            return LaberintoDF.z67;
        }else if(posicion.equals("68")){
            return LaberintoDF.z68;
        }else if(posicion.equals("69")){
            return LaberintoDF.z69;
        }else if(posicion.equals("6a") || posicion.equals("610")){
            return LaberintoDF.z6a;
        }else if(posicion.equals("6b") || posicion.equals("611")){
            return LaberintoDF.z6b;
        }else if(posicion.equals("6c") || posicion.equals("612")){
            return LaberintoDF.z6c;
        }else if(posicion.equals("6d") || posicion.equals("613")){
            return LaberintoDF.z6d;
        }else if(posicion.equals("6e") || posicion.equals("614")){
            return LaberintoDF.z6e;
        }else if(posicion.equals("6f") || posicion.equals("615")){
            return LaberintoDF.z6f;
        }else if(posicion.equals("6g") || posicion.equals("616")){
            return LaberintoDF.z6g;
        }else if(posicion.equals("6h") || posicion.equals("617")){
            return LaberintoDF.z6h;
        }else if(posicion.equals("6i") || posicion.equals("618")){
            return LaberintoDF.z6i;
        }else if(posicion.equals("6j") || posicion.equals("619")){
            return LaberintoDF.z6j;
        }
        //--------------------------------
        else if(posicion.equals("70")){
            return LaberintoDF.z70;
        }else if(posicion.equals("71")){
            return LaberintoDF.z71;
        }else if(posicion.equals("72")){
            return LaberintoDF.z72;
        }else if(posicion.equals("73")){
            return LaberintoDF.z73;
        }else if(posicion.equals("74")){
            return LaberintoDF.z74;
        }else if(posicion.equals("75")){
            return LaberintoDF.z75;
        }else if(posicion.equals("76")){
            return LaberintoDF.z76;
        }else if(posicion.equals("77")){
            return LaberintoDF.z77;
        }else if(posicion.equals("78")){
            return LaberintoDF.z78;
        }else if(posicion.equals("79")){
            return LaberintoDF.z79;
        }else if(posicion.equals("7a") || posicion.equals("710")){
            return LaberintoDF.z7a;
        }else if(posicion.equals("7b") || posicion.equals("711")){
            return LaberintoDF.z7b;
        }else if(posicion.equals("7c") || posicion.equals("712")){
            return LaberintoDF.z7c;
        }else if(posicion.equals("7d") || posicion.equals("713")){
            return LaberintoDF.z7d;
        }else if(posicion.equals("7e") || posicion.equals("714")){
            return LaberintoDF.z7e;
        }else if(posicion.equals("7f") || posicion.equals("715")){
            return LaberintoDF.z7f;
        }else if(posicion.equals("7g") || posicion.equals("716")){
            return LaberintoDF.z7g;
        }else if(posicion.equals("7h") || posicion.equals("717")){
            return LaberintoDF.z7h;
        }else if(posicion.equals("7i") || posicion.equals("718")){
            return LaberintoDF.z7i;
        }else if(posicion.equals("7j") || posicion.equals("719")){
            return LaberintoDF.z7j;
        }
        //--------------------------------
        else if(posicion.equals("80")){
            return LaberintoDF.z80;
        }else if(posicion.equals("81")){
            return LaberintoDF.z81;
        }else if(posicion.equals("82")){
            return LaberintoDF.z82;
        }else if(posicion.equals("83")){
            return LaberintoDF.z83;
        }else if(posicion.equals("84")){
            return LaberintoDF.z84;
        }else if(posicion.equals("85")){
            return LaberintoDF.z85;
        }else if(posicion.equals("86")){
            return LaberintoDF.z86;
        }else if(posicion.equals("87")){
            return LaberintoDF.z87;
        }else if(posicion.equals("88")){
            return LaberintoDF.z88;
        }else if(posicion.equals("89")){
            return LaberintoDF.z89;
        }else if(posicion.equals("8a") || posicion.equals("810")){
            return LaberintoDF.z8a;
        }else if(posicion.equals("8b") || posicion.equals("811")){
            return LaberintoDF.z8b;
        }else if(posicion.equals("8c") || posicion.equals("812")){
            return LaberintoDF.z8c;
        }else if(posicion.equals("8d") || posicion.equals("813")){
            return LaberintoDF.z8d;
        }else if(posicion.equals("8e") || posicion.equals("814")){
            return LaberintoDF.z8e;
        }else if(posicion.equals("8f") || posicion.equals("815")){
            return LaberintoDF.z8f;
        }else if(posicion.equals("8g") || posicion.equals("816")){
            return LaberintoDF.z8g;
        }else if(posicion.equals("8h") || posicion.equals("817")){
            return LaberintoDF.z8h;
        }else if(posicion.equals("8i") || posicion.equals("818")){
            return LaberintoDF.z8i;
        }else if(posicion.equals("8j") || posicion.equals("819")){
            return LaberintoDF.z8j;
        }
        //--------------------------------
        else if(posicion.equals("90")){
            return LaberintoDF.z90;
        }else if(posicion.equals("91")){
            return LaberintoDF.z91;
        }else if(posicion.equals("92")){
            return LaberintoDF.z92;
        }else if(posicion.equals("93")){
            return LaberintoDF.z93;
        }else if(posicion.equals("94")){
            return LaberintoDF.z94;
        }else if(posicion.equals("95")){
            return LaberintoDF.z95;
        }else if(posicion.equals("96")){
            return LaberintoDF.z96;
        }else if(posicion.equals("97")){
            return LaberintoDF.z97;
        }else if(posicion.equals("98")){
            return LaberintoDF.z98;
        }else if(posicion.equals("99")){
            return LaberintoDF.z99;
        }else if(posicion.equals("9a") || posicion.equals("910")){
            return LaberintoDF.z9a;
        }else if(posicion.equals("9b") || posicion.equals("911")){
            return LaberintoDF.z9b;
        }else if(posicion.equals("9c") || posicion.equals("912")){
            return LaberintoDF.z9c;
        }else if(posicion.equals("9d") || posicion.equals("913")){
            return LaberintoDF.z9d;
        }else if(posicion.equals("9e") || posicion.equals("914")){
            return LaberintoDF.z9e;
        }else if(posicion.equals("9f") || posicion.equals("915")){
            return LaberintoDF.z9f;
        }else if(posicion.equals("9g") || posicion.equals("916")){
            return LaberintoDF.z9g;
        }else if(posicion.equals("9h") || posicion.equals("917")){
            return LaberintoDF.z9h;
        }else if(posicion.equals("9i") || posicion.equals("918")){
            return LaberintoDF.z9i;
        }else if(posicion.equals("9j") || posicion.equals("919")){
            return LaberintoDF.z9j;
        }
        //--------------------------------
        else if(posicion.equals("a0") || posicion.equals("100")){
            return LaberintoDF.za0;
        }else if(posicion.equals("a1") || posicion.equals("101")){
            return LaberintoDF.za1;
        }else if(posicion.equals("a2") || posicion.equals("102")){
            return LaberintoDF.za2;
        }else if(posicion.equals("a3") || posicion.equals("103")){
            return LaberintoDF.za3;
        }else if(posicion.equals("a4") || posicion.equals("104")){
            return LaberintoDF.za4;
        }else if(posicion.equals("a5") || posicion.equals("105")){
            return LaberintoDF.za5;
        }else if(posicion.equals("a6") || posicion.equals("106")){
            return LaberintoDF.za6;
        }else if(posicion.equals("a7") || posicion.equals("107")){
            return LaberintoDF.za7;
        }else if(posicion.equals("a8") || posicion.equals("108")){
            return LaberintoDF.za8;
        }else if(posicion.equals("a9") || posicion.equals("109")){
            return LaberintoDF.za9;
        }else if(posicion.equals("aa") || posicion.equals("1010")){
            return LaberintoDF.zaa;
        }else if(posicion.equals("ab") || posicion.equals("1011")){
            return LaberintoDF.zab;
        }else if(posicion.equals("ac") || posicion.equals("1012")){
            return LaberintoDF.zac;
        }else if(posicion.equals("ad") || posicion.equals("1013")){
            return LaberintoDF.zad;
        }else if(posicion.equals("ae") || posicion.equals("1014")){
            return LaberintoDF.zae;
        }else if(posicion.equals("af") || posicion.equals("1015")){
            return LaberintoDF.zaf;
        }else if(posicion.equals("ag") || posicion.equals("1016")){
            return LaberintoDF.zag;
        }else if(posicion.equals("ah") || posicion.equals("1017")){
            return LaberintoDF.zah;
        }else if(posicion.equals("ai") || posicion.equals("1018")){
            return LaberintoDF.zai;
        }else if(posicion.equals("aj") || posicion.equals("1019")){
            return LaberintoDF.zaj;
        }
        //--------------------------------
        else if(posicion.equals("b0") || posicion.equals("110")){
            return LaberintoDF.zb0;
        }else if(posicion.equals("b1") || posicion.equals("1771")){
            return LaberintoDF.zb1;
        }else if(posicion.equals("b2") || posicion.equals("1782")){
            return LaberintoDF.zb2;
        }else if(posicion.equals("b3") || posicion.equals("1793")){
            return LaberintoDF.zb3;
        }else if(posicion.equals("b4") || posicion.equals("1804")){
            return LaberintoDF.zb4;
        }else if(posicion.equals("b5") || posicion.equals("1815")){
            return LaberintoDF.zb5;
        }else if(posicion.equals("b6") || posicion.equals("1826")){
            return LaberintoDF.zb6;
        }else if(posicion.equals("b7") || posicion.equals("1837")){
            return LaberintoDF.zb7;
        }else if(posicion.equals("b8") || posicion.equals("1848")){
            return LaberintoDF.zb8;
        }else if(posicion.equals("b9") || posicion.equals("1859")){
            return LaberintoDF.zb9;
        }else if(posicion.equals("ba") || posicion.equals("1110")){
            return LaberintoDF.zba;
        }else if(posicion.equals("bb") || posicion.equals("1111")){
            return LaberintoDF.zbb;
        }else if(posicion.equals("bc") || posicion.equals("1112")){
            return LaberintoDF.zbc;
        }else if(posicion.equals("bd") || posicion.equals("1113")){
            return LaberintoDF.zbd;
        }else if(posicion.equals("be") || posicion.equals("1114")){
            return LaberintoDF.zbe;
        }else if(posicion.equals("bf") || posicion.equals("1115")){
            return LaberintoDF.zbf;
        }else if(posicion.equals("bg") || posicion.equals("1116")){
            return LaberintoDF.zbg;
        }else if(posicion.equals("bh") || posicion.equals("1117")){
            return LaberintoDF.zbh;
        }else if(posicion.equals("bi") || posicion.equals("1118")){
            return LaberintoDF.zbi;
        }else if(posicion.equals("bj") || posicion.equals("1119")){
            return LaberintoDF.zbj;
        }
        //--------------------------------
        else if(posicion.equals("c0") || posicion.equals("120")){
            return LaberintoDF.zc0;
        }else if(posicion.equals("c1") || posicion.equals("121")){
            return LaberintoDF.zc1;
        }else if(posicion.equals("c2") || posicion.equals("122")){
            return LaberintoDF.zc2;
        }else if(posicion.equals("c3") || posicion.equals("123")){
            return LaberintoDF.zc3;
        }else if(posicion.equals("c4") || posicion.equals("124")){
            return LaberintoDF.zc4;
        }else if(posicion.equals("c5") || posicion.equals("125")){
            return LaberintoDF.zc5;
        }else if(posicion.equals("c6") || posicion.equals("126")){
            return LaberintoDF.zc6;
        }else if(posicion.equals("c7") || posicion.equals("127")){
            return LaberintoDF.zc7;
        }else if(posicion.equals("c8") || posicion.equals("128")){
            return LaberintoDF.zc8;
        }else if(posicion.equals("c9") || posicion.equals("129")){
            return LaberintoDF.zc9;
        }else if(posicion.equals("ca") || posicion.equals("1210")){
            return LaberintoDF.zca;
        }else if(posicion.equals("cb") || posicion.equals("1211")){
            return LaberintoDF.zcb;
        }else if(posicion.equals("cc") || posicion.equals("1212")){
            return LaberintoDF.zcc;
        }else if(posicion.equals("cd") || posicion.equals("1213")){
            return LaberintoDF.zcd;
        }else if(posicion.equals("ce") || posicion.equals("1214")){
            return LaberintoDF.zce;
        }else if(posicion.equals("cf") || posicion.equals("1215")){
            return LaberintoDF.zcf;
        }else if(posicion.equals("cg") || posicion.equals("1216")){
            return LaberintoDF.zcg;
        }else if(posicion.equals("ch") || posicion.equals("1217")){
            return LaberintoDF.zch;
        }else if(posicion.equals("ci") || posicion.equals("1218")){
            return LaberintoDF.zci;
        }else if(posicion.equals("cj") || posicion.equals("1219")){
            return LaberintoDF.zcj;
        }
        //--------------------------------
        else if(posicion.equals("d0") || posicion.equals("130")){
            return LaberintoDF.zd0;
        }else if(posicion.equals("d1") || posicion.equals("131")){
            return LaberintoDF.zd1;
        }else if(posicion.equals("d2") || posicion.equals("132")){
            return LaberintoDF.zd2;
        }else if(posicion.equals("d3") || posicion.equals("133")){
            return LaberintoDF.zd3;
        }else if(posicion.equals("d4") || posicion.equals("134")){
            return LaberintoDF.zd4;
        }else if(posicion.equals("d5") || posicion.equals("135")){
            return LaberintoDF.zd5;
        }else if(posicion.equals("d6") || posicion.equals("136")){
            return LaberintoDF.zd6;
        }else if(posicion.equals("d7") || posicion.equals("137")){
            return LaberintoDF.zd7;
        }else if(posicion.equals("d8") || posicion.equals("138")){
            return LaberintoDF.zd8;
        }else if(posicion.equals("d9") || posicion.equals("139")){
            return LaberintoDF.zd9;
        }else if(posicion.equals("da") || posicion.equals("1310")){
            return LaberintoDF.zda;
        }else if(posicion.equals("db") || posicion.equals("1311")){
            return LaberintoDF.zdb;
        }else if(posicion.equals("dc") || posicion.equals("1312")){
            return LaberintoDF.zdc;
        }else if(posicion.equals("dd") || posicion.equals("1313")){
            return LaberintoDF.zdd;
        }else if(posicion.equals("de") || posicion.equals("1314")){
            return LaberintoDF.zde;
        }else if(posicion.equals("df") || posicion.equals("1315")){
            return LaberintoDF.zdf;
        }else if(posicion.equals("dg") || posicion.equals("1316")){
            return LaberintoDF.zdg;
        }else if(posicion.equals("dh") || posicion.equals("1317")){
            return LaberintoDF.zdh;
        }else if(posicion.equals("di") || posicion.equals("1318")){
            return LaberintoDF.zdi;
        }else if(posicion.equals("dj") || posicion.equals("1319")){
            return LaberintoDF.zdj;
        }
        //--------------------------------
        else if(posicion.equals("e0") || posicion.equals("140")){
            return LaberintoDF.ze0;
        }else if(posicion.equals("e1") || posicion.equals("141")){
            return LaberintoDF.ze1;
        }else if(posicion.equals("e2") || posicion.equals("142")){
            return LaberintoDF.ze2;
        }else if(posicion.equals("e3") || posicion.equals("143")){
            return LaberintoDF.ze3;
        }else if(posicion.equals("e4") || posicion.equals("144")){
            return LaberintoDF.ze4;
        }else if(posicion.equals("e5") || posicion.equals("145")){
            return LaberintoDF.ze5;
        }else if(posicion.equals("e6") || posicion.equals("146")){
            return LaberintoDF.ze6;
        }else if(posicion.equals("e7") || posicion.equals("147")){
            return LaberintoDF.ze7;
        }else if(posicion.equals("e8") || posicion.equals("148")){
            return LaberintoDF.ze8;
        }else if(posicion.equals("e9") || posicion.equals("149")){
            return LaberintoDF.ze9;
        }else if(posicion.equals("ea") || posicion.equals("1410")){
            return LaberintoDF.zea;
        }else if(posicion.equals("eb") || posicion.equals("1411")){
            return LaberintoDF.zeb;
        }else if(posicion.equals("ec") || posicion.equals("1412")){
            return LaberintoDF.zec;
        }else if(posicion.equals("ed") || posicion.equals("1413")){
            return LaberintoDF.zed;
        }else if(posicion.equals("ee") || posicion.equals("1414")){
            return LaberintoDF.zee;
        }else if(posicion.equals("ef") || posicion.equals("1415")){
            return LaberintoDF.zef;
        }else if(posicion.equals("eg") || posicion.equals("1416")){
            return LaberintoDF.zeg;
        }else if(posicion.equals("eh") || posicion.equals("1417")){
            return LaberintoDF.zeh;
        }else if(posicion.equals("ei") || posicion.equals("1418")){
            return LaberintoDF.zei;
        }else if(posicion.equals("ej") || posicion.equals("1419")){
            return LaberintoDF.zej;
        }
        //---------------------------------
        else if(posicion.equals("f0")|| posicion.equals("150")){
            return LaberintoDF.zf0;
        }else if(posicion.equals("f1")|| posicion.equals("151")){
            return LaberintoDF.zf1;
        }else if(posicion.equals("f2")|| posicion.equals("152")){
            return LaberintoDF.zf2;
        }else if(posicion.equals("f3")|| posicion.equals("153")){
            return LaberintoDF.zf3;
        }else if(posicion.equals("f4")|| posicion.equals("154")){
            return LaberintoDF.zf4;
        }else if(posicion.equals("f5")|| posicion.equals("155")){
            return LaberintoDF.zf5;
        }else if(posicion.equals("f6")|| posicion.equals("156")){
            return LaberintoDF.zf6;
        }else if(posicion.equals("f7")|| posicion.equals("157")){
            return LaberintoDF.zf7;
        }else if(posicion.equals("f8")|| posicion.equals("158")){
            return LaberintoDF.zf8;
        }else if(posicion.equals("f9")|| posicion.equals("159")){
            return LaberintoDF.zf9;
        }else if(posicion.equals("fa")|| posicion.equals("1510")){
            return LaberintoDF.zfa;
        }else if(posicion.equals("fb")|| posicion.equals("1511")){
            return LaberintoDF.zfb;
        }else if(posicion.equals("fc")|| posicion.equals("1512")){
            return LaberintoDF.zfc;
        }else if(posicion.equals("fd")|| posicion.equals("1513")){
            return LaberintoDF.zfd;
        }else if(posicion.equals("fe")|| posicion.equals("1514")){
            return LaberintoDF.zfe;
        }else if(posicion.equals("ff")|| posicion.equals("1515")){
            return LaberintoDF.zff;
        }else if(posicion.equals("fg")|| posicion.equals("1516")){
            return LaberintoDF.zfg;
        }else if(posicion.equals("fh")|| posicion.equals("1517")){
            return LaberintoDF.zfh;
        }else if(posicion.equals("fi")|| posicion.equals("1518")){
            return LaberintoDF.zfi;
        }else if(posicion.equals("fj")|| posicion.equals("1519")){
            return LaberintoDF.zfj;
        }
        //--------------------------------
        else if(posicion.equals("g0")|| posicion.equals("160")){
            return LaberintoDF.zg0;
        }else if(posicion.equals("g1")|| posicion.equals("161")){
            return LaberintoDF.zg1;
        }else if(posicion.equals("g2")|| posicion.equals("162")){
            return LaberintoDF.zg2;
        }else if(posicion.equals("g3")|| posicion.equals("163")){
            return LaberintoDF.zg3;
        }else if(posicion.equals("g4")|| posicion.equals("164")){
            return LaberintoDF.zg4;
        }else if(posicion.equals("g5")|| posicion.equals("165")){
            return LaberintoDF.zg5;
        }else if(posicion.equals("g6")|| posicion.equals("166")){
            return LaberintoDF.zg6;
        }else if(posicion.equals("g7")|| posicion.equals("167")){
            return LaberintoDF.zg7;
        }else if(posicion.equals("g8")|| posicion.equals("168")){
            return LaberintoDF.zg8;
        }else if(posicion.equals("g9")|| posicion.equals("169")){
            return LaberintoDF.zg9;
        }else if(posicion.equals("ga")|| posicion.equals("1610")){
            return LaberintoDF.zga;
        }else if(posicion.equals("gb")|| posicion.equals("1611")){
            return LaberintoDF.zgb;
        }else if(posicion.equals("gc")|| posicion.equals("1612")){
            return LaberintoDF.zgc;
        }else if(posicion.equals("gd")|| posicion.equals("1613")){
            return LaberintoDF.zgd;
        }else if(posicion.equals("ge")|| posicion.equals("1614")){
            return LaberintoDF.zge;
        }else if(posicion.equals("gf")|| posicion.equals("1615")){
            return LaberintoDF.zgf;
        }else if(posicion.equals("gg")|| posicion.equals("1616")){
            return LaberintoDF.zgg;
        }else if(posicion.equals("gh")|| posicion.equals("1617")){
            return LaberintoDF.zgh;
        }else if(posicion.equals("gi")|| posicion.equals("1618")){
            return LaberintoDF.zgi;
        }else if(posicion.equals("gj")|| posicion.equals("1619")){
            return LaberintoDF.zgj;
        }
        //-------------------------------
        else if(posicion.equals("h0")|| posicion.equals("170")){
            return LaberintoDF.zh0;
        }else if(posicion.equals("h1")|| posicion.equals("171")){
            return LaberintoDF.zh1;
        }else if(posicion.equals("h2")|| posicion.equals("172")){
            return LaberintoDF.zh2;
        }else if(posicion.equals("h3")|| posicion.equals("173")){
            return LaberintoDF.zh3;
        }else if(posicion.equals("h4")|| posicion.equals("174")){
            return LaberintoDF.zh4;
        }else if(posicion.equals("h5")|| posicion.equals("175")){
            return LaberintoDF.zh5;
        }else if(posicion.equals("h6")|| posicion.equals("176")){
            return LaberintoDF.zh6;
        }else if(posicion.equals("h7")|| posicion.equals("177")){
            return LaberintoDF.zh7;
        }else if(posicion.equals("h8")|| posicion.equals("178")){
            return LaberintoDF.zh8;
        }else if(posicion.equals("h9")|| posicion.equals("179")){
            return LaberintoDF.zh9;
        }else if(posicion.equals("ha")|| posicion.equals("1710")){
            return LaberintoDF.zha;
        }else if(posicion.equals("hb")|| posicion.equals("1711")){
            return LaberintoDF.zhb;
        }else if(posicion.equals("hc")|| posicion.equals("1712")){
            return LaberintoDF.zhc;
        }else if(posicion.equals("hd")|| posicion.equals("1713")){
            return LaberintoDF.zhd;
        }else if(posicion.equals("he")|| posicion.equals("1714")){
            return LaberintoDF.zhe;
        }else if(posicion.equals("hf")|| posicion.equals("1715")){
            return LaberintoDF.zhf;
        }else if(posicion.equals("hg")|| posicion.equals("1716")){
            return LaberintoDF.zhg;
        }else if(posicion.equals("hh")|| posicion.equals("1717")){
            return LaberintoDF.zhh;
        }else if(posicion.equals("hi")|| posicion.equals("1718")){
            return LaberintoDF.zhi;
        }else if(posicion.equals("hj")|| posicion.equals("1719")){
            return LaberintoDF.zhj;
        }
        //-------------------------------
        else if(posicion.equals("i0")|| posicion.equals("180")){
            return LaberintoDF.zi0;
        }else if(posicion.equals("i1")|| posicion.equals("181")){
            return LaberintoDF.zi1;
        }else if(posicion.equals("i2")|| posicion.equals("182")){
            return LaberintoDF.zi2;
        }else if(posicion.equals("i3")|| posicion.equals("183")){
            return LaberintoDF.zi3;
        }else if(posicion.equals("i4")|| posicion.equals("184")){
            return LaberintoDF.zi4;
        }else if(posicion.equals("i5")|| posicion.equals("185")){
            return LaberintoDF.zi5;
        }else if(posicion.equals("i6")|| posicion.equals("186")){
            return LaberintoDF.zi6;
        }else if(posicion.equals("i7")|| posicion.equals("187")){
            return LaberintoDF.zi7;
        }else if(posicion.equals("i8")|| posicion.equals("188")){
            return LaberintoDF.zi8;
        }else if(posicion.equals("i9")|| posicion.equals("189")){
            return LaberintoDF.zi9;
        }else if(posicion.equals("ia")|| posicion.equals("1810")){
            return LaberintoDF.zia;
        }else if(posicion.equals("ib")|| posicion.equals("1811")){
            return LaberintoDF.zib;
        }else if(posicion.equals("ic")|| posicion.equals("1812")){
            return LaberintoDF.zic;
        }else if(posicion.equals("id")|| posicion.equals("1813")){
            return LaberintoDF.zid;
        }else if(posicion.equals("ie")|| posicion.equals("1814")){
            return LaberintoDF.zie;
        }else if(posicion.equals("if")|| posicion.equals("1815")){
            return LaberintoDF.zif;
        }else if(posicion.equals("ig")|| posicion.equals("1816")){
            return LaberintoDF.zig;
        }else if(posicion.equals("ih")|| posicion.equals("1817")){
            return LaberintoDF.zih;
        }else if(posicion.equals("ii")|| posicion.equals("1818")){
            return LaberintoDF.zii;
        }else if(posicion.equals("ij")|| posicion.equals("1819")){
            return LaberintoDF.zij;
        }
        //-------------------------------
        else if(posicion.equals("j0")|| posicion.equals("190")){
            return LaberintoDF.zj0;
        }else if(posicion.equals("j1")|| posicion.equals("191")){
            return LaberintoDF.zj1;
        }else if(posicion.equals("j2")|| posicion.equals("192")){
            return LaberintoDF.zj2;
        }else if(posicion.equals("j3")|| posicion.equals("193")){
            return LaberintoDF.zj3;
        }else if(posicion.equals("j4")|| posicion.equals("194")){
            return LaberintoDF.zj4;
        }else if(posicion.equals("j5")|| posicion.equals("195")){
            return LaberintoDF.zj5;
        }else if(posicion.equals("j6")|| posicion.equals("196")){
            return LaberintoDF.zj6;
        }else if(posicion.equals("j7")|| posicion.equals("197")){
            return LaberintoDF.zj7;
        }else if(posicion.equals("j8")|| posicion.equals("198")){
            return LaberintoDF.zj8;
        }else if(posicion.equals("j9")|| posicion.equals("199")){
            return LaberintoDF.zj9;
        }else if(posicion.equals("ja")|| posicion.equals("1910")){
            return LaberintoDF.zja;
        }else if(posicion.equals("jb")|| posicion.equals("1911")){
            return LaberintoDF.zjb;
        }else if(posicion.equals("jc")|| posicion.equals("1912")){
            return LaberintoDF.zjc;
        }else if(posicion.equals("jd")|| posicion.equals("1913")){
            return LaberintoDF.zjd;
        }else if(posicion.equals("je")|| posicion.equals("1914")){
            return LaberintoDF.zje;
        }else if(posicion.equals("jf")|| posicion.equals("1915")){
            return LaberintoDF.zjf;
        }else if(posicion.equals("jg")|| posicion.equals("1916")){
            return LaberintoDF.zjg;
        }else if(posicion.equals("jh")|| posicion.equals("1917")){
            return LaberintoDF.zjh;
        }else if(posicion.equals("ji")|| posicion.equals("1918")){
            return LaberintoDF.zji;
        }else if(posicion.equals("jj")|| posicion.equals("1919")){
            return LaberintoDF.zjj;
        }
        return null;
    }
    private String PosicionBoton(Object boton){
        
        if(boton == LaberintoDF.z00){
            return "00";
        }else if(boton == LaberintoDF.z01){
            return "01";
        }else if(boton == LaberintoDF.z02){
            return "02";
        }else if(boton == LaberintoDF.z03){
            return "03";
        }else if(boton == LaberintoDF.z04){
            return "04";
        }else if(boton == LaberintoDF.z05){
            return "05";
        }else if(boton == LaberintoDF.z06){
            return "06";
        }else if(boton == LaberintoDF.z07){
            return "07";
        }else if(boton == LaberintoDF.z08){
            return "08";
        }else if(boton == LaberintoDF.z09){
            return "09";
        }else if(boton == LaberintoDF.z0a){
            return "0a";
        }else if(boton == LaberintoDF.z0b){
            return "0b";
        }else if(boton == LaberintoDF.z0c){
            return "0c";
        }else if(boton == LaberintoDF.z0d){
            return "0d";
        }else if(boton == LaberintoDF.z0e){
            return "0e";
        }else if(boton == LaberintoDF.z0f){
            return "0f";
        }else if(boton == LaberintoDF.z0g){
            return "0g";
        }else if(boton == LaberintoDF.z0h){
            return "0h";
        }else if(boton == LaberintoDF.z0i){
            return "0i";
        }else if(boton == LaberintoDF.z0j){
            return "0j";
        }
        //
        else if(boton == LaberintoDF.z10){
            return "10";
        }else if(boton == LaberintoDF.z11){
            return "11";
        }else if(boton == LaberintoDF.z12){
            return "12";
        }else if(boton == LaberintoDF.z13){
            return "13";
        }else if(boton == LaberintoDF.z14){
            return "14";
        }else if(boton == LaberintoDF.z15){
            return "15";
        }else if(boton == LaberintoDF.z16){
            return "16";
        }else if(boton == LaberintoDF.z17){
            return "17";
        }else if(boton == LaberintoDF.z18){
            return "18";
        }else if(boton == LaberintoDF.z19){
            return "19";
        }else if(boton == LaberintoDF.z1a){
            return "1a";
        }else if(boton == LaberintoDF.z1b){
            return "1b";
        }else if(boton == LaberintoDF.z1c){
            return "1c";
        }else if(boton == LaberintoDF.z1d){
            return "1d";
        }else if(boton == LaberintoDF.z1e){
            return "1e";
        }else if(boton == LaberintoDF.z1f){
            return "1f";
        }else if(boton == LaberintoDF.z1g){
            return "1g";
        }else if(boton == LaberintoDF.z1h){
            return "1h";
        }else if(boton == LaberintoDF.z1i){
            return "1i";
        }else if(boton == LaberintoDF.z1j){
            return "1j";
        }
        //
        else if(boton == LaberintoDF.z20){
            return "20";
        }else if(boton == LaberintoDF.z21){
            return "21";
        }else if(boton == LaberintoDF.z22){
            return "22";
        }else if(boton == LaberintoDF.z23){
            return "23";
        }else if(boton == LaberintoDF.z24){
            return "24";
        }else if(boton == LaberintoDF.z25){
            return "25";
        }else if(boton == LaberintoDF.z26){
            return "26";
        }else if(boton == LaberintoDF.z27){
            return "27";
        }else if(boton == LaberintoDF.z28){
            return "28";
        }else if(boton == LaberintoDF.z29){
            return "29";
        }else if(boton == LaberintoDF.z2a){
            return "2a";
        }else if(boton == LaberintoDF.z2b){
            return "2b";
        }else if(boton == LaberintoDF.z2c){
            return "2c";
        }else if(boton == LaberintoDF.z2d){
            return "2d";
        }else if(boton == LaberintoDF.z2e){
            return "2e";
        }else if(boton == LaberintoDF.z2f){
            return "2f";
        }else if(boton == LaberintoDF.z2g){
            return "2g";
        }else if(boton == LaberintoDF.z2h){
            return "2h";
        }else if(boton == LaberintoDF.z2i){
            return "2i";
        }else if(boton == LaberintoDF.z2j){
            return "2j";
        }
        //
        else if(boton == LaberintoDF.z30){
            return "30";
        }else if(boton == LaberintoDF.z31){
            return "31";
        }else if(boton == LaberintoDF.z32){
            return "32";
        }else if(boton == LaberintoDF.z33){
            return "33";
        }else if(boton == LaberintoDF.z34){
            return "34";
        }else if(boton == LaberintoDF.z35){
            return "35";
        }else if(boton == LaberintoDF.z36){
            return "36";
        }else if(boton == LaberintoDF.z37){
            return "37";
        }else if(boton == LaberintoDF.z38){
            return "38";
        }else if(boton == LaberintoDF.z39){
            return "39";
        }else if(boton == LaberintoDF.z3a){
            return "3a";
        }else if(boton == LaberintoDF.z3b){
            return "3b";
        }else if(boton == LaberintoDF.z3c){
            return "3c";
        }else if(boton == LaberintoDF.z3d){
            return "3d";
        }else if(boton == LaberintoDF.z3e){
            return "3e";
        }else if(boton == LaberintoDF.z3f){
            return "3f";
        }else if(boton == LaberintoDF.z3g){
            return "3g";
        }else if(boton == LaberintoDF.z3h){
            return "3h";
        }else if(boton == LaberintoDF.z3i){
            return "3i";
        }else if(boton == LaberintoDF.z3j){
            return "3j";
        }
        //
        else if(boton == LaberintoDF.z40){
            return "40";
        }else if(boton == LaberintoDF.z41){
            return "41";
        }else if(boton == LaberintoDF.z42){
            return "42";
        }else if(boton == LaberintoDF.z43){
            return "43";
        }else if(boton == LaberintoDF.z44){
            return "44";
        }else if(boton == LaberintoDF.z45){
            return "45";
        }else if(boton == LaberintoDF.z46){
            return "46";
        }else if(boton == LaberintoDF.z47){
            return "47";
        }else if(boton == LaberintoDF.z48){
            return "48";
        }else if(boton == LaberintoDF.z49){
            return "49";
        }else if(boton == LaberintoDF.z4a){
            return "4a";
        }else if(boton == LaberintoDF.z4b){
            return "4b";
        }else if(boton == LaberintoDF.z4c){
            return "4c";
        }else if(boton == LaberintoDF.z4d){
            return "4d";
        }else if(boton == LaberintoDF.z4e){
            return "4e";
        }else if(boton == LaberintoDF.z4f){
            return "4f";
        }else if(boton == LaberintoDF.z4g){
            return "4g";
        }else if(boton == LaberintoDF.z4h){
            return "4h";
        }else if(boton == LaberintoDF.z4i){
            return "4i";
        }else if(boton == LaberintoDF.z4j){
            return "4j";
        }
        //
        else if(boton == LaberintoDF.z50){
            return "50";
        }else if(boton == LaberintoDF.z51){
            return "51";
        }else if(boton == LaberintoDF.z52){
            return "52";
        }else if(boton == LaberintoDF.z53){
            return "53";
        }else if(boton == LaberintoDF.z54){
            return "54";
        }else if(boton == LaberintoDF.z55){
            return "55";
        }else if(boton == LaberintoDF.z56){
            return "56";
        }else if(boton == LaberintoDF.z57){
            return "57";
        }else if(boton == LaberintoDF.z58){
            return "58";
        }else if(boton == LaberintoDF.z59){
            return "59";
        }else if(boton == LaberintoDF.z5a){
            return "5a";
        }else if(boton == LaberintoDF.z5b){
            return "5b";
        }else if(boton == LaberintoDF.z5c){
            return "5c";
        }else if(boton == LaberintoDF.z5d){
            return "5d";
        }else if(boton == LaberintoDF.z5e){
            return "5e";
        }else if(boton == LaberintoDF.z5f){
            return "5f";
        }else if(boton == LaberintoDF.z5g){
            return "5g";
        }else if(boton == LaberintoDF.z5h){
            return "5h";
        }else if(boton == LaberintoDF.z5i){
            return "5i";
        }else if(boton == LaberintoDF.z5j){
            return "5j";
        }
        //
        else if(boton == LaberintoDF.z60){
            return "60";
        }else if(boton == LaberintoDF.z61){
            return "61";
        }else if(boton == LaberintoDF.z62){
            return "62";
        }else if(boton == LaberintoDF.z63){
            return "63";
        }else if(boton == LaberintoDF.z64){
            return "64";
        }else if(boton == LaberintoDF.z65){
            return "65";
        }else if(boton == LaberintoDF.z66){
            return "66";
        }else if(boton == LaberintoDF.z67){
            return "67";
        }else if(boton == LaberintoDF.z68){
            return "68";
        }else if(boton == LaberintoDF.z69){
            return "69";
        }else if(boton == LaberintoDF.z6a){
            return "6a";
        }else if(boton == LaberintoDF.z6b){
            return "6b";
        }else if(boton == LaberintoDF.z6c){
            return "6c";
        }else if(boton == LaberintoDF.z6d){
            return "6d";
        }else if(boton == LaberintoDF.z6e){
            return "6e";
        }else if(boton == LaberintoDF.z6f){
            return "6f";
        }else if(boton == LaberintoDF.z6g){
            return "6g";
        }else if(boton == LaberintoDF.z6h){
            return "6h";
        }else if(boton == LaberintoDF.z6i){
            return "6i";
        }else if(boton == LaberintoDF.z6j){
            return "6j";
        }
        //
        else if(boton == LaberintoDF.z70){
            return "70";
        }else if(boton == LaberintoDF.z71){
            return "71";
        }else if(boton == LaberintoDF.z72){
            return "72";
        }else if(boton == LaberintoDF.z73){
            return "73";
        }else if(boton == LaberintoDF.z74){
            return "74";
        }else if(boton == LaberintoDF.z75){
            return "75";
        }else if(boton == LaberintoDF.z76){
            return "76";
        }else if(boton == LaberintoDF.z77){
            return "77";
        }else if(boton == LaberintoDF.z78){
            return "78";
        }else if(boton == LaberintoDF.z79){
            return "79";
        }else if(boton == LaberintoDF.z7a){
            return "7a";
        }else if(boton == LaberintoDF.z7b){
            return "7b";
        }else if(boton == LaberintoDF.z7c){
            return "7c";
        }else if(boton == LaberintoDF.z7d){
            return "7d";
        }else if(boton == LaberintoDF.z7e){
            return "7e";
        }else if(boton == LaberintoDF.z7f){
            return "7f";
        }else if(boton == LaberintoDF.z7g){
            return "7g";
        }else if(boton == LaberintoDF.z7h){
            return "7h";
        }else if(boton == LaberintoDF.z7i){
            return "7i";
        }else if(boton == LaberintoDF.z7j){
            return "7j";
        }
        //
        else if(boton == LaberintoDF.z80){
            return "80";
        }else if(boton == LaberintoDF.z81){
            return "81";
        }else if(boton == LaberintoDF.z82){
            return "82";
        }else if(boton == LaberintoDF.z83){
            return "83";
        }else if(boton == LaberintoDF.z84){
            return "84";
        }else if(boton == LaberintoDF.z85){
            return "85";
        }else if(boton == LaberintoDF.z86){
            return "86";
        }else if(boton == LaberintoDF.z87){
            return "87";
        }else if(boton == LaberintoDF.z88){
            return "88";
        }else if(boton == LaberintoDF.z89){
            return "89";
        }else if(boton == LaberintoDF.z8a){
            return "8a";
        }else if(boton == LaberintoDF.z8b){
            return "8b";
        }else if(boton == LaberintoDF.z8c){
            return "8c";
        }else if(boton == LaberintoDF.z8d){
            return "8d";
        }else if(boton == LaberintoDF.z8e){
            return "8e";
        }else if(boton == LaberintoDF.z8f){
            return "8f";
        }else if(boton == LaberintoDF.z8g){
            return "8g";
        }else if(boton == LaberintoDF.z8h){
            return "8h";
        }else if(boton == LaberintoDF.z8i){
            return "8i";
        }else if(boton == LaberintoDF.z8j){
            return "8j";
        }
        //
        else if(boton == LaberintoDF.z90){
            return "90";
        }else if(boton == LaberintoDF.z91){
            return "91";
        }else if(boton == LaberintoDF.z92){
            return "92";
        }else if(boton == LaberintoDF.z93){
            return "93";
        }else if(boton == LaberintoDF.z94){
            return "94";
        }else if(boton == LaberintoDF.z95){
            return "95";
        }else if(boton == LaberintoDF.z96){
            return "96";
        }else if(boton == LaberintoDF.z97){
            return "97";
        }else if(boton == LaberintoDF.z98){
            return "98";
        }else if(boton == LaberintoDF.z99){
            return "99";
        }else if(boton == LaberintoDF.z9a){
            return "9a";
        }else if(boton == LaberintoDF.z9b){
            return "9b";
        }else if(boton == LaberintoDF.z9c){
            return "9c";
        }else if(boton == LaberintoDF.z9d){
            return "9d";
        }else if(boton == LaberintoDF.z9e){
            return "9e";
        }else if(boton == LaberintoDF.z9f){
            return "9f";
        }else if(boton == LaberintoDF.z9g){
            return "9g";
        }else if(boton == LaberintoDF.z9h){
            return "9h";
        }else if(boton == LaberintoDF.z9i){
            return "9i";
        }else if(boton == LaberintoDF.z9j){
            return "9j";
        }
        //
        else if(boton == LaberintoDF.za0){
            return "a0";
        }else if(boton == LaberintoDF.za1){
            return "a1";
        }else if(boton == LaberintoDF.za2){
            return "a2";
        }else if(boton == LaberintoDF.za3){
            return "a3";
        }else if(boton == LaberintoDF.za4){
            return "a4";
        }else if(boton == LaberintoDF.za5){
            return "a5";
        }else if(boton == LaberintoDF.za6){
            return "a6";
        }else if(boton == LaberintoDF.za7){
            return "a7";
        }else if(boton == LaberintoDF.za8){
            return "a8";
        }else if(boton == LaberintoDF.za9){
            return "a9";
        }else if(boton == LaberintoDF.zaa){
            return "aa";
        }else if(boton == LaberintoDF.zab){
            return "ab";
        }else if(boton == LaberintoDF.zac){
            return "ac";
        }else if(boton == LaberintoDF.zad){
            return "ad";
        }else if(boton == LaberintoDF.zae){
            return "ae";
        }else if(boton == LaberintoDF.zaf){
            return "af";
        }else if(boton == LaberintoDF.zag){
            return "ag";
        }else if(boton == LaberintoDF.zah){
            return "ah";
        }else if(boton == LaberintoDF.zai){
            return "ai";
        }else if(boton == LaberintoDF.zaj){
            return "aj";
        }
        //
        else if(boton == LaberintoDF.zb0){
            return "b0";
        }else if(boton == LaberintoDF.zb1){
            return "b1";
        }else if(boton == LaberintoDF.zb2){
            return "b2";
        }else if(boton == LaberintoDF.zb3){
            return "b3";
        }else if(boton == LaberintoDF.zb4){
            return "b4";
        }else if(boton == LaberintoDF.zb5){
            return "b5";
        }else if(boton == LaberintoDF.zb6){
            return "b6";
        }else if(boton == LaberintoDF.zb7){
            return "b7";
        }else if(boton == LaberintoDF.zb8){
            return "b8";
        }else if(boton == LaberintoDF.zb9){
            return "b9";
        }else if(boton == LaberintoDF.zba){
            return "ba";
        }else if(boton == LaberintoDF.zbb){
            return "bb";
        }else if(boton == LaberintoDF.zbc){
            return "bc";
        }else if(boton == LaberintoDF.zbd){
            return "bd";
        }else if(boton == LaberintoDF.zbe){
            return "be";
        }else if(boton == LaberintoDF.zbf){
            return "bf";
        }else if(boton == LaberintoDF.zbg){
            return "bg";
        }else if(boton == LaberintoDF.zbh){
            return "bh";
        }else if(boton == LaberintoDF.zbi){
            return "bi";
        }else if(boton == LaberintoDF.zbj){
            return "bj";
        }
        //
        else if(boton == LaberintoDF.zc0){
            return "c0";
        }else if(boton == LaberintoDF.zc1){
            return "c1";
        }else if(boton == LaberintoDF.zc2){
            return "c2";
        }else if(boton == LaberintoDF.zc3){
            return "c3";
        }else if(boton == LaberintoDF.zc4){
            return "c4";
        }else if(boton == LaberintoDF.zc5){
            return "c5";
        }else if(boton == LaberintoDF.zc6){
            return "c6";
        }else if(boton == LaberintoDF.zc7){
            return "c7";
        }else if(boton == LaberintoDF.zc8){
            return "c8";
        }else if(boton == LaberintoDF.zc9){
            return "c9";
        }else if(boton == LaberintoDF.zca){
            return "ca";
        }else if(boton == LaberintoDF.zcb){
            return "cb";
        }else if(boton == LaberintoDF.zcc){
            return "cc";
        }else if(boton == LaberintoDF.zcd){
            return "cd";
        }else if(boton == LaberintoDF.zce){
            return "ce";
        }else if(boton == LaberintoDF.zcf){
            return "cf";
        }else if(boton == LaberintoDF.zcg){
            return "cg";
        }else if(boton == LaberintoDF.zch){
            return "ch";
        }else if(boton == LaberintoDF.zci){
            return "ci";
        }else if(boton == LaberintoDF.zcj){
            return "cj";
        }
        //
        else if(boton == LaberintoDF.zd0){
            return "d0";
        }else if(boton == LaberintoDF.zd1){
            return "d1";
        }else if(boton == LaberintoDF.zd2){
            return "d2";
        }else if(boton == LaberintoDF.zd3){
            return "d3";
        }else if(boton == LaberintoDF.zd4){
            return "d4";
        }else if(boton == LaberintoDF.zd5){
            return "d5";
        }else if(boton == LaberintoDF.zd6){
            return "d6";
        }else if(boton == LaberintoDF.zd7){
            return "d7";
        }else if(boton == LaberintoDF.zd8){
            return "d8";
        }else if(boton == LaberintoDF.zd9){
            return "d9";
        }else if(boton == LaberintoDF.zda){
            return "da";
        }else if(boton == LaberintoDF.zdb){
            return "db";
        }else if(boton == LaberintoDF.zdc){
            return "dc";
        }else if(boton == LaberintoDF.zdd){
            return "dd";
        }else if(boton == LaberintoDF.zde){
            return "de";
        }else if(boton == LaberintoDF.zdf){
            return "df";
        }else if(boton == LaberintoDF.zdg){
            return "dg";
        }else if(boton == LaberintoDF.zdh){
            return "dh";
        }else if(boton == LaberintoDF.zdi){
            return "di";
        }else if(boton == LaberintoDF.zdj){
            return "dj";
        }
        //
        else if(boton == LaberintoDF.ze0){
            return "e0";
        }else if(boton == LaberintoDF.ze1){
            return "e1";
        }else if(boton == LaberintoDF.ze2){
            return "e2";
        }else if(boton == LaberintoDF.ze3){
            return "e3";
        }else if(boton == LaberintoDF.ze4){
            return "e4";
        }else if(boton == LaberintoDF.ze5){
            return "e5";
        }else if(boton == LaberintoDF.ze6){
            return "e6";
        }else if(boton == LaberintoDF.ze7){
            return "e7";
        }else if(boton == LaberintoDF.ze8){
            return "e8";
        }else if(boton == LaberintoDF.ze9){
            return "e9";
        }else if(boton == LaberintoDF.zea){
            return "ea";
        }else if(boton == LaberintoDF.zeb){
            return "eb";
        }else if(boton == LaberintoDF.zec){
            return "ec";
        }else if(boton == LaberintoDF.zed){
            return "ed";
        }else if(boton == LaberintoDF.zee){
            return "ee";
        }else if(boton == LaberintoDF.zef){
            return "ef";
        }else if(boton == LaberintoDF.zeg){
            return "eg";
        }else if(boton == LaberintoDF.zeh){
            return "eh";
        }else if(boton == LaberintoDF.zei){
            return "ei";
        }else if(boton == LaberintoDF.zej){
            return "ej";
        }
        //
        else if(boton == LaberintoDF.zf0){
            return "f0";
        }else if(boton == LaberintoDF.zf1){
            return "f1";
        }else if(boton == LaberintoDF.zf2){
            return "f2";
        }else if(boton == LaberintoDF.zf3){
            return "f3";
        }else if(boton == LaberintoDF.zf4){
            return "f4";
        }else if(boton == LaberintoDF.zf5){
            return "f5";
        }else if(boton == LaberintoDF.zf6){
            return "f6";
        }else if(boton == LaberintoDF.zf7){
            return "f7";
        }else if(boton == LaberintoDF.zf8){
            return "f8";
        }else if(boton == LaberintoDF.zf9){
            return "f9";
        }else if(boton == LaberintoDF.zfa){
            return "fa";
        }else if(boton == LaberintoDF.zfb){
            return "fb";
        }else if(boton == LaberintoDF.zfc){
            return "fc";
        }else if(boton == LaberintoDF.zfd){
            return "fd";
        }else if(boton == LaberintoDF.zfe){
            return "fe";
        }else if(boton == LaberintoDF.zff){
            return "ff";
        }else if(boton == LaberintoDF.zfg){
            return "fg";
        }else if(boton == LaberintoDF.zfh){
            return "fh";
        }else if(boton == LaberintoDF.zfi){
            return "fi";
        }else if(boton == LaberintoDF.zfj){
            return "fj";
        }
        //
        else if(boton == LaberintoDF.zg0){
            return "g0";
        }else if(boton == LaberintoDF.zg1){
            return "g1";
        }else if(boton == LaberintoDF.zg2){
            return "g2";
        }else if(boton == LaberintoDF.zg3){
            return "g3";
        }else if(boton == LaberintoDF.zg4){
            return "g4";
        }else if(boton == LaberintoDF.zg5){
            return "g5";
        }else if(boton == LaberintoDF.zg6){
            return "g6";
        }else if(boton == LaberintoDF.zg7){
            return "g7";
        }else if(boton == LaberintoDF.zg8){
            return "g8";
        }else if(boton == LaberintoDF.zg9){
            return "g9";
        }else if(boton == LaberintoDF.zga){
            return "ga";
        }else if(boton == LaberintoDF.zgb){
            return "gb";
        }else if(boton == LaberintoDF.zgc){
            return "gc";
        }else if(boton == LaberintoDF.zgd){
            return "gd";
        }else if(boton == LaberintoDF.zge){
            return "ge";
        }else if(boton == LaberintoDF.zgf){
            return "gf";
        }else if(boton == LaberintoDF.zgg){
            return "gg";
        }else if(boton == LaberintoDF.zgh){
            return "gh";
        }else if(boton == LaberintoDF.zgi){
            return "gi";
        }else if(boton == LaberintoDF.zgj){
            return "gj";
        }
        //
        else if(boton == LaberintoDF.zh0){
            return "h0";
        }else if(boton == LaberintoDF.zh1){
            return "h1";
        }else if(boton == LaberintoDF.zh2){
            return "h2";
        }else if(boton == LaberintoDF.zh3){
            return "h3";
        }else if(boton == LaberintoDF.zh4){
            return "h4";
        }else if(boton == LaberintoDF.zh5){
            return "h5";
        }else if(boton == LaberintoDF.zh6){
            return "h6";
        }else if(boton == LaberintoDF.zh7){
            return "h7";
        }else if(boton == LaberintoDF.zh8){
            return "h8";
        }else if(boton == LaberintoDF.zh9){
            return "h9";
        }else if(boton == LaberintoDF.zha){
            return "ha";
        }else if(boton == LaberintoDF.zhb){
            return "hb";
        }else if(boton == LaberintoDF.zhc){
            return "hc";
        }else if(boton == LaberintoDF.zhd){
            return "hd";
        }else if(boton == LaberintoDF.zhe){
            return "he";
        }else if(boton == LaberintoDF.zhf){
            return "hf";
        }else if(boton == LaberintoDF.zhg){
            return "hg";
        }else if(boton == LaberintoDF.zhh){
            return "hh";
        }else if(boton == LaberintoDF.zhi){
            return "hi";
        }else if(boton == LaberintoDF.zhj){
            return "hj";
        }
        //
        else if(boton == LaberintoDF.zi0){
            return "i0";
        }else if(boton == LaberintoDF.zi1){
            return "i1";
        }else if(boton == LaberintoDF.zi2){
            return "i2";
        }else if(boton == LaberintoDF.zi3){
            return "i3";
        }else if(boton == LaberintoDF.zi4){
            return "i4";
        }else if(boton == LaberintoDF.zi5){
            return "i5";
        }else if(boton == LaberintoDF.zi6){
            return "i6";
        }else if(boton == LaberintoDF.zi7){
            return "i7";
        }else if(boton == LaberintoDF.zi8){
            return "i8";
        }else if(boton == LaberintoDF.zi9){
            return "i9";
        }else if(boton == LaberintoDF.zia){
            return "ia";
        }else if(boton == LaberintoDF.zib){
            return "ib";
        }else if(boton == LaberintoDF.zic){
            return "ic";
        }else if(boton == LaberintoDF.zid){
            return "id";
        }else if(boton == LaberintoDF.zie){
            return "ie";
        }else if(boton == LaberintoDF.zif){
            return "if";
        }else if(boton == LaberintoDF.zig){
            return "ig";
        }else if(boton == LaberintoDF.zih){
            return "ih";
        }else if(boton == LaberintoDF.zii){
            return "ii";
        }else if(boton == LaberintoDF.zij){
            return "ij";
        }
        //
        else if(boton == LaberintoDF.zj0){
            return "j0";
        }else if(boton == LaberintoDF.zj1){
            return "j1";
        }else if(boton == LaberintoDF.zj2){
            return "j2";
        }else if(boton == LaberintoDF.zj3){
            return "j3";
        }else if(boton == LaberintoDF.zj4){
            return "j4";
        }else if(boton == LaberintoDF.zj5){
            return "j5";
        }else if(boton == LaberintoDF.zj6){
            return "j6";
        }else if(boton == LaberintoDF.zj7){
            return "j7";
        }else if(boton == LaberintoDF.zj8){
            return "j8";
        }else if(boton == LaberintoDF.zj9){
            return "j9";
        }else if(boton == LaberintoDF.zja){
            return "ja";
        }else if(boton == LaberintoDF.zjb){
            return "jb";
        }else if(boton == LaberintoDF.zjc){
            return "jc";
        }else if(boton == LaberintoDF.zjd){
            return "jd";
        }else if(boton == LaberintoDF.zje){
            return "je";
        }else if(boton == LaberintoDF.zjf){
            return "jf";
        }else if(boton == LaberintoDF.zjg){
            return "jg";
        }else if(boton == LaberintoDF.zjh){
            return "jh";
        }else if(boton == LaberintoDF.zji){
            return "ji";
        }else if(boton == LaberintoDF.zjj){
            return "jj";
        }
        return null;
    }
    //--------------------------------------------------------------------------
    private String play(String pos){
        int x = Character.getNumericValue(pos.charAt(1));
        int y = Character.getNumericValue(pos.charAt(0));
        
        System.out.print(Laberintos[y][x]);
        return null;
    }
    //Coloca las paredes del laberinto------------------------------------------
    private String ColocarParedes(String pos){
        int x = Character.getNumericValue(pos.charAt(1));
        int y = Character.getNumericValue(pos.charAt(0));
        
        if(Laberintos[y][x] == "G"){
            Laberintos[y][x] = "V";
        }else if(Laberintos[y][x] == "V"){
            JOptionPane.showMessageDialog(null, "Esta ya es una pared");
        }
        
        for(int i=0; i<20; i++){
            for(int j=0; j<20; j++){
                System.out.print(Laberintos[i][j] + "\t");
            }
            System.out.println();
        }
        
        return null;
    }
    private void ColocarParedesGrafico(String pos){
        boton(pos).setBackground(new Color(0,204,0));
    }
    //--------------------------------------------------------------------------
    //Colocar Entrada del robot-------------------------------------------------
    private String ColocarEntrada(String pos){
        int x = Character.getNumericValue(pos.charAt(1));
        int y = Character.getNumericValue(pos.charAt(0));
        
        if((y >= 1 && y <= 18)  && (x >=1 && x <= 18)){
            if(Laberintos[y][x].equals("G")){
                JOptionPane.showMessageDialog(null, "No puedes usar esta casilla como entrada por que solo puede ser un muro interior");
            }else if(Laberintos[y][x].equals("V")){
                JOptionPane.showMessageDialog(null, "No puedes usar esta casilla como entrada por que es un muro interior");
            }
        }
        
        if(y == 0 || y == 19){
            if(Laberintos[y][x].equals("S")){
                JOptionPane.showMessageDialog(null, "No puedes usar esta casilla como entrada por que es la salida");
            }else{
                Laberintos[y][x] = "E";
                boton(pos).setBackground(new Color(0,204,204));
                boton(pos).setIcon(new ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Segunda Unidad/LaberintoDelFauno/src/Imagenes/Nave.png"));
                PosBot = pos;
            }
        }else if(x==0 || x==19){
            if(Laberintos[y][x].equals("S")){
                JOptionPane.showMessageDialog(null, "No puedes usar esta casilla como entrada por que es la salida");
            }else{
                Laberintos[y][x] = "E";
                boton(pos).setBackground(new Color(0,204,204));
                boton(pos).setIcon(new ImageIcon("/Volumes/YianMM/Cajon de codigos/Java/TAP/Segunda Unidad/LaberintoDelFauno/src/Imagenes/Nave.png"));
                PosBot = pos;
            }
        }
        return null;
    }
    //--------------------------------------------------------------------------
    //Colocar Salida del robot--------------------------------------------------
    private String ColocarSalida(String pos){
        int x = Character.getNumericValue(pos.charAt(1));
        int y = Character.getNumericValue(pos.charAt(0));
        
        if((y >= 1 && y <= 18)  && (x >=1 && x <= 18)){
            if(Laberintos[y][x] == "G"){
                JOptionPane.showMessageDialog(null, "No puedes usar esta casilla como entrada por que solo puede ser un muro interior");
            }else if(Laberintos[y][x].equals("V")){
                JOptionPane.showMessageDialog(null, "No puedes usar esta casilla como entrada por que es un muro interior");
            }
        }
        
        if(y == 0 || y == 19){
            if(Laberintos[y][x] == "E"){
                JOptionPane.showMessageDialog(null, "No puedes usar esta casilla como salida por que es la entrada");
            }else{
                Laberintos[y][x] = "S";
                boton(pos).setBackground(new Color(102,0,0));
                PosSalida = pos;
            }
        }else if(x==0 || x==19){
            if(Laberintos[y][x] == "E"){
                JOptionPane.showMessageDialog(null, "No puedes usar esta casilla como salida por que es la entrada");
            }else{
                Laberintos[y][x] = "S";
                boton(pos).setBackground(new Color(102,0,0));
                PosSalida = pos;
            }
        }
        return null;
    }
    //--------------------------------------------------------------------------
    //Robot---------------------------------------------------------------------
    private void movimientosBot(String posBot, String posSalida){
        int a = Character.getNumericValue(posBot.charAt(0));
        int b = Character.getNumericValue(posBot.charAt(1));
        
        int d = Character.getNumericValue(posSalida.charAt(0));
        int e = Character.getNumericValue(posSalida.charAt(1));
        
        
        if(b == 0){
            do{
                if((Laberintos[a][b+1]) == "G"){
                    Laberintos [a][b+1] = "X";
                    b = b+1;
                    String PosN = a + "" + b;
                    boton(PosN).setBackground(new Color(255,255,153));
                    verificarSalida(a,b);
                }else if((Laberintos[a-1][b]) == "G"){
                    Laberintos [a-1][b] = "X";
                    a = a-1;
                    String PosN = a + "" + b;
                    boton(PosN).setBackground(new Color(255,255,153));
                    verificarSalida(a,b);
                }else if((Laberintos[a+1][b]) == "G"){
                    Laberintos [a+1][b] = "X";
                    a = a+1;
                    String PosN = a + "" + b;
                    boton(PosN).setBackground(new Color(255,255,153));
                    verificarSalida(a,b);
                }else if((Laberintos[a-1][b]) == "G"){
                    Laberintos [a][b-1] = "X";
                    b = b-1;
                    String PosN = a + "" + b;
                    boton(PosN).setBackground(new Color(255,255,153));
                    verificarSalida(a,b);
                }else if("X".equals(Laberintos[a][b-1])){
                    Laberintos [a][b-1] = "G";
                    break;
                }else if("X".equals(Laberintos[a+1][b])){
                    Laberintos [a+1][b] = "G";
                    break;
                }else if("X".equals(Laberintos[a-1][b])){
                    Laberintos [a-1][b] = "G";
                    break;
                }else if("X".equals(Laberintos[a][b+1])){
                    Laberintos [a][b+1] = "G";
                    break;
                } 

                for(int i=0; i<20; i++){
                    for(int j=0; j<20; j++){
                        System.out.print(Laberintos[i][j] + "-- \t");
                    }
                    System.out.println();
                }

            }while(Laberintos[d][e] != "X");
        }else
        
            if(b == 19){
            
                do{
                    if((Laberintos[a][b-1]) == "G"){
                        Laberintos [a][b-1] = "X";
                        b = b-1;
                        String PosN = a + "" + b;
                        boton(PosN).setBackground(new Color(255,255,153));
                        verificarSalida(a,b);
                    }else if((Laberintos[a-1][b]) == "G"){
                        Laberintos [a-1][b] = "X";
                        a = a-1;
                        String PosN = a + "" + b;
                        boton(PosN).setBackground(new Color(255,255,153));
                        verificarSalida(a,b);
                    }else if((Laberintos[a][b+1]) == "G"){
                        Laberintos [a][b+1] = "X";
                        b = b+1;
                        String PosN = a + "" + b;
                        boton(PosN).setBackground(new Color(255,255,153));
                        verificarSalida(a,b);
                    }else if((Laberintos[a+1][b]) == "G"){
                        Laberintos [a+1][b] = "X";
                        a = a+1;
                        String PosN = a + "" + b;
                        boton(PosN).setBackground(new Color(255,255,153));
                        verificarSalida(a,b);
                    }else if("X".equals(Laberintos[a][b-1])){
                        Laberintos [a][b-1] = "G";
                    }else if("X".equals(Laberintos[a-1][b])){
                        Laberintos [a-1][b] = "G";
                    }else if("X".equals(Laberintos[a][b+1])){
                        Laberintos [a][b+1] = "G";
                    }else if("X".equals(Laberintos[a+1][b])){
                        Laberintos [a+1][b] = "G";
                    } 

                    for(int i=0; i<20; i++){
                        for(int j=0; j<20; j++){
                            System.out.print(Laberintos[i][j] + "\t");
                        }
                        System.out.println();
                    }

                }while(Laberintos[d][e] != "X");
            }
        
            if(a == 0){
                do{
                    if((Laberintos[a+1][b]) == "G"){
                        Laberintos [a+1][b] = "X";
                        a = a+1;
                        String PosN = a + "" + b;
                        boton(PosN).setBackground(new Color(255,255,153));
                        verificarSalida(a,b);
                    }else if((Laberintos[a][b+1]) == "G"){
                        Laberintos [a][b+1] = "X";
                        b = b+1;
                        String PosN = a + "" + b;
                        boton(PosN).setBackground(new Color(255,255,153));
                        verificarSalida(a,b);
                    }else if((Laberintos[a][b-1]) == "G"){
                        Laberintos [a][b-1] = "X";
                        b = b-1;
                        String PosN = a + "" + b;
                        boton(PosN).setBackground(new Color(255,255,153));
                        verificarSalida(a,b);
                    }else if((Laberintos[a-1][b]) == "G"){
                        Laberintos [a-1][b] = "X";
                        a = a-1;
                        String PosN = a + "" + b;
                        boton(PosN).setBackground(new Color(255,255,153));
                        verificarSalida(a,b);
                    }else if("X".equals(Laberintos[a][b+1])){
                        Laberintos [a][b+1] = "G";
                    }else if("X".equals(Laberintos[a+1][b])){
                        Laberintos [a+1][b] = "G";
                    }else if("X".equals(Laberintos[a][b-1])){
                        Laberintos [a][b-1] = "G";
                    }else if("X".equals(Laberintos[a-1][b])){
                        Laberintos [a-1][b] = "G";
                    } 

                    for(int i=0; i<20; i++){
                        for(int j=0; j<20; j++){
                            System.out.print(Laberintos[i][j] + "\t");
                        }
                        System.out.println();
                    }

                }while(Laberintos[d][e] != "X");
            }
            
            if(a == 19){
                do{
                    if((Laberintos[a-1][b]) == "G"){
                        Laberintos [a-1][b] = "X";
                        a = a-1;
                        String PosN = a + "" + b;
                        boton(PosN).setBackground(new Color(255,255,153));
                        verificarSalida(a,b);
                    }else if((Laberintos[a][b+1]) == "G"){
                        Laberintos [a][b+1] = "X";
                        b = b+1;
                        String PosN = a + "" + b;
                        boton(PosN).setBackground(new Color(255,255,153));
                        verificarSalida(a,b);
                    }else if((Laberintos[a][b-1]) == "G"){
                        Laberintos [a][b-1] = "X";
                        b = b-1;
                        String PosN = a + "" + b;
                        boton(PosN).setBackground(new Color(255,255,153));
                        verificarSalida(a,b);
                    }else if((Laberintos[a+1][b]) == "G"){
                        Laberintos [a+1][b] = "X";
                        a = a+1;
                        String PosN = a + "" + b;
                        boton(PosN).setBackground(new Color(255,255,153));
                        verificarSalida(a,b);
                    }else if("X".equals(Laberintos[a][b+1])){
                        Laberintos [a+1][b] = "G";
                    }else if("X".equals(Laberintos[a-1][b])){
                        Laberintos [a][b+1] = "G";
                    }else if("X".equals(Laberintos[a][b-1])){
                        Laberintos [a][b-1] = "G";
                    }else if("X".equals(Laberintos[a+1][b])){
                        Laberintos [a-1][b] = "G";
                    } 

                    for(int i=0; i<20; i++){
                        for(int j=0; j<20; j++){
                            System.out.print(Laberintos[i][j] + "\t");
                        }
                        System.out.println();
                    }

                }while(Laberintos[d][e] != "X");
            }
        
        
        
    }
    
    private void verificarSalida(int a, int b){
        
        if("S".equals(Laberintos [a][b+1])){
            Laberintos [a][b+1] = "X";
            JOptionPane.showMessageDialog(null, "Encontraste la salida");
        }else if("S".equals(Laberintos [a+1][b])){
            Laberintos [a+1][b] = "X";
            JOptionPane.showMessageDialog(null, "Encontraste la salida");
        }else if("S".equals(Laberintos [a][b-1])){
            Laberintos [a][b-1] = "X";
            JOptionPane.showMessageDialog(null, "Encontraste la salida");
        }else if("S".equals(Laberintos [a-1][b])){
            Laberintos [a-1][b] = "X";
            JOptionPane.showMessageDialog(null, "Encontraste la salida");
        }

    }
    //--------------------------------------------------------------------------
}


