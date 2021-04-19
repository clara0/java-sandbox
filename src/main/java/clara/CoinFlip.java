package clara;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CoinFlip {
    public String flipCoinOnce() {
        Random random = new Random();
        int num = random.nextInt(2);
        if (num == 0) {
            return "heads";
        }
        return "tails";
    }

    public Map<String, Float> flipCoins(int amt) {
        int timesHeads = 0;
        int timesTails = 0;
        for (int i = 1; i < amt + 1; i ++) {
            String result = flipCoinOnce();
            if (result.equals("heads")) {
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
