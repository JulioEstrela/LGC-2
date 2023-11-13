package com.example.bolsadevalores.estruturadados;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Function;

public class DynamicArray<T> {
    private int size = 0;
    private int capacity;
    private Object[] elements;

    public DynamicArray() {
        final int DEFAULT_CAPACITY = 1;
        this.capacity = DEFAULT_CAPACITY;
        this.elements = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }
    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.elements = new Object[capacity];
        this.size = 0;
    }

    /*public DynamicArray<T> of(T[] elements){
        StaticArray<T> dynamicArray = new StaticArray<>();
        for(T element : elements){
            dynamicArray.add(element);
        }
        return staticArray;
    }*/

    @SafeVarargs
    public static <E> DynamicArray<E> of(E... elements) {
        DynamicArray<E> dynamicArray = new DynamicArray<>(elements.length);
        for(E element : elements){
            dynamicArray.add(element);
        }
        return dynamicArray;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) this.elements[index];
    }

    public T add(T element) {
        if (this.isFull())
            this.elements = grow();

        this.elements[size++] = element;

        return (T) this.elements;
    }

    private Object[] grow(){
        Object[] tempArray = new Object[++this.capacity];
        for (int i = 0; i < elements.length; i++){
            tempArray[i] = elements[i];
        }
        return tempArray;
    }
    private Object[] diminish(T element){
        Object[] tempArray = new Object[--this.capacity];

        for (int i = indexOf(element); i < this.elements.length-1; i++){
            tempArray[i] = elements[i+1];
        }
        return tempArray;
    }

    @SuppressWarnings("unchecked")
    public T remove(T element){
        if (this.isEmpty()) throw new RuntimeException("Dynamic Array is already empty");

        this.elements = diminish(element);

        this.size--;
        return (T) this.elements;
    }

    public int indexOf(Object o){
        if (this.isEmpty()) throw new RuntimeException("Dynamic Array is empty");

        if (o == null) {
            for (int i = 0; i < size; i++)
                if (elements[i]==null)
                    return i;
        } else {
            for (int i = 0; i < this.elements.length; i++) {
                if (o.equals(elements[i]))
                    return i;
            }
        }
        return -1;
    }

    @SuppressWarnings("unchecked")
    public void forEach(Consumer<T> consumer) {
        for (int i = 0; i < this.size; i++) consumer.accept((T) this.elements[i]);
    }

    @SuppressWarnings("unchecked")
    public DynamicArray<T> filter(Predicate<T> predicate) {
        DynamicArray<T> filteredElements = new DynamicArray<>(this.size);
        for (int i = 0; i < this.size; i++) {
            T element = (T) this.elements[i];
            if (predicate.test(element)) filteredElements.add(element);
        }
        filteredElements.setCapacity(filteredElements.getSize());
        return filteredElements;
    }

    @SuppressWarnings("unchecked")
    public <E> DynamicArray<E> map(Function<T, E> function) {
        DynamicArray<E> mappedElements = new DynamicArray<>(this.size);
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