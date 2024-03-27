package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class SanPhamChiTiet {
    private Integer id;
    private String maSPCT;
    private Integer idMauSac;
    private Integer idKichThuoc;
    private Integer idSanPham;
    private Integer soLuong;
    private Double donGia;
    private int trangThai;
}
