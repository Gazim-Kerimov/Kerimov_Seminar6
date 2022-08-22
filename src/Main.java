import java.util.*;

// Задача 12
public class Main {
    public static void main(String[] args) {
        char[] initList = new char[]{'(', ')', '[', ']','{','}','<','>'};
        Stack<Character> stack = new Stack<Character>();
        Map<Character, Character> map = new HashMap<>();
        map.put('[', ']');
        map.put('(', ')');
        map.put('{', '}');
        map.put('<', '>');
        String checkString = "a + (d {<*>} 3)"; //  верная последовательность
        //String checkString = "a +(d }<* 3)"; //неверная последовательность
        System.out.println("Входной пример: \n" + checkString);
        char[] charList = checkString.toCharArray();
        ArrayList<Character> filteredList = new ArrayList<>();
        for(int i = 0; i < charList.length; i++) {
            char check = charList[i];
            boolean checkFlag = false;
            for (int j = 0; j < initList.length; j++) {
                if (check == initList[j]) checkFlag = true;
            }
            if (checkFlag) filteredList.add(check);
        }

        if(checkBrackets(map,filteredList,0) == 0){
            System.out.println("Последовательность скобок верная");
        }
        else System.out.println("Последовательность скобок неверная");

    }

    public static int checkBrackets(Map map, ArrayList list, int startIndex){
        int result = 0;
        if(map.containsKey(list.get(startIndex))&& map.get(list.get(startIndex)) == list.get(startIndex +1)){
            return result;
        }
        for(int i = startIndex; i < list.size() - 1; i++){
            if(map.containsKey(list.get(startIndex+1))){
                result = result + checkBrackets(map, list, startIndex+1);
            }
            else{
                result++;
                return result;
            }
        }
        return result;
    }
}