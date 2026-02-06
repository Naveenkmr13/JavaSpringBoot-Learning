package inheritence;

class Employee {
    String name;
    double salary;

    Employee(String n, double s){
        this.name = n;
        this.salary = s;
    }
    Employee() {
        this.name = "Unknown";   // in manager.java it call the base class constructor using super() => if we give parameter not a plm
        // but if not we want to create constructor in base class without parameter;
        this.salary = 0.0;
    }
    String getName(){
        return name;
    }
    void setName(String n){
        name = n;
    }
    double getSalary() {
        return salary;
    }
    void setSalary(String n) {
        name = n;
    }
    void raiseSalary(double percent) {
        salary += salary * percent;
    }
}
