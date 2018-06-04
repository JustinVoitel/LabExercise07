/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response to an input string.
 * 
 * @author     Daan Lockhorst and Justin Voitel
 * @version    29.05.2018
 */
import java.util.Random;
import java.util.HashSet;
import java.util.ArrayList;
import java.lang.String;

public class Responder
{
    /**
     * Construct a Responder - nothing to do
     */
    Random r = new Random();
    ArrayList<String> responses = new ArrayList<String>();
    ArrayList<String> keyWords = new ArrayList<String>();
    
    public Responder()
    {   
        keyWords.add("stock response");
        responses.add("Couldn't really from a response, please reformulate");
        
        keyWords.add("can");
        responses.add("I dont really have the answer for that");
        
        keyWords.add("haha");
        responses.add("Very funny!");
        
        keyWords.add("much");
        responses.add("Likelier than likely will be unlikely");
        
        keyWords.add("bla");
        responses.add("blaaaa blaaa blaaaa");
        
        keyWords.add("cat");
        responses.add("I love cats");
        
        keyWords.add("shit");
        keyWords.add("please dont curse, We are nice people");
        
        keyWords.add("computer");
        responses.add("We know a lot about computers because were techsupport");
    }

    /**
     * Generate a response.
     * @return   A string that should be displayed as the response
     */
    public String generateResponse()
    {
        return "That sounds interesting. Tell me more...";
    }
    public String getResponse(String input)
    {
        HashSet<String> inputHash = new HashSet<String>();
        int index = 0;
        for(String s: input.split("\\W+"))
        {
            System.out.println(s);
            inputHash.add(s);
        }
        for (String keyword: keyWords)
        {
            
            if (inputHash.contains(keyword)){
                index = keyWords.indexOf(keyword);
            }
        }
        return responses.get(index);
    }
    public String randomResponse()
    {
        int i = r.nextInt(responses.size());
        return responses.get(i);
    }
}
