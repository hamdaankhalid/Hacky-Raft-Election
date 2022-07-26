package com.hamdaankhalid.consensus;

public class Vote {
    private int term;
    private boolean granted;

    public Vote(int term, boolean granted) {
        this.term = term;
        this.granted = granted;
    }

    public int getTerm() {
        return term;
    }

    public boolean isGranted() {
        return granted;
    }
}
