import { Component, OnInit, Input } from '@angular/core';
import { Question } from '../question';
import { McqData } from '../mcqdata';

@Component({
  selector: 'app-display',
  templateUrl: './display.component.html',
  styleUrls: ['./display.component.css']
})
export class DisplayComponent implements OnInit {

  @Input() question : Question;
  @Input() mcqdata : McqData;
  constructor() { }

  ngOnInit() {
  }

}
