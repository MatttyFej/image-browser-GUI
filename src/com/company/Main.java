package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });

    }

    public static void createAndShowGUI() {
        //declaring components of the main frame
        JFrame mainFrame = new JFrame();
        JPanel mainPanel = new JPanel();
        JLabel inputLabel = new JLabel("You didn't type yet!");

        //Text fields declarations
        JTextField imgNameTxtField = new JTextField();
        JTextField autorTxtField = new JTextField();
        JTextField localizationTxtField = new JTextField();
        JTextField dateTxtField = new JTextField();
        JTextField fileNameTxtField = new JTextField();
        JTextField tagsTxtField = new JTextField();
        JTextField filePathTxtField = new JTextField();

        //Labels next to Text Fields declarations
        JLabel imgNameTxtFieldLbl = new JLabel("Name your image:");
        JLabel autorTxtFieldLbl = new JLabel("Autor:");
        JLabel localizationTxtFieldLbl = new JLabel("Localization:");
        JLabel dateTxtFieldLbl = new JLabel("Date:");
        JLabel fileNameTxtFieldLbl = new JLabel("Data base file name:");
        JLabel tagsTxtFieldLbl = new JLabel("Tags seperated by space:");
        JLabel filePathTxtFieldLbl = new JLabel("Here will be file path:");

        //Buttons
        JButton saveTextButton = new JButton("Add image");
        JButton chooseFileButton = new JButton("Wybierz obraz");
        JButton printDataBaseButton = new JButton("Print data base");

        JFileChooser fileChooser = new JFileChooser();
        //Positioning panel's elements
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.MAGENTA);
        //positioning Text Fieldss
        imgNameTxtField.setBounds(250, 100, 200, 40);
        autorTxtField.setBounds(imgNameTxtField.getX(), imgNameTxtField.getY() + imgNameTxtField.getHeight(), 200, 40);
        localizationTxtField.setBounds(imgNameTxtField.getX(), autorTxtField.getY() + autorTxtField.getHeight(), 200, 40);
        dateTxtField.setBounds(imgNameTxtField.getX(), localizationTxtField.getY() + localizationTxtField.getHeight(), 200, 40);
        fileNameTxtField.setBounds(imgNameTxtField.getX(), dateTxtField.getY() + dateTxtField.getHeight(), 200, 40);
        tagsTxtField.setBounds(imgNameTxtField.getX(), fileNameTxtField.getY() + fileNameTxtField.getHeight(), 200, 40);
        filePathTxtField.setBounds(imgNameTxtField.getX(), tagsTxtField.getY() + tagsTxtField.getHeight(), 200, 40);
        //positioning Labels next to Text Fieldss
        imgNameTxtFieldLbl.setBounds(imgNameTxtField.getX() - 150, imgNameTxtField.getY(), 200, 40);
        autorTxtFieldLbl.setBounds(imgNameTxtFieldLbl.getX(), imgNameTxtFieldLbl.getY() + imgNameTxtFieldLbl.getHeight(), 200, 40);
        localizationTxtFieldLbl.setBounds(imgNameTxtFieldLbl.getX(), autorTxtFieldLbl.getY() + autorTxtFieldLbl.getHeight(), 200, 40);
        dateTxtFieldLbl.setBounds(imgNameTxtFieldLbl.getX(), localizationTxtFieldLbl.getY() + localizationTxtFieldLbl.getHeight(), 200, 40);
        fileNameTxtFieldLbl.setBounds(imgNameTxtFieldLbl.getX(), dateTxtFieldLbl.getY() + dateTxtFieldLbl.getHeight(), 200, 40);
        tagsTxtFieldLbl.setBounds(imgNameTxtFieldLbl.getX(), fileNameTxtFieldLbl.getY() + fileNameTxtFieldLbl.getHeight(), 200, 40);
        filePathTxtFieldLbl.setBounds(imgNameTxtFieldLbl.getX(), tagsTxtFieldLbl.getY() + tagsTxtFieldLbl.getHeight(), 200, 40);

        saveTextButton.setBounds(filePathTxtField.getX(), filePathTxtField.getY() + filePathTxtField.getHeight(), 100, 40);
        chooseFileButton.setBounds(imgNameTxtField.getX(), imgNameTxtField.getY() - imgNameTxtField.getHeight(), 200, 40);
        printDataBaseButton.setBounds(500, 100, 200, 40);

        inputLabel.setBounds(500, 210, 200, 40);
        mainPanel.add(saveTextButton);
        mainPanel.add(imgNameTxtField);
        mainPanel.add(autorTxtField);
        mainPanel.add(localizationTxtField);
        mainPanel.add(dateTxtField);
        mainPanel.add(fileNameTxtField);
        mainPanel.add(tagsTxtField);
        mainPanel.add(filePathTxtField);
        mainPanel.add(inputLabel);
        mainPanel.add(chooseFileButton);
        mainPanel.add(imgNameTxtFieldLbl);
        mainPanel.add(autorTxtFieldLbl);
        mainPanel.add(localizationTxtFieldLbl);
        mainPanel.add(dateTxtFieldLbl);
        mainPanel.add(fileNameTxtFieldLbl);
        mainPanel.add(tagsTxtFieldLbl);
        mainPanel.add(filePathTxtFieldLbl);
        mainPanel.add(printDataBaseButton);


        //Saving text button functions
        saveTextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //String imgDataLine = "\n" + imgNameTxtField.getText() + "," + autorTxtField.getText() + "," + localizationTxtField.getText() + "," + dateTxtField.getText() + "\n";
                ImgDataBaseManager  dtbManager = new ImgDataBaseManager();
                String imgDataLine = dtbManager.collectImgInfo(imgNameTxtField.getText(), autorTxtField.getText(), localizationTxtField.getText(), dateTxtField.getText(),tagsTxtField.getText(), filePathTxtField.getText());
                try {
                    dtbManager.addImageToDataBase(fileNameTxtField.getText(), imgDataLine);
                } catch (IOException e1) {
                    inputLabel.setText("Blad");
                }
                inputLabel.setText("DODANO!");
            }
        });

        //image choosing button functions
        chooseFileButton.addActionListener(event -> fileChooser.showOpenDialog(mainFrame));
        fileChooser.addActionListener(event -> {
            String path = fileChooser.getSelectedFile().getPath();
            String fileName = fileChooser.getSelectedFile().getName();
            filePathTxtField.setText(path);
            imgNameTxtField.setText(fileName);
        });

        printDataBaseButton.addActionListener(e -> {
            try {
                new ImgDataBaseManager().printDataBase(fileNameTxtField.getText());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        //this button is not created yet
        /*loadDataBaseButton.addActionListener(e -> {
            try {
                System.out.println(new ImgDataBaseManager().dataBaseToString(fileNameTxtField.getText()));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });*/


        //creating and setting main frame
        Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
        mainFrame.setSize(screenDim.width/2, screenDim.height/2);
        mainFrame.setContentPane(mainPanel);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);

    }
}
