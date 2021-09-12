package clara;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests {@code CoinFlip}.
 *
 * @see CoinFlip
 */
public class CoinFlipTest {
    CoinFlip coinFlip;

    /**
     * Creates new instance of {@code CoinFlip} before every method.
     */
    @Before
    public void before() {
        coinFlip = new CoinFlip();
    }

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
