import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MainDashbordComponent } from './main-dashbord/main-dashbord.component';
import * as PlotlyJS from 'plotly.js-dist-min';
import { PlotlyModule } from 'angular-plotly.js';
import {CommonModule} from '@angular/common';
import { PlotGraphComponent } from './componentes/plot-graph/plot-graph.component';
import { HttpClientModule } from '@angular/common/http';
import { BotaoUploadComponent } from './componentes/botao-upload/botao-upload.component';
import {FormsModule} from "@angular/forms";
import { HashLocationStrategy, LocationStrategy } from '@angular/common';

PlotlyModule.plotlyjs = PlotlyJS;
@NgModule({
  declarations: [
    AppComponent,
    MainDashbordComponent,
    PlotGraphComponent,
    BotaoUploadComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CommonModule,
    PlotlyModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [{provide: LocationStrategy, useClass: HashLocationStrategy}],
  bootstrap: [AppComponent]
})
export class AppModule { }
