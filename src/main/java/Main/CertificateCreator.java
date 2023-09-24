package Main;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class CertificateCreator {
    public static final String DIR_PATH = System.getProperty("user.dir");
    private static final String FRESCO_PATH = DIR_PATH + "/src/main/resources/fonts/FRESBN_.PFM";
    private static final String CERT_OUTPUT_LOCATION = DIR_PATH + "/src/main/resources/completed/";

    public CertificateCreator() {
    }

    public void create(String participantsTable) {

        ParticipantsExtractor extractor = new ParticipantsExtractor();
        java.util.List<Participant> listParticipants = extractor.getParticipants(participantsTable);
        Map<String, Template> templates = TemplateInfoProvider.getInfo();

        try {

            for (int i = 0; i < listParticipants.size(); i++) {

                Participant participant = listParticipants.get(i);
                BaseFont frescoFont = BaseFont.createFont(FRESCO_PATH, BaseFont.WINANSI, BaseFont.EMBEDDED);

                String fileName = participant.getTemplateName();
                if (participant.getTeacher().equals("") && !fileName.substring(0, 4).equals("Cert")) {
                    fileName = fileName + "NoTeach";
                }
                fileName = DIR_PATH + "/src/main/resources/data/templates/" + fileName + ".pdf";

                File file = new File(fileName);
                if (!file.isFile()) {
                    System.out.println("Couldn't find template for " + i + ". " + participant.getName() + " " + fileName);
                    continue;
                }

                Files.createDirectories(Paths.get("C:/CertificatesLYPCO"));  //creates if exists
                PdfReader pdfReader = new PdfReader(fileName);
                PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream("/CertificatesLYPCO/" + formFileName(participant)));

                //Contain the pdf data.
                PdfContentByte pageContentByte = pdfStamper.getOverContent(1);

                pageContentByte.beginText();

                Template template = templates.get(participant.getTemplateName());

                pageContentByte.setColorFill(BaseColor.WHITE);
                pageContentByte.setCharacterSpacing(template.getSpacing());

                //Write text name
                pageContentByte.setFontAndSize(frescoFont, template.getFontSizeName());
                pageContentByte.showTextAligned(PdfContentByte.ALIGN_CENTER, participant.getName(), template.getxName(), template.getyName(), 0);


                //Write text category
                pageContentByte.setFontAndSize(frescoFont, template.getFontSizeCategory());
                String[] lines = participant.getOfficialCategory().split("\\n");
                int yChange = 0;

                for (int j = 0; j < lines.length; j++, yChange -= template.getyChange()) {

                    pageContentByte.showTextAligned(PdfContentByte.ALIGN_CENTER, lines[j], template.getxCategory(), template.getyCategory() + yChange, 0);

                }

                //Write text teacher
                pageContentByte.setFontAndSize(frescoFont, template.getFontSizeTeacher());
                String teacherName = participant.getTeacher();
                if (teacherName.length() >= 20) {
                    pageContentByte.setFontAndSize(frescoFont, (float) (template.getFontSizeTeacher() * 0.85));
                }
                String[] teacherSplit = splitName(teacherName);
                yChange = 0;


                for (int j = 0; j < teacherSplit.length; j++, yChange -= template.getyChange()) {

                    pageContentByte.showTextAligned(PdfContentByte.ALIGN_CENTER, teacherSplit[j], template.getxTeacher(), template.getyTeacher() + yChange, 0);

                }

                pageContentByte.endText();
                pdfStamper.close();
                pdfReader.close();

                //

            }
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }
    }

    private static String formFileName(Participant participant) {
        String fileName = participant.getName() + participant.getMedal() + ".pdf";

        return fileName.replaceAll("\\s+", "");
    }


    private static String[] splitName(String teacherName) {
        int length = teacherName.length();
        String[] parts = teacherName.split("\\s+");


        if (length <= 20) {
            return new String[]{teacherName};

        } else if (length <= 40) {

            StringBuilder firstPart = new StringBuilder();
            StringBuilder secondPart = new StringBuilder();
            int counter = 0;

            while (firstPart.length() < teacherName.length() * (0.3)) {
                firstPart.append(parts[counter]).append(" ");
                counter++;
            }
            for (; counter < parts.length; counter++) {
                secondPart.append(parts[counter]).append(" ");
            }

            return new String[]{firstPart.toString().trim(), secondPart.toString().trim()};
        } else {

            StringBuilder firstPart = new StringBuilder();
            StringBuilder secondPart = new StringBuilder();
            StringBuilder thirdPart = new StringBuilder();
            int counter = 0;

            while (firstPart.length() < teacherName.length() * (0.3)) {
                firstPart.append(parts[counter]).append(" ");
                counter++;
            }
            while (firstPart.length() + secondPart.length() < teacherName.length() * (0.63)) {
                secondPart.append(parts[counter]).append(" ");
                counter++;
            }
            for (; counter < parts.length; counter++) {
                thirdPart.append(parts[counter]).append(" ");
            }

            return new String[]{firstPart.toString().trim(), secondPart.toString().trim(), thirdPart.toString().trim()};
        }

    }
}
