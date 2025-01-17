/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aperturecompressor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author taisi
 */
public class Compressor {

    ArrayList<Integer> InputX;
    ArrayList<Double> InputY;

    ArrayList<Integer> CompressedX;
    ArrayList<Double> CompressedY;

    double aperture;

    public Compressor() {
        InputX = new ArrayList<Integer>();
        InputY = new ArrayList<Double>();

        CompressedX = new ArrayList<Integer>();
        CompressedY = new ArrayList<Double>();

    }

    public double L(double x, double x1, double y1, double x2, double y2) {
        return y1 + (x - x1) * ((y2 - y1) / (x2 - x1));
    }

    public void compress(double aperture) {
        this.aperture = aperture;
        int startX = 0, endX;
        endX = startX;
        boolean isOutsideAperture; //флажок лин функции вне апертуры

        CompressedX.add(InputX.get(startX)); //первая точка всегда входит в набор данных
        CompressedY.add(InputY.get(startX)); //первая точка всегда входит в набор данных

        while (endX < InputX.size()) {
            isOutsideAperture = false;
            for (int j = endX; j > startX; j--) {
                //проверка попадания в апертуру
                if (Math.abs(InputY.get(j) - L(InputX.get(j), InputX.get(startX),
                        InputY.get(startX), InputX.get(endX), InputY.get(endX))) > aperture) {
                    isOutsideAperture = true;
                }
            }
            if (isOutsideAperture) {
                //Добавить точку в набор сжатых данныъх
                CompressedX.add(InputX.get(endX - 1));
                CompressedY.add(InputY.get(endX - 1));
                //перенос границы диапазона
                startX = endX - 1;
            } else {
                //продолжение проверки, смещение endX
                endX++;
                if (endX == InputX.size()) //крайняя точка в массив сжатых данных
                {
                    CompressedX.add(InputX.get(endX - 1));
                    CompressedY.add(InputY.get(endX - 1));
                }
            }
        }
    }

    public void PrintCopressedData() {
        System.out.println("Total points: " + CompressedX.size());
        for (int i = 0; i < CompressedX.size(); i++) {
            System.out.println(CompressedX.get(i) + " " + CompressedY.get(i));
        }
        //коэф сжатия
        System.out.println("Metric of compression: " + (double) InputX.size() / (double) CompressedX.size());
    }

    public void LoadFromFile(String fn) {
        File f = new File(fn);
        try {
            Scanner scanner = new Scanner(f);
            String line = "";
            line = scanner.nextLine();
            //InputX = new ArrayList<Integer>();
            String data[] = line.split(";");
            for (int i = 0; i < data.length; i++) {
                InputX.add(Integer.parseInt(data[i]));
                //System.out.println(InputX.get(i));
            }
            line = scanner.nextLine();
            //InputX = new ArrayList<Integer>();
            data = line.split(";");
            for (int i = 0; i < data.length; i++) {
                InputY.add(Double.parseDouble(data[i]));
                //System.out.println(InputY.get(i));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Compressor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
