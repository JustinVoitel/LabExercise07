import java.util.Random;
import java.util.HashSet;
import java.util.Arrays;
/**
 * Write a description of class RandomNumber here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RandomNumber
{
    private HashSet<Integer> set = new HashSet<Integer>();
    private int[] frequencies;
    private int[][] freqTable;
    private Random randomNum = new Random();
    private int dublicates = 0;
    public RandomNumber(){
        set = new HashSet<>();
        frequencies = new int[50];
        freqTable = new int[3][50];
    }
  
    public void drawTable(int i){
        while (set.size() < 6){
            int number = randomNum.nextInt(49)+1;
            if(!set.contains(number)){
                set.add(number);
                freqTable[i][number]++;
            } else{
                dublicates++;
            }
        }
        set.clear();
    }
    
    public void draw(){
        while (set.size() < 6){
            int number = randomNum.nextInt(49)+1;
            if(!set.contains(number)){
                set.add(number);
                frequencies[number]++;
            } else{
                dublicates++;
            }
           
        }
        set.clear();
    }
    
    public void printDrawings(){
        set.stream()
        .forEach(record -> System.out.println(record));
    }
    
    public void LottoOf(int n){
        int i = 0;
        while(i <= n){
            draw();
            i++;
        }
    }
    
    public void lottoTableOf(int n, int x){
        int i = 0;
        while(i <= n){
            drawTable(x);
            i++;
        }
    }
    
    public void printFreqTable(){
        lottoTableOf(1000,0);
        lottoTableOf(10000,1);
        lottoTableOf(100000,2);
        
        for(int i=0; i<= freqTable[2].length-1;i++){
            System.out.println(
                i + "--> \t"+ 
                freqTable[0][i] + " \t "+
                freqTable[1][i] + " \t "+
                freqTable[2][i]
                );
        }
        System.out.println("count: " + getCountTable() + ", dublicates: " + dublicates);
    }
    
    public void printFrequency(){
        for(int i=0; i<= frequencies.length-1;i++){
            System.out.println(i + "-->"+ frequencies[i]);
        }
        
        System.out.println("count: " + getCount() + ", dublicates: " + dublicates);
    }
    
    public int getCount(){
        return Arrays.stream(frequencies)
        .reduce(0,(acc,record)-> acc+record);
    }
    
    public int getCountTable(){
        int count1 = Arrays.stream(freqTable[0])
        .reduce(0,(acc,record)-> acc+record);
        int count2 = Arrays.stream(freqTable[1])
        .reduce(0,(acc,record)-> acc+record);
        int count3 = Arrays.stream(freqTable[2])
        .reduce(0,(acc,record)-> acc+record);
        return count1+count2+count3;
        
    }
}
