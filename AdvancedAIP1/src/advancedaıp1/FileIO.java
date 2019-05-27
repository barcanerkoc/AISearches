package advancedaıp1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


//mkyong.com üzerinde bulunan dosyadan okuma işlemini refere ederek yaptım hocam.
public class FileIO{
    
    // Data assumed will store data like this:
    // 1 2 3
    // 4 5 6
    // 6 7 0
    // ----- End of first puzzle
    // 1 4 3
    // 2 7 6
    // 0 5 6
    // 9 12 11
    // ----- End of second puzzle
    public static int[][] readData(String path){
        
        ArrayList<ArrayList<Integer>> data = new ArrayList<>();
        
        BufferedReader br = null;
        FileReader fr = null;
        
        try {
            
            fr = new FileReader(path);
            br = new BufferedReader(fr);
            
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                
                if(sCurrentLine.charAt(0) == '-'){
                    continue;
                }
                
                ArrayList<Integer> rowData = new ArrayList<>();
                String[] nums = sCurrentLine.split(" ");
                for(int x = 0; x < nums.length ; x++){
                    
                    rowData.add(Integer.valueOf(nums[x]));
                    
                }
                
                data.add(rowData);
                
            }
            
        } catch (IOException e) {
            
            e.printStackTrace();
            
        } finally {
            
            try {
                
                if (br != null)
                    br.close();
                
                if (fr != null)
                    fr.close();
                
            } catch (IOException ex) {
                
                ex.printStackTrace();
                
            }
            
        }
        
        int[][] dataConv = new int[data.size()][data.get(0).size()];
        
        for(int y = 0; y < data.size(); y++){
            
            for(int x = 0; x < data.size(); x++){
                
                dataConv[y][x] = data.get(y).get(x);
                
            }
            
        }
        
        return dataConv;
        
    }
    
    
}
