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
40
16, 21



[5,1,4,2]
6

1,2,4,5

5, 1
2, 4

1,2
4,5

1, 5
2, 4


 */
public class LeetCode00881 {

    public static void main(String[] args) {
        int answer = new LeetCode00881().numRescueBoats(new int[] {21,40,16,24,30}, 50);
        System.out.println(answer);
        answer = new LeetCode00881().numRescueBoats(new int[] {5,1,4,2}, 6);
        System.out.println(answer);
    }

    public int numRescueBoats(int[] people, int limit) {
        int fullBoats = 0;
        final List<Integer> semiFullBoats = new ArrayList<>();

        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        while(left <= right) {
            final boolean once = left == right;
            fullBoats = getFullBoats(people, limit, fullBoats, semiFullBoats, right--);
            if (!once) {
                fullBoats = getFullBoats(people, limit, fullBoats, semiFullBoats, left++);
            }
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
            if (newWeight < limit) {
                semiFullBoats.remove(j);
                semiFullBoats.add(newWeight);
                found = true;
                break;
            } else if (newWeight == limit) {
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

        if (i < people.length - 1) {
            semiFullBoats.sort((o1, o2) -> -o1.compareTo(o2));
        }
        return fullBoats;
    }
}
