package com.vti.backend.repository;

import com.vti.backend.dto.*;
import java.util.Optional;

public interface ICandidateRepository {
    boolean emailTonTai(String email) throws Exception;
    void luuExperience(ExperienceCandidate c) throws Exception;
    void luuFresher(FresherCandidate c) throws Exception;
    Optional<Candidate> timTheoEmailVaPassword(String email, String password) throws Exception;
}
