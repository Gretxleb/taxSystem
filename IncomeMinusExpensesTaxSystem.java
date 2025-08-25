package taxes;

public class IncomeMinusExpensesTaxSystem extends TaxSystem {
    @Override
    public int calcTaxFor(int debit, int credit) {
        int profit = debit - credit;
        if (profit > 0) {
            return (int) (profit * 0.15);
        } else {
            return 0;
        }
    }
}
