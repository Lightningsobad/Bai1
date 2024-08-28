
package data;

import java.util.Comparator;

/**
 *
 * @author quang
 */
public class SapXepTangDanTheoLuong implements Comparator<LaoDong>{

    @Override
    public int compare(LaoDong o1, LaoDong o2) {
        return Double.compare(o1.tinhLuong(), o2.tinhLuong());
    }
    
    
}
