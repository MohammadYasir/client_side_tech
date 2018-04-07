import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { papers } from '../../paperdata';
import { syllabus } from '../../syllabusdata';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  papers = papers;
  syllabus = syllabus;
  units = [];
  topics = [];
  form;
  @Output() searchEvt : EventEmitter = new EventEmitter();

  constructor() { }

  ngOnInit() {
    this.form = new FormGroup({
      paper : new FormControl({}),
      unit : new FormControl(),
      topic : new FormControl()
    });
    this.form.paper = this.papers[0];
    this.units = this.syllabus.paperII.unit;
    this.topics = this.units[0].topic;
    this.form.unit = this.units[0];
    //this.form.topic = this.topics[0];
  }

  search(){
    this.searchEvt.emit({
      unit: this.form.unit.name,
      topic: this.form.topic.name,
      month: this.form.paper.month,
      year: this.form.paper.year
    });
  }

  onPaperChange(){
    if (this.form.paper.paper === 2) {
      this.units = this.syllabus.paperII.unit;
    } else {
      this.units = this.syllabus.paperIII.unit;
    }
    this.form.unit = this.units[0];
    this.topics = this.units[0].topic;
    //this.form.topic = this.topics[0];
  }

  onUnitChange(){
    this.topics = this.form.unit.topic;
    //this.form.topic = this.topics[0];
  }

}
