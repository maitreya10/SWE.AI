class Twitter {
    int count;
    HashMap<Integer, List<int[]>> tweetMap;
    HashMap<Integer, HashSet<Integer>> followerMap;

    public Twitter() {
        count = 0;
        tweetMap = new HashMap<>();
        followerMap = new HashMap<>();
    }
    
    /**
     * Look at the beauty of Functional Interfaces, lambda function; just look at the number of lines of code.
     */
    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k -> new ArrayList<>()); // just put initialize a new ArrayList
        tweetMap.computeIfPresent(userId, (k, v) -> { // perform this computation on the "Value" of the key-Value Map.
            v.add(new int[]{count, tweetId});
            return v;
        });
        count++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0])); // specify required argument for specifying that ots a maxHeap. Comparator to compare based on "counts" which is in the 0th index. reverse order as MaxHeap.
        followerMap.computeIfAbsent(userId, k -> new HashSet<>());
        followerMap.get(userId).add(userId);
        followerMap.get(userId).forEach((followeeId) -> {
            if (tweetMap.containsKey(followeeId)) {
                int i = tweetMap.get(followeeId).size() - 1;
                int[] tweet = tweetMap.get(followeeId).get(i);
                maxHeap.offer(new int[]{tweet[0], tweet[1], followeeId, --i});
            }
        });
        while(!maxHeap.isEmpty() && res.size() < 10) {
            int[] data = maxHeap.poll();
            res.add(data[1]);

            if (data[3] >= 0) {
                int[] tweet = tweetMap.get(data[2]).get(data[3]);
                maxHeap.offer(new int[]{tweet[0], tweet[1], data[2], --data[3]});
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followerMap.computeIfAbsent(followerId, k -> new HashSet<>());
        followerMap.computeIfPresent(followerId, (k, v) -> {
            v.add(followeeId);
            return v;
        });
    }
    
    public void unfollow(int followerId, int followeeId) {
        HashSet<Integer> set = followerMap.computeIfAbsent(followerId, k -> new HashSet<>());
        if (set.contains(followeeId)) {
            set.remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
