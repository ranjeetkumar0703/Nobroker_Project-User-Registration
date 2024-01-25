package com.nobroker.service;// PDFGenerationService.java

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.nobroker.entity.User;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class PDFGenerationService {

    public byte[] generatePDF(List<User> users) throws DocumentException {
        Document document = new Document(PageSize.A4);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, baos);

        document.open();

        PdfPTable table = new PdfPTable(6); // five columns for name, email,password, mobile and emailverified
        table.setWidthPercentage(100);

        addTableHeader(table);
        addRows(table, users);

        document.add(table);

        document.close();

        return baos.toByteArray();
    }

    private void addTableHeader(PdfPTable table) {
        PdfPCell headerCell;
        headerCell = new PdfPCell(new Paragraph("Id"));
        headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(headerCell);

        headerCell = new PdfPCell(new Paragraph("Name"));
        headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(headerCell);

        headerCell = new PdfPCell(new Paragraph("Email"));
        headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(headerCell);

        headerCell = new PdfPCell(new Paragraph("Password"));
        headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(headerCell);


        headerCell = new PdfPCell(new Paragraph("Mobile"));
        headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(headerCell);

        headerCell = new PdfPCell(new Paragraph("EmailVerified"));
        headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(headerCell);
    }

    private void addRows(PdfPTable table, List<User> users) {
        for (User user : users) {
            table.addCell(String.valueOf(user.getId()));
            table.addCell(user.getName());
            table.addCell(user.getEmail());
            table.addCell(user.getPassword());
            table.addCell(user.getMobile());
            table.addCell(String.valueOf(user.isEmailVerified()));
        }
    }
}
