import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Component } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { HomepageComponent } from './homepage/homepage.component';
import { RouterModule } from '@angular/router';
import { EmployeeModule } from './employees/employee.module';
import { from } from 'rxjs';

@NgModule({
  declarations: [
    AppComponent,
    HomepageComponent,
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot ([
      {path: "**", component: HomepageComponent }
    ]),
    EmployeeModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
