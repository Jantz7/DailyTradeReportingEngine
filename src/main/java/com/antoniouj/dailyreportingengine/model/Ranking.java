package com.antoniouj.dailyreportingengine.model;

/**
 * Ranking of an Instruction in terms of AmountOfTrade
 */
public class Ranking {

    // Ranking of the Instruction
    private int rank;

    // The entity of the Instruction
    private String entity;

    public Ranking(int rank, String entity) {
        this.rank = rank;
        this.entity = entity;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }
}
