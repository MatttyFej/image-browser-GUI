package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class ImgDataBaseManager {

    public String collectImgInfo(String imgName, String autor, String localization, String date, String tags, String path){
        return imgName + "," + autor + "," + localization + "," + date + "," + tags + "," + path;
    }

    public void addImageToDataBase(String fileName, String imgInfo)
        throws IOException {
        Path filePath = Paths.get(fileName);
        Files.write(filePath, Arrays.asList(imgInfo), Files.exists(filePath) ? StandardOpenOption.APPEND : StandardOpenOption.CREATE);

    }

    public void printDataBase (String fileName) throws IOException{
        File file = new File(fileName);

        BufferedReader br = new BufferedReader(new FileReader(file));
        String currentLine;
        while ((currentLine = br.readLine()) != null){
            System.out.println(currentLine);
        }

    }

    public String dataBaseToString (String fileName) throws IOException{
        File file = new File(fileName);

        BufferedReader br = new BufferedReader(new FileReader(file));
        String dataBaseStr = "";
        String currentLine;
        while ((currentLine = br.readLine()) != null){
            dataBaseStr += currentLine + "\n";
        }
        return dataBaseStr;

    }
}
