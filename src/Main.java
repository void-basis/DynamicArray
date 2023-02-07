/*
Массивы в Java имеют фиксированную длину. Попробуем обойти это ограничение. Создайте класс DynamicArray, который хранит
в себе массив, и имеет методы для добавления void add(T el), void remove(int index) удаления и извлечения T get(int index)
из него элементов, при переполнении текущего массива, должен создаваться новый, большего размера.

Для возможности работы с различными классами DynamicArray должен быть дженериком. Для решения задачи можно воспользоваться
 методами из класса java.util.Arrays. Импорт этого класса уже объявлен в тестирующей системе. Добавлять его явно не нужно

Требования:
1. должен быть класс public static class DynamicArray
2. класс DynamicArray должен иметь методы публичные void add(T el), void remove(int index) и T get(int index)
3. В случае подбора некорректного индекса ожидается, что метод get выбросит ArrayIndexOutOfBoundsException
4. класс DynamicArray должен  иметь публичный конструктор по умолчанию
5. работа методов должна соответствовать условию
 */

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        DynamicArray<Integer> array = new DynamicArray<>();
        array.add(0);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        array.add(6);
        array.add(7);
        array.add(8);
        array.add(9);
        //System.out.println(array.get(0));
        //System.out.println(array.get(2));
        //System.out.println(array.get(6));
        //System.out.println(array.get(7));
        array.remove(7);
        //System.out.println(array.get(6));
        //System.out.println(array.get(7));
        //System.out.println(array.get(6));
        //array.remove(7);
        //array.remove(7);
        array.add(10);
        array.add(11);
        array.add(12);
        array.add(13);
        array.add(14);
        System.out.println(array.get(0));
        System.out.println(array.get(14));
        System.out.println(array.get(1));
        System.out.println(array.get(4));
        // for (int u = 0; u < array.length; u++) {
        //   System.out.print(array.get(u) + " ");
        //}
    }
}

class DynamicArray<T> {
    T[] array = (T[]) new Object[0];
    T[] buffer;

    public void add(T el) {
        //System.out.println("длина массива до увеличения " + array.length);
        array = Arrays.copyOf(array, array.length + 1);
        array[array.length - 1] = el;
        //System.out.println("длина массива после увеличения " + array.length);
    }

    public void remove(int index) {
        if (array.length > index) {
            buffer = array;
            array = (T[]) new Object[array.length - 1];
                /*System.out.println("длина до удаления *** " + array.length);
                for (int i = 0; i < array.length; i++) {
                    System.out.print(array[i] + " ");
                }
                System.out.println();*/
            System.arraycopy(buffer, 0, array, 0, index);
            System.arraycopy(buffer, index + 1, array, index, array.length - index);
                /*System.out.println("длина после удаления ***" + array.length);
                for (int i = 0; i < array.length; i++) {
                    System.out.print(array[i] + " ");
                }
                System.out.println();*/
        }
    }

    public T get(int index) {
        if ((array.length > index) && (array[index] != null)) {
            return array[index];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
}
