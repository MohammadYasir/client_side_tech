/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.forkbrainz.service.question.util;

/**
 *
 * @author Mohammad yasir
 */
public class NetQuestionRequest {
    private int year;
    private String subject;
    private String month;
    private String paper;
    private String topic;
    private String unit;
    private int queNo;
    private String statement;
    private String [] options;
    private String [] correctOptions;
    private String description;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public String[] getCorrectOptions() {
        return correctOptions;
    }

    public void setCorrectOptions(String[] correctOptions) {
        this.correctOptions = correctOptions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
