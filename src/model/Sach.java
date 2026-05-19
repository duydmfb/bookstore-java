package model;

import interfaces.CoGiamGia;
import interfaces.CoTimKiem;

import java.util.List;

public class Sach implements CoGiamGia {
    private String tenSach;
    private String tacGia;
    private double giaGoc;
    private double phanTramGiam;
    private int soLuongTonKho;
    private String maSach;

    public Sach (String tenSach, String tacGia, double giaGoc, double phanTramGiam,int soLuongTonKho, String maSach) {
        if (tenSach == null || tenSach.isEmpty()){
            throw new IllegalArgumentException("Tên sách không được để trống");
        }
        if (giaGoc < 0){
            throw new IllegalArgumentException("Giá sách không được âm");
        }
        this.tenSach= tenSach;
        this.tacGia=tacGia;
        this.giaGoc=giaGoc;
        this.phanTramGiam= phanTramGiam;
        this.soLuongTonKho=soLuongTonKho;
        this.maSach=maSach;
    }



    public double getGiaGoc() {
        return giaGoc;
    }

    public String getTenSach() {
        return tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public double getPhanTramGiam() {
        return phanTramGiam;
    }

    public int getSoLuongTonKho() {
        return soLuongTonKho;
    }

    public String getMaSach() {
        return maSach;
    }

    @Override
    public double tinhGiaSauGiam(double giaGoc){
        return giaGoc*(1 - phanTramGiam/100);
    }



    @Override
    public String toString() {
        return "Sach{ten='" + tenSach + "', tacGia='" + tacGia +
                "', gia=" + giaGoc + ", giamGia=" + phanTramGiam + "%, tonKho=" + soLuongTonKho + "}";
    }

    public void giamTonKho(int soLuong) {
        if (soLuong > soLuongTonKho){
            throw new IllegalArgumentException("Số lượng mua vượt quá tồn kho");
        } else {
             soLuongTonKho  -= soLuong;
        }
    }
}
