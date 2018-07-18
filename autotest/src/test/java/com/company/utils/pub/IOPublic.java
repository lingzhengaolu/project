package com.company.utils.pub;

import java.io.*;
import java.util.ArrayList;

public class IOPublic {
    private String originalPath;
    private String targetPath;

    //构造1：无参构造
    public IOPublic() {
    }

    //构造二：单参数传入
    public IOPublic(String filepath) {
        this.originalPath = filepath;
        this.targetPath = filepath;
    }

    //构造三：双参数传入
    public IOPublic(String originalpath, String targetpath) {
        this.originalPath = originalpath;
        this.targetPath = targetpath;
    }
    //copy重载1
    public void copy(File fid) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(fid);
        } catch (IOException e) {
            e.printStackTrace();
        }
        copyCommonCode(fis);
    }

    //copy重载2
    public void copy(File fid, String targetpath) {
        targetPath = targetpath;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(fid);
        } catch (IOException e) {
            e.printStackTrace();
        }
        copyCommonCode(fis);
    }

    //copy重载3
    public void copy(String originalpath, String targetpath) {
        originalPath = originalpath;
        targetPath = targetpath;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(originalPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        copyCommonCode(fis);
    }
    //read重载1
    public ArrayList<String> read() {
        return readCommonCode();
    }

    //read重载2
    public ArrayList<String> read(String originalpath) {
        this.originalPath = originalpath;
        return readCommonCode();
    }
    //write重载1
    public void write(String value) {
        writeCommonCode(value);
    }

    //write重载2
    public void write(String targetpath, String value) {
        targetPath = targetpath;
        writeCommonCode(value);
    }


    //read公共方法
    private ArrayList<String> readCommonCode() {
        ArrayList<String> arrayList=new ArrayList<String>();
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            File fr = new File(originalPath);
            fis = new FileInputStream(fr);
            isr = new InputStreamReader(fis, "gbk");//解决乱码
            br = new BufferedReader(isr);
            String ss = "T";//初始化
            while (ss != null) {
                ss = br.readLine();
                if (ss != null) {//如果ss为null则不打印
                    arrayList.add(ss);
                    System.out.println(ss);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                isr.close();
                fis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }



    //write公共方法
    private void writeCommonCode(String value) {
        FileOutputStream fos;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            File fw = new File(targetPath);
            fos = new FileOutputStream(fw, true);//追加写入
            osw = new OutputStreamWriter(fos);
            bw = new BufferedWriter(osw);
            bw.write(value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
                osw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //copy公共方法
    private void copyCommonCode(FileInputStream fis) {
        BufferedInputStream bis = null;//加缓冲区，也可以不加
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;//加缓冲区，也可以不加
        try {
            bis = new BufferedInputStream(fis);
            fos = new FileOutputStream(targetPath);
            bos = new BufferedOutputStream(fos);
            byte[] data = new byte[1024];
            int len;
            System.out.println("正在复制，请稍后...");
            while ((len = bis.read(data)) != -1) {//对于大文件读取1024字节后，写入1024字节
                bos.write(data, 0, len);//防止非4k磁盘分区的文件最后一次写入不足1024字节报错的情况
            }
            System.out.println("复制完毕！");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                bos.close();
                fos.close();
                bis.close();
                fis.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }


}