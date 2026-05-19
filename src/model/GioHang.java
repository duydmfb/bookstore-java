package model;

import java.util.ArrayList;
import java.util.List;

public class GioHang {
    private KhachHang khachHang;
    private List<Sach> danhSachSach;

    public GioHang(KhachHang khachHang){
        this.danhSachSach = new ArrayList<>();
        this.khachHang = khachHang;
    }

    public List<Sach> getDanhSachSach() {
        return danhSachSach;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void themSach (Sach sach){
        if (sach != null) {
            this.danhSachSach.add(sach);
        }
    }

    public void xoaSach(Sach sach){
        this.danhSachSach.remove(sach);
    }

    public double tinhTongTien(){
        double tongTien = 0;
        for (Sach sach : danhSachSach){
            tongTien += sach.tinhGiaSauGiam(sach.getGiaGoc());
        }
        return tongTien;
    }
}
