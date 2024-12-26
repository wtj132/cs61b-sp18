public class LinkedListDeque<T> {
    private class intnode {
        intnode prev;
        T value;
        intnode next;

        private intnode(T x) {
            prev = null;
            next = null;
            value = x;
        }
    }

    private intnode sential;
    private int size;
    private intnode last;
    private intnode c;

    public LinkedListDeque() {
        sential = new intnode(null);
        last=new intnode(null);
        size = 0;
        c=sential;
    }

    public void addFirst(T x) {
        intnode first = new intnode(x);
        first.next = sential.next;
        first.prev = sential;
        sential.next = first;
        if(isEmpty()){
            last=first;
        }
        size += 1;
    }

    public void addLast(T x) {
        if(isEmpty()){
            addFirst(x);
        }else {
            intnode corrent = new intnode(x);
            last.next = corrent;
            corrent.prev = last;
            last = corrent;
        }
        size += 1;
    }

    public T get(int x) {
        if(isEmpty()){
            return null;
        }
        intnode corrent = sential.next;
        for (int i = 0; i < x; i++) {
            if (corrent.next != null) {
                corrent = corrent.next;
            }
        }return corrent.value;

    }


    public T getRecursive(int x){
        if(isEmpty()){
            return null;
        }
        c=c.next;
        if (x == 0) {
            return c.value;
        }
        return getRecursive(x - 1);

    }

    public T removeFirst(){
        if(isEmpty()){
            return null;
        }
        T first_value=sential.next.value;
        sential.next=sential.next.next;
        if(sential.next!=null) {
            sential.next.prev = sential;
        }
        size-=1;
        if(isEmpty()){
            last=new intnode(null);
        }
        return first_value;
    }

    public T removeLast(){
        if(isEmpty()){
            return null;
        }
        T last_value=last.value;
        last.prev.next=null;
        last=last.prev;
        size-=1;
        if(isEmpty()){
            last=new intnode(null);
        }
        return last_value;
    }

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public void printDeque(){
        intnode corrent=sential;
        if(!isEmpty()){
            do{
                corrent=corrent.next;
                System.out.println(corrent.value+" ");
            }while (corrent.next!=null);
        }
    }
//    public static void main(String[] args){
//        LinkedListDeque<Integer> list=new LinkedListDeque<>();
//        list.addLast(0);
//        list.addLast(1);
//        list.addLast(3);
////        System.out.println(list.removeFirst());
//        list.addFirst(5);
//        list.addFirst(2);
////        System.out.println(list.removeFirst());
//        System.out.println(list.get(4));
//
//    }

}
