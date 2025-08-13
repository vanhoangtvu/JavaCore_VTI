package com.vti.backend.utils;

import com.vti.backend.dto.GraduationRank;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ScannerUtils {
    private static final Scanner SC = new Scanner(System.in);
    // Regex dong bo voi Validator
    private static final Pattern PHONE = Pattern.compile("^0[0-9]{8,11}$");
    private static final Pattern EMAIL = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    private static final Pattern PWD   = Pattern.compile("^(?=.*[A-Z]).{6,12}$");

    // ====== In ra man hinh ======
    public static void print(String msg) {
        System.out.print(msg);
    }
    public static void println(String msg) {
        System.out.println(msg);
    }
    public static void hr() {
        System.out.println("--------------------------------------------------");
    }

    // ====== Nhap raw ======
    public static String inputRaw(String label) {
        print(label);
        return SC.nextLine().trim();
    }

    // ====== Nhap so nguyen ======
    public static int inputInt(String label) {
        while (true) {
            print(label);
            String s = SC.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                println("Loi: vui long nhap so nguyen -> nhap lai!");
            }
        }
    }

    public static int inputIntInRange(String label, int min, int max) {
        while (true) {
            int v = inputInt(label);
            if (v < min || v > max) {
                println("Loi: gia tri phai trong [" + min + "," + max + "] -> nhap lai!");
                continue;
            }
            return v;
        }
    }

    // ====== Khong rong ======
    public static String inputNonBlank(String label) {
        while (true) {
            String v = inputRaw(label);
            if (v.isBlank()) {
                println("Loi: gia tri khong duoc rong -> nhap lai!");
                continue;
            }
            return v;
        }
    }

    // ====== Phone (bat dau 0, 9-12 so) ======
    public static String inputPhoneStrict() {
        while (true) {
            String v = inputRaw("Nhap phone (bat dau 0, 9-12 so): ");
            if (!PHONE.matcher(v).matches()) {
                println("Loi: phone phai bat dau bang 0 va co do dai 9-12 so -> nhap lai!");
                continue;
            }
            return v;
        }
    }

    // ====== Email hop le ======
    public static String inputEmailStrict() {
        while (true) {
            String v = inputRaw("Nhap email: ");
            if (!EMAIL.matcher(v).matches()) {
                println("Loi: email khong hop le -> nhap lai!");
                continue;
            }
            return v;
        }
    }

    // ====== Password 6-12, co chu hoa ======
    public static String inputPasswordStrict() {
        while (true) {
            String v = inputRaw("Nhap password (6-12, co chu hoa): ");
            if (!PWD.matcher(v).matches()) {
                println("Loi: password 6-12 ky tu va co it nhat 1 chu hoa -> nhap lai!");
                continue;
            }
            return v;
        }
    }

    // ====== GraduationRank ======
    public static GraduationRank inputGraduationRank() {
        while (true) {
            String v = inputRaw("Nhap graduation_rank (EXCELLENCE/GOOD/FAIR/POOR): ")
                    .toUpperCase(Locale.ROOT);
            try {
                return GraduationRank.valueOf(v);
            } catch (IllegalArgumentException e) {
                println("Loi: gia tri khong hop le -> nhap lai!");
            }
        }
    }

    // ====== Menu ======
    public static int menuMain() {
        println("");
        println("=== MENU ===");
        println("1. Dang ky Experience");
        println("2. Dang ky Fresher");
        println("3. Dang nhap");
        println("0. Thoat");
        return inputInt("Chon: ");
    }
}
