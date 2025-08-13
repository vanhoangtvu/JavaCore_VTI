package com.vti.backend.controller;

import com.vti.backend.dto.*;
import com.vti.backend.service.ICandidateService;
import com.vti.backend.utils.ScannerUtils;

public class CandidateController {
    private final ICandidateService service;
    public CandidateController(ICandidateService service) { this.service = service; }

    public void registerExperience() throws Exception {
        ExperienceCandidate c = new ExperienceCandidate();
        nhapChung(c);
        c.setExpInYear(ScannerUtils.inputIntInRange("Nhap exp_in_year (0-10): ", 0, 10));
        c.setProSkill(ScannerUtils.inputNonBlank("Nhap pro_skill: "));
        service.dangKyExperience(c);
        ScannerUtils.println(">>> Dang ky EXPERIENCE thanh cong!");
    }

    public void registerFresher() throws Exception {
        FresherCandidate c = new FresherCandidate();
        nhapChung(c);
        c.setGraduationRank(ScannerUtils.inputGraduationRank());
        service.dangKyFresher(c);
        ScannerUtils.println(">>> Dang ky FRESHER thanh cong!");
    }

    public void login() throws Exception {
        String email = ScannerUtils.inputRaw("Email: ");
        String pass  = ScannerUtils.inputRaw("Password: ");
        Candidate u = service.dangNhap(email, pass);
        ScannerUtils.println(">>> Dang nhap OK. Xin chao " + u.getFirstName() + " " + u.getLastName());
    }

    private void nhapChung(Candidate c) {
        c.setFirstName(ScannerUtils.inputNonBlank("Nhap first_name: "));
        c.setLastName (ScannerUtils.inputNonBlank("Nhap last_name : "));
        c.setPhone    (ScannerUtils.inputPhoneStrict());
        c.setEmail    (ScannerUtils.inputEmailStrict());
        c.setPassword (ScannerUtils.inputPasswordStrict());
    }
}
