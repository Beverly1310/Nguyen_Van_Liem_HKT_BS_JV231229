package ra.run;

import ra.bussinessImp.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProductManagement {
    public static final String NOTFOUND_ALERT = "Sản phẩm cần không tồn tại";
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
                    ProductManagement.creatProduct(scanner,productList);
                    break;
                case 2:
                    ProductManagement.displayAll(productList);
                    break;
                case 3:
                    ProductManagement.sortProduct(productList);
                    break;
                case 4:
                    ProductManagement.deleteProduct(scanner,productList);
                    break;
                case 5:
                    ProductManagement.searchProduct(scanner,productList);
                    break;
                case 6:
                    ProductManagement.changeStatus(scanner,productList);
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

    /////////////////////////////////////////////////////////CHỨC NĂNG///////////////////////////////////
    //Thêm sản phẩm
    public static void creatProduct(Scanner scanner, List<Product> productList ){
        System.out.println("Nhập số lượng sản phẩm cần thêm");
        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            Product newProduct = new Product();
            System.out.println("Nhập thông tin cho sản phẩm thứ"+(i+1));
            newProduct.inputData(scanner);
            productList.add(newProduct);
            System.out.println("---------------");
        }
    }
    //Hiển thị toàn bộ sản phẩm
    public static void displayAll(List<Product> productList){
        productList.forEach(Product::displayData);
    }
    // sắp xếp sản phẩm theo lợi nhuận tăng dần
    public static void sortProduct(List<Product> productList){
        Collections.sort(productList);
        displayAll(productList);
    }
    //xóa sản phẩm theo mã
    public static void deleteProduct(Scanner scanner,List<Product> productList){
        System.out.println("Nhập mã sản phẩm cần xóa:");
        int inputId = Integer.parseInt(scanner.nextLine());
        boolean isRemoved = productList.removeIf(product -> product.getProductId()==inputId);
        if (isRemoved){
            System.out.println("Xóa thành công");
        } else {
            System.err.println(NOTFOUND_ALERT);
        }
    }
    // tìm sản phẩm theo tên
    public static void searchProduct(Scanner scanner, List<Product> productList){
        System.out.println("Nhập tên sản phẩm cần tìm");
        String inputName = scanner.nextLine();
        if (productList.stream().anyMatch(product -> product.getProductName().equals(inputName))){
            productList.stream().filter(product -> product.getProductName().equals(inputName)).forEach(Product::displayData);
        } else {
            System.err.println(NOTFOUND_ALERT);;
        }
    }
    // thay đổi trạng thái toggle
    public  static void changeStatus(Scanner scanner, List<Product> productList){
        System.out.println("Nhập mã sản phẩm cần thay đổi trạng thái");
        int inputId = Integer.parseInt(scanner.nextLine());
        if (productList.stream().anyMatch(product -> product.getProductId()==inputId)){
            productList.stream().filter(product -> product.getProductId()==inputId).forEach(product -> product.setProductStatus(!product.isProductStatus()));
            System.out.println("Thay đổi thành công");
        } else {
            System.err.println(NOTFOUND_ALERT);;
        }
    }
}

