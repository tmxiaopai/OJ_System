package com.oj;

import java.io.*;

/**
 * @author TMXIAOPAI
 * @Package com.oj
 * @Date 2019/11/20-上午10:03
 */
public class ReadFile {

    public static void main(String[] args) throws IOException {
       /* Reader reader = new InputStreamReader(new FileInputStream(" output.txt"));

// 一次读一个字节
        int tempchar;
        while ((tempchar = reader.read()) != -1) {
            // 对于windows下，\r\n这两个字符在一起时，表示一个换行。
            // 但如果这两个字符分开显示时，会换两次行。
            // 因此，屏蔽掉\r，或者屏蔽\n。否则，将会多出很多空行。
            if (((char) tempchar) != '\r'||((char) tempchar) != '\n') {
                System.out.println("1"+(char) tempchar);
            }
        }
        reader.close();*/

        BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
        String tempString = null;
// 一次读入一行，直到读入null为文件结束
        while ((tempString = reader.readLine()) != null) {
            String[] se=tempString.split(" ");
            Integer a[]=new Integer[8];
            Integer b[]=new Integer[8];
            for(int i=0;i<se.length;i++){
                if(0==i%2)a[i/2]=Integer.valueOf(se[i]);
                else {
                    b[i/2]=Integer.valueOf(se[i]);
                }
            }
            for(int i=0;i<a.length;i++){
                System.out.println("a"+a[i]);
                System.out.println("b"+b[i]);
            }
        }
        reader.close();


        /*FileInputStream fileInputStream;
        byte[] fileContent = new byte[9];
        try {
            fileInputStream = new FileInputStream("output.txt");
            fileContent = fileInputStream.toString().getBytes();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<Integer> a=new ArrayList<>();
        ArrayList<Integer> b=new ArrayList<>();
        for(int i=0;i<fileContent.length;i++){
            if(0==i%2){
                a.add(Integer.parseInt(String.valueOf(fileContent[i])));
            }else {
                b.add(Integer.parseInt(String.valueOf(fileContent[i])));
            }
            System.out.println("第"+i+"个:" + fileContent[i]);
        }
        for(Integer as:a){
            System.out.println(as.toString());
        }
        for(Integer as:b){
            System.out.println(as.toString());
        }*/
    }

}
