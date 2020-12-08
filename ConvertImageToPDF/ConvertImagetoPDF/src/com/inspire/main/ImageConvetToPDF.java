package com.inspire.main;

import com.inspire.util.ImageToPdfConverterUtil;

public class ImageConvetToPDF {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		ImageToPdfConverterUtil img = new ImageToPdfConverterUtil();
		img.FilesToPDF("C:/Users/User/Downloads");
	}
}
