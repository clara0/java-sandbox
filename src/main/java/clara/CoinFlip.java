package clara;

import java.util.HashMap;
import java.util.Map;
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

    public Map<String, Float> flipCoins(int amt) {
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
        final int finalTimesHeads = timesHeads;
        final int finalTimesTails = timesTails;
        return new HashMap<String, Float>() {
            {
                put("Total Times Flipped", (float) amt);
                put("Heads", (float) finalTimesHeads);
                put("Tails", (float) finalTimesTails);
                put("Percent Heads", NumberUtils.findPercent(finalTimesHeads, amt));
                put("Percent Tails", NumberUtils.findPercent(finalTimesTails, amt));
            }
        };
    }

}
