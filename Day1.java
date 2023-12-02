import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.Scanner; 
import java.util.ArrayList; 
import java.util.HashMap; 
import java.util.Arrays; 

class Day1 {

    public static ArrayList<Character> getDigits(String str) {
        ArrayList<Character> arr = new ArrayList<>(); 
        HashMap<Character, ArrayList<String>> hashMap = new HashMap<>(); 
        HashMap<String, Character> stringNum = new HashMap<>(); 

        hashMap.put('o', new ArrayList<String>(Arrays.asList("one"))); 
        hashMap.put('t', new ArrayList<String>(Arrays.asList("two", "three"))); 
        hashMap.put('f', new ArrayList<String>(Arrays.asList("four", "five"))); 
        hashMap.put('s', new ArrayList<String>(Arrays.asList("six", "seven"))); 
        hashMap.put('e', new ArrayList<String>(Arrays.asList("eight"))); 
        hashMap.put('n', new ArrayList<String>(Arrays.asList("nine"))); 

        stringNum.put("one", '1'); 
        stringNum.put("two", '2'); 
        stringNum.put("three", '3'); 
        stringNum.put("four", '4'); 
        stringNum.put("five", '5'); 
        stringNum.put("six", '6'); 
        stringNum.put("seven", '7'); 
        stringNum.put("eight", '8'); 
        stringNum.put("nine", '9'); 
        
        
        int i = 0; 

        /*
         * check if key is in object then check if 
         */

        while(i < str.length()) {
            char curr = str.charAt(i);
            
            if (hashMap.containsKey(curr)) {
                // iterate value which is always an array 
                var value = hashMap.get(curr);
                
                for (int j = 0; j < value.size(); j++) {
                    // iterating array of potential word numbers 
                    String currentEl = value.get(j); 
                    // now see if the value is apart of the string of original string 
                    try {
                        // get substring at current index ending at length of 
                        // System.out.println("current index " + i); 
                        // System.out.println("current char is " + curr); 
                        // System.out.println("This is the string " + str); 
                        // System.out.println("current el is " + currentEl); 
                        String subString = str.substring(i, i + value.get(j).length()); 
                        // System.out.println("This is the substring " + subString); 
                        // System.out.println(currentEl + " " + subString); 
                        // compare substring to currentEl 
                        if (currentEl.equals(subString)) {
                            // System.out.println(subString + " " + stringNum.get(subString));
                            arr.add(stringNum.get(subString));  
                        }
                    } catch (Exception e) {
                        // TODO: handle exception
                        // System.out.println("letter in hashmap but splice didnt work"); 
                    }
                }
            }

            if(Character.isDigit(curr)) {
                arr.add(curr); 
            }
            i += 1; 
        }
        // System.out.println(arr); 
        return arr; 
    }

    public static void main(String[] args) {
        int total = 0;
        int totalLines = 0;  

        int practice = 0; 
        // for first two lines should be 158 
        // current 148 

        try {
            File myObj = new File("input.txt");     
            Scanner myReader = new Scanner(myObj); 
            while(myReader.hasNextLine()) {
                
                // 2 pointer
                totalLines = totalLines + 1;  
                String data = myReader.nextLine(); 
                ArrayList<Character> arr2 = getDigits(data);  
                // get first and last digits to total 
                // if only 1 number double it 
                
                // take care of singles first 
                
                if (arr2.size() == 1) {
                    int i = Character.getNumericValue(arr2.get(0)) * 11; 
                    total += i; 
                }
                if (arr2.size() > 1) {
                    // tens place 
                    int i = Character.getNumericValue(arr2.get(0)) * 10; 
                    int j = Character.getNumericValue(arr2.get(arr2.size() - 1)); 
                    total += (i + j); 
                }

                
                // uncomment for practice and 3 lines 
                // practice += 1; 
                // if (practice > 2) {
                //     break; 
                // }
                
            }   
            System.out.println(total); 
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("in exception"); 
            System.out.println(e); 
        }
        
    } 

}