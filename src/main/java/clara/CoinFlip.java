package clara;

import clara.util.NumberUtils;

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

    public Stats flipCoins(int amt) {
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
        return new Stats(amt, timesHeads, timesTails, NumberUtils.findPercent(timesHeads, amt), NumberUtils.findPercent(timesTails, amt));
    }

    public static final class Stats {
        private final int amt;
        private final int timesHeads;
        private final int timesTails;
        private final float percentHeads;
        private final float percentTails;

        public Stats(int amt, int timesHeads, int timesTails, float percentHeads, float percentTails) {
            this.amt = amt;
            this.timesHeads = timesHeads;
            this.timesTails = timesTails;
            this.percentHeads = percentHeads;
            this.percentTails = percentTails;
        }

        public int getAmt() {
            return amt;
        }

        public int getTimesHeads() {
            return timesHeads;
        }

        public int getTimesTails() {
            return timesTails;
        }

        public float getPercentHeads() {
            return percentHeads;
        }

        public float getPercentTails() {
            return percentTails;
        }
    }

}
