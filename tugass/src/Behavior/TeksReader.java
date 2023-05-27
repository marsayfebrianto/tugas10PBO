/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Behavior;

/**
 *
 * @author Second
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class TeksReader {
    public static void main(String[] args) throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            BufferedReader reader = new BufferedReader(new FileReader(file));
            int wordCount = 0;
            int lineCount = 0;
            int vowelCount = 0;
            int consonantCount = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                String[] words = line.trim().split("\\s+");
                wordCount += words.length;
                for (String word : words) {
                    for (int i = 0; i < word.length(); i++) {
                        char ch = Character.toLowerCase(word.charAt(i));
                        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                            vowelCount++;
                        } else if (ch >= 'a' && ch <= 'z') {
                            consonantCount++;
                        }
                    }
                }
            }
            reader.close();
            System.out.println("Jumlah kata: " + wordCount);
            System.out.println("Jumlah baris: " + lineCount);
            System.out.println("Jumlah huruf vokal: " + vowelCount);
            System.out.println("Jumlah huruf konsonan: " + consonantCount);
        } else {
            System.out.println("Pembacaan file dibatalkan.");
        }
    }
}

