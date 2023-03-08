import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class PrimeMachine implements SeriesMachine{
    private ArrayList<Integer> primeReader()throws IOException{
        ArrayList<Integer> primeList = new ArrayList<Integer>();
        /**Reads text file */
        BufferedReader primeFile = new BufferedReader(new FileReader("primes.txt"));
        Integer line = Integer.parseInt(primeFile.readLine());
        while(line!=null){
            primeList.add(line);
            try {
                line = Integer.parseInt(primeFile.readLine());
            } catch (Exception e) {
                System.out.println("Finished reading file");
                line = null;
            }
        }
        primeFile.close();
        return primeList;
    }
    public void calculate(Integer max) throws IOException{
        ArrayList<Integer> primeList = new ArrayList<Integer>(primeReader());
        boolean isPrime = true;
        Integer highestPrime=primeList.get(primeList.size()-1);
        for(int num=highestPrime; num<highestPrime+max; num++){
            for(int prime=0; prime<primeList.size(); prime++){
                if(num%primeList.get(prime)==0){
                    isPrime =false;
                    break;
                }
                if(num/primeList.get(prime)<primeList.get(prime)){
                    break;
                }
            }
            if(isPrime==true){
                primeList.add(num);
            }
            else{
                max+=1;
            }
        }
        primeWriter(primeList);
    }
    private void primeWriter(ArrayList<Integer> primeList) throws FileNotFoundException{
        PrintWriter writer = new PrintWriter("primes.txt");
        for (Integer prime : primeList){
            writer.write(prime+"\n");
        }
        writer.close();
    }

}
