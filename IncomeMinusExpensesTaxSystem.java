package taxes;

public class IncomeMinusExpensesTaxSystem extends TaxSystem {
    @Override
    public int calcTaxFor(int debit, int credit) {
        // Рассчитываем разницу
        int profit = debit - credit;
        // Налог 15% от разницы, если она положительная
        if (profit > 0) {
            return (int) (profit * 0.15);
        } else {
            return 0;
        }
    }
}
