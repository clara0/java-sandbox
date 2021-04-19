package clara;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class CoinFlipTest {
    CoinFlip coinFlip = new CoinFlip();

    @Test
    public void flipCoinOnce() {
        CoinFlip.Result result = coinFlip.flipCoinOnce();
        try {
            assertEquals(CoinFlip.Result.HEADS, result);
        } catch (AssertionError e) {
            assertEquals(CoinFlip.Result.TAILS, result);
        }
    }

    @Test
    public void flipCoins() {
        Map<String, Float> result = coinFlip.flipCoins(100);
        assertEquals((float) 100.0, (Object) result.get("Total Times Flipped"));
        Map<String, Float> result1 = coinFlip.flipCoins(5000);
        assertEquals((float) 5000.0, (Object) result1.get("Total Times Flipped"));
    }
}
