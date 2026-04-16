
import java.util.*;

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        
        Arrays.sort(products); 
        
        String prefix = "";
        
        for (char ch : searchWord.toCharArray()) {
            prefix += ch;
            
            List<String> temp = new ArrayList<>();
            
            for (String product : products) {
                if (product.startsWith(prefix)) {
                    temp.add(product);
                    if (temp.size() == 3) break; 
                }
            }
            
            result.add(temp);
        }
        
        return result;
    }
}
