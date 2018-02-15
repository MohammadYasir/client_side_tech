/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.forkbrainz.util.converttodb;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;
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

    public static void main(String[] args) {
        File f = new File("E:\\CHECKOUT\\web1\\netappserver\\war\\questions\\2015\\december\\p3\\60");
        try {
            getJson(f);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }

    public static String getJson(File dir) throws IOException {
        File file = new File(dir, "q.html");
        Document doc = Jsoup.parse(file, "UTF-8");
        
        Element qDetails = doc.getElementById("qDetails");
        Element qContent = doc.getElementById("qContent");
        Element qOptions = doc.getElementById("qOptions");
        Element qAnswer = doc.getElementById("qAnswer");
        Element qDescription = doc.getElementById("qDescription");

        return null;
    }

    /**
     * This function processes a given String in html doc for image tags
     * and embed the given image.
    */
    private static void processHtmlForImages(File dir, Document doc){
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
            if("PNG".equalsIgnoreCase(extension)){
                return "data:image/png;base64,"+encodedfile;
            } else if("JPEG".equalsIgnoreCase(extension) || "JPG".equalsIgnoreCase(extension)) {
                return "data:image/jpg;base64,"+encodedfile;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
