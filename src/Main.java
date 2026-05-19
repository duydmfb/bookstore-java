import model.*;
import service.GioHangService;
import service.SachService;

import static model.TrangThaiDonHang.DA_GIAO;

public class Main {
    public static void main(String[] args) {
        System.out.println("========== BẮT ĐẦU CHẠY THỬ FLOW HỆ THỐNG BOOKSTORE ==========\n");


        // 1. Tạo 3 cuốn sách test

        Sach sach1 = new Sach("Đắc Nhân Tâm", "Dale Carnegie",90000 , 0, 20,"MD03");

        Sach sach2 = new Sach("Nhà Giả Kim","Paulo Coelho" , 85000, 0, 10,"MD04");

        Sach sach3 = new Sach("Mắt Biếc","Nguyễn Nhật Ánh" , 35000, 10, 1, "MD02");

        SachService sachService = new SachService();
        sachService.themSach(sach1);
        sachService.themSach(sach2);
        sachService.themSach(sach3);
        // 2. Tạo 1 khách hàng có role CUSTOMER
        KhachHang khachHang = new KhachHang(
                01,
                "Nguyễn Văn A",
                "vana@gmail.com",
                "password123",
                "0987654321",
                Role.CUSTOMER
        );
        System.out.println("[INFO] Đã tạo khách hàng: " + khachHang.getHoTen() + " (Role: " + khachHang.getRole() + ")");



        // 3. Tạo giỏ hàng và thêm 2 cuốn sách vào (sach1 và sach2)
        GioHang gioHang = new GioHang(khachHang);
        gioHang.themSach(sach1);
        gioHang.themSach(sach2);
        System.out.println("[INFO] Đã thêm '" + sach1.getTenSach() + "' và '" + sach2.getTenSach() + "' vào giỏ hàng.");

        GioHangService gioHangService = new GioHangService(gioHang);
        // test sách còn hàng
        // test sách hết hàng — sach1 và sach2 có phanTramGiam = 0 nên tonKho > 0
        // sach3 có tonKho = 1 — thử thêm vào xem

        gioHangService.themSachVaoGio(sach3); // còn 1 quyển → thêm được
        gioHangService.themSachVaoGio(new Sach("Sách Hết", "Tác Giả X", 50000, 0, 0, "MD01")); // hết hàng → in thông báo

        // 4. In ra tổng tiền giỏ hàng
        double tongTienGioHang = gioHang.tinhTongTien();
        System.out.println("\n=== 1. THÔNG TIN GIỎ HÀNG ===");
        System.out.println("-> Chủ giỏ hàng: " + gioHang.getKhachHang().getHoTen());
        System.out.println("-> Số lượng sách: " + gioHang.getDanhSachSach().size() + " cuốn");
        System.out.println("-> Tổng tiền sách (đã áp dụng giảm giá): " + tongTienGioHang + " VNĐ");

        // 5. Tạo đơn hàng từ giỏ hàng (Mã đơn: 1001)
        DonHang donHang = gioHangService.datHang("1001");
        System.out.println("\n[INFO] Khách hàng bấm nút Đặt Hàng... Hệ thống đang tạo đơn hàng...");

        // 6. In ra thông tin đơn hàng (Mong đợi: Tổng tiền = 152k + 30k ship = 182k)
        System.out.println("\n=== 2. THÔNG TIN ĐƠN HÀNG VỪA TẠO ===");
        System.out.println("-> Mã đơn hàng: #" + donHang.getMaDonHang());
        System.out.println("-> Người nhận: " + donHang.getKhachHang().getHoTen());
        System.out.println("-> Trạng thái đơn hàng: " + donHang.getTrangThai());
        System.out.println("-> Tổng tiền thanh toán (Gồm 30k ship toàn quốc): " + donHang.getTongTienThanhToan() + " VNĐ");

        // 7. Admin cập nhật trạng thái đơn sang DANG_GIAO và in ra kiểm tra
        System.out.println("\n[INFO] Admin duyệt đơn và chuyển cho bên vận chuyển...");
        donHang.capNhatTrangThai(DA_GIAO);

        System.out.println(sachService.timTheoTen("kim"));
        System.out.println(sachService.timTheoTacGia("Coelho"));

        System.out.println("\n=== 3. CẬP NHẬT TRẠNG THÁI ĐƠN HÀNG ===");
        System.out.println("-> Trạng thái mới của đơn #" + donHang.getMaDonHang() + ": " + donHang.getTrangThai());

        System.out.println("\n========== CHẠY FLOW THÀNH CÔNG KHÔNG CÓ LỖI ==========");

        System.out.println("Tồn kho Mắt Biếc sau khi đặt: " + sach3.getSoLuongTonKho());

        // Test 1 — tên sách rỗng
        try {
            Sach sachLoi = new Sach("", "tac gia", 50000, 0, 10, "MD99");
        } catch (IllegalArgumentException e) {
            System.out.println("Test 1 - Lỗi: " + e.getMessage());
        }

// Test 2 — giá âm
        try {
            Sach sachLoi = new Sach("Tên sách", "tac gia", -1000, 0, 10, "MD98");
        } catch (IllegalArgumentException e) {
            System.out.println("Test 2 - Lỗi: " + e.getMessage());
        }

// Test 3 — truyền null vào giỏ hàng
        try {
            gioHangService.themSachVaoGio(null);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Sách không được null");
        }
    }
}