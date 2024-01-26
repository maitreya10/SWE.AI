class TimeMap {
    private Map<String, List<Pair<String, Integer>>> hm;
    public TimeMap() {
        hm = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!hm.containsKey(key)) {
            hm.put(key, new ArrayList<>());
            hm.get(key).add(new Pair(value, timestamp));
        } else {
            hm.get(key).add(new Pair(value, timestamp));
        }
    }
    
    public String get(String key, int timestamp) {
        if (!hm.containsKey(key)) {
            return "";
        }
        if (hm.get(key).get(0).getValue() > timestamp) {
            return "";
        }  
        int low = 0;
        int high = hm.get(key).size() - 1;
        int mid, ans = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (hm.get(key).get(mid).getValue() <= timestamp) {
                low = mid + 1;
                ans = mid;
            } else {
                high = mid - 1;
            }
        }
        return hm.get(key).get(ans).getKey();    
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
