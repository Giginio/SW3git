
package test;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

import com.indvd00m.ascii.render.Render;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContextBuilder;
import com.indvd00m.ascii.render.api.IRender;
import com.indvd00m.ascii.render.elements.PseudoText;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new App().getGreeting());

        // Ascii Render Example
        IRender render = new Render();
        IContextBuilder builder = render.newBuilder();
        builder.width(60).height(10);
        builder.element(new PseudoText("bockmic1"));
        ICanvas canvas = render.render(builder.build());
        String s = canvas.getText();
        System.out.println(s);

        // PDF Box
        PDDocument helloPdf = new PDDocument();
        PDPage page = new PDPage(PDRectangle.A4);
        helloPdf.addPage(page);

        PDPageContentStream contentStream = new PDPageContentStream(helloPdf, page);
        contentStream.beginText();
        contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA), 36);
        contentStream.newLineAtOffset(5, 400);
        contentStream.showText("Hello DevOps!!!");
        contentStream.endText();
        contentStream.close();

        helloPdf.save(new File("simple.pdf"));
        helloPdf.close();
    }
}