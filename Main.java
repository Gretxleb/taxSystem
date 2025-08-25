import taxes.IncomeTaxSystem;
import taxes.IncomeMinusExpensesTaxSystem;

public class Main {
    public static void main(String[] args) {
        // Создаем компанию с системой "УСН доходы"
        System.out.println("--- Тестирование \"УСН доходы\" ---");
        Company company = new Company("ООО \"Ромашка\"", new IncomeTaxSystem());
        company.shiftMoney(1000); // Доход
        company.shiftMoney(-200); // Расход
        company.payTaxes(); // Налог: 1000 * 0.06 = 60 руб.

        System.out.println("\n--- Смена налоговой системы на \"УСН доходы минус расходы\" ---");
        // Меняем систему налогообложения на "УСН доходы минус расходы"
        company.setTaxSystem(new IncomeMinusExpensesTaxSystem());
        company.shiftMoney(1000); // Доход
        company.shiftMoney(-200); // Расход
        company.payTaxes(); // Налог: (1000 - 200) * 0.15 = 120 руб.
        
        System.out.println("\n--- Проверка случая с отрицательной прибылью ---");
        company.shiftMoney(500); // Доход
        company.shiftMoney(-800); // Расход
        company.payTaxes(); // Налог: (500 - 800) < 0 -> 0 руб.
    }
}
