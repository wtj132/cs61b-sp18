public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char a,char b){
        int c;
        if(a-b>=0){
            c=a-b;
        }else{
            c=b-a;
        }
        return c==1;
    }
}
