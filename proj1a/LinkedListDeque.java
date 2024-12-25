public class LinkedListDeque<unknow> {
    public class intnode {
        intnode prev;
        unknow value;
        intnode next;

        public intnode(unknow x) {
            prev = null;
            next = null;
            value = x;
        }
    }

    private intnode sential;
    private int size;
    private intnode last;

    public LinkedListDeque() {
        sential = new intnode(null);
        size = 0;
    }

    public void addFirst(unknow x) {
        intnode first = new intnode(x);
        first.next = sential.next;
        first.prev = sential;
        if (sential.next == null) {
            last = first;
        }
        sential.next = first;
        size += 1;
    }

    public void addLast(unknow x) {
        intnode corrent = new intnode(x);
        last.next = corrent;
        corrent.prev = last;
        last = corrent;
        size += 1;
    }

    public unknow get(int x) {
        intnode corrent = sential;
        if (x != 0) {
            for (int i = 0; i < x; i++) {
                if (corrent.next != null) {
                    corrent = corrent.next;
                }
            }return corrent.value;
        }else{
            return corrent.next.value;
        }
    }

    private intnode c=sential;
    public unknow getRecursive(int x){
        if(x==0){
            return c.value;
        }
        return getRecursive(x-1);
    }

    public void removeFirst(){
        sential.next=sential.next.next;
        if(sential.next!=null) {
            sential.next.prev = sential;
        }
        size-=1;
    }

    public void removeLast(){
        last.prev.next=null;
        last=last.prev;
        size-=1;
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
}
