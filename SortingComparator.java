import java.util.Comparator;

/**
 * This is a comparator...
 */
class SortingComparator implements Comparator<Player> {
    // complete this method
    public int compare(Player a, Player b) {
        int status;
        if(a.score == b.score){
            status = a.name.compareTo(b.name);
        }
        else{
            status = a.score > b.score ? -1 : 1;
        }
        return status;
    }
}