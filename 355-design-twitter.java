import java.util.*;

class Twitter {
    HashMap<Integer, HashSet<Integer>> following;
    HashMap<Integer, List<int[]>> post;
    int time;

    public Twitter() {
        following = new HashMap<>();
        post = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        time++;
        List<int[]> p = post.getOrDefault(userId, new ArrayList<>());
        p.add(0, new int[]{tweetId, time});
        post.put(userId, p);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> list = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        HashSet<Integer> followingList = following.getOrDefault(userId, new HashSet<>());
        followingList.add(userId);

        for (int id : followingList) {
            List<int[]> tweets = post.getOrDefault(id, new ArrayList<>());

            for (int i = 0; i < Math.min(tweets.size(), 10); i++) {
                pq.offer(tweets.get(i));
                if (pq.size() > 10) pq.poll();
            }
        }

        while (!pq.isEmpty()) {
            list.add(0, pq.poll()[0]);
        }

        return list;
    }
    
    public void follow(int followerId, int followeeId) {
        HashSet<Integer> f = following.getOrDefault(followerId, new HashSet<>());
        f.add(followeeId);
        following.put(followerId, f);
    }
    
    public void unfollow(int followerId, int followeeId) {
        HashSet<Integer> f = following.getOrDefault(followerId, new HashSet<>());
        f.remove(followeeId);
        following.put(followerId, f);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Twitter twitter = new Twitter();

        int q = sc.nextInt();

        while (q-- > 0) {
            String op = sc.next();

            if (op.equals("post")) {
                int userId = sc.nextInt();
                int tweetId = sc.nextInt();
                twitter.postTweet(userId, tweetId);
            } 
            else if (op.equals("follow")) {
                int followerId = sc.nextInt();
                int followeeId = sc.nextInt();
                twitter.follow(followerId, followeeId);
            } 
            else if (op.equals("unfollow")) {
                int followerId = sc.nextInt();
                int followeeId = sc.nextInt();
                twitter.unfollow(followerId, followeeId);
            } 
            else if (op.equals("feed")) {
                int userId = sc.nextInt();
                List<Integer> feed = twitter.getNewsFeed(userId);
                for (int id : feed) {
                    System.out.print(id + " ");
                }
                System.out.println();
            }
        }

        sc.close();
    }
}