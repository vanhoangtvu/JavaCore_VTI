package com.vti.backend.service;

import com.vti.backend.dto.*;
import com.vti.backend.repository.ICandidateRepository;
import com.vti.backend.utils.Validator;

public class CandidateServiceImpl implements ICandidateService {
    private final ICandidateRepository repo;

    public CandidateServiceImpl(ICandidateRepository repo) { this.repo = repo; }

    @Override
    public void dangKyExperience(ExperienceCandidate c) throws Exception {
        kiemTraChung(c);
        Validator.checkExp(c.getExpInYear());
        if (repo.emailTonTai(c.getEmail())) throw new IllegalStateException("email da ton tai");
        repo.luuExperience(c);
    }

    @Override
    public void dangKyFresher(FresherCandidate c) throws Exception {
        kiemTraChung(c);
        if (c.getGraduationRank() == null) throw new IllegalArgumentException("graduation_rank bat buoc");
        if (repo.emailTonTai(c.getEmail())) throw new IllegalStateException("email da ton tai");
        repo.luuFresher(c);
    }

    @Override
    public Candidate dangNhap(String email, String password) throws Exception {
        Validator.checkEmail(email);
        Validator.checkPassword(password);
        return repo.timTheoEmailVaPassword(email, password)
                   .orElseThrow(() -> new IllegalArgumentException("sai email hoac password"));
    }

    // validate chung: firstName, lastName, phone, email, password
    private void kiemTraChung(Candidate c) {
        Validator.checkNotBlank("first_name", c.getFirstName());
        Validator.checkNotBlank("last_name",  c.getLastName());
        Validator.checkPhone(c.getPhone());
        Validator.checkEmail(c.getEmail());
        Validator.checkPassword(c.getPassword());
    }
}
