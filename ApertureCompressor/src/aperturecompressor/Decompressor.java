/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aperturecompressor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author taisi
 */
public class Decompressor {
    ArrayList<Integer> CompressedX;
    ArrayList<Double> CompressedY;
    
    ArrayList<Integer> RepairedX;
    ArrayList<Double> RepairedY;
    
    
    public double L(double x, double x1, double y1, double x2, double y2){
        return  y1+(x-x1)*((y2-y1)/(x2-x1));
    }
    
    public void Decompress(){ //восстановление данных
        
        RepairedX = new ArrayList<Integer>();
        RepairedY = new ArrayList<Double>();
        //первое значение
        RepairedX.add(CompressedX.get(0));
        RepairedY.add(CompressedY.get(0));
        System.out.println(CompressedX.get(0)+" "+CompressedY.get(0));
        
        for (int i=0; i <CompressedX.size()-1;i++){
            //Восстановление точек в диапазоне между знач из сжатых данных 
            for (int j=CompressedX.get(i)+1; j<CompressedX.get(i+1); j++)
            {
                //Восстановление с помощью лин интерполяции
                RepairedX.add(j);
                RepairedY.add( L(j, CompressedX.get(i), CompressedY.get(i),
                        CompressedX.get(i+1), CompressedY.get(i+1))) ;
                System.out.println("Repaired: " + RepairedX.get(RepairedX.size()-1) + " " + RepairedY.get(RepairedY.size()-1));
            }
            RepairedX.add(CompressedX.get(i+1));
            RepairedY.add(CompressedY.get(i+1));          
            System.out.println(CompressedX.get(i+1) + " " + CompressedY.get(i+1));
        }        
    }
    public void PrintRepairedData(){
        System.out.println("Repaired Data: ");
        for(int i =0; i<RepairedX.size(); i++){
            System.out.println(RepairedX.get(i) + " "+ RepairedY.get(i));
        }
        //коэф сжатия
        //System.out.println("Metric of compression: "+ (double)InputX.size()/(double)CompressedX.size());
    }
    public void SaveToFile(String fn){
        File f = new File(fn);
        try {
            FileWriter fw = new FileWriter(f);
            String line="";
            for (int i =0; i<RepairedY.size(); i++){
                line = line + RepairedY.get(i) + ";";
            }
            fw.write(line.replace(".",","));
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Decompressor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
