import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Question } from '../../question';

@Component({
  selector: 'app-qlistitem',
  templateUrl: './qlistitem.component.html',
  styleUrls: ['./qlistitem.component.css']
})
export class QlistitemComponent implements OnInit {

  @Input() question : Question;
  @Output() clicked = new EventEmitter();
  constructor() { }

  ngOnInit() {
  }

  onClicked(){
    this.clicked.emit(this.question);
  }
}
