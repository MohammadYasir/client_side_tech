import { Component, OnInit, Input } from '@angular/core';
import { NgForOf } from '@angular/common';
import { Question } from '../question';

@Component({
  selector: 'app-qlist',
  templateUrl: './qlist.component.html',
  styleUrls: ['./qlist.component.css']
})
export class QlistComponent implements OnInit {

  @Input() allQuestions: Question[] = [];
  constructor() { }

  ngOnInit() {
  }

  onQuestionClicked(){
    console.log("Clicked")
  }
}
