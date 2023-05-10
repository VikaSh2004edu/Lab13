package by.vikaedu;

import java.lang.Math;
import java.text.DecimalFormat;

/**
 * Tester
 *
 */
public class Tester 
{
    public String name;
    public String surName;
    public int expirienceInYears;
    public int englishLevel;
    public double salary;
    // 1. Перегруженный через this Конструктор
    // Универсальный конструктор
    public Tester (String name, String surname, int expirienceinyears, int englishlevel, double salary)
    {
      this.name = name;
      this.surName = surname;
      this.expirienceInYears = expirienceinyears;
      this.englishLevel = englishlevel;
      this.salary = salary;
    }
    // Конструктор с нулевым стажем 
    public Tester (String name, String surname, int englishlevel, double salary)
    {
      // Вызываем универсальный конструктор с expirienceinyears=0
      this(name, surname, 0, englishlevel, salary);
    }
    // Конструктор с нулевым уровлем владения английским и нулевым стажем
    public Tester (String name, String surname, double salary)
    {
      // Вызываем конструктор с нулевым стажем с englishlevel=0
      this(name, surname, 0, salary);
    }

    // 2. Перегруженный метод Расчет оплаты - с учетов повышающих коэффициентов на стаж и знание английского
    // countmonth - колич месяцев (м.б. нецелым 1+3/31 - 1мес + 3 дня из 31
    // kfexpirience - повышающий коэффициент за стаж
    // kfenglish - повышающий коэффициент за знание английского
    public double Earning (double countmonth, double kfexpirience, double kfenglish)
    {
      return this.CalcEarning (countmonth, this.salary, kfexpirience * this.expirienceInYears, this.englishLevel * kfenglish);
    }
    // Расчет оплаты - с нулевым коэффициентом за знание английского и kfenglish=0.0
    public double Earning (double countmonth, double kfexpirience)
    { // Вызываем полный метод расчета
      return this.Earning(countmonth, kfexpirience, 0.0);
    }
    // Расчет оплаты - с нулевымы коэффициентами
    public double Earning (double countmonth)
    { // Вызываем метод с нулевым коэффициентом английского и kfexpirience=0.0
      return this.Earning(countmonth, 0.0);
    }
    // 3. Статический метод расчета начисленной суммы 
    // countmonth - колич месяцев (м.б. нецелым 1+3/31 - 1мес + 3 дня из 31
    // doplexpirience - доплата за стаж
    // doplenglish - доплата за знание английского
    public static double CalcEarning (double countmonth, double salary, double doplexpirience, double doplenglish)
    {
      double v = (salary + doplexpirience + doplenglish) * countmonth;
      // Пытаемся округлить результат до копеек
      return Math.round(v * 100.0) / 100.0;
    }
    // 3. Преобразование double в string с двумя знаками после запятой
    public static String SumToString (double sum)
    {
      DecimalFormat df = new DecimalFormat("#.00");
      return df.format(sum);
    }
    @Override
    public String toString()
    {
      String s = this.name + " " + this.surName +
                 ", стаж "+Integer.valueOf(this.expirienceInYears).toString()+
                 ", уровень английского "+Integer.valueOf(this.englishLevel).toString()+
                 ", оклад "+SumToString(this.salary);
      return s;
    }
}
