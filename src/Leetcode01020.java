import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Leetcode01020 {


    public static void main(String[] args) {
        int[][] grid = new int[][]  {
                {0,0,0,0},
                {1,0,1,0},
                {0,1,1,0},
                {0,0,0,0}};
        int answer = new Leetcode01020().numEnclaves(grid);
        Assert.check(3 == answer, "3 !=  " + answer);
        
        grid = new int[][]  {
                {0,1,1,0},
                {0,0,1,0},
                {0,0,1,0},
                {0,0,0,0}};
        answer = new Leetcode01020().numEnclaves(grid);
        Assert.check(0 == answer, "0 !=  " + answer);

    }
    public int numEnclaves(int[][] grid) {

        final int yMax = grid.length;
        final int xMax = grid[0].length;

        final Set<Point> visited = new HashSet<>();
        int found = 0;

        for (int x = 0; x < xMax; ++x) {
            for (int y = 0; y < yMax; ++y) {
                final int item = grid[y][x];

                if (item == 0) {
                    continue;
                }

                final Point point = new Point(x, y);
                if (visited.contains(point)) {
                    continue;
                }

                int size = fillIsland(point, visited, xMax, yMax, grid);
                if (size > 0) {
                    found += size;
                }
            }
        }


        return found;
    }

    private static boolean isBounded(int x, int y, int xMax, int yMax) {
        return x == 0 || y == 0 || x == xMax - 1 || y == yMax - 1;
    }

    private static boolean isValid(int x, int y, int xMax, int yMax, int [][] grid) {
        return x >= 0 && y >= 0 && x < xMax && y < yMax && grid[y][x] == 1;
    }

    private int fillIsland(Point point, Set<Point> visited, int xMax, int yMax, int[][] grid) {
        final Set<Point> locals = new HashSet<>();
        boolean isolated = true;
        final Queue<Point> queue = new LinkedList<>();
        queue.offer(point);
        while (!queue.isEmpty()) {
            final Point item = queue.poll();
            if (visited.contains(item)) {
                continue;
            }
            visited.add(item);

            if (isolated && isBounded(item.x, item.y, xMax, yMax)) {
                isolated = false;
            }
            locals.add(item);

            if (isValid(item.x - 1, item.y, xMax, yMax, grid)) {
                queue.offer(new Point(item.x - 1, item.y));
            }
            if (isValid(item.x + 1, item.y, xMax, yMax, grid)) {
                queue.offer(new Point(item.x + 1, item.y));
            }
            if (isValid(item.x, item.y - 1, xMax, yMax, grid)) {
                queue.offer(new Point(item.x, item.y - 1));
            }
            if (isValid(item.x, item.y + 1, xMax, yMax, grid)) {
                queue.offer(new Point(item.x, item.y + 1));
            }
        }

/*
        System.out.println(isolated);
        System.out.println(locals);
*/
        if (isolated) {
            return locals.size();
        } else {
            return -1;
        }
    }

    private static class Point {
        final int x;
        final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            return y == point.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

}
