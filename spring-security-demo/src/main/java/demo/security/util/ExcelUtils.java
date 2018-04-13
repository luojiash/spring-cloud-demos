package demo.security.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

public class ExcelUtils {
    private static Map<CellType, Function<Cell, Object>> map = new HashMap<>();

    static {
        map.put(CellType.NUMERIC, Cell::getNumericCellValue);
        map.put(CellType.STRING, Cell::getStringCellValue);
        map.put(CellType.FORMULA, Cell::getCellFormula);
        map.put(CellType.BOOLEAN, Cell::getBooleanCellValue);
    }

    public static Object getCellContent(Cell cell) {
        return Optional.ofNullable(cell).map(c -> map.get(c.getCellTypeEnum())).map(f -> f.apply(cell)).orElse("");
    }
}
