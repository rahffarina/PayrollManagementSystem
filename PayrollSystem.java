package payrollsystem;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PayrollSystem {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new FullTimeEmployee("E001", "أحمد علي", 1200.0, LocalDate.of(2021, 5, 10), 300.0));
        employees.add(new ContractorEmployee("E002", "سارة محمد", LocalDate.of(2023, 1, 15), 25, 160));
        employees.add(new FullTimeEmployee("E003", "خالد عبدالله", 1500.0, LocalDate.of(2019, 8, 1), 400.0));
        employees.add(new ContractorEmployee("E004", "فاطمة عمر", LocalDate.of(2022, 11, 20), 30, 180));

        System.out.println("--- القائمة قبل الفرز ---");
        for (Employee e : employees) {
            System.out.println(e);
        }

        Collections.sort(employees);
        System.out.println("\n--- القائمة بعد الفرز تنازلياً حسب صافي الدخل ---");
        for (Employee e : employees) {
            System.out.println(e);
        }

        employees.sort(Comparator.comparing(Employee::getJoinDate));
        System.out.println("\n--- القائمة مرتبة حسب تاريخ الانضمام (الأقدمية) ---");
        for (Employee e : employees) {
            System.out.println(e);
        }

        double totalTax = 0;
        double totalBonus = 0;
        double performanceScoreExample = 4.5;

        for (Employee e : employees) {
            totalTax += e.calculateTax();
            totalBonus += e.calculateBonus(performanceScoreExample);
        }

        System.out.println("\n--- التكاليف الإجمالية ---");
        System.out.println("إجمالي الضرائب المستقطعة: " + totalTax);
        System.out.println("إجمالي المكافآت الموزعة: " + totalBonus);
    }
}
