package com.neu.naam.pojo; 

import java.awt.Color;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PDFView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document pdfdoc, PdfWriter pdfwriter, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Font  myFont = new Font(Font.HELVETICA, 20, Font.BOLDITALIC, Color.BLACK);
		
		List<Cart> cartlist = (List<Cart>) model.get("cartitems");
		Paragraph title = new Paragraph("Thank you for shopping at the Store", myFont);
		
		Phrase producttitle = new Phrase("Below you will find a summary of the item you have purchased");
		String inp="";
		for (Cart cart_item : cartlist) {
			inp+=cart_item.getTitle()+cart_item.getCategory();
		}
		String hash=makeSHA1Hash(inp);
		Phrase thank = new Phrase("Transaction code: "+ hash +"\n\nThank you for shopping with us");
		
		PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100.0f);
        float width[]=new float[] {3.0f, 2.0f, 1.0f};
        table.setWidths(width);
        table.setSpacingBefore(12);
		
		PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.gray);
        cell.setPadding(4);
		
        cell.setPhrase(new Phrase("Product Title", myFont));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Category", myFont));
        table.addCell(cell);
 
        cell.setPhrase(new Phrase("Price", myFont));
        table.addCell(cell);
        
        for (Cart cart_item : cartlist) {
            table.addCell(cart_item.getTitle());
            table.addCell(cart_item.getCategory());
            table.addCell(String.valueOf(cart_item.getTotalprice()));
        }
        
		pdfdoc.add(title);
		pdfdoc.add(producttitle);
		pdfdoc.add(table);
		pdfdoc.add(thank);
	}

	public String makeSHA1Hash(String input)
            throws NoSuchAlgorithmException, UnsupportedEncodingException
        {
            MessageDigest md = MessageDigest.getInstance("SHA1");
            md.reset();
            byte[] buffer = input.getBytes("UTF-8");
            md.update(buffer);
            byte[] digest = md.digest();

            String hexStr = "";
            for (int i = 0; i < digest.length; i++) {
                hexStr +=  Integer.toString( ( digest[i] & 0xff ) + 0x100, 16).substring( 1 );
            }
            return hexStr;
        }
}
