import java.io.IOException;

public class Run{
     public static void main(String[] args) throws IOException{
        SeriesMachine series = new FibonacciMachine();
        series.calculate(1000);

    }
}
