package ActionPages;

public class DuplicateString {
    public static void main(String[] args) {
        String duplicateString = "Dhananjay kumar Dhananjay";
        String[] splitString = duplicateString.split(" ");
        int flag = 0;
        String temString = "";
//        for(int i=0;i<splitString.length;i++)
//        {
//            temString=splitString[i];
//            if(splitString[i].equals(temString))
//            {
//                temString=splitString[i];
//                System.out.println(temString);
//            }
        int i = 0;
        for (String dString : splitString) {
            if (dString.equals(splitString[i])) {
                flag = flag + 1;
            }
            i++;
        }

//        }
        System.out.println(flag);
    }
}
