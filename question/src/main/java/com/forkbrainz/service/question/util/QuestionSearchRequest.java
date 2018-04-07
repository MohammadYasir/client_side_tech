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
public class QuestionSearchRequest {
    private int year;
    private String month;
    private String unit;
    private String topic;
    private String paper;

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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getPaper() {
        return paper;
    }

    public void setPaper(String paper) {
        this.paper = paper;
    }

    @Override
    public String toString() {
        return "Year: "+year+" month: "+month+" unit: "+unit+" topic: "+topic;
    }
}
