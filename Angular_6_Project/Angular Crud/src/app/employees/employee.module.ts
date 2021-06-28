import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { EmployeeFormComponent } from './employee-form/employee-form.component';
import { EmployeeService } from './shared/employee.service';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HttpClient } from '@angular/common/http';

@NgModule({
  declarations: [
    EmployeeListComponent,
    EmployeeFormComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    EmployeeService
  ],
  exports: [
    EmployeeListComponent,
    EmployeeFormComponent
  ]
})
export class EmployeeModule { }
