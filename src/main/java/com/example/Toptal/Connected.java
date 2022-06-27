package com.example.Toptal;

import java.util.*;
import java.util.stream.Collectors;

public class Connected {
    public static class edge{
        int city1;
        int city2;

        public edge(int city1, int city2) {
            this.city1 = city1;
            this.city2 = city2;
        }

        @Override
        public String toString() {
            return this.city1 +","+ this.city2;
        }
    }

    private static int getConnectedComponent(Map<Integer, List<Integer>> adjs,int count){
        List<Integer> keys =  adjs.keySet().stream().collect(Collectors.toList());

        for (int x=0;x<keys.size();x++){
            Iterator<Integer> ik = adjs.keySet().iterator();
            while(ik.hasNext()){
                int ike = ik.next();

                if (adjs.get(ike).contains(keys.get(x))){
                    System.out.println("-----Stage2------");
                    //get the list of current key and merge with that list
                    //get the content out
                    List<Integer> due_remove = adjs.get(keys.get(x));
                    //Merge the
                    List<Integer> adlist =  adjs.get(ike);
                    adlist.remove(adlist.indexOf(keys.get(x)));
                    adlist.addAll(due_remove);
                    adjs.remove(keys.get(x));
                    adjs.put(ike,adlist);
                    count++;
                    getConnectedComponent(adjs,count);
                    System.out.println("-----------");

                    System.out.println(adjs);
                    break;

                }

            }
        }

        System.out.println(adjs.size());
        return adjs.size();
    }
    private static Map<Integer, List<Integer>>  buildAdjacencicy(List<edge> obj){
        //First do flat
        //Map<String, Set<Integer>> adj = new HashMap<String,Set<Integer>>();
        Map<Integer, List<Integer>> adj = obj.stream()
                .collect(Collectors.groupingBy(x->x.city1,Collectors.mapping(x->x.city2, Collectors.toList())))
               .entrySet().stream()
              .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(oldValue, newValue)-> oldValue,LinkedHashMap::new));
        System.out.println(adj);
        //After sort
        Comparator<Map.Entry<Integer, List<Integer>>> sorted = Comparator.comparingInt(stringListEntry -> stringListEntry.getValue().get(0));
        adj.entrySet().stream().sorted(sorted).forEach(System.out::println);
        //System.out.println(adj);

        return adj;
    }

    public static void main(String[] args){
        List<edge> array = new ArrayList<>(Arrays.asList(new edge(8,5),new edge(1,2),new edge(2,3),new edge(2,4),new edge(3,5),new edge(6,7)));
       // getConnectedComponent(array);
        Map<Integer, List<Integer>> adj =buildAdjacencicy(array);
        getConnectedComponent(adj,0);



    }


}
