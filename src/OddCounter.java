import java.util.HashMap;
import java.util.Map;

public class OddCounter{

    public void main(String[] args){
    
        int[] input = {1,1,3,3,5};
        OddCounter o = new OddCounter();
        int result = o.findOdds(input);
    }
    
    public int findOdds(int[] inputs){
        Map<Integer, Boolean> hash = new HashMap<Integer, Boolean>();
        int size = inputs.length;
        
        for(int i=0; i<size; i++){
            int current = inputs[i];
            if (hash.containsKey(current)){ //existed before
                hash.remove(current);
            } else {
                hash.put(current, true);
            } 
        }
        
        //assuming there is one and only one return
        return hash.keySet().get(0);
    }
}