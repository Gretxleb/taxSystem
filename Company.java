import taxes.TaxSystem;

public class Company {
    private String title;
    private int debit = 0;
    private int credit = 0;
    private TaxSystem taxSystem;

    public Company(String title, TaxSystem taxSystem) {
        this.title = title;
        this.taxSystem = taxSystem;
    }

    public void shiftMoney(int amount) {
        if (amount > 0) {
            this.debit += amount;
        } else if (amount < 0) {
            this.credit += Math.abs(amount);
        }
    }

    public void setTaxSystem(TaxSystem newTaxSystem) {
        this.taxSystem = newTaxSystem;
    }

    public void payTaxes() {
        // Полиморфный вызов: calcTaxFor() будет использовать логику
        // конкретного объекта taxSystem (УСН доходы или УСН доходы-расходы)
        int taxAmount = taxSystem.calcTaxFor(debit, credit);
        System.out.printf("Компания %s уплатила налог в размере: %d руб.\n", this.title, taxAmount);
        this.debit = 0;
        this.credit = 0;
    }
}
