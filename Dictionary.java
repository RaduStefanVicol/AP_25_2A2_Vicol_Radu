package org.example.lab7experiment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Dictionary {
    private final ArrayList<String> words = new ArrayList<>();

    public Dictionary(String filePath) {
        loadWordsFromFile(filePath);
    }

    private void loadWordsFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.contains("'") && line.length()<8)
                    words.add(line.trim().toUpperCase());
            }
        } catch (IOException e) {
            System.err.println("Error reading dictionary file: " + e.getMessage());
        }
    }

    public int isInDictionary(String word) {
        int[] wordFreq = new int[26];
        word = word.toUpperCase();
        for (char c : word.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                wordFreq[c - 'A']++;
            }
        }
        for (String dictWord : words) {
            if (dictWord.length() != word.length()) continue;
            int[] dictFreq = new int[26];
            for (char c : dictWord.toCharArray()) {
                if (c >= 'A' && c <= 'Z') {
                    dictFreq[c - 'A']++;
                }
            }
            boolean found = true;
            for (int i = 0; i < 26; i++) {
                if (wordFreq[i] < dictFreq[i]) {
                    found = false;
                    break;
                }
            }
            if (found) {
                int sum=0;
                for (int i:dictFreq)
                    sum+=dictFreq[i];
                System.out.println("\n\n\n\nFOUND WORD:\n" + dictWord + "\n\n\n");
                return sum;
            }
        }
        return 0;
    }


    public ArrayList<String> getWords() {
        return words;
    }
}
