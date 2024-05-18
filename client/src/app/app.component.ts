import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {BottomNavigationComponent} from "./components/bottom-navigation/bottom-navigation.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, BottomNavigationComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'client';
}
