import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { NgForOf } from '@angular/common';
import { Question } from '../question';

@Component({
  selector: 'app-qlist',
  templateUrl: './qlist.component.html',
  styleUrls: ['./qlist.component.css']
})
export class QlistComponent implements OnInit {

  @Input() allQuestions: Question[] = [];
  @Output() questionclicked : EventEmitter<Question> = new EventEmitter<Question>();
  constructor() { }

  ngOnInit() {
  }

  onQuestionClicked(question){
    this.questionclicked.emit(question);
  }
}
