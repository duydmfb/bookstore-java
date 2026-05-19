package service;

import interfaces.CoTimKiem;
import model.Sach;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SachService implements CoTimKiem<Sach> {
    private Map<String, Sach> danhSachSach = new HashMap<>();


    public Map<String, Sach> getDanhSachSach() {
        return danhSachSach;
    }

    public void themSach(Sach sach){
        danhSachSach.put(sach.getMaSach(), sach);
    }

    public Map<String, Sach> layTatCa(){
        return danhSachSach;
    }

    public Sach timTheoMa(String maSach){
        return danhSachSach.get(maSach);
    }

    @Override
    public List<Sach> timTheoTen(String tenSach) {
        List<Sach> ketQua = new ArrayList<>();
        for (Sach sach : danhSachSach.values()){
            if (sach.getTenSach().toLowerCase().contains(tenSach.toLowerCase())){
                ketQua.add(sach);
            }
        }
        return ketQua;
    }

    @Override
    public List<Sach> timTheoTacGia(String tacGia) {
        List<Sach> ketQua = new ArrayList<>();
        for (Sach sach : danhSachSach.values()) {
            if (sach.getTacGia().toLowerCase().contains(tacGia.toLowerCase())) {
                ketQua.add(sach);
            }
        }
        return ketQua;
    }
}
