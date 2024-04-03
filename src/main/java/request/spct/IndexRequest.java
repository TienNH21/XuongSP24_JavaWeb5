package request.spct;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class IndexRequest {
    private int idSanPham;
    private String keyword;
    private Integer trangThai;
    private Integer page;
    private Integer limit;

    public static IndexRequest make(Map<String, String[]> params) throws Exception
    {
        Integer idSP = null;
        String idSPStr = params.get("idSanPham")[0];
        if (idSPStr == null || idSPStr.trim().length() == 0) {
            throw new Exception("Sản phẩm không hợp lệ!");
        }

        try {
            idSP = Integer.parseInt(idSPStr);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Sản phẩm không hợp lệ!");
        }

        String keyword = params.get("keyword")[0];
        String tts = params.get("trangThai")[0];
        String limitStr = params.get("limit")[0];
        String pageStr = params.get("page")[0];

        Integer trangThai = tts == null || tts.trim().length() == 0 ? null : Integer.parseInt(tts);
        Integer limit = limitStr == null || limitStr.trim().length() == 0 ? null : Integer.parseInt(limitStr);
        Integer page = pageStr == null || pageStr.trim().length() == 0 ? null : Integer.parseInt(pageStr);
        return new IndexRequest(idSP, keyword, trangThai, page, limit);
    }
}
