package demo.restservices;

import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public @ Data class Quote {
    @JsonProperty("c")
    private double current;
    @JsonProperty("h")
    private double high;
    @JsonProperty("l")
    private double low;
    @JsonProperty("o")
    private double open;
    @JsonProperty("pc")
    private double previousClose;
    @JsonProperty("t")
    private int time;

    /*
    public double getCurrent() {
        return current;
    }

    public double getHigh() {
        return high;
    }

    public double getLow() {
        return low;
    }

    public double getOpen() {
        return open;
    }

    public double getPreviousClose() { return previousClose; }

    public int getTime() { return time; }

    public void setCurrent(double current) {
        this.current = current;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public void setPreviousClose(double previousClose) {
        this.previousClose = previousClose;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "current='" + current + '\'' +
                ", high='" + high + '\'' +
                "low='" + low + '\'' +
                ", open='" + open + '\'' +
                "previousClose='" + previousClose + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

     */
}