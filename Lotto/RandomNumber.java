import java.util.Random;
import java.util.HashSet;
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
    private Random randomNum = new Random();
    public RandomNumber(){
        set = new HashSet<>();
        frequencies = new int[50];
    }
  
    
    public void draw(){
        while (set.size() < 6){
            int number = randomNum.nextInt(49)+1;
            set.add(number);
            frequencies[number]++;
        }
        set.clear();
    }
    
    public void printDrawings(){
        set.stream()
        .forEach(record -> System.out.println(record));
    }
    
    public void pickLottoOf(int n){
        int i = 0;
        while(i <= n){
            draw();
            i++;
        }
    }
    
    
    public void printFrequency(){
        for(int i=0; i<= frequencies.length-1;i++){
            System.out.println(i + "-->"+ frequencies[i]);
        }
    }
    
}
