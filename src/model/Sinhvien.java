package model;

import java.io.Serializable;

public class Sinhvien implements Serializable {
    private String maSV;
    private String hoten;
    private int tuoi;

    private String gioitinh;

    private String diachi;

    private double diem;

    public Sinhvien(String code) {
    }

    public Sinhvien(String maSV, String hoten, int tuoi, String gioitinh, String diachi, double diem) {
        this.maSV = maSV;
        this.hoten = hoten;
        this.tuoi = tuoi;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.diem = diem;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public double getDiem() {
        return diem;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }

    @Override
    public String toString() {
        return "Sinhvien{" +
                "Mã sinh viên='" + maSV + '\'' +
                ", Họ và tên='" + hoten + '\'' +
                ", Tuổi=" + tuoi +
                ", Giới tính='" + gioitinh + '\'' +
                ", Địa chỉ='" + diachi + '\'' +
                ", Điểm trung bình=" + diem +
                '}';
    }

    public String in() {
        return maSV + ", " + hoten +
                ", " + tuoi +
                ", " + gioitinh +
                ", " + diachi + ", " + diem;
    }
}
