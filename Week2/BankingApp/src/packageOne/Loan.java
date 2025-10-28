package packageOne;

class Loan {
    double amount;
    double rate;
    int years;

    Loan(double amount, double rate, int years) {
        this.amount = amount;
        this.rate = rate;
        this.years = years;
    }

    double totalSimpleAmount() {
        return amount + (amount * rate * years) / 100;
    }

    double simpleEMI() {
        return totalSimpleAmount() / (years * 12);
    }

    double totalCompoundAmount() {
        return amount * Math.pow(1 + rate / 100, years);
    }

    double compoundEMI() {
        return totalCompoundAmount() / (years * 12);
    }
}


