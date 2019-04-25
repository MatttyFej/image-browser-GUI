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
        JPanel menuPanel = new JPanel();
        JPanel dataBasePanel = new JPanel();
        JPanel displayImagePanel = new JPanel();
        JLabel inputLabel = new JLabel("You didn't type yet!");

        //Text fields declarations
        JTextField imgNameTxtField = new JTextField();
        JTextField autorTxtField = new JTextField();
        JTextField localizationTxtField = new JTextField();
        JTextField dateTxtField = new JTextField();
        JTextField fileNameTxtField = new JTextField();
        JTextField tagsTxtField = new JTextField();
        JTextField filePathTxtField = new JTextField();
        JTextField findByTagTextFiled = new JTextField("specify tag");

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
        JButton chooseFileButton = new JButton("Choose image");
        JButton printDataBaseButton = new JButton("Print data base");
        JButton loadDataBaseButton = new JButton("Load data base");
        JButton findByTagButton = new JButton("Print images with specified tag");
        JButton upgradedPrintDataBaseButton = new JButton("Actually print data base");
        JButton goToMenuButton = new JButton("Menu");


        JFileChooser fileChooser = new JFileChooser();
        JTextArea printedDataBaseTextArea = new JTextArea("Here you'll see data base");
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
        findByTagTextFiled.setBounds(500, 300, 200, 40);
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
        loadDataBaseButton.setBounds(500, 100, 200, 40);
        printDataBaseButton.setBounds(500, loadDataBaseButton.getY()+loadDataBaseButton.getHeight(), 200, 40);
        upgradedPrintDataBaseButton.setBounds(printDataBaseButton.getX() + printDataBaseButton.getWidth(), printDataBaseButton.getY(), 200 , 40);
        findByTagButton.setBounds(500, findByTagTextFiled.getY() + findByTagTextFiled.getHeight(), 280, 40);
        goToMenuButton.setBounds(500, 400, 200, 40);

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
        mainPanel.add(loadDataBaseButton);
        mainPanel.add(findByTagTextFiled);
        mainPanel.add(findByTagButton);
        mainPanel.add(goToMenuButton);
        mainPanel.add(upgradedPrintDataBaseButton);


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
                new ImgDataBaseManager().printDataBase();
            } catch (Exception e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(mainFrame, "Nie wczytano żadnej bazy danych!");
            }
        });

        //printing data base in TextArea
        upgradedPrintDataBaseButton.addActionListener(e -> {
            printedDataBaseTextArea.setText(new ImgDataBaseManager().getDataBaseHolder());
            mainFrame.setContentPane(dataBasePanel);
            mainFrame.repaint();
            mainFrame.revalidate();
        });

        //this button is not created yet
        loadDataBaseButton.addActionListener(e -> {
            boolean isSuccesful = true;
            try {
                new ImgDataBaseManager().loadDataBaseToString(fileNameTxtField.getText());
            } catch (IOException e1) {
                JOptionPane.showMessageDialog(mainFrame, "Nie znaleziono pliku o (nie)podanej nazwie!");
                isSuccesful = false;
            }
            if(isSuccesful)
                inputLabel.setText("Data base succesfully loaded");
        });

        findByTagButton.addActionListener(e -> {
            new ImgDataBaseManager().printImgListWithSpecifiedTag(findByTagTextFiled.getText());
        });

        goToMenuButton.addActionListener(e -> {
            mainFrame.setContentPane(menuPanel);
            mainFrame.repaint();
            mainFrame.revalidate();
        });


        //creating and setting main frame
        Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
        mainFrame.setSize(screenDim.width/2, screenDim.height/2);
        mainFrame.setContentPane(menuPanel);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);

        //menu Panel
        JButton functionsButton = new JButton("Actual fucntions");
        JButton displayImageButton = new JButton("Display image");

        functionsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        displayImageButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.add(functionsButton);
        menuPanel.add(displayImageButton);

        functionsButton.addActionListener(e -> {
            mainFrame.setContentPane(mainPanel);
            mainFrame.repaint();
            mainFrame.revalidate();
        });

        ImageIcon icon = new ImageIcon("C:\\Users\\Mattty\\Desktop\\Moje własne 3.0\\zdjecia\\maxresdefault.jpg");
        JLabel imageLabel = new JLabel(icon);
        JButton imageLabelToMenuButton = new JButton("Back to menu");
        imageLabel.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));

        displayImagePanel.setLayout(new BoxLayout(displayImagePanel, BoxLayout.Y_AXIS));

        displayImagePanel.add(imageLabel);
        displayImagePanel.add(imageLabelToMenuButton);

        displayImageButton.addActionListener(e -> {
            mainFrame.setSize(icon.getIconWidth(), icon.getIconHeight() + 100);
            mainFrame.setContentPane(displayImagePanel);
            mainFrame.repaint();
            mainFrame.revalidate();
        });

        imageLabelToMenuButton.addActionListener(e -> {
            mainFrame.setContentPane(menuPanel);
            mainFrame.repaint();
            mainFrame.revalidate();
        });

        //display data base panel
        dataBasePanel.add(goToMenuButton);
        dataBasePanel.add(printedDataBaseTextArea);



    }
}
