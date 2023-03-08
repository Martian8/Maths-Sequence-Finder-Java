import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
/**This is basically useless since it hits the max Long quite quickly, it's more of a proof of concept */
public class FibonacciMachine implements SeriesMachine{
    /**Converts from a text file into an ArrayList */
    private ArrayList<Long> fibonacciReader()throws IOException{
        ArrayList<Long> fibonacciList = new ArrayList<Long>();
        /**Reads text file */
        BufferedReader fibonacciFile = new BufferedReader(new FileReader("fibonacci.txt"));
        Long line = Long.parseLong(fibonacciFile.readLine());
        while(line!=null){
            fibonacciList.add(line);
            try {
                line = Long.parseLong(fibonacciFile.readLine());
            } catch (Exception e) {
                System.out.println("Finished reading file");
                line = null;
            }
        }
        fibonacciFile.close();
        return fibonacciList;
    }
    /**This is the function that does the actual maths behind finding fibonacci numbers (and runs the other functions) */

    public void calculate(Integer max) throws IOException{
        ArrayList<Long> fibonacciList = new ArrayList<Long>(fibonacciReader());
        for(int num=0; num<max; num++){
            if (0 > fibonacciList.get(fibonacciList.size()-1)+fibonacciList.get(fibonacciList.size()-2)){
                System.out.println("Reached the maximum value");
                break;
            }
            fibonacciList.add(fibonacciList.get(fibonacciList.size()-1)+fibonacciList.get(fibonacciList.size()-2));
        }
        fibonacciWriter(fibonacciList);
    }
    /**This function writes the ArrayList back into the file */
    private void fibonacciWriter(ArrayList<Long> fibonacciList) throws FileNotFoundException{
        PrintWriter writer = new PrintWriter("fibonacci.txt");
        for (Long fibonacci : fibonacciList){
            writer.write(fibonacci+"\n");
        }
        writer.close();
    }

}
