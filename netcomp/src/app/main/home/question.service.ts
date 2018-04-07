import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Question } from './question';
import { McqData } from './mcqdata';

@Injectable()
export class QuestionService {

  constructor(private http: HttpClient) { }

  get(obj){
    return this.http.post<Question[]>('http://localhost:8080/search', obj);
  }

  getQuestionData(id){
    return this.http.get<McqData>('http://localhost:8080/qdata/'+id);
  }
}
