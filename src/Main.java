import java.io.IOException;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.*;

public class Main {

    // flipthematrix();


    //int max = getSumFirstQ(matrix);

    //System.out.println(max);
    //System.out.println(position("grampromsderze"));
   static String PROGRAMMER = "programmer";



    public static void main(String[] arg) throws Exception {
        Scanner scanner = new Scanner(System.in);


        while(true){
            try {

                System.out.println("Donner un nombre 1 : ");
                Integer hokka1 = Integer.valueOf(scanner.nextLine());


                System.out.println("Donner un nombre 2 : ");
                Integer hokka2 = Integer.valueOf(scanner.nextLine());

                Integer result = hokka1 * hokka2;

                System.out.println("Le résultat :" + result);
            }
            catch(Exception e){
                if(scanner.nextLine().equals("exit")){
                    System.exit(0);
                }
                System.out.println(" yezzi blé blada w hét un nombre ") ;

            }
        }

    }



    private static void maxProfit() {
        ArrayList<Integer> todayStock = getListInteger(5);
        ArrayList<Integer> tomorrowStock = getListInteger(5);
        int floussi = 10;

        printList(todayStock);
        printList(tomorrowStock);

        int max = 0;
        for (int i =0 ; i < todayStock.size() ; i++){

            int profit = getMaxProfit(floussi,(ArrayList<Integer>)todayStock.clone(),(ArrayList<Integer>)tomorrowStock.clone(),i);
               if(profit > max ) max = profit;

        }
        System.out.println(max);
    }

    private static int getMaxProfit(int floussi, ArrayList<Integer> todayStock, ArrayList<Integer> tomorrowStock,int current) {

        if(todayStock.size() == 1)
        {
            if(floussi > todayStock.get(0))
            return tomorrowStock.get(0) - todayStock.get(0);
            return 0;
        }

        int profit = tomorrowStock.get(current) - todayStock.get(current);
       if(floussi > todayStock.get(current) && profit > 0 )
       { // let's buy and try
           int newFlouss = floussi - todayStock.get(current);
           todayStock.remove(current);
           tomorrowStock.remove(current);
           int max = 0;
           for(int j = 0 ; j < todayStock.size() ; j++){
               int otherprofit = getMaxProfit(newFlouss,todayStock,tomorrowStock,j);
               if(otherprofit > max)
                   max = otherprofit;
           }

           return profit + max;
       }
       return 0;

    }

    public static int position(String s){

        String copy  = new String (s);
        char[] chars = PROGRAMMER.toCharArray();
        for(char letter : chars){
            copy = copy.replaceFirst(String.valueOf(letter),"#");
        }
        System.out.println(copy);
        return copy.lastIndexOf("#");
    }
    //Person haithem = new Person("Haithem" , 42);

     //   System.out.println(haithem.name() + " aged : " + haithem.age);


    public record Person ( String name, int age){

    }
    //sortLinkedListsFromInput();
    private static void sortLinkedListsFromInput() {
        Scanner scanner = new Scanner(System.in);
        String testCase =  scanner.nextLine(); // first line

        String firstListSize = scanner.nextLine();
        LinkedList<Integer> firstLinkedList = new LinkedList<>();
        for(int i = 0 ; i < Integer.valueOf(firstListSize) ; i ++)
            firstLinkedList.push(Integer.valueOf( scanner.nextLine()));

        String secondListSize = scanner.nextLine();
        LinkedList<Integer> secondLinkedList = new LinkedList<>();
        for(int i = 0 ; i < Integer.valueOf(secondListSize) ; i ++)
            secondLinkedList.push(Integer.valueOf( scanner.nextLine()));

        printList(firstLinkedList);
        printList(secondLinkedList);

        LinkedList<Integer> resultLinkedList = new LinkedList<>();
        boolean started = false;
        Integer element1 = null ,element2 = null;
        while(!firstLinkedList.isEmpty() || !secondLinkedList.isEmpty() || element1 != null || element2 !=null)
        {
            if(!started){
                 element1 = firstLinkedList.pollLast() ;
                 element2 = secondLinkedList.pollLast() ;
                started = true;
            }

            System.out.println(element1 + " " + element2);
           if(element1 == null )
           {
               resultLinkedList.push(element2);
               element2 = secondLinkedList.pollLast() ; // get another
               continue;
           }
            if(element2 == null )
            {
                resultLinkedList.push(element2);
                element1 = firstLinkedList.pollLast() ; // get another
                continue;
            }


            if(element1 < element2){
                resultLinkedList.push(element1);
                element1 = firstLinkedList.pollLast() ; // get another
            }
            else if (element1 > element2) {
                resultLinkedList.push(element2);
                element2 = secondLinkedList.pollLast() ; // get another
            }
            else { // equals
                resultLinkedList.push(element1);
                resultLinkedList.push(element2);
                element1 = firstLinkedList.pollLast() ; // get another
                element2 = secondLinkedList.pollLast() ; // get another
            }


        }

        printList(resultLinkedList);
    }


    //int result = superDigit(Test.test , 100000);
        //System.out.println(result);
    public static int superDigit(String n, int k) {
        // Write your code here

        // creating the string of p
        //StringBuffer sb = new StringBuffer();
       // for(int i = 0 ; i < k ; i++ )
           // sb.append(n);

        //String number = sb.toString();


        return superD( k * superD(n) +"");

    }
    public static int superD(String number)
    {
        if(number.equals("")) return 0;
        else if(number.length() == 1) return Integer.valueOf(number);
        char[] digits = number.toCharArray();
        long sum =0;
        for( int i = 0 ; i <digits.length ; i ++ )
            sum+= Integer.valueOf(String.valueOf(digits[i]));
        return superD(sum+"");

    }




    private static void dateconversion() throws ParseException {
        String input = "07:05:45PM";

        SimpleDateFormat sdfInput = new SimpleDateFormat("h:m:sa");
        SimpleDateFormat sdfOutput = new SimpleDateFormat("H:m:s");

        Date date  = sdfInput.parse(input);

        System.out.println(date);
        System.out.println(sdfOutput.format(date));

        input.toCharArray();

        char[] a = new char[5];
        //String  aa = new String(a[0]);
        BigInteger b = BigInteger.ZERO;

       // b.add(BigInteger.valueOf());
    }


    private static void flipthematrix() {
        List<List<Integer>> matrix = getMatrix(4);

        printMatrix(matrix);

        Integer[][] arrayMatrix = new Integer[matrix.size()][];

        for(int i =  0 ; i < matrix.size() ; i++){
          arrayMatrix[i] = matrix.get(i).toArray(new Integer[matrix.size()]);
        }
        System.out.println();
        // System.out.println(arrayMatrix[1][2]);
        int sum = 0;
        int n = arrayMatrix.length /2;
        for(int i =  0 ; i < arrayMatrix.length /2 ; i++){
            for(int j = 0;  j < arrayMatrix.length /2 ; j++){
                int g =   Math.max( Math.max(arrayMatrix[i][j],arrayMatrix[i][2*n -j -1]) ,
                        Math.max(arrayMatrix[2*n -i -1][j],arrayMatrix[2*n-i -1][2*n -j -1]    ) )  ;
                sum+= g;
                System.out.print(g + ".");

            }
        }
        System.out.println();
        System.out.println(sum);
    }

    public static void printMatrix(List<List<Integer>> list){

        for(List<Integer> column : list )
            printList(column);

    }

    public static List<List<Integer>> getMatrix(int n){

        List<List<Integer>> list = new ArrayList<List<Integer>>();

        for( int i = 0 ; i < n ; i++)
        {
            list.add(getListInteger(n));
        }
        return list;
    }

    //  System.out.println(getKthGElement(arrayInteger , 5)) ;


   public static Integer  getKthGElement (Integer[] arrayInteger , int k){
       Arrays.sort(arrayInteger);
        // we will concider that array contain duplicated values ( easy without duplication)
       int depth = 0;
       for (int i =arrayInteger.length -1 ; i > 0  ; i-- )
       {
           if(arrayInteger[i] != arrayInteger[i-1])
               depth++;
           if(depth == k)
               return arrayInteger[i];
       }

        return -1;
   }



    private static void testList() {


        Integer[] arrayInteger = getArrayInteger(5);

        ArrayList<Integer> list = new ArrayList<Integer>();

        //printList(list);
        printList(arrayInteger);
        //arrayInteger = sortArray1(arrayInteger);

        Arrays.sort(arrayInteger);

        printList(arrayInteger);


        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 == o2)
                    return 0;
                if (o1 < o2)
                    return -1;
                else return 1;
            }
        });
    }

    private static Integer[] getArrayInteger( int lengthList ) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        Integer[] arrayInteger = new Integer[lengthList];

        for (int i = 0; i < arrayInteger.length; i++) {
            int number = (int) Math.round(Math.random() * 10);
            list.add(number);
            arrayInteger[i] = number;
        }
        return arrayInteger;
    }
    private static  ArrayList<Integer> getListInteger( int lengthList ) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        //Integer[] arrayInteger = new Integer[lengthList];

        for (int i = 0; i < lengthList; i++) {
            int number = (int) Math.round(Math.random() * 10);
            list.add(number);
            //arrayInteger[i] = number;
        }
        return list;
    }


    public static void printList(List<Integer> list) {
        for (Integer element : list)
            System.out.print("-" + element);
        System.out.println();
    }


    public static void printList(Integer[] array) {
        for (Integer element : array)
            System.out.print("-" + element);
        System.out.println();
    }

    public static Integer[] sortArray(Integer[] array) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (Integer element : array) {
            list.add(element);
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 == o2) return 0;
                if (o1 > o2) return 1;
                else return -1;
            }
        });
        return list.toArray(new Integer[array.length]);
    }

    public static Integer[] sortArray1(Integer[] array) {
        //Integer[] result = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            System.out.print("Step " + (i +1) + ":" );
            printList(array);
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].intValue() > array[j].intValue())
                {
                    System.out.println("    +swap n°"+ j +" : " +array[i] + " and " +array[j]);
                    Integer temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

}


