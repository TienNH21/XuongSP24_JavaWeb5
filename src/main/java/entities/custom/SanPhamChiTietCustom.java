package entities.custom;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class SanPhamChiTietCustom {
    private Integer id;
    private String maSPCT;
    private String tenMauSac;
    private String tenKichThuoc;
    private int soLuong;
    private double donGia;
    private int trangThai;
}
