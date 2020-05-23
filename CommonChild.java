public class CommonChild {
    public static void main(String[] args){
        System.out.println(commonChild("ELGGYJWKTDHLXJRBJLRYEJWVSUFZKYHOIKBGTVUTTOCGMLEXWDSXEBKRZTQUVCJNGKKRMUUBACVOEQKBFFYBUQEMYNENKYYGUZSP","FRVIFOVJYQLVZMFBNRUTIYFBMFFFRZVBYINXLDDSVMPWSQGJZYTKMZIPEGMVOUQBKYEWEYVOLSHCMHPAZYTENRNONTJWDANAMFRX"));
    }
    static int commonChild(String s1, String s2) {
        int max = 0;
        int first = 0;
        while(first < s1.length()){
            int counter = 0;
            int firstPointer = first;
            int second = 0;
            while(firstPointer < s1.length()){
                int secondPointer = second;
                while(secondPointer < s2.length()){
                    if(s1.charAt(firstPointer) == s2.charAt(secondPointer)){
                        counter ++;
                        second = secondPointer+1;
                        break;
                    }
                    else{
                        secondPointer++;
                    }
                }
                firstPointer ++;
            }
            if(counter > max){
                max = counter;
            }
            first ++;
        }
        return max;
    }
}
