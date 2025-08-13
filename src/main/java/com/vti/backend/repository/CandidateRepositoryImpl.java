package com.vti.backend.repository;

import com.vti.backend.dto.*;
import com.vti.backend.utils.JDBCUtils;

import java.sql.*;
import java.util.Optional;

public class CandidateRepositoryImpl implements ICandidateRepository {

    @Override
    public boolean emailTonTai(String email) throws Exception {
        String sql = "SELECT 1 FROM candidates WHERE email=?";
        try (Connection cn = JDBCUtils.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) { return rs.next(); }
        }
    }

    @Override
    public void luuExperience(ExperienceCandidate c) throws Exception {
        String sql = "INSERT INTO candidates(first_name,last_name,phone,email,password,candidate_type,exp_in_year,pro_skill) " +
                     "VALUES(?,?,?,?,?,'EXPERIENCE',?,?)";
        try (Connection cn = JDBCUtils.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, c.getFirstName());
            ps.setString(2, c.getLastName());
            ps.setString(3, c.getPhone());
            ps.setString(4, c.getEmail());
            ps.setString(5, c.getPassword());
            ps.setInt(6, c.getExpInYear());
            ps.setString(7, c.getProSkill());
            ps.executeUpdate();
        }
    }

    @Override
    public void luuFresher(FresherCandidate c) throws Exception {
        String sql = "INSERT INTO candidates(first_name,last_name,phone,email,password,candidate_type,graduation_rank) " +
                     "VALUES(?,?,?,?,?,'FRESHER',?)";
        try (Connection cn = JDBCUtils.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, c.getFirstName());
            ps.setString(2, c.getLastName());
            ps.setString(3, c.getPhone());
            ps.setString(4, c.getEmail());
            ps.setString(5, c.getPassword());
            ps.setString(6, c.getGraduationRank().name());
            ps.executeUpdate();
        }
    }

    @Override
    public Optional<Candidate> timTheoEmailVaPassword(String email, String password) throws Exception {
        String sql = "SELECT * FROM candidates WHERE email=? AND password=?";
        try (Connection cn = JDBCUtils.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, password);
            try (ResultSet r = ps.executeQuery()) {
                if (!r.next()) return Optional.empty();
                String type = r.getString("candidate_type");
                if ("EXPERIENCE".equals(type)) {
                    ExperienceCandidate e = new ExperienceCandidate();
                    mapBase(r, e);
                    e.setExpInYear(r.getInt("exp_in_year"));
                    e.setProSkill(r.getString("pro_skill"));
                    return Optional.of(e);
                } else {
                    FresherCandidate f = new FresherCandidate();
                    mapBase(r, f);
                    String gr = r.getString("graduation_rank");
                    if (gr != null) f.setGraduationRank(GraduationRank.valueOf(gr));
                    return Optional.of(f);
                }
            }
        }
    }

    private void mapBase(ResultSet r, Candidate c) throws Exception {
        c.setId(r.getInt("id"));
        c.setFirstName(r.getString("first_name"));
        c.setLastName(r.getString("last_name"));
        c.setPhone(r.getString("phone"));
        c.setEmail(r.getString("email"));
        c.setPassword(r.getString("password"));
    }
}
