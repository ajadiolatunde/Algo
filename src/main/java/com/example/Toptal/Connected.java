package com.example.Toptal;

import java.util.*;
import java.util.stream.Collectors;

/***
 * Get numbers of connected component in undirected graph
 */

public class Connected {
    private static int ans = 0;
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

    private static void getSetConnectedComponent(Map<Integer, Set<Integer>> adjs,int count){
        List<Integer> keys =  adjs.keySet().stream().collect(Collectors.toList());
        boolean stop = true;
        for (int x=0;x<keys.size();x++){
            if (!stop){
                break;
            }
            Iterator<Integer> ik = adjs.keySet().iterator();
            while(ik.hasNext()){
                int ike = ik.next();
                if (adjs.get(ike).contains(keys.get(x))){
                    Set<Integer> due_remove = adjs.get(keys.get(x));
                    //Merge the
                    adjs.get(ike).remove( keys.get(x));
                    adjs.get(ike).addAll(due_remove);
                    adjs.get(ike).remove(ike);
                    adjs.remove(keys.get(x));

                    adjs.put(ike, adjs.get(ike));
                    count++;
                    System.out.println(adjs.entrySet());

                    getSetConnectedComponent(adjs,count);
                    stop = false;
                    break;
                }
            }
        }
        //System.out.println(adjs.size());
        //System.out.println(adjs.entrySet());

        ans=  adjs.size();
    }

    private static int getConnectedComponent(Map<Integer, List<Integer>> adjs,int count){
        List<Integer> keys =  adjs.keySet().stream().collect(Collectors.toList());
        boolean stop = false;
        for (int x=0;x<keys.size();x++){
            if (stop){
                break;
            }
            Iterator<Integer> ik = adjs.keySet().iterator();
            while(ik.hasNext()){
                int ike = ik.next();
                if (adjs.get(ike).contains(keys.get(x))){
                    List<Integer> due_remove = adjs.get(keys.get(x));
                    //Merge the
                    adjs.get(ike).remove( adjs.get(ike).indexOf(keys.get(x)));
                    adjs.get(ike).addAll(due_remove);
                    adjs.remove(keys.get(x));
                    adjs.put(ike, adjs.get(ike));
                    count++;
                    getConnectedComponent(adjs,count);
                    stop = true;
                    break;
                }
            }
        }
        //System.out.println(adjs.size());
        System.out.println(adjs.entrySet());
        return adjs.size();
    }

    private static Map<Integer, Set<Integer>>  buildNodeAdjacencicy(List<edge> obj){
        Map<Integer, Set<Integer>> adj =  new HashMap<>();
        obj.stream().forEach(
                x-> {
                    Set<Integer> cit1 = new HashSet<>();
                    cit1.add(x.city2);
                    if (adj.containsKey(x.city1)){
                        Set<Integer> nk = adj.get(x.city1);
                        nk.add(x.city2);
                        adj.put(x.city1,nk);
                    }else{
                        adj.put(x.city1,cit1);
                    }
                    Set<Integer> cit2 = new HashSet<>();
                    cit2.add(x.city1);
                    if (adj.containsKey(x.city2)){
                        Set<Integer> nk = adj.get(x.city2);
                        nk.add(x.city1);
                        adj.put(x.city2,nk);
                    }else{
                        adj.put(x.city2,cit2);
                    }

                }
        );
        System.out.println(adj.entrySet());
      return adj;
    }


    public static void main(String[] args){
        List<edge> array = new ArrayList<>(Arrays.asList(new edge(8,5),new edge(1,2),new edge(2,3),new edge(2,4),new edge(3,5),new edge(6,7)));// return 2
        List<edge> array1 = new ArrayList<>(Arrays.asList(new edge(0,1),new edge(1,2),new edge(2,3),new edge(3,4)));//return 1
        Map<Integer, Set<Integer>> adjs = buildNodeAdjacencicy(array1);
        getSetConnectedComponent(adjs,0);
        System.out.println("--ans--"+ans);

    }

}
