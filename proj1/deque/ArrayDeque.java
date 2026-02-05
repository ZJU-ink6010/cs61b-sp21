package deque;



public class ArrayDeque<T> {
    private T[] array;
    private int size;
    private int nextFirst = 3;
    private int nextLast = 4;

    public ArrayDeque(){
        array = (T[]) new Object[8];
        size = 0;
    }
    public void resizing(int newSize){
        T[] newArray = (T[]) new Object[newSize];
        int del = newSize - size;
        System.arraycopy(array,nextFirst+1,newArray,0,size-nextFirst-1);
        System.arraycopy(array,0,newArray,size-nextFirst-1,nextFirst+1);
        array = newArray;
        nextLast = size;
        nextFirst = newSize-1;
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
            System.out.print(' ');
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
                retValue = array[array.length-1];
                size--;
                nextLast = array.length-1;
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
        if(index <= size-1){
            return array[index];
        }else{
            return null;
        }


    }


}
