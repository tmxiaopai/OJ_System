package com.oj.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author TMXIAOPAI
 * @Package com.oj.service
 * @Date 2019/11/20-下午4:19
 */
@ResponseBody
@Service
public class JudgeService {

    //将字符存储为文件
    public boolean writeFile(String content, String filename) {

        /*try {
            FileOutputStream fos = new FileOutputStream(file, true);
            StringBuffer sb = new StringBuffer();
            sb.append(content);
            fos.write(sb.toString().getBytes("utf-8"));
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;*/


        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(filename, false));
            bw.write(content);
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件存入异常");
            return false;
        }
        return true;

        /*FileOutputStream bos = null;
        try {
            bos = new FileOutputStream("output.txt");
            byte[] fileContent = result.getBytes();
            bos.write(fileContent);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*PrintStream bw;
        try {
            bw = new PrintStream(new FileOutputStream("/home/tmxiaopai/IdeaProjects/OJ_System/src/main/webapp/static/123.c"));
            bw.println(content);
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件存入异常");
            return false;
        }
        return true;*/
    }

    //读文件
    public void readFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String tempString;
        while ((tempString = reader.readLine()) != null) {
            /*String[] se = tempString.split(" ");//切割字符串
            for (int i = 0; i < se.length; i++) {
                System.out.println(Integer.valueOf(se[i]));
            }*/
            System.out.println(tempString);
        }
        reader.close();
    }


    public String formateDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);

    }

    //判度文件内容是否相同
    public boolean fileCompare(String outFileName, String fileName) {

        File file1 = new File(outFileName + ".txt");
        File file2 = new File(fileName = ".txt");

        if (file1.length() != file2.length()) {
            return false;
        }

        /*String md1=DigestUtils.md5Hex(new FileInputStream(outFileName));
        String md2=DigestUtils.md5Hex(new FileInputStream(fileName));*/
        /*BufferedReader reader1 = null;
        BufferedReader reader2 = null;
        try {
            reader1 = new BufferedReader(new FileReader(outFileName));
            reader2 = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("源输出文件或目标输出文件没有找到。。。。。。");
        }
        boolean flag = true;
        String tempstring1 = new String();
        String tempstring2 = new String();
        while (!(tempstring1 = reader1.readLine()).equals("")&&!(tempstring2 = reader2.readLine()).equals("")) {
            *//*try {
                if (!((reader1.readLine() != null) || (reader2.readLine() != null))) break;
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("文件按行读取错误。。。。。。");
            }*//*

         *//*try {
                tempstring1 = reader1.readLine();
                tempstring2 = reader2.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("来嗯个文件读取出现问题。。。。。。");
            }*//*
            System.out.println(tempstring1);
            System.out.println(tempstring2);
            if (!tempstring1.equals(tempstring2)) {
                System.out.println(tempstring1);
                System.out.println(tempstring2);
                return false;
            }


        }
        return true;
*/
        /*try {
            reader1.close();
            reader2.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文联读取流没有关闭");
        }*/
        return true;
    }

    //判题过程
    /*public String judgeCode(String sourceCode, Integer ouId) {
        String sourceFile = String.valueOf(ouId);
        writeFile(sourceCode, new File(sourceFile));
        if (complierCode(sourceFile)) {
            runCode(sourceFile);
        }
        return "编译失败";
    }*/

    //编译代码
    public String complierCode(String filename) {
        String result = null;
        try {
            System.out.println("要编译的文件名称为:" + filename);
            String cmd = "javac "+filename;
            result = execCmd(cmd, null);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("编译的时候出现了问题。。。");
        }
        return result;
    }

    //判断是否编译成功
    boolean isComplierSuccess(String filename){

    }

    //运行代码
    public boolean runCode(String filename) {
        try {
            System.out.println("宗内存" + Runtime.getRuntime().totalMemory());
            System.out.println("空闲内存" + Runtime.getRuntime().freeMemory());
            String result = execCmd("java " + filename, null);
            System.out.println("空闲内存" + Runtime.getRuntime().freeMemory());
            System.out.println(result);
            writeFile(result, new File(filename + "run.txt"));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("运行的时候出现了问题");
        }


        //比较代码运行结果是否一致


        return false;
    }

    //调用系统命令
    public String execCmd(String cmd, File dir) throws Exception {
        StringBuilder result = new StringBuilder();

        Process process = null;
        BufferedReader bufrIn = null;
        BufferedReader bufrError = null;

        try {
            // 执行命令, 返回一个子进程对象（命令在子进程中执行）
            process = Runtime.getRuntime().exec(cmd, null, dir);

            // 方法阻塞, 等待命令执行完成（成功会返回0）
            process.waitFor();

            // 获取命令执行结果, 有两个结果: 正常的输出 和 错误的输出（PS: 子进程的输出就是主进程的输入）
            bufrIn = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
            bufrError = new BufferedReader(new InputStreamReader(process.getErrorStream(), "UTF-8"));

            // 读取输出
            String line = null;
            while ((line = bufrIn.readLine()) != null) {
                result.append(line).append('\n');
            }
            while ((line = bufrError.readLine()) != null) {
                result.append(line).append('\n');
            }

        } finally {
            closeStream(bufrIn);
            closeStream(bufrError);

            // 销毁子进程
            if (process != null) {
                process.destroy();
            }
        }
        return result.toString();
    }

    private void closeStream(Closeable stream) {
        if (stream != null) {
            try {
                stream.close();
            } catch (Exception e) {
                // nothing
            }
        }
    }


}
