public class TimingExperiment{

//Data Generation 

public static KeyValue{
  String key;
  String value;
  pulic KeyValue(String key, String value){
    this.key = key;
    this.value = value;
  }
}

// Data shuffling and generation
public static dataGenerate{
  public static KeyValue[] generateData(int N){
    KeyValue[] data = new KeyValue[N];
    for(int i = 0; i<N; i++){
      data[i] = new KeyValue(String.valueOf(i+1),"");
    }
    List<KeyValue>list = Arrays.asList(data);
    Collections.shuffle(List);
    for(int i = 0; i<N; i++){
      list.get(i).value = String.valueOf(i+1);
    }
    return list.toArray(new KeyValue[0];
  }
  //Timing Methods
  public static void main(String[] args){
    int N = 1<<20; //2^20 
    KeyValue[] data = DataGenerator.generateData(N);
    int loads = {75,80,85,90,95};
    int repetitions  = 30; 

     System.out.println("Load\topenHash\tchainHash");
     for(int load:loads){
        int entries = (int)(950000*load/100);
        int m = entries;

        double openTime = 0;
        double chainTime = 0;
        for(int r=0; r<repetitions; r++){
            openHash oh = new openHash(m);
            chainedHash ch = new chainedHash(m);

            for(int i = 0; i<entries; i++){
                oh.insert(data[i].key, data[i].value);
                ch.insert(data[i].key, data[i].value);
            }
            long start = System.currentTimeMillis();

            for(int i = 0; i<entries; i++){
                oh.lookup(data[i].key);
            }
            long end = System.currentTimeMillis();
            openTime += (end - start);

            lond start = System.currentTimeMillis();
            for(int i = 0; i<entries; i++){
                ch.lookup(data[i].key);
            }
            long end = System.currentTimeMillis();
            chainTime += (end - start);
        }
        System.out.println(load+(openTime/repetitions/1000)+(chainTime/repetitions/1000));
     }                                        


}
}



