package demo.restservices;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {
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
    private double time;

    public double getCurrent() {
        return current;
    }

    public double getOpen() {
        return open;
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
}