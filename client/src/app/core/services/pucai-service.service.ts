import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';
import {IPucai} from '../models/pucai';

@Injectable({
  providedIn: 'root',
})
export class PucaiService {

  constructor(private http: HttpClient) {
  }

  findAllFromLastWeek(): Observable<IPucai[]> {
    return this.http.get<IPucai[]>('http://localhost:8080/api/v1/pucais/last-week');
  }

  findAllFromLastDay(): Observable<IPucai[]> {
    return this.http.get<IPucai[]>('http://localhost:8080/api/v1/pucais/last-day');
  }

  findById(id: number): Observable<IPucai> {
    return this.http.get<IPucai>(`http://localhost:8080/api/v1/pucais/${id}`);
  }

  save(pucai: IPucai): Observable<any> {
    return this.http.post('http://localhost:8080/api/v1/pucais', pucai);
  }

  deleteById(id: number): Observable<any> {
    return this.http.delete(`http://localhost:8080/api/v1/pucais/${id}`);
  }

  hasUserSubmittedScoreToday() {
    return this.findAllFromLastDay().pipe(
      map(scores => {
        if (Array.isArray(scores)) {
          console.log(scores)
          return scores.length > 0;
        }
        return false
      })
    )
  }
}
