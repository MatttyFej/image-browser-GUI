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
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImgDataBaseManager {

    private static String dataBaseHolder;

    public String getDataBaseHolder() {
        return dataBaseHolder;
    }

    public void setDataBaseHolder(String dataBaseHolder) {
        this.dataBaseHolder = dataBaseHolder;
    }

    public String collectImgInfo(String imgName, String autor, String localization, String date, String tags, String path){
        return imgName + "," + autor + "," + localization + "," + date + "," + tags + "," + path;
    }

    public void addImageToDataBase(String fileName, String imgInfo)
        throws IOException {
        Path filePath = Paths.get(fileName);
        Files.write(filePath, Arrays.asList(imgInfo), Files.exists(filePath) ? StandardOpenOption.APPEND : StandardOpenOption.CREATE);

    }

    public void printDataBase () {
        Scanner scanner = new Scanner(dataBaseHolder);
        while(scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }

    public void loadDataBaseToString(String fileName) throws IOException{
        dataBaseHolder = "";
        File file = new File(fileName);

        BufferedReader br = new BufferedReader(new FileReader(file));
        String currentLine;
        while ((currentLine = br.readLine()) != null){
            dataBaseHolder += currentLine + "\n";
        }
        br.close();
    }

    public void saveDataBaseToFile (String fileName, String dataBase) throws IOException{
        Path filePath = Paths.get(fileName);
        Files.write(filePath, Arrays.asList(dataBase), Files.exists(filePath) ? StandardOpenOption.APPEND : StandardOpenOption.CREATE);
    }

    public String getTags (String dataBaseLine){
        Pattern pattern = Pattern.compile("(.*),(.*),(.*),(.*),(.*),(.*)");
        Matcher matcher = pattern.matcher(dataBaseLine);
        matcher.matches();
        return matcher.group(5);
    }

    public void printImgListWithSpecifiedTag (String tag){
        Scanner dtbScanner = new Scanner(getDataBaseHolder());
        String currentLine = "";
        while(dtbScanner.hasNextLine()){
            currentLine = dtbScanner.nextLine();
            String dtbTags = getTags(currentLine);
            boolean containsTag = dtbTags.toLowerCase().contains(tag.toLowerCase());
            if(containsTag)
                System.out.println(currentLine);
        }
    }
}
