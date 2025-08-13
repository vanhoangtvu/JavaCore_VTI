package com.vti.backend.dto;

public class ExperienceCandidate extends Candidate {
    private int expInYear;     // 0..10
    private String proSkill;

    public int getExpInYear() { return expInYear; }
    public void setExpInYear(int expInYear) { this.expInYear = expInYear; }
    public String getProSkill() { return proSkill; }
    public void setProSkill(String proSkill) { this.proSkill = proSkill; }
}
