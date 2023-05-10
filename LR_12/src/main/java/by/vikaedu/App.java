package by.vikaedu;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("------- Задание 1 : -------" );
        System.out.println("Hello Вика!" );

        System.out.println("------- Задание 2 : -------" );
        System.out.println("--- Объекты, созданные каскадными конструкторами" );
        // t1 - стаж 0, английский 0
	Tester t1 = new Tester ("Иванов", "Иван", 1000.00);
        // t2 - стаж 10, английский 0
        Tester t2 = new Tester ("Петров", "Петр", 10, 2000.00);
        // t3 - стаж 10, английский 5
        Tester t3 = new Tester ("Сидоров", "Сидор", 10, 5, 3000.00);
        System.out.println(t1.toString());
        System.out.println(t2.toString());
        System.out.println(t3.toString());
        System.out.println("--- Проверка статических методов Tester.CalcEarning и Tester.SumToString" );
        System.out.println("Начислено Сидорову за 1 месяц с кф 6 за стаж и 2 за знание английского :" );
        System.out.println("t3.Earning(1, 6, 2) = "+Tester.SumToString(t3.Earning(1, 6, 2)));
        System.out.println("Tester.CalcEarning(1, 3000.00, 10*6, 5*2) = "+
                               Tester.SumToString(Tester.CalcEarning(1, 3000.00, 10*6, 5*2)));
    }
}
