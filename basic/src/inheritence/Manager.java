package inheritence;

class Manager extends Employee {
    double bonus;

    Manager(String n, double s, double b) {
        super(n,s);
        this.bonus = b;
    }

    double getBonus() {
        return bonus;
    }

    void setBonus(double b) {
        this.bonus = b;
    }
}
