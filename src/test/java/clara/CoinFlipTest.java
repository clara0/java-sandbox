package clara;

import org.junit.Test;

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
        assertEquals(100, coinFlip.flipCoins(100).getAmt());
        assertEquals(5000, coinFlip.flipCoins(5000).getAmt());
    }
}
