public class OffByN implements CharacterComparator{
    private int n;

    public OffByN(int n){
        this.n=n;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int c=x-y;
        if(c>=0) {
            return c == n;
        }else{
            return -c==n;
        }
    }
}
