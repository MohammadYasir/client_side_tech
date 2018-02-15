/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.forkbrainz.service.data;

import org.dizitart.no2.Document;
import org.dizitart.no2.mapper.Mappable;
import org.dizitart.no2.mapper.NitriteMapper;

/**
 *
 * @author Mohammad yasir
 */
public class McqData implements Mappable {

    private String statement;
    private String [] options;
    private String [] correctOptions;
    private String description;
    
    @Override
    public Document write(NitriteMapper nm) {
        Document doc = new Document();
        doc.put("statement", getStatement());
        doc.put("options", getOptions());
        doc.put("correctOptions", getCorrectOptions());
        doc.put("description", getDescription());
        return doc;
    }

    @Override
    public void read(NitriteMapper nm, Document dcmnt) {
        if(dcmnt != null){
            setStatement(dcmnt.get("statement", String.class));
            setOptions(dcmnt.get("options", String[].class));
            setCorrectOptions(dcmnt.get("correctOptions", String[].class));
            setDescription(dcmnt.get("description", String.class));
        }
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
