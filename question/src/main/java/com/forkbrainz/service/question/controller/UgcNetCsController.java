/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.forkbrainz.service.question.controller;

import com.forkbrainz.service.data.McqData;
import com.forkbrainz.service.data.ugcnet.NetQuestion;
import com.forkbrainz.service.data.ugcnet.Subject;
import com.forkbrainz.service.question.util.NetQuestionRequest;
import org.dizitart.no2.NitriteId;
import org.dizitart.no2.WriteResult;
import org.dizitart.no2.objects.ObjectRepository;
import org.dizitart.no2.util.Iterables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @Autowired
    @Qualifier("McqDataRepository")
    private ObjectRepository<McqData> collectionMcq;
    
    @PostMapping("/add")
    public Long addQuestion(@RequestBody NetQuestionRequest req){
        //Create NetQuestion Object
        NetQuestion question = new NetQuestion();
        question.setMonth(req.getMonth());
        question.setYear(req.getYear());
        question.setTopic(req.getTopic());
        question.setUnit(req.getUnit());
        question.setSubject(Subject.valueOf(req.getSubject()));
        question.setPaper(req.getPaper());
        question.setQueNo(req.getQueNo());
        
        //Create McqData Object
        McqData data = new McqData();
        data.setStatement(req.getStatement());
        data.setOptions(req.getOptions());
        data.setCorrectOptions(req.getCorrectOptions());
        data.setDescription(req.getDescription());
        
        //Insert McqData in DB
        WriteResult res = collectionMcq.insert(data);
        Long dataId = Iterables.firstOrDefault(res).getIdValue();
        
        //Add DataId of the inserted value in Question
        question.setDataId(dataId);
        
        //Insert Question in DB
        WriteResult result = collection.insert(question);
        return Iterables.firstOrDefault(result).getIdValue();
    }
    
    @GetMapping("/qdata/{id}")
    public ResponseEntity<McqData> getQuestionData(@PathVariable(value = "id") Long dataId){
        NitriteId nid = NitriteId.createId(dataId);
        McqData data = collectionMcq.getById(nid);
        return ResponseEntity.ok().body(data);
    }
}
