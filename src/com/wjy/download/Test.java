package com.wjy.download;

public class Test {

	public static void main(String[] args) {

		String fileUrl = "https://ss1.bdstatic.com/kvoZeXSm1A5BphGlnYG/skin_zoom/881.jpg?2";
		String fileName = "baidutupian";
		String fileExt = "jpg";

		DownloadFile.download(fileUrl, fileName, fileExt);

	}

}
