package demo.security.controller;

import demo.security.util.ExcelUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class FileUploadController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/upload")
    public String uploadPage() {
        return "upload";
    }

    @PostMapping("/upload")
    @ResponseBody
    public String upload(MultipartFile file) {
        if (!isXls(file) && !isXlsx(file)) {
            return "不支持的文件格式";
        }

        try {
            parse(file);
            return "success";
        } catch (IOException e) {
            logger.error("parse err", e);
            return "error";
        }
    }

    private void parse(MultipartFile file) throws IOException {
        Workbook workbook;
        if (isXls(file)) {
            workbook = new HSSFWorkbook(file.getInputStream());
        } else {
            workbook = new XSSFWorkbook(file.getInputStream());
        }

        Sheet sheet = workbook.getSheetAt(0);
        int firstRowNum = sheet.getFirstRowNum();
        int lastRowNum = sheet.getLastRowNum();
        for (int i = firstRowNum; i <= lastRowNum; ++i) {
            Row row = sheet.getRow(i);
            short firstCellNum = row.getFirstCellNum();
            short lastCellNum = row.getLastCellNum();
            for (int j = firstCellNum; j < lastCellNum; ++j) {
                Cell cell = row.getCell(j);
                System.out.print(ExcelUtils.getCellContent(cell));
                if (j != lastCellNum - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }

    private boolean isXls(MultipartFile file) {
        return file.getOriginalFilename().endsWith(".xls");
    }

    private boolean isXlsx(MultipartFile file) {
        return file.getOriginalFilename().endsWith(".xlsx");
    }
}
