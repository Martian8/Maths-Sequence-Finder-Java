import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class primeMachine {
    public ArrayList<Integer> primeReader()throws IOException{
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
    public ArrayList<Integer> primeCalculator(ArrayList<Integer> primeList, Integer max){
        boolean isPrime = true;
        Integer highestPrime=primeList.get(primeList.size()-1);
        for(int num=highestPrime; num<highestPrime+max; num++){
            isPrime = true;
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
        }
        return primeList;
    }
    public void primeWriter(ArrayList<Integer> primeList) throws FileNotFoundException{
        PrintWriter writer = new PrintWriter("primes.txt");
        for (Integer prime : primeList){
            writer.write(prime+"\n");
        }
        writer.close();
    }
}
