package com.example.dfs;

import java.util.*;

public class Island {
    /**
     *unction bitmapHoles that takes in strArr which is an array
     * of strings that form a 2D matrix of 0 and 1's.
     * The function should determine how many holes,
     * or contiguous regions of 1's, exist in the matrix.
     * A contiguous region is one where there is a connected group of 1's
     * going in one or more of four directions: up, down, left, or right.
     * @param array
     * @return
     */
    private static int getIsland(List<String> array){
        int column_leng = array.get(0).length();
        int row_leng = array.size();
        //Registry
        List<String> visited = new ArrayList<String>();
        int count = 0;
        //Distinct registry
        Map<String,Set<String>> map = new HashMap<>();
        for (int r=0;r<row_leng;r++){

            for (int c=0;c<column_leng;c++){
                //check row
                String location = String.valueOf(array.get(r).charAt(c));
                //If location char is 1
                if (location.equals("1")){
                    Set<String> loc = new HashSet<>();
                    //Check registry to see that is not yoet visited
                    if (!visited.contains(r+""+c)){
                        loc.add(r+""+c);
                        //visited.add(r+""+c);
                        count++;
                        //Check all column till 0 is found and registered all visited
                            for (int sub_c=c+1;sub_c<column_leng;sub_c++){
                                location = String.valueOf(array.get(r).charAt(c+1));
                                if (location.equals("1") && !visited.contains(r+""+sub_c)){
                                    loc.add(r+""+sub_c);
                                    visited.add(r+""+sub_c);

                                }else if (location.equals("1") ){

                                    int finalR2 = r;
                                    int finalSub_c = sub_c;
                                    String old_key = map.entrySet().stream()
                                            .filter(entry -> entry.getValue().contains(finalR2 +""+ finalSub_c))
                                            .findFirst().get().getKey();
                                    System.out.println("------ol-----"+old_key);

                                    Set<String> old_loc = map.get(old_key);
                                    old_loc.add(r+""+c);
                                    map.put(old_key,old_loc);

                                }else{
                                    break;
                                }
                            }
                            //Check all row till 0 is found and registered all visited
                            for (int sub_r=r+1;sub_r<row_leng;sub_r++){
                                location = String.valueOf(array.get(sub_r).charAt(c));
                                if (location.equals("1") && !visited.contains(sub_r+""+c)){
                                    visited.add(sub_r+""+c);
                                    loc.add(sub_r+""+c);

                                }else{
                                    break;
                                }

                            }
                            loc.add(r+""+c);
                            map.put(r+""+c,loc);


                   }//Already visited ,locate the key of the map that contains the coord and add
                    else{
                        int finalR = r;
                        int finalC = c;
                        String key = map.entrySet().stream()
                                .filter(entry -> entry.getValue().contains(finalR +""+ finalC))
                                .findFirst().get().getKey();
                        Set<String> new_loc = map.get(key);
                        //Transverse row for 1
                        for (int sub_r=r+1;sub_r<row_leng;sub_r++){
                            location = String.valueOf(array.get(sub_r).charAt(c));
                            if (location.equals("1") && !visited.contains(sub_r+""+c)){
                                visited.add(sub_r+""+c);
                                new_loc.add(sub_r+""+c);

                            }else if(location.equals("1") ){
                                //Todo: get key of marked if diffrent and merge
                                System.out.println(key+" "+sub_r+"--"+c);
                                System.out.println(key+" hre       --------"+c);

                                int finalSub_r = sub_r;
                                int finalC1 = c;
                                String old_key = map.entrySet().stream()
                                        .filter(entry -> entry.getValue().contains(finalSub_r +""+ finalC1))
                                        .findFirst().get().getKey();
                                System.out.println(old_key+" --------"+c);

                                if (!old_key.equals(key)){
                                    Set<String> old_loc = map.get(old_key);
                                    new_loc.addAll(old_loc);
                                    count--;
                                    map.remove(old_key);
                                }

                            }else{
                                break;
                            }

                        }
                        //Transverse column for 1

                        for (int sub_c=c+1;sub_c<column_leng;sub_c++){
                            location = String.valueOf(array.get(r).charAt(sub_c));
                            //changing column
                            if (location.equals("1") && !visited.contains(r+""+sub_c)){
                                visited.add(r+""+sub_c);
                                new_loc.add(r+""+sub_c);

                            }else if(location.equals("1")){
                                //Get the key of current registry (Union relationship)
                                int finalR1 = r;
                                int finalSub_c = sub_c;
                                String old_key = map.entrySet().stream()
                                        .filter(entry -> entry.getValue().contains(finalR1 +""+ finalSub_c))
                                        .findFirst().get().getKey();
                                if (!old_key.equals(key)){
                                    Set<String> old_loc = map.get(old_key);
                                    new_loc.addAll(old_loc);
                                    count--;
                                    map.remove(old_key);
                                }

                            }else{
                                break;
                            }

                        }

                        map.put(key,new_loc);

                    }
                }
            }
            System.out.println();
        }
        System.out.println(count);
        System.out.println(map.entrySet());


        return count;
    }

    public static void main(String[] args){
        List<String> arrays5 = Arrays.asList("01111", "01001", "00001", "11110");//return is 2
        List<String> arrays2 = Arrays.asList("10111", "10101", "11101", "11111");//return is 1
        List<String> arrays1 = Arrays.asList("1100", "1100", "0010", "0001");//return is 3
        List<String> arrays6 = Arrays.asList("01111", "01101", "00011", "11110");//return is 1

        getIsland(arrays6);

    }
}
