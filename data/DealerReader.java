package com.neu.jan17.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.TreeSet;

public class DealerReader {
    TreeSet<String> sorted = new TreeSet<String>();

    public TreeSet<String> DealersReader() {
        try{
            URL pathUrl = getClass().getResource("dealers.txt");
            File dealersFile = new File(pathUrl.getPath());
            BufferedReader reader = new BufferedReader(new FileReader(dealersFile));
            String line=null;
            while((line=reader.readLine())!=null){
                sorted.add(line);
            }reader.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return sorted;
    }

}
