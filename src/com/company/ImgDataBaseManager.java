package com.company;

import java.io.IOException;
import java.nio.charset.Charset;
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
}
