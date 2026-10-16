import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/** One-time export of the original registration test grids using the engine's POI version. */
public class ExportListFixtures {
    private static Path destination;
    private static int count;

    public static void main(String[] args) throws Exception {
        destination = Path.of(args[0]);
        write("ListResult", "values", "PASS", "getCodes()");
        write("QualifiedListResult", "values", "PASS", "(RegisteredFunctions.getCodes())");
        write("CleanAndGetCodes", "values", "PASS", "cleanAndGetCodes(values)");
        write("EmptyListResult", "values", "PASS", "emptyCodes()");
        write("NullListResult", "values", "PASS", "nullCodes()");
        write("NestedListResult", "result", "size(getCodes()) == 2", "size(getCodes())");
        write("LongListResult", "numbers", "PASS", "getNumbers()");
        write("BatchedListResult", "values", "PASS", "getCodes()", "PASS", "getCodes()");
        write("invalid/WrongListElement", "values", "PASS", "getNumbers()");
        write("invalid/ListResultToScalar", "output", "PASS", "getCodes()");
        System.out.println("Created " + count + " list-return Excel fixtures in " + destination);
    }

    private static void write(String name, String output, String... cells) throws Exception {
        Path file = destination.resolve(name + ".xlsx");
        Files.createDirectories(file.getParent());
        try (XSSFWorkbook workbook = new XSSFWorkbook()) {
            var sheet = workbook.createSheet("Rules");
            var header = sheet.createRow(0);
            header.createCell(0).setCellValue("text");
            header.getCell(0).setCellStyle(fill(workbook, "FFFFFF00"));
            header.createCell(1).setCellValue(output);
            header.getCell(1).setCellStyle(fill(workbook, "FF00B0F0"));
            header.setHeightInPoints(24);
            sheet.setColumnWidth(0, 65 * 256);
            sheet.setColumnWidth(1, 65 * 256);
            sheet.createFreezePane(0, 1);
            for (int i = 0; i < cells.length; i += 2) {
                var row = sheet.createRow(i / 2 + 1);
                row.createCell(0).setCellValue(cells[i]);
                row.createCell(1).setCellValue(cells[i + 1]);
            }
            try (var stream = Files.newOutputStream(file, StandardOpenOption.CREATE_NEW)) {
                workbook.write(stream);
            }
        }
        count++;
    }

    private static XSSFCellStyle fill(XSSFWorkbook workbook, String argb) {
        XSSFColor color = new XSSFColor();
        color.setARGBHex(argb);
        XSSFCellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(color);
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        return style;
    }
}
