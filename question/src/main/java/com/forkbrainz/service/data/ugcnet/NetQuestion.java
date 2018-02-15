/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.forkbrainz.service.data.ugcnet;

import com.forkbrainz.service.data.McqData;
import org.dizitart.no2.Document;
import org.dizitart.no2.mapper.Mappable;
import org.dizitart.no2.mapper.NitriteMapper;

/**
 *
 * @author Mohammad yasir
 */
public class NetQuestion implements Mappable{
    
    private int year;
    private Subject subject;
    private String month;
    private String paper;
    private String topic;
    private String unit;
    private int queNo;
    private McqData data;

    @Override
    public Document write(NitriteMapper nm) {
        Document doc = new Document();
        doc.put("year", getYear());
        doc.put("subject", getSubject());
        doc.put("month", getMonth());
        doc.put("paper", getPaper());
        doc.put("topic", getTopic());
        doc.put("unit", getUnit());
        doc.put("queNo", getQueNo());
        doc.put("data", data.write(nm));
        return doc;
    }

    @Override
    public void read(NitriteMapper nm, Document dcmnt) {
        if(dcmnt != null){
            setYear(dcmnt.get("year", Integer.class));
            setSubject(dcmnt.get("subject", Subject.class));
            setMonth(dcmnt.get("month", String.class));
            setPaper(dcmnt.get("paper", String.class));
            setTopic(dcmnt.get("topic", String.class));
            setUnit(dcmnt.get("unit", String.class));
            setQueNo(dcmnt.get("queNo", Integer.class));
            McqData mcq = new McqData();
            mcq.read(nm, dcmnt);
            setData(mcq);
        }
    }
    
    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getPaper() {
        return paper;
    }

    public void setPaper(String paper) {
        this.paper = paper;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getQueNo() {
        return queNo;
    }

    public void setQueNo(int queNo) {
        this.queNo = queNo;
    }

    public McqData getData() {
        return data;
    }

    public void setData(McqData data) {
        this.data = data;
    }

}
