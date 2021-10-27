package ru.mephi.hw3;

public enum Role {

    STAFF(0.1d),
    MANAGER(0.2d),
    EXECUTIVE(0.3d);
    ;
    private final double rate;

    Role(double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return this.rate;
    }
}

