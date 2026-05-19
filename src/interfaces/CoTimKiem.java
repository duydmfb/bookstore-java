package interfaces;

import java.util.List;

public interface CoTimKiem<T> {
     List<T> timTheoTen(String tenSach);
     List<T> timTheoTacGia(String tacGia);
}


