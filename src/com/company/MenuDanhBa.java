package com.company;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuDanhBa {
    Scanner scanner = new Scanner(System.in);
    DanhBaManager contactManager = new DanhBaManager();

    public MenuDanhBa() {
    }

    public void menuOfSystem() {
        try {
            do {
                menuContact();
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        contactManager.displayAll();
                        break;
                    case 2:
                        contactManager.addContact();
                        break;
                    case 3:
                        System.out.println("▹ Nhập số điện thoại cần sửa VD: (+84)-095638425:");
                        String phoneEdit = scanner.nextLine();
                        if (phoneEdit.equals("")) {
                            menuOfSystem();
                        } else {
                            contactManager.updateContact(phoneEdit);
                        }
                        break;
                    case 4:
                        System.out.println("▹ Nhập số điện thoại cần xóa VD: (+84)-829673833:");
                        String phoneDelete = scanner.nextLine();
                        if (phoneDelete.equals("")) {
                            menuOfSystem();
                        } else {
                            contactManager.deleteContact(phoneDelete);
                        }
                        break;
                    case 5:
                        System.out.println("▹ Nhập từ khóa:");
                        String keyword = scanner.nextLine();
                        contactManager.searchContactByNameOrPhone(keyword);
                        break;
                    case 6:
                        ArrayList<Danhba> contactArrayList = contactManager.readFile(DanhBaManager.PATH_NAME_CONTACT);
                        contactArrayList.forEach(Danhba::display);
                        System.out.println("Read file successfully !");
                        System.out.println("--------------------");
                        break;
                    case 7:
                        contactManager.writeFile(contactManager.getContactList(), DanhBaManager.PATH_NAME_CONTACT);
                        break;
                    case 8:
                        System.exit(0);
                    default:
                        System.out.println("Lựa chọn không tồn tại, mời bạn nhập lại !!!");
                        System.out.println("--------------------");
                        break;
                }
            } while (true);
        } catch (NumberFormatException | DateTimeParseException e) {
            System.out.println("Bạn nhập sai kiểu dữ liệu, mời nhập lại !!!");
            System.out.println("--------------------");
            menuOfSystem();
        }
    }

    private void menuContact() {
        System.out.println("----CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ----");
        System.out.println("Chọn chức năng theo số (để tiếp tục):");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Tìm kiếm");
        System.out.println("6. Đọc từ file");
        System.out.println("7. Ghi vào file");
        System.out.println("8. Thoát");
        System.out.println("Chọn chức năng:");
    }
}
