import java.util.*;

/*
[21,40,16,24,30]
50

30,16
40
24,21



16,21,24,30,40

40
30, 16
24, 21


---
40, 30, 24, 21, 16

40
30, 16
24, 21

[5,1,4,2]
6

1,2,4,5

5, 1
2, 4

1,2
4,5

1, 5
2, 4


5, 4, 2, 1

5, 1
4, 2

 */
public class LeetCode00881 {

    public static void main(String[] args) {
        int answer = new LeetCode00881().numRescueBoats(new int[] {21,40,16,24,30}, 50);
        System.out.println("3=="+answer);
        answer = new LeetCode00881().numRescueBoats(new int[] {5,1,4,2}, 6);
        System.out.println("2=="+answer);
        answer = new LeetCode00881().numRescueBoats(new int[] {2695,22727,26302,27700,25273,26944,27691,16217,11739,21158}, 29998);
        System.out.println("8=="+answer);
        answer = new LeetCode00881().numRescueBoats(new int[] {3,2,3,2,2}, 6);
        System.out.println("3=="+answer);
    }

    public int numRescueBoats(int[] people, int limit) {

        Arrays.sort(people);
        int bigIndex = people.length - 1;
        int smallIndex = 0;
        int boats = 0;
        while(smallIndex < bigIndex) {
            final int small = people[smallIndex];
            final int big = people[bigIndex];
            if ((big + small) > limit) {
                ++boats;
                --bigIndex;
            } else {
                --bigIndex;
                ++smallIndex;
                ++boats;
            }
        }

        if (smallIndex == bigIndex) {
            return boats  + 1;
        } else {
            return boats;
        }
    }

}
