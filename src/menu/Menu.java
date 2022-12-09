package menu;

import manager.Manager;

public class Menu {
    Manager manager = new Manager();

    public void menu() {
        int choice;
        do {
            String menu = """
                    ______________________________________________
                    ---- CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN ----
                    Chọn chức năng theo số (để tiếp tục)
                    1. Xem danh sách sinh viên
                    2. Thêm mới
                    3. Cập nhật
                    4. Xóa
                    5. Sắp xếp
                    6. Đọc từ file
                    7. Ghi vào file
                    8. Thoát     
                    Chọn chức năng:
                    """;
            System.out.println(menu);

            choice = manager.checkLoiNhap();

            switch (choice) {
                case 1 -> manager.hienthi5sv();
                case 2 -> manager.them();
                case 3 -> manager.capnhat();
                case 4 -> manager.xoa();
                case 5 -> manager.sapxep();
                case 6 -> manager.doctufile();
                case 7 -> manager.ghivaofile();
                case 8 -> System.exit(0);
                default -> System.out.println("Chọn lại!");
            }
        } while (true);
    }
}
