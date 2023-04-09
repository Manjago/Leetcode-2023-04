import java.util.*;

public class LeetCode01857 {

    public static void main(String[] args) {
        // colors = "abaca",
        // //edges = [[0,1],[0,2],[2,3],[3,4]]

        int answer = new LeetCode01857().largestPathValue("keitgkggegyktyeytgyigkggktiigigkeyygtgytiygtkg", new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {3, 4}, {4, 5}, {5, 6}, {3, 6}, {5, 7}, {6, 8}, {5, 8}, {7, 8}, {8, 9}, {7, 10}, {8, 10}, {9, 10}, {10, 11}, {9, 11}, {7, 11}, {5, 12}, {11, 12}, {11, 13}, {13, 14}, {12, 14}, {12, 15}, {10, 15}, {14, 15}, {7, 15}, {9, 16}, {13, 16}, {12, 16}, {15, 16}, {11, 17}, {14, 17}, {16, 17}, {15, 18}, {14, 18}, {17, 18}, {18, 19}, {14, 19}, {13, 19}, {14, 20}, {15, 21}, {12, 21}, {20, 21}, {19, 22}, {20, 22}, {21, 22}, {22, 23}, {19, 23}, {11, 23}, {18, 23}, {13, 24}, {23, 24}, {21, 24}, {24, 25}, {13, 25}, {23, 25}, {15, 26}, {23, 26}, {25, 26}, {24, 26}, {26, 27}, {25, 27}, {26, 28}, {27, 28}, {20, 28}, {23, 28}, {11, 28}, {23, 29}, {29, 30}, {25, 31}, {26, 31}, {15, 32}, {30, 32}, {31, 33}, {27, 33}, {30, 33}, {28, 33}, {29, 34}, {32, 35}, {33, 35}, {34, 35}, {35, 36}, {13, 36}, {34, 36}, {30, 37}, {36, 37}, {35, 37}, {24, 37}, {35, 38}, {34, 39}, {37, 39}, {37, 40}, {39, 41}, {37, 41}, {41, 42}, {38, 42}, {40, 43}, {43, 44}, {39, 44}, {35, 44}, {38, 45}, {44, 45}, {26, 45}});
        Assert.check(10 == answer, "10 != " + answer);

/*
        answer = new LeetCode01857().largestPathValue("bbbhb", new int[][]{{0, 2}, {3, 0}, {1, 3}, {4, 1}});
        Assert.check(4 == answer, "4 != " + answer);


        answer = new LeetCode01857().largestPathValue("abaca", new int[][]{{0, 1}, {0, 2}, {2, 3}, {3, 4}});
        Assert.check(3 == answer, "3 != " + answer);

        answer = new LeetCode01857().largestPathValue("a", new int[][]{{0, 0}});
        Assert.check(-1 == answer, "-1 != " + answer);
*/
    }

    private static int findMax(Node[] nodes, Path startPath) {
        final Queue<Path> queue = new LinkedList<>();
        queue.offer(startPath);

        final PathRater pathRater = new PathRater();

        while (!queue.isEmpty()) {
            final Path currentPath = queue.poll();
            final Node currentNode = nodes[currentPath.top()];
            boolean isLeaf = true;
            for (Node next : currentNode.neighboors) {
                isLeaf = false;
                final Path nextPath = currentPath.withNum(next.num);
                if (nextPath == null) {
                    return -1;
                }
                queue.add(nextPath);
            }

            if (isLeaf) {
                pathRater.rate(currentPath, nodes);
            }
        }

        return pathRater.answer();
    }

    public int largestPathValue(String colors, int[][] edges) {

        final int yMax = edges.length;

        final Node[] nodes = new Node[colors.length()];
        for (int i = 0; i < colors.length(); i++) {
            final Node node = new Node(i, colors.charAt(i));
            nodes[i] = node;
        }

        for (int y = 0; y < yMax; y++) {
            final int fromIndex = edges[y][0];
            final int toIndex = edges[y][1];
            final Node fromNode = nodes[fromIndex];
            final Node toNode = nodes[toIndex];
            fromNode.neighboors.add(toNode);
            toNode.goodForStart = false;
        }

        int max = -1;
        for (Node node : nodes) {
            if (node.goodForStart) {
                final Path startPath = new Path().withNum(node.num);
                final int pretender = findMax(nodes, startPath);
                if (pretender == -1) {
                    return -1;
                }
                if (max < pretender) {
                    max = pretender;
                }
            }
        }
        return max;
    }

    private static class PathRater {

        private final int[] colours = new int[26];

        void rate(Path path, Node[] nodes) {
            final int[] temp = new int[26];
            for (Integer index : path.path) {
                final Node node = nodes[index];
                int colorIndex = node.color - 'a';
                ++temp[colorIndex];
            }
            for (int i = 0; i < 26; ++i) {
                if (colours[i] < temp[i]) {
                    colours[i] = temp[i];
                }
            }
        }

        int answer() {
            return Arrays.stream(colours).max().orElse(0);
        }
    }

    private static class Path {
        final List<Integer> path;
        final Set<Integer> visited;

        public Path() {
            path = new ArrayList<>();
            visited = new HashSet<>();
        }

        public Path(Path parentPath) {
            this();
            visited.addAll(parentPath.visited);
            path.addAll(parentPath.path);
        }

        int top() {
            return path.get(path.size() - 1);
        }

        public Path withNum(int num) {
            final Path result = new Path(this);
            if (!result.add(num)) {
                return null;
            }
            return result;
        }

        private boolean add(int num) {
            if (visited.contains(num)) {
                return false;
            }
            visited.add(num);
            path.add(num);
            return true;
        }
    }

    private static class Node {
        private final int num;
        private final char color;
        private final List<Node> neighboors = new ArrayList<>();
        private boolean goodForStart = true;

        private Node(int num, char color) {
            this.num = num;
            this.color = color;
        }
    }
}
