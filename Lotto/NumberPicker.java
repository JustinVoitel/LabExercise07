
/**
 * This is a lottery class 
 * 
 * @author (Daan lockhorst
 * @version 29.05.2018
 */
import java.util.Random;
import java.util.Arrays;
import java.util.HashSet;
import java.util.ArrayList;


public class NumberPicker
{
    // instance variables - replace the example below with your own
    Random r = new Random();
    
    /**
     * @param  a integer which is the highest number the random picker can pick
     * @return a randomly picked int between 0 and @param n;
     */
    public int getRandomNR(int n)
    {
        int out = r.nextInt(n);
        return out;
    }
    /**
     * a method that picks 6 random numbers and puts them i a hashmap to make sure it
     * doesn't pick the same number twice
     *
     * @return a HashSet with 6 random numbers between 0, 49
     */
    public HashSet<Integer> getNonDoubleEntryLottoNumbers()
    {
        HashSet<Integer> lottoNR= new HashSet<Integer>();
        while (lottoNR.size() < 6){
            lottoNR.add(getRandomNR(49) + 1);
        }
        System.out.println(lottoNR);
        return lottoNR; 
    }
    /**
     * Here we check the frequency of numbers between 0, 49, prints and return a frequencyTable.
     * 
     * @param n is for the number of 6 number lotteries 
     * @retur int array lottoResult with frequency data on how often numbers between 0, 49 appear
     */
    public int[] getLottoResult(int n)
    {
        int[] lottoResult = new int[6 * n];
        int[] frequencyTable = new int[50];
        
        for(int z = 0; z < (6 * n); z++)
        {
            lottoResult[z] = getRandomNR(50);
            frequencyTable[lottoResult[z]] += 1;
        }
        //print out the frequencytable not vital to the method
        for (int j = 0; j < 49; j++)
        {
            System.out.println(j + ": " + frequencyTable[j]);
        }
        return frequencyTable;
    }
    /**
     * Here we print the results of frequency from 0 to 49,
     * if we were to play 1000, 10000, 100000, 1000000 times a 6 number lotery.
     * organized in a table and printed out. Code idea for the table printing
     * comes from Stackoverflow.com @Luca Mastrostefano
     */
    public void getAllTables()
    {
        int[] result1K = getLottoResult(1000);
        int[] result10K = getLottoResult(10000);
        int[] result100K = getLottoResult(100000);
        int[] result1M = getLottoResult(1000000);
        
        final Object[][] table = new String[50][];
        for(int i = 0; i < 50; i++){
            table[i] = new String[] { "NR: " + i , Integer.toString(result1K[i]), Integer.toString(result10K[i]), 
                Integer.toString(result100K[i]), Integer.toString(result1M[i])};
            }
            
        for (final Object[] row : table) {
            System.out.format("%15s%15s%15s%15s%15s\n", row);
        }
    }
}

