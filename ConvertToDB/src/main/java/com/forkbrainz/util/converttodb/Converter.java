/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.forkbrainz.util.converttodb;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Mohammad yasir
 */
public class Converter {

    public static final String BASE_PATH = "E:\\CHECKOUT\\web1\\netappserver\\war\\questions";
    
    public static int COUNT = 0;

    public static void main(String[] args) {
        //File f = new File("E:\\CHECKOUT\\web1\\netappserver\\war\\questions\\2016\\july\\p3\\53");
        File f = new File(BASE_PATH);
        try {
            processDir(f);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static void processDir(File dir) throws IOException{
        File[] files = dir.listFiles();
        for (File f : files) {
            if(f.isDirectory()) {
                processDir(f);
            } else {
                System.out.println(dir.getAbsolutePath());
                try {
                    String json = getJson(dir);
                    sendJson(json);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Exception: "+e.getMessage());
                }
                break;
            }
        }
    }

    public static String getJson(File dir) throws IOException {
        File file = new File(dir, "q.html");
        Document doc = Jsoup.parse(file, "UTF-8");
        processHtmlForImages(dir, doc);
        Element qDetails = doc.getElementById("qDetails");
        Element qContent = doc.getElementById("qContent");
        Element qOptions = doc.getElementById("qOptions");
        Element qAnswer = doc.getElementById("qAnswer");
        Element qDescription = doc.getElementById("qDescription");
        
        NetQuestionRequest req = new NetQuestionRequest();
        
        processQDetails(qDetails, req);
        processQOptions(qOptions, qAnswer, req);
        req.setStatement(qContent.html());
        req.setDescription(qDescription.html());
        req.setSubject("CS");
        
        Gson g = new GsonBuilder().disableHtmlEscaping().create();
        return g.toJson(req);
    }

    public static void sendJson(String json) throws UnsupportedEncodingException, IOException {
        String url = "http://localhost:8080/add";
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        StringEntity entity = new StringEntity(json);
        post.setEntity(entity);
        post.setHeader("Accept", "application/json");
        post.setHeader("Content-type", "application/json");

        CloseableHttpResponse response = client.execute(post);
        if (response.getStatusLine().getStatusCode() != 200) {
            System.out.println("Response code got: "+response.getStatusLine().getStatusCode());
        } 
        client.close();
        COUNT++;
        try {
            Thread.sleep(250);
        } catch (Exception e) {
        }
    }

    /**
     * This function processes a given String in html doc for image tags and
     * embed the given image.
     */
    private static void processHtmlForImages(File dir, Document doc) {
        Elements elems = doc.getElementsByTag("img");
        elems.forEach(ele -> {
            String src = ele.attr("src");
            String filename = src.substring(src.indexOf("qimg"));
            File file = new File(dir, filename);
            String encodedData = encodeFileToBase64Binary(file, "png");
            ele.attr("src", encodedData);
        });
    }

    /**
     * This function encodes a given image to a stream of bytes.
     */
    private static String encodeFileToBase64Binary(File file, String extension) {
        String encodedfile = null;
        try (FileInputStream fileInputStreamReader = new FileInputStream(file);) {
            byte[] bytes = new byte[(int) file.length()];
            fileInputStreamReader.read(bytes);
            encodedfile = Base64.getEncoder().encodeToString(bytes);
            if ("PNG".equalsIgnoreCase(extension)) {
                return "data:image/png;base64," + encodedfile;
            } else if ("JPEG".equalsIgnoreCase(extension) || "JPG".equalsIgnoreCase(extension)) {
                return "data:image/jpg;base64," + encodedfile;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void processQDetails(Element qDetails, NetQuestionRequest req) {
        Elements elem = qDetails.getElementsByTag("li");
        elem.forEach(li->{
            if(li.html().contains("Q No.:")){
                String str = li.getElementsByTag("strong").first().html();
                req.setQueNo(Integer.parseInt(str));
            }
            if(li.html().contains("Exam:")){
                String str = li.getElementsByTag("strong").first().html();
                String str1[] = str.split(",");
                String str2[] = str1[0].split(" ");
                req.setYear(Integer.parseInt(str2[1]));
                req.setMonth(StringUtils.capitalize(str2[0]));
                req.setPaper(str1[1]);
            }
            if(li.html().contains("Unit:")){
                String str = li.getElementsByTag("p").first().html();
                req.setUnit(str);
            }
            if(li.html().contains("Topic(s):")){
                String str = li.getElementsByTag("p").first().html();
                req.setTopic(str);
            }
        });
    }

    private static void processQOptions(Element qOptions, Element qAnswer, NetQuestionRequest req) {
        String str = qAnswer.getElementsByTag("p").html();
        String[] correctOptions = new String[1];
        correctOptions[0]= str;
        req.setCorrectOptions(correctOptions);
        ArrayList<String> opt = new ArrayList<>();
        Elements elem = qOptions.getElementsByTag("li");
        
        elem.forEach(li->{
            opt.add(li.html());
        });
        String[] options = new String[4];
        options[0] = opt.get(0);
        options[1] = opt.get(1);
        options[2] = opt.get(2);
        options[3] = opt.get(3);
        req.setOptions(options);
    }
}
