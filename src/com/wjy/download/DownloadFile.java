package com.wjy.download;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;

public class DownloadFile {

	private static final String PATH = "D:/";

	public static void download(String fileUrl, String fileName, String fileExt) {
		String name = PATH + fileName + "." + fileExt;
		DataInputStream dataInputStream = null;
		FileOutputStream fileOutputStream = null;
		ByteArrayOutputStream byteArrayOutputStream = null;
		try {
			dataInputStream = new DataInputStream(new URL(fileUrl).openStream());
			fileOutputStream = new FileOutputStream(new File(name));
			byteArrayOutputStream = new ByteArrayOutputStream();
			int length;
			byte[] value = new byte[1024];
			while ((length = dataInputStream.read(value)) > 0) {
				byteArrayOutputStream.write(value, 0, length);
			}
			fileOutputStream.write(byteArrayOutputStream.toByteArray());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				byteArrayOutputStream.close();
				dataInputStream.close();
				fileOutputStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
