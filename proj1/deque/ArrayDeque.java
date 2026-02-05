package deque;

import java.lang.reflect.Array;

public class ArrayDeque<T> {
    private T[] array;
    private int size;
    private int nextFirst = 4;
    private int nextLast = 5;

    public ArrayDeque(){
        array = (T[]) new Object[8];
        size = 0;
    }
    public void resizing(int newSize){
        T[] newArray = (T[]) new Object[newSize];
        int del = newSize - size;
        System.arraycopy(array,0,newArray,0,nextLast);
        System.arraycopy(array,nextFirst+1,newArray,nextFirst+1+del,size-nextFirst-1);
        array = newArray;
        nextFirst = nextFirst+del;
     }
    public void addFirst(T input){
        if (size == array.length){
            resizing(size * 2);
        }

        array[nextFirst] = input;
        size++;
        if(nextFirst == 0){
            nextFirst = array.length-1;
        }else {
            nextFirst --;
        }
    }

    public void addLast(T input){
        if (size == array.length){
            resizing(size * 2);
        }

        array[nextLast] = input;
        size++;
        if(nextLast == array.length - 1){
            nextLast = 0;
        }else{
            nextLast ++;
        }
    }

    public boolean isEmpty(){
        if(size == 0){
            return true;
        }else{
            return false;
        }
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        for(int i =0;i<size;i++){
            System.out.print(array[i]);
        }
        System.out.println();

    }

    public T removeFirst(){
        if(size > 0){
            T retValue;
            if(nextFirst + 1 == array.length){
                retValue = array[0];
                size--;
                nextFirst = 0;
            }else{
                retValue = array[nextFirst+1];
                size--;
                nextFirst ++;
            }
           return retValue;
        }else{
            return null;
        }
    }

    public T removeLast(){
        if(size > 0){
            T retValue;
            if(nextLast == 0){
                retValue = array[size-1];
                size--;
                nextFirst = size-1;
            }else{
                retValue = array[nextLast-1];
                size--;
                nextLast --;
            }
            return retValue;
        }else{
            return null;
        }

    }

    public T get(int index){
        return array[index];
    }


}
