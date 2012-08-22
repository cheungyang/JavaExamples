
public class Illuminati {

    public Illuminati(){}
    
    public static void main(String[] args){
        Illuminati illuminati = new Illuminati();
        
        for(int i=1; i<=5; i++){
            String[] results = illuminati.findPattern(i,i);
            for(int j=0; j<results.length; j++){
                System.out.println(results[j]);
            }
        }
    }

    public String[] findPattern(int total, int current){
        if (2==total && 2==current){
           String[] out = {"11","69","88","96"};
           return out;
        } else if (1==current){
            String[] out = {"0", "1", "8"};
            return out;
        } else if (2<total && 2==current){
            String[] out = {"00","11","69","88","96"};
            return out;
        } else {  //current>2
            String[] rtn = this.findPattern(total, current-2);
            String[] embeds = {"00","11","69","88","96"};
//            if (4 < total){
//                embeds = {"00","11","69","88","96"};
//            } else {
//                embeds = {"11","69","88","96"};
//            }
            String[] out = new String[rtn.length * embeds.length];
            int k = 0;
            System.out.print("length1:"+out.length);
            System.out.print("length2:"+rtn.length);
            System.out.print("length3:"+embeds.length);
            for (int i=0; i<embeds.length; i++){
                for (int j=0; j<rtn.length; i++){
                    out[k++] = embeds[i].substring(0,1)+rtn[j]+embeds[i].substring(1,2);
                }
            }
            return out;
        }
    }
}