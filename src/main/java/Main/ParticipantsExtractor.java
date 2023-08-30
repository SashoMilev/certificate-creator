package Main;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import static Main.CertificateCreator.DIR_PATH;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;


public class ParticipantsExtractor {

    private static final String TABLE_PATH = DIR_PATH + "/src/main/resources/data/Certificates_list.xlsx";

    public List<Participant> getParticipants(String dataPath) {
        //  BasicConfigurator.configure();    //in order to get rid of non-fatal error message about Log4j2

        List<Participant> participants = new ArrayList<>();




        try {

            FileInputStream inputStream = new FileInputStream(new File(dataPath));
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet firstSheet = workbook.getSheetAt(0);

            // Iterators to traverse over
            Iterator<Row> rowIterator = firstSheet.iterator();


            // Skip the first row containing names of the columns
            if (rowIterator.hasNext()) {
                rowIterator.next();
            }

            while (rowIterator.hasNext()) {

                Row nextRow = rowIterator.next();
                // This is for a Row's cells
                Iterator<Cell> cellIterator = nextRow.cellIterator();

                int ID = 0;
                String firstName = "";
                String lastName = "";
                String teacherName = "";
                String category = "";
                String medalType = "";

                while (cellIterator.hasNext()) {

                    Cell currentCell = cellIterator.next();

                    // Switch case variable to get the columnIndex
                    int columnIndex = currentCell.getColumnIndex();

                    switch (columnIndex) {

                        // First column is ID
                        case 0:
                            ID = (int) currentCell.getNumericCellValue();

                            break;
                        // firstName
                        case 1:
                            firstName = currentCell.getStringCellValue();

                            if (checkIfNameIsMisspelled(firstName)) {

                                firstName = fixName(firstName);

                            }
                            break;
                        // lastName
                        case 2:
                            lastName = currentCell.getStringCellValue();

                            if (checkIfNameIsMisspelled(lastName)) {

                                lastName = fixName(lastName);
                            }
                            break;
                        // teacherName
                        case 3:
                            teacherName = currentCell.getStringCellValue();

                            if (checkIfNameIsMisspelled(teacherName)) {

                                teacherName = fixName(teacherName);

                            }
                            break;
                        // category
                        case 4:
                            category = currentCell.getStringCellValue();

                            break;
                        // medalType
                        case 5:
                            medalType = currentCell.getStringCellValue();

                            break;

                    }
                }

                if (ID != 0) {
                    Participant participant = new Participant(ID, firstName, lastName, teacherName, category, medalType);
                    participants.add(participant);
                }

            }

            workbook.close();
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return participants;
    }

    public static boolean checkIfNameIsMisspelled(String name) {


        return name.equals(name.toUpperCase(Locale.ROOT))
                || name.matches(".+\\.\\b.+");
    }

    public static String fixName(String name) {

        //if dot[.] is not followed by whitespace
        if (name.matches(".+\\.\\b.+")) {
            String[] parts = name.split("\\.\\b");
            name = String.join(". ", parts);
        }

        if (name.length() > 1) {

            if (name.contains(" ")) {

                String[] names = name.split("\\s+");

                for (int i = 0; i < names.length; i++) {

                    names[i] = names[i].toLowerCase(Locale.ROOT);
                    names[i] = Character.toUpperCase(names[i].charAt(0)) + names[i].substring(1);
                }

                return String.join(" ", names);
            } else {

                name = name.toLowerCase(Locale.ROOT);
                name = Character.toUpperCase(name.charAt(0)) + name.substring(1);

                return name;
            }
        }

        return name;
    }
}
