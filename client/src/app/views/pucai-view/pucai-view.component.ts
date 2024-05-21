import {Component, ElementRef, ViewChild} from '@angular/core';
import {PucaiService} from "../../core/services/pucai-service.service";
import {AsyncPipe} from "@angular/common";

@Component({
  selector: 'app-pucai-view',
  standalone: true,
  imports: [
    AsyncPipe
  ],
  providers: [PucaiService],
  templateUrl: './pucai-view.component.html',
  styleUrl: './pucai-view.component.css',
})
export class PucaiViewComponent {
  @ViewChild('stomachache') stomachache!: ElementRef<HTMLSelectElement>;
  @ViewChild('bleeding') bleeding!: ElementRef<HTMLSelectElement>;
  @ViewChild('consistence') consistence!: ElementRef<HTMLSelectElement>;
  @ViewChild('stoolIn24Hours') stoolIn24Hours!: ElementRef<HTMLSelectElement>;
  @ViewChild('nocternal') nocternal!: ElementRef<HTMLSelectElement>;
  @ViewChild('activity') activity!: ElementRef<HTMLSelectElement>;

  constructor(private pucai: PucaiService) {
    this.pucai.hasUserSubmittedScoreToday().subscribe(
      res => {
        this.isScoreSubmittedToday = res;
      }
    );
  }

  sum = 0;
  isScoreSubmittedToday = true;

  saveValue(value: string) {
    this.sum += Number(value)
  }

  resetValues() {
    this.stomachache.nativeElement.selectedIndex = 0;
    this.bleeding.nativeElement.selectedIndex = 0;
    this.consistence.nativeElement.selectedIndex = 0;
    this.stoolIn24Hours.nativeElement.selectedIndex = 0;
    this.nocternal.nativeElement.selectedIndex = 0;
    this.activity.nativeElement.selectedIndex = 0;
  }

  savePucai(score: number) {
    if (score !== 0 && !this.isScoreSubmittedToday) {
      this.pucai.save({
        score: score,
        date: new Date()
      }).subscribe();
    }
  }
}
