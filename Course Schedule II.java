

Graphs
(7 / 13)


Prerequisites

Intro to Graphs
Data Structures & Algorithms for Beginners
Matrix DFS
Data Structures & Algorithms for Beginners
Matrix BFS
Data Structures & Algorithms for Beginners
Adjacency List
Data Structures & Algorithms for Beginners
Status
Star
Problem   
Difficulty   
Video Solution
Code
Number of Islands   	
Max Area of Island   	
Clone Graph   	
Walls And Gates   	
Rotting Oranges   	
Pacific Atlantic Water Flow   	
Surrounded Regions   	
Course Schedule   	
Course Schedule II   	
Graph Valid Tree   	
Number of Connected Components In An Undirected Graph   	
Redundant Connection   	
Word Ladder   	
View on Github
class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();
        int[] indegree = new int[numCourses];
        int[] topologicalOrder = new int[numCourses];

        //creating the adjlist
        for (int i = 0; i < prerequisites.length; i++) {
            int post = prerequisites[i][0];
            int pre = prerequisites[i][1];
            List<Integer> lst = adjList.getOrDefault(
                pre,
                new ArrayList<Integer>()
            );
            lst.add(post);
            adjList.put(pre, lst);

            indegree[post] += 1;
        }

        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int i = 0;
        while (!q.isEmpty()) {
            int node = q.remove();
            topologicalOrder[i++] = node;

            if (adjList.containsKey(node)) {
                for (Integer neighbor : adjList.get(node)) {
                    indegree[neighbor]--;

                    if (indegree[neighbor] == 0) {
                        q.add(neighbor);
                    }
                }
            }
        }

        if (i == numCourses) {
            return topologicalOrder;
        }

        return new int[0];
    }
}
Select Roadmap

(83 / 150)


