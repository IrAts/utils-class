package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class EncodingUtils {

	public static void txtConvertToUTF8(String inputFileUrl, String outputFileUrl) throws IOException {
		String inputFileEncode = EncodingDetect.getJavaEncode(inputFileUrl);
        System.out.println("inputFileEncode===" + inputFileEncode);
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(new FileInputStream(inputFileUrl), inputFileEncode));
        BufferedWriter bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(outputFileUrl), "UTF-8"));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            bufferedWriter.write(line + "\r\n");
        }
        bufferedWriter.close();
        bufferedReader.close();
        String outputFileEncode = EncodingDetect.getJavaEncode(outputFileUrl);
        System.out.println("outputFileEncode===" + outputFileEncode);
        System.out.println("txt文件格式转换完成");
	}
}
