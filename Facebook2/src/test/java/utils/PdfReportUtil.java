package utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.util.List;

public class PdfReportUtil {

    public static void generatePDF(String filePath, List<TestResultData> results) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
            Paragraph title = new Paragraph("Automation Test Report", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(new Paragraph("Generated on: " + new java.util.Date()));
            document.add(new Paragraph(" "));
            
            for (TestResultData result : results) {
                Font headerFont = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
                document.add(new Paragraph("Test Case: " + result.getTestName(), headerFont));

                Font statusFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
                if ("PASS".equalsIgnoreCase(result.getStatus())) {
                    statusFont.setColor(BaseColor.GREEN);
                } else {
                    statusFont.setColor(BaseColor.RED);
                }
                document.add(new Paragraph("Status: " + result.getStatus(), statusFont));

                if (result.getExecutionTime() != null) {
                    document.add(new Paragraph("Execution Time: " + result.getExecutionTime()));
                }

                if (result.getErrorMessage() != null) {
                    document.add(new Paragraph("Error: " + result.getErrorMessage()));
                }

                if (result.getScreenshotPath() != null) {
                    try {
                        Image screenshot = Image.getInstance(result.getScreenshotPath());
                        screenshot.scaleToFit(500, 300);
                        document.add(screenshot);
                    } catch (Exception e) {
                        document.add(new Paragraph("⚠ Screenshot not available"));
                    }
                }

                document.add(new Paragraph("-----------------------------------------------------"));
                document.add(new Paragraph(" "));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }
}
