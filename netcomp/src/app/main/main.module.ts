import { NgModule }       from '@angular/core';
import { MainComponent } from './main.component';
import { HomeComponent } from './home/home.component';

import { MainRoutingModule } from './main-routing.module';
import { AnalyzeComponent } from './analyze/analyze.component';
import { QpapersComponent } from './qpapers/qpapers.component';
import { PrintedComponent } from './printed/printed.component';
import { ProgressComponent } from './progress/progress.component';
import { AccountComponent } from './account/account.component';
import { QlistComponent } from './home/qlist/qlist.component';
import { QlistitemComponent } from './home/qlist/qlistitem/qlistitem.component';
import { DisplayComponent } from './home/display/display.component';
import { SearchComponent } from './home/search/search.component';

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
    AccountComponent,
    QlistComponent,
    QlistitemComponent,
    DisplayComponent,
    SearchComponent
  ]
})
export class MainModule {}
