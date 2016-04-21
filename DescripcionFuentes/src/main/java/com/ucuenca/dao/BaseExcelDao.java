/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucuenca.dao;

import com.ucuenca.mdl.Column;
import com.ucuenca.mdl.Column_Excel;
import com.ucuenca.mdl.DataBase;
import com.ucuenca.mdl.Table;
import com.ucuenca.mdl.Table_Excel;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Pablo
 */
public class BaseExcelDao extends AbstractDao {

    private String path;

    public BaseExcelDao(String path) {
        this.path = path;
    }

    /**
     * This method gets sheets of file excel
     *
     * @param workbook
     * @Author pablo and adrian
     * @return list table
     */
    public ArrayList<Table> getSheet(Workbook workbook) {
        int numberOfSheets = workbook.getNumberOfSheets();
        ArrayList<Table> listTable = new ArrayList<Table>();
        for (int i = 0; i < numberOfSheets; i++) {
            Table table = new Table_Excel();
            Sheet sheet = workbook.getSheetAt(i);
            table.setTABLE_NAME(sheet.getSheetName());
            getColumn(sheet);
            listTable.add(table);

        }
        return listTable;
    }

    /**
     * This method gets workbook
     *
     * @param schema
     * @Author pablo and adrian
     */
    public DataBase getWorkBook() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(path);
            Workbook workbook = new XSSFWorkbook(fis);
            DataBase dataSet = new DataBase();
            dataSet.setSCHEMA_NAME(workbook.toString());
            dataSet.setTables(getSheet(workbook));
            return dataSet;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * This method gets columns
     *
     * @param sheet
     * @Author pablo and adrian
     * @return list cols
     */
    public List<Column> getColumn(Sheet sheet) {
        Iterator<Row> rowIterator = sheet.iterator();
        List<Column> columns = new ArrayList<Column>();
        while (rowIterator.hasNext()) {
            Column colum = new Column_Excel();
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                if (Cell.CELL_TYPE_STRING == cell.getCellType()) {
                    colum.setCOLUMN_NAME(cell.getStringCellValue());
                } else if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
                    colum.setCOLUMN_NAME(cell.getStringCellValue());
                }

            }
            columns.add(colum);
        }

        return columns;
    }
}
