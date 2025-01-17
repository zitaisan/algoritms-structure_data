/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aperturecompressor;

/**
 *
 * @author taisi
 */
public class ApertureCompressor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // сжатие данных        
        Compressor MyCompressor = new Compressor();
        MyCompressor.LoadFromFile("dataset.csv");
        MyCompressor.compress(5);
        MyCompressor.PrintCopressedData();
        //восстановление данных
        Decompressor MyDecompressor = new Decompressor();
        MyDecompressor.CompressedX = MyCompressor.CompressedX;
        MyDecompressor.CompressedY = MyCompressor.CompressedY;
        MyDecompressor.Decompress();
        MyDecompressor.PrintRepairedData();
        MyDecompressor.SaveToFile("repaired.csv");
    }
}
