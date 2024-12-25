import java.rmi.server.ObjID;

public class ArrayDeque <unknow>{

        private unknow [] list;
        private int index;


        public ArrayDeque(){
            index=0;
            list=(unknow[]) new Object[100];
        }
        public void addLast(unknow x){
            if(index==list.length){
                resize();
            }
            list[index]=x;
            index+=1;
        }
        public void addFirst(unknow x){
            if(index==list.length){
                resize();
            }
            unknow [] new_list=(unknow[]) new Object[list.length+1];
            new_list[0]=x;
            System.arraycopy(list,0,new_list,1,list.length);
            list=new_list;
            index+=1;
        }

        public unknow get(int x){
            return list[x-1];
        }
        public int size(){
            return index;
        }
        private void resize(){
            unknow [] new_list=(unknow[])new Object[list.length*2];
            System.arraycopy(list,0,new_list,0,list.length);
            list=new_list;
        }
        public void removeLast(){
            index-=1;
        }
        public void removeFirst(){
            unknow[] new_list=(unknow[]) new Object[list.length-1];
            System.arraycopy(list,1,new_list,0,list.length-1);
            list=new_list;
            index-=1;
        }
        public boolean isEmpty(){
            return index==0;
        }
        public void printDeque(){
            for(int i=0;i<index;i++){
                System.out.println(list[i]+" ");
            }
        }




}
