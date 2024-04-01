package entities.mapping_entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="SanPhamChiTiet")
public class SanPhamChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "IdMauSac", nullable = false)
    private Integer idMauSac;

    @Column(name = "IdKichThuoc", nullable = false)
    private Integer idKichThuoc;

    @Column(name = "IdSanPham", nullable = false)
    private Integer idSanPham;

    @Column(name = "MaSPCT", nullable = false, length = 255)
    private String maSpct;

    @Column(name = "SoLuong", nullable = false)
    private Integer soLuong;

    @Column(name = "DonGia", nullable = false, precision = 0)
    private Double donGia;

    @Column(name = "TrangThai", nullable = false)
    private Integer trangThai;

}
