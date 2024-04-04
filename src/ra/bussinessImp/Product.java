package ra.bussinessImp;

import ra.bussiness.IProduct;

import java.util.Scanner;

public class Product implements IProduct,Comparable<Product> {
    private int productId;
    private String productName;
    private String title;
    private String descriptions;
    private float importPrice;
    private float exportPrice;
    private float interest;
    private boolean productStatus;

    public Product() {
    }

    public Product(int productId, String productName, String title, String descriptions, float importPrice, float exportPrice, float interest, boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.title = title;
        this.descriptions = descriptions;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.productStatus = productStatus;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }
// nhập thông tin
    @Override
    public void inputData(Scanner scanner) {
        this.productId = inputProductId(scanner);
        this.productName = inputProductName(scanner);
        this.title = inputProductTitle(scanner);
        this.descriptions = inputProductDescription(scanner);
        this.importPrice = inputProductImportPrice(scanner);
        this.exportPrice = inputProductExportPrice(scanner);
        this.interest = this.exportPrice - this.importPrice;
        this.productStatus = inputProductStatus(scanner);
    }
//lấy Id sản phẩm
    public int inputProductId(Scanner scanner) {
        System.out.println("Nhập mã ID cho sản phẩm: ");
        int inputId = Integer.parseInt(scanner.nextLine());
        return inputId;
    }
// lấy tên sản phẩm
    public String inputProductName(Scanner scanner) {
        System.out.println("Nhập tên cho sản phẩm: ");
        String inputName = scanner.nextLine();
        return inputName;
    }
// lấy tiêu đề sản phẩm
    public String inputProductTitle(Scanner scanner) {
        System.out.println("Nhập tiêu đề cho sản phẩm: ");
        String inputTitle = scanner.nextLine();
        return inputTitle;
    }
//lấy  mô tả sản phẩm
    public String inputProductDescription(Scanner scanner) {
        System.out.println("Nhập mô tả cho sản phẩm: ");
        String inputDescription = scanner.nextLine();
        return inputDescription;
    }
// lấy giá nhập
    public float inputProductImportPrice(Scanner scanner) {
        System.out.println("Giá nhập của sản phẩm: ");
        float inputImportPrice = Float.parseFloat(scanner.nextLine());
        return inputImportPrice;
    }
// lấy giá xuất
    public float inputProductExportPrice(Scanner scanner) {
        System.out.println("Giá xuất của sản phẩm: ");
        float inputExportPrice = Float.parseFloat(scanner.nextLine());
        return inputExportPrice;
    }
// lấy trạng thái
    public boolean inputProductStatus(Scanner scanner) {
        System.out.println("Trạng thái của sản phẩm: ");
        boolean inputExportPrice = Boolean.parseBoolean(scanner.nextLine());
        return inputExportPrice;
    }
// hiển thị thông tin sản phẩm
    @Override
    public void displayData() {
        System.out.printf("Mã sản phẩm: %-8s || Tên sản phẩm: %-10s\nTiêu đề: %-10s\nMô tả: %-15s\nGiá nhập: %-5s || Giá xuất: %-5s || Lợi nhuận: %-5s\nTrạng thái: %-5s\n",
                this.productId,this.productName,this.title,this.descriptions,this.importPrice,this.exportPrice,this.interest,this.productStatus ? "Còn hàng" : "Hết háng");
        System.out.println("=====================================");
        System.out.println();

    }
// ghi đè compareTo
    @Override
    public int compareTo(Product o) {
        return Float.compare(this.interest,o.getInterest());
    }
}
