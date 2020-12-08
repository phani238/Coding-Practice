package com.inspire.util;

import java.io.File;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

public class ImageToPdfConverterUtil {

	public static void FilesToPDF(String path) {
		File directoryPath = new File(path);
		File filesList[] = directoryPath.listFiles();
		for (File file : filesList) {
			if (file.getName().split("\\.")[1].toLowerCase().equals("png")
					|| file.getName().split("\\.")[1].toLowerCase().equals("jpg")
					|| file.getName().split("\\.")[1].toLowerCase().equals("jfif")
					|| file.getName().split("\\.")[1].toLowerCase().equals("jpeg")) {
				boolean isSuccess = imageToPDF(file.getParent(), file.getName(), file.getName().split("\\.")[0]);
				if(isSuccess)	file.delete();
			}
		}
	}

	public static boolean imageToPDF(String root, String fileNameWithExt, String fileNameWithoutExt) {
		Document document = new Document();
		try {
			FileOutputStream fos = new FileOutputStream(root + "\\" + fileNameWithoutExt + ".pdf");
			PdfWriter writer = PdfWriter.getInstance(document, fos);
			writer.open();
			document.open();
			Image image = Image.getInstance(new File(root, fileNameWithExt).getAbsolutePath());
			image.setAlignment(Element.ALIGN_CENTER);
			float imageWidth = image.getWidth();
			if (imageWidth > document.getPageSize().getWidth()) {
				int indentation = 0;
				float scaler = ((document.getPageSize().getWidth() - document.leftMargin() - document.rightMargin()
						- indentation) / image.getWidth()) * 100;
				image.scalePercent(scaler);
			}
			document.add(image);
			document.close();
			writer.close();
			System.out.println("Image Converted successfully");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to convert" + e);
			return false;
		}
	}
}
