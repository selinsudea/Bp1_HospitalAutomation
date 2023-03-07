
/*
 *@file Hastaneotomasyon 
 *@ Bir hastane otomasyonu hazırladım.Çeşitli kontroller yaparak randevu alabiliyorum.
 *@assignment Proje2
 *@18.01.2022-22.01.2022
 * @author Selin Sude ATALI - selinsude.atali@stu.fsm.edu.tr
 */

public class Arraylist {

    private Object array[];

    private int size;

    private int capacity;

    public Arraylist() {
        array = new Object[2];
        size = 0;
        capacity = 2;
    }

    public void addElement(Object element) {

        if (size == capacity) {
            ensureCapacity(2);
        }
        array[size] = element;
        size++;
    }

    public void addElement(String element) {

        if (size == capacity) {
            ensureCapacity(2);
        }
        array[size] = element;
        size++;
    }

    public void addElement(long element) {

        if (size == capacity) {
            ensureCapacity(2);
        }
        array[size] = element;
        size++;
    }

    public void addElement(int index, Object element) {

        if (size == capacity) {
            ensureCapacity(2);
        }

        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }

        array[index] = element;
        size++;
    }

    public void addElement(int index, int element) {

        if (size == capacity) {
            ensureCapacity(2);
        }

        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }

        array[index] = element;
        size++;
    }

    public void addElement(int element) {
        if (size == capacity) {
            ensureCapacity(2);
        }
        array[size] = element;
        size++;
    }

    public Object getElement(int index) {
        return array[index];
    }

    public int randevugetir(int i) {
        return (int) array[i];
    }

    public String stringgetir(int i) {
        return (String) array[i];
    }

    public long randevugetirlong(int i) {
        return (long) array[i];
    }

    public Doktor doktorgetir(int i) {
        return (Doktor) array[i];
    }

    public void remove(int index) {
        if (index >= size || index < 0) {
            System.out.println("No element at this index");
        } else {
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            array[size - 1] = null;
            size--;
        }
    }

    public void ensureCapacity(int minCapacity) {
        Object temp[] = new Object[capacity * minCapacity];
        for (int i = 0; i < capacity; i++) {
            temp[i] = array[i];
        }
        array = temp;
        capacity = capacity * minCapacity;
    }

    public void trimToSize() {
        System.out.println("Trimming the array");
        Object temp[] = new String[size];
        for (int i = 0; i < size; i++) {
            temp[i] = array[i];
        }
        array = temp;
        capacity = array.length;

    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

}
