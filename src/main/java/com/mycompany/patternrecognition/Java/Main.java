package com.mycompany.patternrecognition.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author Mykyta Tymko
 */
public class Main {

    /**
     * Iterate through each line of input.
     * @param args
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
            String[] splittedInput = line.split(";");
            String pattern = splittedInput[0];
            String blobs = splittedInput[1];
            Main.doSomething(pattern, blobs);
        }
    }

    public static void doSomething(String pattern, String blobs) {

        String[] wor = blobs.split("A");
        String[] symbols = pattern.split("");

        int[] count = new int[wor.length + 1];
        for (int i = 0; i < wor.length; i++) {
            count[i] = 0;
        }

        for (int i = 0; i < wor.length; i++) {
            for (int j = 0; j < wor[i].length() - 1; j++) {
                String[] sym = wor[i].split("");
                if (sym[j].equals(symbols[0])) {
                    for (int k = 0; k < symbols.length; k++) {
                        if (k == symbols.length - 1 && sym[j + k].equals(symbols[0 + k])) {
                            count[i]++;
                        } else if (sym[j + k].equals(symbols[0 + k])) {
                            continue;
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < wor.length; i++) {
            count[wor.length] += count[i];
        }

        for (int i = 0; i < wor.length + 1; i++) {
            if (i == wor.length) {
                System.out.print(count[i]);
            } else {
                System.out.print(count[i] + "|");
            }
        }

    }

}
