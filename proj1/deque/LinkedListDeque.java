package deque;

import net.sf.saxon.functions.ConstantFunction;
import net.sf.saxon.lib.SchemaURIResolver;

public class LinkedListDeque<T> {
    /** helper function stuffNode*/
    public class stuffNode<T>{
        private T item;
        private stuffNode prev;
        private stuffNode next;

        public stuffNode(T input,stuffNode prevNode, stuffNode nextNode){
            item = input;

            prev = prevNode;
            if(prevNode!=null){
                prevNode.next = this;
            }

            next = nextNode;

            if (nextNode!=null){
                nextNode.prev = this;
            }


        }
    }

    private stuffNode sentinelNode;
    private int size;

    public LinkedListDeque(){
        sentinelNode = new stuffNode(6010,null,null);
        size = 0;
        sentinelNode.next =sentinelNode;
        sentinelNode.prev = sentinelNode;
    }


    public void addFirst(T input){
        stuffNode firstNode  = new stuffNode(input,sentinelNode,sentinelNode.next);
        size++;
    }

    public void addLast(T input){
        stuffNode lastNode  = new stuffNode(input,sentinelNode.prev,sentinelNode);

        size++;
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
        stuffNode node = sentinelNode.next;
        while(node!=sentinelNode){
            System.out.print(node.item);
            System.out.print(' ');
            node = node.next;
        }
        System.out.println();
    }

    public T removeFirst(){
        if(size > 0){
            stuffNode delNode = sentinelNode.next;
            sentinelNode.next = delNode.next;
            sentinelNode.next.prev = sentinelNode;
            size--;
            return (T) delNode.item;
        }else{
            return null;
        }
    }

    public T removeLast(){
        if(size > 0){
            stuffNode delNode = sentinelNode.prev;
            sentinelNode.prev = delNode.prev;
            sentinelNode.prev.next = sentinelNode;
            size--;
            return (T) delNode.item;
        }else{
            return null;
        }
    }

    public T get(int index){
        if(size-1 >= index){
            stuffNode currNode = sentinelNode.next;
            int currIndex = 0;
            while(currIndex < index){
                currNode = currNode.next;
            }
            return (T)currNode.item;
        }else{
            return null;
        }
    }

    public T getRecursive(int index){
        if(size-1 >= index){
            int count = 0;
            stuffNode node = sentinelNode.next;
            if(count < index){
                return (T)helper(node.next,count+1,index);
            }else{
                return (T)node.item;
            }



        }else{
            return null;
        }

    }
    public T helper(stuffNode node, int count, int index){
        if(count < index){
            return (T) helper(node.next,count+1,index);
        }else{
            return (T)node.item;
        }
    }
}



