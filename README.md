Создать абстрактный класс Person (человек) с методами:
```Java
public abstract void init(Scanner scanner) // считывание параметров с консоли
public int getAge(); // возвращается возраст человека на текущий момент (полное количество лет) 
public String toString() // возвращается состояние объекта в виде строки (определяется только в наследниках, т.к.определен в Object)
```
Построить иерархию классов:
* Человек 
  * Студент
  * Школьник
  * Сотрудник
    * Преподаватель
    * Директор
Написать программу, которая:
1) Считывает с консоли количество человек.
2) В цикле считывает параметры. Сначала спрашивается тип персоны и создается объект
нужного класса. Затем у объекта вызывается метод init() и вводятся характеристики
объекта (номер зачетной книжки для студента, номер сертификата для преподавателя и
т.д.).
Метод init() разный у разных классов.
3) Считанные объекты кладутся в массив.
4) Ищется самый младший человек и выводится на экран (вывод через toString())
