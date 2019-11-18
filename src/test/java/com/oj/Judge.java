package com.oj;

import java.io.*;
import java.lang.Runtime;
import java.lang.Process;

/**
 * @author TMXIAOPAI
 * @Package com.oj
 * @Date 2019/11/18-下午3:59
 */
public class Judge {
    public static void main(String[] args) {
        Runtime run=Runtime.getRuntime();
        try {
           // Process process = run.exec("javac /home/OJ_Subject/Main.java");
            PrintStream oldPrintStream = System.out;
            FileOutputStream bos = null;
            Process process=null;
            try {
                bos = new FileOutputStream("output.txt");
                System.setOut(new PrintStream(bos));
                process = run.exec("java /home/OJ_Subject/Main");
                System.setOut(oldPrintStream);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }catch (IOException e) {
                e.printStackTrace();
            }

            String line;
            BufferedReader stdoutReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuffer out = new StringBuffer();
            while ((line = stdoutReader.readLine()) != null ) {
                System.out.println(line);
            }
            try {
                process.waitFor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            process.destroy();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
