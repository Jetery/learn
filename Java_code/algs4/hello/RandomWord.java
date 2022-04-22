import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2022.04.22
 */

//Todo
// Write a program RandomWord.java that reads a sequence of words from standard input and prints one of those words uniformly at random.
// Do not store the words in an array or list.
// Instead, use Knuth’s method: when reading the ith word, select it with probability 1/i to be the champion,
// replacing the previous champion. After reading all the words, print the surviving champion.

    
public class RandomWord {
    public static void main(String[] args) {
        String ans = StdIn.readString();
        String temp;
        int count = 1;
        while (!StdIn.isEmpty()) {
            temp = StdIn.readString();
            count++;
            if (StdRandom.bernoulli(1.0 / count)) {
                ans = temp;
            }
        }
        StdOut.print(ans);
    }
}
