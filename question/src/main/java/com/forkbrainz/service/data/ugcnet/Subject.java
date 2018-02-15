/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.forkbrainz.service.data.ugcnet;

/**
 *
 * @author Mohammad yasir
 */
public enum Subject {
    
    CS("Computer Science");
    
    private final String text;

    private Subject(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
    
    
}
