import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import { ApiService } from '../../api.service';
import * as Plotly from 'plotly.js-dist-min';
import {Data} from 'plotly.js-dist-min';
@Component({
  selector: 'app-plot-graph',
  templateUrl: './plot-graph.component.html',
  styleUrls: ['./plot-graph.component.css']
})
export class PlotGraphComponent implements OnInit {
  constructor(private apiService: ApiService) { }
  ngOnInit(): void {
    this.getData();
  }

  getData(): void {
    this.apiService.vacPDay().subscribe(
      response => {
        this.loadData(response);
      },
      error => {
        console.error(error);
      }
    );
  }

  loadData(response: any): void{
    const trace1: Data = {

      x: response.map((d: any) => d.date),

      y: response.map((d: any) => d.vacs),

      type: 'scatter'

    };
    const data = [trace1];


    Plotly.newPlot('graph', data);
  }
}
