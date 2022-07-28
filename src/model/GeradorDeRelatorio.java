package model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import entity.Programa;

public class GeradorDeRelatorio {
	
	
	public static void obterProgramacaoDeUmCanal(List<Programa> list) {

        Document document = new Document(PageSize.A4);

        try {
            OutputStream outputStream = new FileOutputStream("Programa.pdf"); // no do arquivo.
            PdfWriter.getInstance(document, outputStream);

            document.open();
            Paragraph paragraph = new Paragraph("---Programas disponiveis---"); // nome que vai aparecer no PDF.
            paragraph.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph);
            for (int i = 0; i < list.size(); i++) {
                Paragraph pg2 = new Paragraph("\n" + list.get(i).toString()); // inserindo os dados no PDF
                document.add(pg2);
            }
            document.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
