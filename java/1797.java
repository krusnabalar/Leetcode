import java.util.*;

class AuthenticationManager {
    int timeToLive;
    Map<String, Integer> currTokens;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        this.currTokens = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        this.currTokens.put(tokenId, currentTime + timeToLive);
    }

    public void renew(String tokenId, int currentTime) {
        if (this.currTokens.containsKey(tokenId) && this.currTokens.get(tokenId) > currentTime) {
            this.currTokens.put(tokenId, currentTime + this.timeToLive);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int counter = 0;
        for (Map.Entry<String, Integer> id : this.currTokens.entrySet()) {
            if (id.getValue() > currentTime)
                counter++;
        }
        return counter;
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */