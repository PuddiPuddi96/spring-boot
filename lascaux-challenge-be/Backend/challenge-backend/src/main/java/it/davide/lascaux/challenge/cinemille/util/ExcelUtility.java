package it.davide.lascaux.challenge.cinemille.util;

import it.davide.lascaux.challenge.cinemille.model.FilmFromExcel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelUtility {

    private static final String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    private static final String SHEET = "films";

    public static boolean hasExcelFormat(MultipartFile file) {
        return TYPE.equals(file.getContentType());
    }

    public static List<FilmFromExcel> getFilmsFromExcel(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);

            Sheet sheet = workbook.getSheet(SHEET);
            Iterator<Row> rows = sheet.iterator();

            List<FilmFromExcel> films = new ArrayList<>();
            int rowNumber = 0;

            boolean isLastRow = false;
            while (rows.hasNext() && !isLastRow) {
                Row currentRow = rows.next();
                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cellsInRow = currentRow.iterator();
                FilmFromExcel film = new FilmFromExcel();
                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();
                    switch (cellIdx) {
                        case 0:
                            film.setFilmTitle(currentCell.getStringCellValue());
                            break;
                        case 1:
                            film.setFilmDuration((int) currentCell.getNumericCellValue());
                            break;
                        case 2:
                            film.setFilmGenre(currentCell.getStringCellValue());
                            break;
                        case 3:
                            film.setRoomNumber((int) currentCell.getNumericCellValue());
                            break;
                        case 4:
                            film.setProgrammingStartDate(currentCell.getLocalDateTimeCellValue());
                            break;
                        case 5:
                            film.setProgrammingEndDate(currentCell.getLocalDateTimeCellValue());
                            break;
                        default:
                            break;
                    }
                    cellIdx++;
                }
                if(film.getFilmTitle() == null || film.getFilmTitle().isEmpty())
                    isLastRow = true;
                else
                    films.add(film);
            }
            workbook.close();
            return films;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file");
        }
    }

}
