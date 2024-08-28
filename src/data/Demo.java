package data;

import java.util.*;

/**
 *
 * @author quang
 */
public class Demo {

    List<LaoDong> arr = new ArrayList();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Demo demo = new Demo();
        demo.fakeData();
        int choice;
        do {
            inMenu();
            System.out.print("Moi nhap lua chon: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    demo.sapXepTangDanTheoLuong();
                    break;
                case 2:
                    demo.timLaoDongLuongCaoNhat();
                    break;
                case 3:
                    demo.nhapThemDoiTuong();
                    break;
                case 4:
                    demo.xoaLaoDong();
                    break;
                case 5:
                    demo.suaLaoDong();
                    break;
                case 6:
                    demo.inDanhSachTenChuHoa();
                    break;
                case 7:
                    System.out.println("Chao tam biet!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
                    break;
            }
        } while (choice != 7);
    }

    public static void inMenu() {
        System.out.println("MENU:");
        System.out.println("1. Sap xep tang dan theo luong");
        System.out.println("2. Tim doi tuong luong cao nhat");
        System.out.println("3. Nhap vao them doi tuong va in ra");
        System.out.println("4. Xoa doi tuong");
        System.out.println("5. Sua doi tuong");
        System.out.println("6. In danh sach ho ten chu hoa");
        System.out.println("7. Thoat");
    }

    private void inDanhSach() {
        LaoDong.inTieuDe();
        for (LaoDong x : arr) {
            x.inDuLieu();
        }
    }

    public void fakeData() {
        LaoDong ld1 = new NhanVienThoiVu("HAUI001", "AN", "HA NOI", LoaiNhanVien.NVThoiVu, 15, 200000);
        LaoDong ld2 = new NhanVienChinhThuc("HAUI002", "BINH", "THAI BINH", LoaiNhanVien.NVChinhThuc, 10, 1.5);
        LaoDong ld3 = new NhanVienThoiVu("HAUI003", "cuong", "HAI PHONG", LoaiNhanVien.NVThoiVu, 25, 200000);
        LaoDong ld4 = new NhanVienThoiVu("HAUI004", "DUNG", "HA NAM", LoaiNhanVien.NVThoiVu, 25, 200000);
        LaoDong ld5 = new NhanVienChinhThuc("HAUI005", "HAI", "THAI NGUYEN", LoaiNhanVien.NVChinhThuc, 8, 2.5);
        arr.add(ld1);
        arr.add(ld2);
        arr.add(ld3);
        arr.add(ld4);
        arr.add(ld5);
    }

    public void sapXepTangDanTheoLuong() {
        SapXepTangDanTheoLuong sx = new SapXepTangDanTheoLuong();
        Collections.sort(arr, sx);
        inDanhSach();
    }

    public void timLaoDongLuongCaoNhat() {
        System.out.println("Cac lao dong co luong cao nhat: ");
        LaoDong ldmax = Collections.max(arr, Comparator.comparing(LaoDong::tinhLuong));
        for (LaoDong x : arr) {
            if (x.tinhLuong() == ldmax.tinhLuong()) {
                if (x instanceof NhanVienThoiVu) {
                    x.inDuLieu();
                } else {
                    x.inDuLieu();
                }
            }
        }
    }

    public void nhapThemDoiTuong() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap loai lao dong muon them(1. Nhan Vien Thoi Vu, 2. Nhan Vien Chinh Thuc): ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                LaoDong ld1 = new NhanVienThoiVu();
                ((NhanVienThoiVu) ld1).nhap();
                arr.add(ld1);
                break;
            case 2:
                LaoDong ld2 = new NhanVienChinhThuc();
                ((NhanVienChinhThuc) ld2).nhap();
                arr.add(ld2);
                break;
            default:
                System.out.println("Lua chon khong hop le");
                break;
        }
        System.out.println("Danh sach sau khi nhap: ");
        inDanhSach();
    }

    private LaoDong timKiemLaoDongTheoTen(String name) {
        for (LaoDong x : arr) {
            if (x.getHoTen().equalsIgnoreCase(name)) {
                return x;
            }
        }
        return null;
    }

    public void xoaLaoDong() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ten lao dong muon xoa: ");
        String name = sc.nextLine();
        if (timKiemLaoDongTheoTen(name) != null) {
            arr.remove(timKiemLaoDongTheoTen(name));
            System.out.println("Danh sach sau khi xoa: ");
            inDanhSach();
        } else {
            System.out.println("Doi tuong khong ton tai");
        }
    }

    public void suaLaoDong() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ten lao dong muon sua: ");
        String name = sc.nextLine();
        if (timKiemLaoDongTheoTen(name) != null) {
            System.out.println("Thong tin lao dong truoc khi sua: ");
            timKiemLaoDongTheoTen(name).inDuLieu();
            if (timKiemLaoDongTheoTen(name) instanceof NhanVienChinhThuc) {
                ((NhanVienChinhThuc) timKiemLaoDongTheoTen(name)).nhap();
            } else {
                ((NhanVienThoiVu) timKiemLaoDongTheoTen(name)).nhap();
            }
            System.out.println("Danh sach sau khi sua: ");
            inDanhSach();
        } else {
            System.out.println("Doi tuong khong ton tai");
        }
    }
    
    public void inDanhSachTenChuHoa(){
        for (LaoDong x : arr) {
            x.setHoTenChuHoa(x.getHoTen());
            x.inDuLieu();          
        }
    }
}
