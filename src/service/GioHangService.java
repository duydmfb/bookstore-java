package service;

import interfaces.CoGiamGia;
import model.DonHang;
import model.GioHang;
import model.Sach;

public class GioHangService implements CoGiamGia {
    private GioHang gioHang;

    public GioHangService(GioHang gioHang){
        this.gioHang=gioHang;
    }

    public void themSachVaoGio(Sach sach){
        if (sach == null) {
            throw new IllegalArgumentException("...");
        }
        if(sach.getSoLuongTonKho() == 0) {
            System.out.println("Sách "+ sach.getTenSach() + " đã hết hàng.");
        } else {
            gioHang.themSach(sach);
        }
    }

    @Override
    public double tinhGiaSauGiam(double giaGoc) {
        return gioHang.tinhTongTien();
    }

    public DonHang datHang(String maDonHang) {
        for (Sach sach : gioHang.getDanhSachSach()){
            sach.giamTonKho(1);
        }
        DonHang donHang =new DonHang(maDonHang, gioHang);
        return donHang;
    }
}
