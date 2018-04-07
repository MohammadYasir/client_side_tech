import { Component, OnInit, Input } from '@angular/core';
import { Question } from '../../question';

@Component({
  selector: 'app-qlistitem',
  templateUrl: './qlistitem.component.html',
  styleUrls: ['./qlistitem.component.css']
})
export class QlistitemComponent implements OnInit {

  @Input() question : Question;
  constructor() { }

  ngOnInit() {
  }
}
