import java.io.IOException;
import java.util.ArrayList;

public class Run{
     public static void main(String[] args) throws IOException{
        primeMachine run = new primeMachine();
        ArrayList<Integer> primeList = new ArrayList<Integer>(run.primeReader());
        primeList = run.primeCalculator(primeList, 10000000);
        run.primeWriter(primeList);
    }
}

