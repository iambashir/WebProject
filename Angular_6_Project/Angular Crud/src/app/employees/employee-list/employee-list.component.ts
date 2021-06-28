import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../shared/employee.service';
import { Employee } from 'src/app/Model/employee.model';
import { tap } from 'rxjs/operators';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  [x: string]: any;

  allEmployee: Employee[];

  constructor(
    private employeeService: EmployeeService
  ) { }

  ngOnInit() {
    this.getAllEmployees();

    this.employeeService.refreshNeeded$.subscribe(()=>{this.getAllEmployees();});
    this.getAllEmployees();
    
  }

  getAllEmployees(){
    this.employeeService.getAllEmployees().subscribe(
      (data: Employee[]) => {
        this.allEmployee = data;
      }
    );
  }

  deleteEmployee(catid: string) {
    this.employeeService.deleteEmployee(catid).subscribe(
      (data: Employee) => {
        this.getAllEmployees();
      }
    );
  }

  editEmployee(emp: Employee) {
    this.employeeService.currentEmployee = Object.assign({}, emp);
  }

}
