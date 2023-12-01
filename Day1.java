import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.Scanner; 
import java.util.ArrayList; 


class Day1 {

    public static ArrayList<Character> getDigits(String str) {
        ArrayList<Character> arr = new ArrayList<>(); 
        int i = 0; 
        while(i < str.length()) {
            char curr = str.charAt(i); 
            if(Character.isDigit(curr)) {
                arr.add(curr); 
            }
            i += 1; 
        }
        return arr; 
    }

    public static void main(String[] args) {
        int total = 0;
        int totalLines = 0;  
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
                
            }   
            System.out.println(total); 
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("in exception"); 
            System.out.println(e); 
        }
        
    } 

}