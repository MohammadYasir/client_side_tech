import { Component, OnInit } from '@angular/core';
import { QuestionService } from './question.service';
import { Question } from './question';
import { McqData } from './mcqdata';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  allQuestions : Question[] = [];
  currentQuestion : Question;
  currentQuestionData : McqData;

  constructor(private questionService: QuestionService) {
    this.questionService.get({year:2012}).subscribe(questions=>{
      this.allQuestions = questions;
      this.currentQuestion = questions[0];
      this.questionService.getQuestionData(this.currentQuestion.dataId).subscribe(mcqdata=>{
        this.currentQuestionData = mcqdata;
      });
    });
  }

  ngOnInit() {

  }
  onQuestionClicked(question){
    this.currentQuestion = question;
    //Load the question data from server
    this.questionService.getQuestionData(question.dataId).subscribe(mcqdata=>{
      this.currentQuestionData = mcqdata;
    });
  }
  search(obj){
    this.questionService.get(obj).subscribe(qs=>{
      console.log(qs);
      this.allQuestions = qs;
      this.currentQuestion = qs[0];
      this.questionService.getQuestionData(this.currentQuestion.dataId).subscribe(mcqdata=>{
        this.currentQuestionData = mcqdata;
      });
    });
  }
}
