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
        String[]
            s1 = params.get("idSanPham"),
            s2 = params.get("keyword"),
            s3 = params.get("trangThai"),
            s4 = params.get("limit"),
            s5 = params.get("page");

        Integer idSP = null;
        if (s1 == null || s1[0].trim().length() == 0) {
            throw new Exception("Sản phẩm không hợp lệ!");
        }

        try {
            idSP = Integer.parseInt(s1[0].trim());
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Sản phẩm không hợp lệ!");
        }

        String keyword = s2 == null ? null : s2[0];
        String tts = s3 == null ? null : s3[0];
        String limitStr = s4 == null ? null : s4[0];
        String pageStr = s5 == null ? null : s5[0];

        Integer trangThai = tts == null || tts.trim().length() == 0 ? null : Integer.parseInt(tts);
        Integer limit = limitStr == null || limitStr.trim().length() == 0 ? 10 : Integer.parseInt(limitStr);
        Integer page = pageStr == null || pageStr.trim().length() == 0 ? 1 : Integer.parseInt(pageStr);
        return new IndexRequest(idSP, keyword, trangThai, page, limit);
    }
}
