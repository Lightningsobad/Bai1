package data;

import java.util.Scanner;

/**
 *
 * @author quang
 */
public class NhanVienChinhThuc extends LaoDong {

    private int thamNien;
    private double heSoLuong;
    private final double LUONG_CO_BAN = 1050000;

    public NhanVienChinhThuc() {
    }
    
    

    public NhanVienChinhThuc(String maNhanVien, String hoTen, String diaChi, LoaiNhanVien loaiNV, int thamNien, double heSoLuong) {
        super(maNhanVien, hoTen, diaChi, loaiNV);
        try {
            setThamNien(thamNien);
            this.heSoLuong = heSoLuong;
        } catch (Exception e) {
            System.out.println("Chuong trinh co loi: " + e.toString());
        }

    }

    public void setThamNien(int thamNien) throws Exception {
        if (thamNien < 0) {
            setHeSoLuong(1.2);
            throw new Exception("Tham nien phai >= 0");
        }
        this.thamNien = thamNien;
    }

    public void setHeSoLuong(double heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public double tinPhuCap() {
        if (thamNien >= 3) {
            return LUONG_CO_BAN * 1.2;
        } else {
            return LUONG_CO_BAN * 1.0;
        }
    }

    @Override
    public double tinhLuong() {
        return LUONG_CO_BAN * heSoLuong + tinPhuCap();
    }

    @Override
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        super.nhap();
        try {
            System.out.print("Nhap tham nien: ");
            setThamNien(Integer.parseInt(sc.nextLine()));
            System.out.print("Nhap he so luong: ");
            setHeSoLuong(sc.nextDouble());
        } catch (Exception e) {
            System.out.println("Chuong trinh co loi: " + e.toString());
        }

    }

}
