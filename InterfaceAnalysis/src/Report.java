
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author taisi
 */
public class Report 
{
    ArrayList<RecordReport> records;
    
    public Report(){
        records = new ArrayList<>();
    }
    
    void AddRecord(int userID, double workTime, boolean success){
        records.add(new RecordReport(userID, workTime, success) );
    }
    
    
    void SaveToFile(String fn){
        File f = new File(fn);
        
        try {
            FileWriter fw = new FileWriter(f);
            String line;
            String sep = System.getProperty("line.separator");
            fw.write("userID; workTime; success;" + sep);
            for (int i =0; i <records.size(); i++){
                line = records.get(i).userID + ";" + records.get(i).workTime + ";" + records.get(i).success+ ";" + sep;
                fw.write(line.replace(".",","));
            }
            fw.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
    }
}
