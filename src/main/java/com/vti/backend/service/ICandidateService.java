package com.vti.backend.service;

import com.vti.backend.dto.*;

public interface ICandidateService {
    void dangKyExperience(ExperienceCandidate c) throws Exception;
    void dangKyFresher(FresherCandidate c) throws Exception;
    Candidate dangNhap(String email, String password) throws Exception;
}
