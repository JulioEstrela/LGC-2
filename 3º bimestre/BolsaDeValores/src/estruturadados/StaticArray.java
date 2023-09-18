package estruturadados;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Function;

public class StaticArray<T> {
    private int size = 0;
    private int capacity;
    private Object[] elements;

    public StaticArray() {
        final int DEFAULT_CAPACITY = 10;
        this.capacity = DEFAULT_CAPACITY;
        this.elements = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }
    public StaticArray(int capacity) {
        this.capacity = capacity;
        this.elements = new Object[capacity];
        this.size = 0;
    }

    /*public StaticArray<T> of(T[] elements){
        StaticArray<T> staticArray = new StaticArray<>();
        for(T element : elements){
            staticArray.add(element);
        }
        return staticArray;
    }*/

    @SafeVarargs
    public static <E> StaticArray<E> of(E... elements) {
        StaticArray<E> staticArray = new StaticArray<>(elements.length);
        for(E element : elements){
            staticArray.add(element);
        }
        return staticArray;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) this.elements[index];
    }

    public void add(T element) {
        if (this.isFull())
            grow();

        this.elements[size++] = element;
    }

    private void grow(){
        StaticArray<Object> tempArray = new StaticArray<>(this.capacity + 1);
        for (Object element : elements){
            tempArray.add(element);
        }
    }

    @SuppressWarnings("unchecked")
    public T remove(int index) {
        if (this.isEmpty()) throw new RuntimeException("Static Array is already empty");
        for (int i = index; i < this.size - 1; i++)
            this.elements[i] = this.elements[i + 1];

        this.size--;
        return (T) this.elements;
    }

    @SuppressWarnings("unchecked")
    public void forEach(Consumer<T> consumer) {
        for (int i = 0; i < this.size; i++) consumer.accept((T) this.elements[i]);
    }

    @SuppressWarnings("unchecked")
    public StaticArray<T> filter(Predicate<T> predicate) {
        StaticArray<T> filteredElements = new StaticArray<>(this.size);
        for (int i = 0; i < this.size; i++) {
            T element = (T) this.elements[i];
            if (predicate.test(element)) filteredElements.add(element);
        }
        filteredElements.setCapacity(filteredElements.getSize());
        return filteredElements;
    }

    @SuppressWarnings("unchecked")
    public <E> StaticArray<E> map(Function<T, E> function) {
        StaticArray<E> mappedElements = new StaticArray<>(this.size);
        for (int i = 0; i < this.size; i++) mappedElements.add(function.apply((T) this.elements[i]));
        return mappedElements;
    }

    public boolean isFull() {
        return this.size == this.capacity;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;
    }

    private void setCapacity(int capacity) {
        if (capacity < 0) throw new RuntimeException("Capacity must be a non-negative number");
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "StaticArray{" +
                "elements=" + Arrays.toString(elements) +
                '}';
    }


}