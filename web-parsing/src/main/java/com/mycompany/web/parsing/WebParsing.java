/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.web.parsing;
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
public class WebParsing {
    public static void main(String[] args) {
        //раздел 1 - определить цвет фона
        try { //проверяем на ошибку определения файла
            File HTMLfile = new File("index.html"); //создаем переменную с файлом
            Scanner fileWork = new Scanner(HTMLfile, "cp1251"); //определяем тип scanner и передаем html-файл
            String background =""; // создаем переменную для вставки строки с названием цвета                
            while (fileWork.hasNext()){ //пока файл не пустой 
                
                String s = fileWork.nextLine(); //читаем строку файла
                int startPos = s.indexOf("<body"); //запоминаем индекс позиции
                    
                if (startPos!=-1){ //определяем условие для нахождения информации про фон
                    int i = startPos + 32; //определяем индекс начальной позиции                   
                    while (s.charAt(i)!=';'){ //проходимся по строке пока не найдем символ
                        background = background + s.charAt(i); //читаем символ строчки и передаем ее в название background
                        i = i + 1; //увеличиваем индекс и переходим к следующему символу 
                    }                    
                }
            }
            System.out.print("Answer 1 ");
            System.out.print("Background color is "); //для красивого вывода для задания раздела 1 выводим фразу
            System.out.println(background); //выводим ответ на задание            
            fileWork.close(); //закрываем файл
        } catch (FileNotFoundException ex) { //обработка ошибки
            Logger.getLogger(WebParsing.class.getName()).log(Level.SEVERE, null, ex);
        }
        //раздел 2 - найти все ключевые слова, определённые в мета-тегах и записать их в массив
        try { //проверяем на ошибку определения файла
            File HTMLfile = new File("index.html"); //создаем переменную с файлом
            Scanner fileWork = new Scanner(HTMLfile, "cp1251"); //определяем тип scanner и передаем html-файл
            ArrayList<String> keywords = new ArrayList<>();               
            while (fileWork.hasNext()){ //пока файл не пустой 
                String s = fileWork.nextLine(); //читаем строку файла
                int startPos = s.indexOf("<meta name=\"keywords\""); //запоминаем индекс позиции
                if (startPos!=-1){ //определяем условие для нахождения информации про фон
                    int i = startPos + 31; //определяем индекс начальной позиции                   
                    String keyword = "";
                    while (s.charAt(i)!='"'){ //проходимся по строке пока не найдем символ
                        keyword = keyword + s.charAt(i); //читаем символ строчки и передаем ее в название background
                        i = i + 1; //увеличиваем индекс и переходим к следующему символу 
                    } 
                    String[] splitKeywords = keyword.split(", ");//разделяем строку на несколько элементов
                    
                    for (int j = 0; j <= splitKeywords.length-1;j++){
                        keywords.add(splitKeywords[j]); //записываем элементы в массив
                        
                    }
                }
            }
            System.out.print("Answer 2 ");
            System.out.println("Keywords from meta-tag: ");
            for (int i = 0; i<= keywords.size()-1; i++) // проходимся по массиву
            {
                System.out.println(keywords.get(i)); //выводим содержимое массива для задания
            }            
            fileWork.close(); //закрываем файл
        } catch (FileNotFoundException ex) { //обработка ошибки
            Logger.getLogger(WebParsing.class.getName()).log(Level.SEVERE, null, ex);
        }
        //раздел 3 - оценить удобочитаемость страницы (шрифт, фон и др.)
        try { //проверяем на ошибку определения файла
            File HTMLfile = new File("index.html"); //создаем переменную с файлом
            Scanner fileWork = new Scanner(HTMLfile, "cp1251"); //определяем тип scanner и передаем html-файл
            String background =""; // создаем переменную для вставки строки с названием цвета                
            String color="";
            String font="";
            while (fileWork.hasNext()){ //пока файл не пустой 
                
                String s = fileWork.nextLine(); //читаем строку файла
                int startPos = s.indexOf("<body"); //запоминаем индекс позиции  
                if (startPos!=-1){ //определяем условие для нахождения информации про фон
                    //находим цвет фона  
                    int i_background = startPos + 32; //определяем индекс начальной позиции                   
                    while (s.charAt(i_background)!=';'){ //проходимся по строке пока не найдем символ
                        background = background + s.charAt(i_background); //читаем символ строчки и передаем ее в название background
                        i_background = i_background + 1; //увеличиваем индекс и переходим к следующему символу 
                    }
                    int i_color = i_background + 9; //определяем индекс начальной позиции                   
                    while (s.charAt(i_color)!=';'){ //проходимся по строке пока не найдем символ
                        color = color + s.charAt(i_color); //читаем символ строчки и передаем ее в название background
                        i_color = i_color + 1; //увеличиваем индекс и переходим к следующему символу 
                    }
                    int i_font = i_color + 13; //определяем индекс начальной позиции                   
                    while (s.charAt(i_font)!='"'){ //проходимся по строке пока не найдем символ
                        font = font + s.charAt(i_font); //читаем символ строчки и передаем ее в название background
                        i_font = i_font + 1; //увеличиваем индекс и переходим к следующему символу 
                    }                   
                }      
            }
            System.out.print("Answer 3 ");
            System.out.print("Background color is "); //для красивого вывода для задания раздела 1 выводим фразу
            System.out.println(background); //выводим ответ на задание    
            System.out.print("Font color is "); //для красивого вывода для задания раздела 1 выводим фразу
            System.out.println(color); //выводим ответ на задание
            System.out.print("Font size is "); //для красивого вывода для задания раздела 1 выводим фразу
            System.out.println(font); //выводим ответ на задание 
            //Страница неудобо читаема, так как выбраны цвета шрифта/фона несочетаемые. Размер шрифта выглядит адекватно(видно на сайте)
            fileWork.close(); //закрываем файл
        } catch (FileNotFoundException ex) { //обработка ошибки
            Logger.getLogger(WebParsing.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
