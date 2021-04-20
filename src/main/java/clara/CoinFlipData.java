package clara;

public class CoinFlipData {
    private int amt;
    private int timesHeads;
    private int timesTails;
    private float percentHeads;
    private float percentTails;

    public CoinFlipData(int amt, int timesHeads, int timesTails, float percentHeads, float percentTails) {
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

    public void setAmt(int amt) {
        this.amt = amt;
    }

    public void setTimesHeads(int timesHeads) {
        this.timesHeads = timesHeads;
    }

    public void setTimesTails(int timesTails) {
        this.timesTails = timesTails;
    }

    public void setPercentHeads(float percentHeads) {
        this.percentHeads = percentHeads;
    }

    public void setPercentTails(float percentTails) {
        this.percentTails = percentTails;
    }
}
