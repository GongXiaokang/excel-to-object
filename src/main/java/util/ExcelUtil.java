package util;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by gongthomas on 2018/1/23.
 */
public class ExcelUtil {

    private static final int INDEX_FIRST=0;

    /**
     * 将execel文件内容读取到二维数组
     * @param is
     * @return
     * @throws BiffException
     * @throws IOException
     */
    public static String[][] readExcelToArray(InputStream is) throws BiffException,IOException{

        Workbook workbook = Workbook.getWorkbook(is);
        Sheet firstSheet = workbook.getSheet(INDEX_FIRST);

        int rowCount = firstSheet.getRows();
        int columnCount = firstSheet.getColumns();
        String[][] result = new String[rowCount][columnCount];

        for(int row=0;row<rowCount;row++){
            for(int column=0;column<columnCount;column++){
                Cell cell = firstSheet.getCell(column,row);
                result[row][column]=cell.getContents();
            }
        }
        return result;
    }


}
