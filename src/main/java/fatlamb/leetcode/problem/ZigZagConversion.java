package fatlamb.leetcode.problem;

public class ZigZagConversion {
    public static void main(String[] args){
        System.out.println(new ZigZagConversion().convert("PAYPALISHIRING", 3));
    }

    public String convert(String s, int numRows) {
        if (numRows == 0){
            return null;
        }
        if (numRows == 1){
            return s ;
        }
        StringBuilder result = new StringBuilder();
        int length = s.length();
        //第一行
        int j = 0 ;
        while (j < length){
            result.append(s.charAt(j));
            j += 2*numRows-2 ;
        }
        //中间行
        for (int i = 1 ; i < numRows-1 ; i++){
            j = i ;
            while (j < length){
//                System.out.println(j);
                result.append(s.charAt(j));
                j+= 2*(numRows - i - 1) ;
                if (j >= length){
                    break;
                }
                result.append(s.charAt(j));
                j += 2 * i ;
            }

        }
        //最后行
        j = numRows-1 ;
        while (j < length){
            result.append(s.charAt(j));
            j += 2*numRows-2 ;
        }
        return result.toString();
    }
}
