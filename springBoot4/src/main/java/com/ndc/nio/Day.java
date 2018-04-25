package com.ndc.nio;

//@Profile

public enum Day {
    Happy("birth");

    @SuppressWarnings("unused")
    private String sb;

    private Day(String sb) {
        this.sb = sb;
    }
}
