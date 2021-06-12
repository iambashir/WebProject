package com.example.el;

public class Employee {
  private Name name;
  private Company company;

  public Employee(Name name, Company company) {
    setName(name);
    setCompany(company);
  }

  public Name getName() {
    return (name);
  }

  public void setName(Name name) {
    this.name = name;
  }

  public Company getCompany() {
    return (company);
  }

  public void setCompany(Company company) {
    this.company = company;
  }
}
