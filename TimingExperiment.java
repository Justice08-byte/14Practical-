//Data Generation 

public class KeyValue{
  String key;
  String value;
  pulic KeyValue(String key, String value){
    this.key = key;
    this.value = value;
  }
}

// Data shuffling and generation
public class dataGenerate{
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
}


