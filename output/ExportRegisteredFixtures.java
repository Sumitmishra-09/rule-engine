import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/** One-time export of the original registration test grids using the engine's POI version. */
public class ExportRegisteredFixtures {
    private static Path destination;
    private static int count;

    public static void main(String[] args) throws Exception {
        destination = Path.of(args[0]);
        write("Dates", "result", "diffMonth(endDate,startDate) >= 6", "twice(diffMonth(endDate,startDate))");
        write("Predicate", "output", "positive(number)", "\"matched\"");
        write("PredicateParenthesized", "output", "(positive(number))", "\"matched\"");
        write("PredicateNegated", "output", "!positive(number)", "\"matched\"");
        write("PredicateAnd", "output", "positive(number) && positive(number)", "\"matched\"");
        write("PredicateOr", "output", "positive(number) || positive(number)", "\"matched\"");
        write("PredicateQualified", "output", "RegisteredFunctions.positive(number)", "\"matched\"");
        write("BooleanOutput", "flag", "PASS", "RegisteredFunctions.positive(number)");
        write("Zero", "result", "PASS", "constant()");
        write("EmptyVarargs", "output", "PASS", "join()");
        write("Varargs", "output", "PASS", "join(text,\"x\",tag(text))");
        write("WidenLong", "result", "PASS", "twice(smallNumber)");
        write("WidenDecimal", "decimal", "PASS", "decimal(100)");
        write("ListArgument", "result", "PASS", "size(values)");
        write("NullArgument", "flag", "PASS", "positive(null)");
        write("Tag", "output", "PASS", "tag(text)");
        write("ChoiceText", "output", "PASS", "choice(text)");
        write("ChoiceNumber", "result", "PASS", "choice(number)");
        write("Batched", "values", "PASS", "tag(\"one\")", "PASS", "tag(\"two\")");
        write("Failing", "result", "PASS", "fail(number)");
        write("BuiltIn", "result", "contains(\"b\")", "max(number,100)");
        write("invalid/UnknownFunction", "output", "missing(number)", "\"matched\"");
        write("invalid/MissingArgument", "output", "positive()", "\"matched\"");
        write("invalid/ExtraArgument", "output", "positive(number,number)", "\"matched\"");
        write("invalid/WrongType", "output", "positive(text)", "\"matched\"");
        write("invalid/UnexpectedArgument", "output", "constant(number)", "\"matched\"");
        write("invalid/PrimitiveNull", "output", "primitive(null)", "\"matched\"");
        write("invalid/QualifiedWrongType", "output", "RegisteredFunctions.positive(text)", "\"matched\"");
        System.out.println("Created " + count + " Excel fixtures in " + destination);
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
