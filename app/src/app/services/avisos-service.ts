import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AvisosService {

  private API_URL = "http://localhost:8080/api/aviso"

  constructor(private httpClient: HttpClient) {}

  getAvisos(): Observable<any>{
    return this.httpClient.get(this.API_URL);
  }

  postAvisos(aviso: any): Observable<any>{
    return this.httpClient.post(this.API_URL, aviso);
  }
}
