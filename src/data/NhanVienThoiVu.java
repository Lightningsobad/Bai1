package data;

import java.util.Scanner;

/**
 *
 * @author quang
 */
public class NhanVienThoiVu extends LaoDong {

    private int soNgayCong;
    private double donGia;

    public NhanVienThoiVu() {
    }
    
    

    public NhanVienThoiVu(String maNhanVien, String hoTen, String diaChi, LoaiNhanVien loaiNV, int soNgayCong, double donGia) {
        super(maNhanVien, hoTen, diaChi, loaiNV);
        try {
            setSoNgayCong(soNgayCong);
            this.donGia = donGia;
        } catch (Exception e) {
            System.out.println("Chuong trinh co loi: " + e.toString());
        }

    }

    public void setSoNgayCong(int soNgayCong) throws Exception {
        if (soNgayCong <= 0) {
            throw new Exception("So ngay cong phai > 0");
        }
        this.soNgayCong = soNgayCong;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double tinhThuong() {
        if (soNgayCong >= 25) {
            return 2500000;
        }
        return 0;
    }

    @Override
    public double tinhLuong() {
        return soNgayCong * donGia + tinhThuong();
    }

    @Override
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        super.nhap();
        while (true) {
            try {
                System.out.print("Nhap so ngay cong: ");
                setSoNgayCong(Integer.parseInt(sc.nextLine()));
                System.out.print("Nhap don gia: ");
                setDonGia(sc.nextDouble());
                break;
            } catch (Exception e) {
                System.out.println("CHuong trinh co loi: " + e.toString());
            }
        }
    }

}
