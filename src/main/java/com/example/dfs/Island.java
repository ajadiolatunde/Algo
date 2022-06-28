package com.example.dfs;

import java.util.*;

public class Island {
    /**
     *unction bitmapHoles that takes in strArr which is an array
     * of strings that form a 2D matrix of 0 and 1's.
     * The function should determine how many holes,
     * or contiguous regions of 0's, exist in the matrix.
     * A contiguous region is one where there is a connected group of 0's
     * going in one or more of four directions: up, down, left, or right.
     * @param array
     * @return
     */
    private static int getIsland(List<String> array){
        int column_leng = array.get(0).length();
        int row_leng = array.size();
        List<String> visited = new ArrayList<String>();
        int count = 0;
        Map<String,Set<String>> map = new HashMap<>();
        for (int r=0;r<row_leng;r++){

            for (int c=0;c<column_leng;c++){
                //System.out.print(array.get(r).charAt(c));
                //check row
                String location = String.valueOf(array.get(r).charAt(c));
                if (location.equals("1")){
                    Set<String> loc = new HashSet<>();

                    if (!visited.contains(r+""+c)){
                        loc.add(r+""+c);
                        //visited.add(r+""+c);
                        count++;
                        //Check  vertical
                            for (int sub_c=c+1;sub_c<column_leng;sub_c++){
                                location = String.valueOf(array.get(r).charAt(c+1));
                                if (location.equals("1") && !visited.contains(r+""+sub_c)){
                                    loc.add(r+""+sub_c);
                                    visited.add(r+""+sub_c);
                                }else{
                                    break;
                                }
                            }
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
        List<String> arrays5 = Arrays.asList("01111", "01001", "00001", "11110");//return is 4
        List<String> arrays2 = Arrays.asList("01111", "01101", "00000", "11110");//return is 2
        List<String> arrays1 = Arrays.asList("1100", "1100", "0010", "0001");//return is 2
        List<String> arrays6 = Arrays.asList("01111", "01101", "00011", "11110");//return is 3



        getIsland(arrays6);

    }
}
