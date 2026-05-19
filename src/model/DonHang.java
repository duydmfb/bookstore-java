package model;

import java.time.LocalDate;
import java.util.List;



public class DonHang {
    private String maDonHang;
    private KhachHang khachHang;
    private List<Sach> danhSachSach;
    private double tongTien;
    private LocalDate ngayDat;
    private TrangThaiDonHang trangThai;
    private double phiShip;


    public DonHang(String maDonHang, GioHang gioHang){
        this.maDonHang = maDonHang;
        this.khachHang = gioHang.getKhachHang();
        this.danhSachSach = gioHang.getDanhSachSach();
        this.tongTien = gioHang.tinhTongTien();
        this.ngayDat = LocalDate.now();
        this.trangThai = TrangThaiDonHang.CHO_XAC_NHAN;
        this.phiShip = PHI_SHIP;
    }

    public String getMaDonHang() {
        return maDonHang;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public List<Sach> getDanhSachSach() {
        return danhSachSach;
    }

    public double getTongTien() {
        return tongTien;
    }

    public LocalDate getNgayDat() {
        return ngayDat;
    }

    public TrangThaiDonHang getTrangThai() {
        return trangThai;
    }

    public double getPhiShip() {
        return phiShip;
    }

    public double getTongTienThanhToan() {
        return tongTien+phiShip;
    }

    private static final double PHI_SHIP = 30000;

    public void capNhatTrangThai(TrangThaiDonHang trangThai){
        this.trangThai = trangThai;
    }


}
