package manager;

import io.IOsinhvien;
import model.Sinhvien;

import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    Scanner scanner = new Scanner(System.in);
    private ArrayList<Sinhvien> sinhviens = new ArrayList<>();
    public final String REGEX_STRING = "[ny]";


    public Sinhvien taoSinhvien() {

        String masv;
        do {
            System.out.println("Nhập mã sinh viên: ");
            String masv1 = scanner.nextLine();
            try {
                int index = checkmasinhvien(masv1);
                if (index == -1) {
                    masv = masv1;
                    break;
                } else {
                    System.out.println("Mã sinh viên đã tồn tại");
                }
            } catch (Exception e) {
                System.out.println("Nhập lại mã sinh viên");
            }
        } while (true);
        System.out.println("Nhập tên sinh viên: ");
        String hoten = scanner.nextLine();

        System.out.println("Nhập tuổi sinh viên: ");
        int tuoi = checkLoiNhap();

        System.out.println("Nhập giới tính sinh viên: ");
        String gioitinh = scanner.nextLine();

        System.out.println("Nhập địa chỉ sinh viên: ");
        String diachi = scanner.nextLine();

        System.out.println("Nhập điểm trung bình sinh viên sinh viên: ");
        double diem;

        while (true) {
            try {
                diem = Double.parseDouble(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.err.println("Sai định dạng! Vui lòng chọn lại");
            }
        }

        Sinhvien product = new Sinhvien(masv, hoten, tuoi, gioitinh, diachi, diem);
        System.out.println(product);
        return product;
    }


    public void hienthi5sv() {


        int dem = 0;
        for (int i = 0; i < sinhviens.size(); i++) {
            if (dem % 5 == 0 && dem != 0) {
                System.out.println("Nhấn Enter để tiếp tục");
                scanner.nextLine();
            }
            System.out.println(sinhviens.get(i));
            dem++;
        }
    }
    public void hienthi() {
        for (Sinhvien sv:
             sinhviens) {
            System.out.println(sv.toString());
        }
    }


    public void them() {
        Sinhvien sinhvien = taoSinhvien();
        sinhviens.add(sinhvien);
    }


    public void capnhat() {
        System.out.println("Nhập mã sinh viên bạn muốn sửa: ");
        String code = scanner.nextLine();
        for (int i = 0; i < sinhviens.size(); i++) {
            if (sinhviens.get(i).getMaSV().equals(code)) {
                sinhviens.set(i, taoSinhvien());
            }
        }
    }


    public void xoa() {
        System.out.println("Nhập mã sinh viên bạn muốn xóa:  ");
        String code = scanner.nextLine();
        System.out.println("Bạn có chắc sẽ xóa sinh viên (yes:y hoặc no:n): ");
        String choice = validateString(REGEX_STRING);
        if (choice.equals("y")) {
            for (int i = 0; i < sinhviens.size(); i++) {
                if (sinhviens.get(i).getMaSV().equalsIgnoreCase(code)) {
                    sinhviens.remove(i);
                    System.out.println("Xóa thành công");
                    break;
                }
            }
        } else {
            System.out.println("Hủy bỏ xóa!");
        }

    }


    public void sapxep() {
        int choose = 3;
        System.out.println("1. Sắp xếp điểm trung bình tăng dần.");
        System.out.println("2. Sắp xếp điểm trung bình giảm dần.");
        System.out.println("3. Thoát.");
        System.out.println("Nhập số để lựa chọn: ");
        do {
            if (choose > 3) System.out.println("Vui lòng nhập lại");
            choose = Integer.parseInt(scanner.nextLine());
        } while (choose > 3);

        switch (choose) {
            case 1 -> sapxeptang();
            case 2 -> sapxepgiam();
            case 3 -> System.out.println("xin chào");
        }
    }


    public void sapxeptang() {
        Sinhvien temp;
        for (int i = 0; i < sinhviens.size() - 1; i++) {
            for (int j = i + 1; j < sinhviens.size(); j++) {
                if (sinhviens.get(i).getDiem() > sinhviens.get(j).getDiem()) {
                    temp = sinhviens.get(i);
                    sinhviens.set(i, sinhviens.get(j));
                    sinhviens.set(j, temp);
                }
            }
        }
        hienthi();

    }


    public void sapxepgiam() {

        Sinhvien temp;
        for (int i = 0; i < sinhviens.size() - 1; i++) {
            for (int j = i + 1; j < sinhviens.size(); j++) {
                if (sinhviens.get(i).getDiem() < sinhviens.get(j).getDiem()) {
                    temp = sinhviens.get(i);
                    sinhviens.set(i, sinhviens.get(j));
                    sinhviens.set(j, temp);
                }
            }
        }

        hienthi();

    }


    public void doctufile() {
        System.out.println("Đọc từ File sẽ mất dữ liệu hiện tại, bạn có muốn tiếp tục? (yes:y hoặc no:n): ");
        String choice = validateString(REGEX_STRING);
        if (choice.equals("y")) {
            sinhviens = IOsinhvien.read();
            System.out.println("Đã đọc xong, chọn chức năng xem danh sách để kiểm tra.");
        }
    }


    public void ghivaofile() {
        System.out.println("Ghi vào File sẽ mất dữ liệu đang lưu, bạn có muốn tiếp tục? (yes:y hoặc no:n): ");
        String choice = validateString(REGEX_STRING);
        if (choice.equals("y")) {
            IOsinhvien.write(sinhviens);
            System.out.println("Ghi file thành công, Chọn chức năng đọc file để kiểm tra.");
        }
    }


    public int checkLoiNhap() {
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.err.println("Sai định dạng! Vui lòng chọn lại");
            }
        }
        return choice;
    }

    public String validateString(String regex) {
        while (true) {
            String name = scanner.nextLine();
            if (name.matches(regex)) {
                return name;
            }
            System.err.println("Sai định dạng, vui lòng nhập lại.");
        }
    }

    public int checkmasinhvien(String masv) {
        for (int i = 0; i < sinhviens.size(); i++) {
            if (masv.equals(sinhviens.get(i).getMaSV())) {
                return i;
            }
        }
        return -1;
    }

}
