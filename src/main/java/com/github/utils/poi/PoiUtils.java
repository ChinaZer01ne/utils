package com.github.utils.poi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Zer01ne
 * @Date: 2018/11/20 13:49
 * @Version 1.0
 */
public class PoiUtils {

    private static final String EXCEL2003_SUFFIX = ".xls";
    private static final String EXCEL2007_SUFFIX = ".xlsx";
    private static  ExecutorService service = Executors.newFixedThreadPool(1);
    private static Logger logger = LoggerFactory.getLogger(PoiUtils.class);

    public static void asyncImportExcel(final File file){

        service.submit(() ->
            importExcel(file)
        );

    }


    public static void importExcel(File file){

        Workbook workbook;

        try {
            //不同版本不同处理
            if (isExcel2003(file.getPath())){

                workbook = new HSSFWorkbook(new FileInputStream(file));
            }else if (isExcel2007(file.getPath())){

                workbook = new XSSFWorkbook(new FileInputStream(file));
            }else {
                logger.info("文件格式错误");
                return;
            }
        }catch (Exception e){
            e.printStackTrace();
            return;
        }

        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {

            Sheet sheet = workbook.getSheetAt(i);

            for (int j = 1; j < sheet.getLastRowNum(); j++) {
                Row row = sheet.getRow(j);
                for (int k = 0; k < row.getLastCellNum(); k++) {
                    Cell cell = row.getCell(k);
                    //功能定制
                    print(cell);

                }
            }

            try {
                workbook.close();
            }catch (IOException e) {

                e.printStackTrace();
            }
        }

    }

    private static void print(Cell cell) {
        if (cell == null){
            System.out.println("null");
        }else {
            CellType cellTypeEnum = cell.getCellTypeEnum();
            if (cellTypeEnum.equals(CellType.STRING)){
                System.out.println(cell.getStringCellValue());
            }else if (cellTypeEnum.equals(CellType.NUMERIC)){
                System.out.println(cell.getNumericCellValue());
            }else  if (cellTypeEnum.equals(CellType.BOOLEAN)){
                System.out.println(cell.getBooleanCellValue());
            }else  if (cellTypeEnum.equals(CellType.ERROR)){
                System.out.println(cell.getErrorCellValue());
            }else  if (cellTypeEnum.equals(CellType.FORMULA)){
                System.out.println(cell.getCellFormula());
            }

        }
    }


    private static boolean isExcel2003(String filePath){
        return filePath.endsWith(EXCEL2003_SUFFIX);
    }

    private static boolean isExcel2007(String filePath){
        return filePath.endsWith(EXCEL2007_SUFFIX);
    }

    private PoiUtils(){}

}
