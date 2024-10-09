import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class ApiService {
  // private apiUrl = 'http://localhost:8081/countryVaccinatio';
  private apiUrl = environment.apiUrl;

  constructor(private http: HttpClient) {}

  vacPDay(): Observable<any> {
    return this.http.get(`${this.apiUrl}/vacPDay`);
  }

  sendData(data: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/upload`, data);
  }
}
