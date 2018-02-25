import { NgModule }       from '@angular/core';
import { MainComponent } from './main.component';
import { HomeComponent } from './home/home.component';

import { MainRoutingModule } from './main-routing.module';
import { AnalyzeComponent } from './analyze/analyze.component';
import { QpapersComponent } from './qpapers/qpapers.component';
import { PrintedComponent } from './printed/printed.component';
import { ProgressComponent } from './progress/progress.component';
import { AccountComponent } from './account/account.component';

@NgModule({
  imports: [
    MainRoutingModule
  ],
  declarations: [
    MainComponent,
    HomeComponent,
    AnalyzeComponent,
    QpapersComponent,
    PrintedComponent,
    ProgressComponent,
    AccountComponent
  ]
})
export class MainModule {}
