import java.util.Scanner;

public class GajiKaryawan {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // ── INPUT ──────────────────────────────────────────
        System.out.println("=========================================");
        System.out.println("   SISTEM PENGGAJIAN KARYAWAN            ");
        System.out.println("=========================================");
        System.out.print("Masukkan Golongan Karyawan (A / B / C) : ");
        String golongan = input.next().toUpperCase();

        System.out.print("Masukkan Jam Lembur                    : ");
        int jamLembur = input.nextInt();

        // ── PROSES: Tentukan Gaji Pokok ───────────────────
        double gajiPokok = 0;

        if (golongan.equals("A")) {
            gajiPokok = 5_000_000;
        } else if (golongan.equals("B")) {
            gajiPokok = 6_500_000;
        } else if (golongan.equals("C")) {
            gajiPokok = 9_500_000;
        } else {
            System.out.println("\n[ERROR] Golongan tidak valid! Masukkan A, B, atau C.");
            input.close();
            return;
        }

        // ── PROSES: Tentukan Persentase Lembur ────────────
        double persenLembur = 0;

        if (jamLembur < 0) {
            System.out.println("\n[ERROR] Jam lembur tidak boleh negatif!");
            input.close();
            return;
        } else if (jamLembur == 0) {
            persenLembur = 0;
        } else if (jamLembur == 1) {
            persenLembur = 0.30;
        } else if (jamLembur == 2) {
            persenLembur = 0.32;
        } else if (jamLembur == 3) {
            persenLembur = 0.34;
        } else if (jamLembur == 4) {
            persenLembur = 0.36;
        } else if (jamLembur >= 5) {
            persenLembur = 0.38;
        }

        // ── PROSES: Hitung Gaji Lembur & Total ────────────
        double gajiLembur      = gajiPokok * persenLembur;
        double totalPenghasilan = gajiPokok + gajiLembur;

        // ── OUTPUT ────────────────────────────────────────
        System.out.println("\n=========================================");
        System.out.println("         RINCIAN PENGHASILAN             ");
        System.out.println("=========================================");
        System.out.printf("  Golongan Karyawan   : %s%n", golongan);
        System.out.printf("  Jam Lembur          : %d Jam%n", jamLembur);
        System.out.println("-----------------------------------------");
        System.out.printf("  Gaji Pokok          : Rp %,.0f%n", gajiPokok);
        System.out.printf("  Persentase Lembur   : %.0f%%%n", persenLembur * 100);
        System.out.printf("  Gaji Lembur         : Rp %,.0f%n", gajiLembur);
        System.out.println("-----------------------------------------");
        System.out.printf("  TOTAL PENGHASILAN   : Rp %,.0f%n", totalPenghasilan);
        System.out.println("=========================================");

        input.close();
    }
}
