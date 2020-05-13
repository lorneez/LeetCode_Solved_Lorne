public class MinNumberBribes {
    /**
     * Runtime complexity: O(n)
     * Space complexity: O(1)
     * minimumBribes finds the minimum number of switches needed to sort the array by saving the values of the three
     * lowest swaps. It uses
     */
    static void minimumBribes(int[] q) {
        int count = 0 ;
        //always keep track of min three values observed
        //Compare currently seeing value with this three values.
        int midOfThree = Integer.MAX_VALUE;
        int maxOfThree =  Integer.MAX_VALUE;
        int minOfThree =  Integer.MAX_VALUE ;
        //iterating from left to right
        for(int i=q.length-1 ; i >= 0 ; i--){
            // check if the person has bribed more than 3 people.
            if((q[i]-i) > 3 ) {
                System.out.println("Too chaotic");
                return;
            }
            else{
                //means current value has passed at least 3 values -> wrong
                if(q[i] > maxOfThree){
                    System.out.println("Too chaotic");
                    return;
                }
                else if(q[i] > midOfThree){ //means -> current value has bribed 2 ppl
                    count=count+2;
                }
                else if(q[i] > minOfThree){ //means-> current value has bribed 1 person.
                    count=count+1;
                }
                //three values store minimum 3
                if(q[i]<minOfThree){
                    maxOfThree=midOfThree;
                    midOfThree=minOfThree;
                    minOfThree = q[i];
                }
                else if(q[i]<midOfThree){
                    maxOfThree=midOfThree;
                    midOfThree = q[i];
                }
                else if(q[i]<maxOfThree){
                    maxOfThree = q[i];
                }
            }
        }
        System.out.println(count);
    }
}
