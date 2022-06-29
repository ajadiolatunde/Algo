package com.example.Toptal;

import java.util.*;
import java.util.stream.Collectors;

/***
 * Get numbers of connected component in undirected graph
 * Step 1:Get list of all node components
 * Step 2:Build adjacency list with node components
 * Step 3:Conduct a union test by
 *      - Look for parent relationship by collapsing a related link
 *      - If a parent is found in another parent neighbour list then merge the parent neirbour list and remove the parent node from the list .
 *      -Perform forward and backward iteration by comparing key to all available keyset values
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

    private static void getRecursiveSetConnectedComponent(Map<Integer, Set<Integer>> adjs,int count){
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

                    getRecursiveSetConnectedComponent(adjs,count);
                    stop = false;
                    break;
                }
            }
        }
        System.out.println(adjs.entrySet());
        ans=  adjs.size();
    }

    private static int getConnectedComponent(Map<Integer, Set<Integer>> adjs){
        int x = 0;
        boolean stop = false;
        while (x<adjs.entrySet().size()-1){
            stop = false;
            List<Integer> keys =  adjs.keySet().stream().collect(Collectors.toList());
            //Forward
            for (int y=0;y<keys.size();y++){
                //Find first key in first key set
                if (adjs.get(keys.get(y)).contains(keys.get(x))){
                    Set<Integer> set_list = adjs.get(keys.get(x));
                    set_list.addAll(adjs.get(keys.get(y)));
                    set_list.remove(keys.get(x));
                    set_list.remove(keys.get(y));
                    adjs.remove( keys.get(x));
                    adjs.put(keys.get(y),set_list );
                    stop = true;
                    break;
                }
                //Reverse find last key in the first key set
                if (adjs.get(keys.get(y)).contains(keys.get(adjs.entrySet().size()-1-x))){
                    Set<Integer> set_list = adjs.get(keys.get(adjs.entrySet().size()-1-x));
                    set_list.addAll(adjs.get(keys.get(y)));
                    set_list.remove(keys.get(adjs.entrySet().size()-1-x));
                    set_list.remove(keys.get(y));
                    adjs.remove(keys.get(adjs.entrySet().size()-1-x));
                    adjs.put(keys.get(y),set_list );
                    stop = true;
                    break;
                }
            }
            if (stop){
                x=0;
            }else{
                x++;
            }

        }
        //System.out.println(adjs.size());
        System.out.println(adjs.entrySet());
        System.out.println(adjs.entrySet().size());
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
        //Test data
        List<edge> array = new ArrayList<>(Arrays.asList(new edge(8,5),new edge(1,2),new edge(2,3),new edge(2,4),new edge(3,5),new edge(6,7)));// return 2
        List<edge> array1 = new ArrayList<>(Arrays.asList(new edge(0,1),new edge(1,2),new edge(2,3),new edge(3,4)));//return 1
        List<edge> array2 = new ArrayList<>(Arrays.asList(new edge(1,2),new edge(2,4),new edge(5,7),new edge(7,2),new edge(9,5)));//return 1

        Map<Integer, Set<Integer>> adjs = buildNodeAdjacencicy(array2);
        //getSetConnectedComponent(adjs);
        getConnectedComponent(adjs);

    }

}
