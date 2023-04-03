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
        int fullBoats = 0;
        final List<Integer> semiFullBoats = new ArrayList<>();

        Arrays.sort(people);
        for(int i = people.length - 1; i >= 0; --i) {
            fullBoats = getFullBoats(people, limit, fullBoats, semiFullBoats, i);
        }

        return fullBoats + semiFullBoats.size();
    }

    private static int getFullBoats(int[] people, int limit, int fullBoats, List<Integer> semiFullBoats, int i) {
        final int humanWeight = people[i];
        if (humanWeight > limit) {
            throw new IllegalArgumentException("Human [" + i + "] has too big weight " + humanWeight);
        }

        boolean found = false;
        for (int j = 0; j < semiFullBoats.size(); j++) {
            final int boat = semiFullBoats.get(j);
            final int newWeight = boat + humanWeight;
            if (newWeight <= limit) {
                semiFullBoats.remove(j);
                ++fullBoats;
                found = true;
                break;
            }
        }

        if (!found) {
            if (humanWeight == limit) {
                ++fullBoats;
            } else {
                semiFullBoats.add(humanWeight);
            }
        }

        if (i > 0) {
            semiFullBoats.sort((o1, o2) -> -o1.compareTo(o2));
        }
        return fullBoats;
    }
}
