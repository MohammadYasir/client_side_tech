import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Question } from './question';

@Injectable()
export class QuestionService {

  constructor(private http: HttpClient) { }

  get(){
    return this.http.post<Question[]>('http://localhost:8080/search', {year:2012});
  }
}
