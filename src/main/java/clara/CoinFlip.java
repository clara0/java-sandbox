package clara;

import java.util.Random;

public class CoinFlip {
    public enum Result {
        HEADS,
        TAILS
    }

    public Result flipCoinOnce() {
        Random random = new Random();
        int num = random.nextInt(2);
        if (num == 0) {
            return Result.HEADS;
        }
        return Result.TAILS;
    }

    public CoinFlipData flipCoins(int amt) {
        int timesHeads = 0;
        int timesTails = 0;
        for (int i = 1; i < amt + 1; i ++) {
            Result result = flipCoinOnce();
            if (result.equals(Result.HEADS)) {
                timesHeads += 1;
            } else {
                timesTails +=1;
            }
        }
        return new CoinFlipData(amt, timesHeads, timesTails, NumberUtils.findPercent(timesHeads, amt), NumberUtils.findPercent(timesTails, amt));
    }

}
