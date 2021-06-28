import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../shared/employee.service';
import { Employee } from 'src/app/Model/employee.model';


@Component({
  selector: 'app-employee-form',
  templateUrl: './employee-form.component.html',
  styleUrls: ['./employee-form.component.css']
})
export class EmployeeFormComponent implements OnInit {

  allCatName: String[];
  selectCatName: String ='';
  constructor(
    private employeeservice: EmployeeService
  ) { }

  selectChange(event: any) {
    this.selectCatName = event.target.value;
  }

  ngOnInit() {
    this.getAllCatname();
  }

  getAllCatname() {
    this.employeeservice.getAllCatName().subscribe(
      (data: String[]) => {
        this.allCatName = data;
      }
    );
  }

  createOrUpdate(currentEmployee: Employee) {

    if ( currentEmployee.catid != null ) {
      this.updateEmployee(currentEmployee);
    } else {
      this.createEmployee(currentEmployee);
    }
  }

  createEmployee(emp: Employee) {
    this.employeeservice.createEmployee(emp).subscribe();
    this.ngOnInit();
  }

  updateEmployee(emp: Employee) {
    this.employeeservice.updateEmployee(emp).subscribe();
  }

  clear() {
    this.employeeservice.currentEmployee = {
    catid: '',
    catname: '',
    description: '',
    };
  }

}
