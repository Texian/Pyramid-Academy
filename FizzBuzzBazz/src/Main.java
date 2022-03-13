import java.util.stream.IntStream;

public class Main {
    public static void FizzBuzz(int[] fuzzy) {
        String isfuzz = null;
        for (int fuzz : fuzzy) {
            isfuzz = (fuzzy[fuzz] % 5 == 0 && fuzzy[fuzz] % 3 == 0 ? "fizz buzz baz" : fuzzy[fuzz] % 5 == 0 ? "buzz" : fuzzy[fuzz] % 3 == 0 ? "fizz" : "Fizzled");
        System.out.println(fuzzy[fuzz] + " " +isfuzz);
        }
    }

    public static void main(String[] args){
        int[] fuzzy = IntStream.range(0,100).toArray();
        FizzBuzz(fuzzy);
    }
}