package ra.run;

import ra.bussinessImp.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> productList = new ArrayList<>();
        boolean isExit = false;
        while (!isExit){
            System.out.println("****************JAVA-HACKATHON-05-BASIC-MENU***************\n" +
                    "1. Nhập số sản phẩm và nhập thông tin sản phẩm \n" +
                    "2. Hiển thị thông tin các sản phẩm \n" +
                    "3. Sắp xếp sản phẩm theo lợi nhuận tăng dần \n" +
                    "4. Xóa sản phẩm theo mã sản phẩm \n" +
                    "5. Tìm kiếm sản phẩm theo tên sản phẩm \n" +
                    "6. Thay đổi trạng thái của sản phẩm theo mã sản phẩm \n" +
                    "7. Thoát\n" +
                    "Mời nhập lựa chọn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    ProductManger.creatProduct(scanner,productList);
                    break;
                case 2:
                    ProductManger.displayAll(productList);
                    break;
                case 3:
                    ProductManger.sortProduct(productList);
                    break;
                case 4:
                    ProductManger.deleteProduct(scanner,productList);
                    break;
                case 5:
                    ProductManger.searchProduct(scanner,productList);
                    break;
                case 6:
                    ProductManger.changeStatus(scanner,productList);
                    break;
                case 7:
                    isExit=true;
                    break;
                default:
                    System.out.println("Mời nhập lại");
                    break;
            }
        }
    }

}

