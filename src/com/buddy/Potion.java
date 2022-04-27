package com.buddy;

public class Potion {
    String name;
    String statRefilled;
    int amountRefilled;

    public Potion() {
        String name;
        String statRefilled;
        int amountRefilled;
    }

    public Potion(String name, String statRefilled, int amountRefilled) {
        this.name = name;
        this.statRefilled = statRefilled;
        this.amountRefilled = amountRefilled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatRefilled() {
        return statRefilled;
    }

    public void setStatRefilled(String statRefilled) {
        this.statRefilled = statRefilled;
    }

    public int getAmountRefilled() {
        return amountRefilled;
    }

    public void setAmountRefilled(int amountRefilled) {
        this.amountRefilled = amountRefilled;
    }
}
