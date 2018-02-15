/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.forkbrainz.service.question.controller;

import com.forkbrainz.service.data.ugcnet.NetQuestion;
import org.dizitart.no2.WriteResult;
import org.dizitart.no2.objects.ObjectRepository;
import org.dizitart.no2.util.Iterables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Mohammad yasir
 */
@RestController
public class UgcNetCsController {
    
    @Autowired
    @Qualifier("CsRepository")
    private ObjectRepository<NetQuestion> collection;
    
    @PostMapping("/add")
    public Long addQuestion(@RequestBody NetQuestion question){
        WriteResult result = collection.insert(question);
        return Iterables.firstOrDefault(result).getIdValue();
    }
}
