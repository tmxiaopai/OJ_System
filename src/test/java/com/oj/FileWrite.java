package com.oj;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author TMXIAOPAI
 * @Package com.oj
 * @Date 2019/11/20-上午10:30
 */
public class FileWrite {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.java",true));
        String content="public class M {\n" +
                "    public static void main(String[] args) {\n" +
                "        System.out.println(\"ok current\");\n" +
                "        for (int i = 0; i < 100; i++) {\n" +
                "            System.out.println(i);\n" +
                "        }\n" +
                "    }\n" +
                "}\n19 22\n" +
                "25 33\n" +
                "33 44\n" +
                "4444 55\n";
        bw.write(content);
        bw.flush();
        bw.close();
    }
}
