package com.vti.backend.utils;

import java.util.regex.Pattern;

public class Validator {
    // Regex theo de: phone bat dau 0, 9-12 so; email hop le; password 6-12 ky tu co it nhat 1 chu hoa
    private static final Pattern PHONE = Pattern.compile("^0[0-9]{8,11}$");
    private static final Pattern EMAIL = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    private static final Pattern PWD   = Pattern.compile("^(?=.*[A-Z]).{6,12}$");

    public static void checkPhone(String v) {
        if (!PHONE.matcher(v).matches()) {
            throw new IllegalArgumentException("phone phai bat dau bang 0 va co do dai 9-12 so");
        }
    }
    public static void checkEmail(String v) {
        if (!EMAIL.matcher(v).matches()) throw new IllegalArgumentException("email khong hop le");
    }
    public static void checkPassword(String v) {
        if (!PWD.matcher(v).matches()) throw new IllegalArgumentException("password 6-12 ky tu va co it nhat 1 chu hoa");
    }
    public static void checkNotBlank(String label, String v) {
        if (v == null || v.isBlank()) throw new IllegalArgumentException(label + " khong duoc rong");
    }
    public static void checkExp(int y) {
        if (y < 0 || y > 10) throw new IllegalArgumentException("exp_in_year phai trong [0,10]");
    }
}
