import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {PucaiViewComponent} from "./views/pucai-view/pucai-view.component";
import {BottomNavigationComponent} from "./shared/bottom-navigation/bottom-navigation.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, PucaiViewComponent, BottomNavigationComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Pucai';
}
