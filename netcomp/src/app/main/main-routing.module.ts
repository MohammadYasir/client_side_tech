import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common'
import { RouterModule, Routes } from '@angular/router';
import { MainComponent } from './main.component';
import { HomeComponent } from './home/home.component';
import { AnalyzeComponent } from './analyze/analyze.component';
import { QpapersComponent } from './qpapers/qpapers.component';
import { PrintedComponent } from './printed/printed.component';
import { ProgressComponent } from './progress/progress.component';
import { AccountComponent } from './account/account.component';
import { QuestionService } from './home/question.service';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';

const mainRoutes: Routes = [
  { path: '', component: MainComponent, children: [
    { path:'', component: HomeComponent },
    { path:'home', component: HomeComponent },
    { path:'analyze', component: AnalyzeComponent },
    { path:'qpapers', component: QpapersComponent },
    { path:'printed', component: PrintedComponent },
    { path:'track', component: ProgressComponent },
    { path:'account', component: AccountComponent }
  ] }
];

@NgModule({
  imports: [
    RouterModule.forChild(mainRoutes)
  ],
  exports: [
    RouterModule, CommonModule, HttpClientModule, ReactiveFormsModule
  ],
  providers: [QuestionService]
})
export class MainRoutingModule { }
