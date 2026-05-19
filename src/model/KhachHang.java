package model;

public class KhachHang {
    private int id;
    private String hoTen;
    private String email;
    private String matKhau;
    private String soDienThoai;
    private Role role;

    public KhachHang(int id, String hoTen, String email, String matKhau, String  soDienThoai, Role role){
        this.id = id;
        this.hoTen = hoTen;
        this.email = email;
        this.matKhau = matKhau;
        this.soDienThoai = soDienThoai;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getEmail() {
        return email;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public Role getRole() {
        return role;
    }
}
