package com.cartify.utils;

import com.cartify.model.entities.Invoice;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;


public class InvoiceGeneratorUtil {
    public static byte[] generateInvoicePdf(Invoice invoice) {

        try {
            Document document = new Document();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            PdfWriter.getInstance(document, out);

            document.open();
            document.add(new Paragraph("Cartify Invoice"));
            document.add(new Paragraph("Invoice Number: " + invoice.getInvoiceNumber()));
            document.add(new Paragraph("Transaction ID: " + invoice.getTransactionId()));
            document.add(new Paragraph("Amount: " + invoice.getTotalAmount()));
            document.close();

            return out.toByteArray();

        } catch (Exception e) {
            throw new RuntimeException("Invoice generation failed");
        }
    }
}