import java.rmi.server.ObjID;

public class ArrayDeque <T>{

        private T [] list;
        private int index;
        private int first;
//        private int capacity=8;


        public ArrayDeque(){
            index=0;
            list=(T[]) new Object[8];
        }
        public void addLast(T x){
            if(index==list.length){
                resize();
            }
            list[index]=x;
            index+=1;
        }

        public void addFirst(T x){
            if(index==list.length){
                resize();
            }
            T [] new_list=(T[]) new Object[list.length+1];
            new_list[0]=x;
            System.arraycopy(list,0,new_list,1,list.length);
            list=new_list;
            index+=1;
        }

        public T get(int x){
            return list[x];
        }
        public int size(){
            return index;
        }
        private void resize(){
            T [] new_list=(T[])new Object[list.length*2];
            System.arraycopy(list,0,new_list,0,list.length);
            list=new_list;
        }
        public T removeLast(){
            if(isEmpty()){
                return null;
            }
            int last=index;
            index--;
            if(need_resizedown()){
                resizedown();
            }
            return list[last-1];
        }
        public T removeFirst(){
            if(isEmpty()){
                return null;
            }
            T[] new_list=(T[]) new Object[list.length-1];
            System.arraycopy(list,1,new_list,0,list.length-1);
            T first=list[0];
            list=new_list;
            index-=1;
            return first;
        }
        public boolean isEmpty(){
            return index==0;
        }
        public void printDeque(){
            for(int i=0;i<index;i++){
                System.out.println(list[i]+" ");
            }
        }
        private void resizedown(){
            double new_size= list.length*0.5;
            int n_s=(int) new_size;
            T[] new_list=(T[]) new Object[n_s];
            System.arraycopy(list,0,new_list,0,index);
            list=new_list;
        }
        private boolean need_resizedown(){
            return (list.length>16&&list.length>4*index);
        }
        private int capacity(){
            return list.length;
        }


//    public static void main(String[] args){
//            ArrayDeque<Integer> list=new ArrayDeque<>();
//            list.addFirst(1);
//            list.addFirst(2);
//            list.addLast(3);
//            System.out.println(list.removeLast());
//            System.out.println(list.get(0));
//    }

}
