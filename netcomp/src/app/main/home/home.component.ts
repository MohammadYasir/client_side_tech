import { Component, OnInit } from '@angular/core';
import { QuestionService } from './question.service';
import { Question } from './question';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  allQuestions : Question[] = [];

  constructor(private questionService: QuestionService) { }

  ngOnInit() {
    this.questionService.get().subscribe(questions=>{
      console.log(questions);
      this.allQuestions = questions;
    });
  }

}
