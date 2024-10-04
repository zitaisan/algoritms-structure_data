/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author taisi
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Structure {
    private File pageFile;
    String fileName;
    String title;
    String h1;
    String content;
    String link;
    public Structure(String fileName, String title, String content, String h1, String link){
        //описание структуры
        this.fileName=fileName;
        this.title=title;
        this.content=content;
        this.h1=h1;
        this.link=link;
        
    }
    public void saveToFile(){
        pageFile=new File(fileName);
        try {
            //описание страницы html и ее наполнение
            char kav='"'; //кавычки для ссылки
                       
            String ls = System.getProperty("line.separator"); //добавление перехода на след. строку
            try (FileWriter fw = new FileWriter(pageFile)) {
                fw.write("<!doctype html>"+ls);
                fw.write("<html>"+ls);
                fw.write("  <head>"+ls);
                fw.write("  <title>" + title + "</title>" + ls);
                fw.write("  </head>"+ls);
                fw.write("  <body>" + ls);
                fw.write("      <content>" + ls);
                fw.write("          <h1>" + h1 + "</h1>" + ls);
                fw.write("          <p>" + content + "</p>" + ls);
                fw.write("          <a href=" + kav + link + kav + "></a>" + ls);
                fw.write("      </content>" + ls);
                fw.write("  </body>" + ls);
                fw.write("</html>"+ls);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Structure.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
