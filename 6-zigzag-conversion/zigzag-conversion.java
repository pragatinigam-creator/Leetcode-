class Solution {
    public String convert(String s, int numRows) {
        
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }
        
        StringBuilder[] rows = new StringBuilder[numRows];
        
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        
        int row = 0;
        boolean goingDown = false;
        
        for (int i = 0; i < s.length(); i++) {
            rows[row].append(s.charAt(i));
            
            if (row == 0 || row == numRows - 1) {
                goingDown = !goingDown;
            }
            
            if (goingDown) {
                row++;
            } else {
                row--;
            }
        }
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            result.append(rows[i]);
        }
        
        return result.toString();
    }
}