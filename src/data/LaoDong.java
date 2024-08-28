package data;

import java.util.Scanner;

/**
 *
 * @author quang
 */
public abstract class LaoDong {

    protected String maNhanVien;
    protected String hoTen;
    protected String diaChi;
    protected LoaiNhanVien loaiNV;

    public abstract double tinhLuong();

    public LaoDong(String maNhanVien, String hoTen, String diaChi, LoaiNhanVien loaiNV) {
        try {
            this.maNhanVien = maNhanVien;
            setHoTen(hoTen);
            setDiaChi(diaChi);
            this.loaiNV = loaiNV;
        } catch (Exception e) {
            System.out.println("Chuong trinh co loi: " + e.toString());
        }

    }

    public LaoDong() {
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public void setHoTen(String hoTen) throws Exception {
        if (hoTen.isEmpty()) {
            throw new Exception("Ten khong duoc de trong");
        }
        this.hoTen = hoTen;
    }

    public void setDiaChi(String diaChi) throws Exception {
        if (diaChi.isEmpty()) {
            throw new Exception("Dia chi khong duoc de trong");
        }
        this.diaChi = diaChi;
    }

    public void setLoaiNV(LoaiNhanVien loaiNV) {
        this.loaiNV = loaiNV;
    }

    public LoaiNhanVien getLoaiNV() {
        return loaiNV;
    }

    public String getHoTen() {
        return hoTen.toUpperCase();
    }
    
    public void setHoTenChuHoa(String name){
        this.hoTen = name;
    }
    
    
    

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Nhap ma nhan vien: ");
                setMaNhanVien(sc.nextLine());
                System.out.print("Nhap ten nhan vien: ");
                setHoTen(sc.nextLine());
                System.out.print("Nhap dia chi nhan vien: ");
                setDiaChi(sc.nextLine());
                int choice;
                do {
                    System.out.print("Nhap loai nhan vien:(1. NV Thoi vu, 2. NV Chinh Thuc): ");
                    choice = Integer.parseInt(sc.nextLine());
                    switch (choice) {
                        case 1:
                            setLoaiNV(LoaiNhanVien.NVThoiVu);
                            break;
                        case 2:
                            setLoaiNV(LoaiNhanVien.NVChinhThuc);
                            break;
                        default:
                            System.out.println("Lua chon khong hop le");
                            break;
                    }
                } while (choice != 1 && choice != 2);
                break;
            } catch (Exception e) {
                System.out.println("Chuong trinh co loi: " + e.toString());
            }
        }

    }
    
    public static void inTieuDe() {
        System.out.printf("|%-15s|%-15s|%-15s|%-15s|%-15s|\n", "MA NHAN VIEN", "HO TEN", "DIA CHI"
                , "LOAI NV", "LUONG");
    }
    
    public void inDuLieu() {
        System.out.printf("|%-15s|%-15s|%-15s|%-15s|%-15.1f|\n", maNhanVien, hoTen, diaChi
                , loaiNV, tinhLuong());
    }

}
