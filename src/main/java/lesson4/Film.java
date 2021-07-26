package lesson4;

import java.time.LocalDateTime;

public class Film {
    private String name;
    private LocalDateTime dataTimeStart;
    private int duration;
    private int price;
    private int buedTickets;
    private LocalDateTime dataTimeEnd;
    private int durationBreak;
    private int allVisitor;
    private int averageVisitor;
    private int amountProfit;

    public Film(String name, LocalDateTime dataTimeStart, int duration, int price, int buedTickets) {
        this.name = name;
        this.dataTimeStart = dataTimeStart;
        this.duration = duration;
        this.price = price;
        this.buedTickets = buedTickets;
        dataTimeEnd = dataTimeStart.plusMinutes(duration);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDataTimeStart() {
        return dataTimeStart;
    }

    public void setDataTimeStart(LocalDateTime dataTimeStart) {
        this.dataTimeStart = dataTimeStart;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getBuedTickets() {
        return buedTickets;
    }

    public void setBuedTickets(int buedTickets) {
        this.buedTickets = buedTickets;
    }

    public LocalDateTime getDataTimeEnd() {
        return dataTimeEnd;
    }

    public void setDataTimeEnd(LocalDateTime dataTimeEnd) {
        this.dataTimeEnd = dataTimeEnd;
    }

    public int getDurationBreak() {
        return durationBreak;
    }

    public void setDurationBreak(int durationBreak) {
        this.durationBreak = durationBreak;
    }

    public int getAllVisitor() {
        return allVisitor;
    }

    public void setAllVisitor(int allVisitor) {
        this.allVisitor = allVisitor;
    }

    public int getAverageVisitor() {
        return averageVisitor;
    }

    public void setAverageVisitor(int averageVisitor) {
        this.averageVisitor = averageVisitor;
    }

    public int getAmountProfit() {
        return amountProfit;
    }

    public void setAmountProfit(int amountProfit) {
        this.amountProfit = amountProfit;
    }
}
