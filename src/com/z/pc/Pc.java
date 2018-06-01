package com.z.pc;


import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Pc {
    public void startPc(){
        try {
            URL url = new URL("http://quote.eastmoney.com/zs000001.html");
            URLConnection con =  url.openConnection();
            con.connect();//建立连接
//            con.setRequestProperty("User-Agent","Mozilla/5.0 (Windows Nt 6.1; WoW64) AppleWebKit/537.36"+" (KHTML,like Gecko) Chrome/45.0.2454.101 Safari/537.36");


//            InputStream inputStream =  url.openStream();
            InputStream inputStream = con.getInputStream();
            StringBuffer sb = new StringBuffer();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            String a = "";
            while ( (a=br.readLine())!=null){
                sb.append(a+"\n");
            }
            inputStream.close();
            FileOutputStream fs = new FileOutputStream("d:1.txt");
            fs.write(sb.toString().getBytes());



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
            Pc pc = new Pc();
            pc.startPc();
    }
}
