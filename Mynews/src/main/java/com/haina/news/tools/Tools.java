package com.haina.news.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.servlet.http.HttpServletRequest;

import com.haina.news.domin.Mynews;

public class Tools {
	//转换html
		public static String changeHtml(String url,Mynews mn,HttpServletRequest request,int n) throws Exception{
			String u = request.getServletContext().getRealPath("/");
			System.out.println(n);
			InputStreamReader  fis = new InputStreamReader(new FileInputStream(new File(url)));
			OutputStreamWriter fos = new OutputStreamWriter(new FileOutputStream(u+mn.getId()+n+".html"),"GBK");
		    char[] chs = new char[1024];;
			int len = 0;
			String ss = "";
			while((len = fis.read(chs)) != -1){
				String s = new String(chs,0,len);
				  ss+=s;
			}
			String s1 = ss.substring(ss.lastIndexOf("%")+2, ss.length());
			String s2 = s1.replace("${mn.title}", mn.getTitle());
			String s3 = s2.replace("${mn.source}",mn.getSource() );
			String s4 = s3.replace("${mn.content}", mn.getContent());
			//System.out.println(s4);
			try {
				fos.write(s4);
				fis.close();
				fos.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new File(u+mn.getId()+n+".html").getPath();
		}

}
