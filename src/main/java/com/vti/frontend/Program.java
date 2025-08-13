package com.vti.frontend;

import com.vti.backend.controller.CandidateController;
import com.vti.backend.repository.CandidateRepositoryImpl;
import com.vti.backend.repository.ICandidateRepository;
import com.vti.backend.service.CandidateServiceImpl;
import com.vti.backend.service.ICandidateService;
import com.vti.backend.utils.ScannerUtils;

public class Program {
    public static void main(String[] args) throws Exception {
        ICandidateRepository repo = new CandidateRepositoryImpl();
        ICandidateService service = new CandidateServiceImpl(repo);
        CandidateController controller = new CandidateController(service);

        while (true) {
            int chon = ScannerUtils.menuMain();
            if (chon == 0) break;
            try {
                switch (chon) {
                    case 1 -> controller.registerExperience();
                    case 2 -> controller.registerFresher();
                    case 3 -> controller.login();
                    default -> ScannerUtils.println("Loi: lua chon khong hop le!");
                }
            } catch (Exception e) {
                ScannerUtils.println("Loi: " + e.getMessage());
            }
        }
    }
}
