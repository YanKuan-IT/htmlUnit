package yk;

import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTable;

/**
 * �����򵥱��,��ȡ����������
 * http://www.java1234.com/crawler/table01.html
 * <!DOCTYPE html>
 * <html>
 * <head>
 * <meta charset="UTF-8">
 * <title>�򵥱��</title>
 * </head>
 * <body>
 *     <table id="table1">
 *         <tr>
 *             <th>ѧ��</th>
 *             <th>����</th>
 *         </tr>
 *         <tr>
 *             <td>007</td>
 *             <td>��Ъ��</td>
 *         </tr>
 *     </table>
 * </body>
 * </html>
 */
public class TableTwo {
	public static void main(String[] args) {
		//ʵ����web�ͻ���
		WebClient webClient = new WebClient(BrowserVersion.FIREFOX_24);
		//ȡ��css֧��
		webClient.getOptions().setCssEnabled(false);
		//ȡ��JavaScript֧��
		webClient.getOptions().setJavaScriptEnabled(false);
		
		try {
			//������ȡҳ��
			HtmlPage page = webClient.getPage("http://www.java1234.com/crawler/table01.html");
			//����id��ȡ���
			HtmlTable table = page.getHtmlElementById("table1");
			System.out.println("��1�е�2��:"+table.getCellAt(0, 1).asText());
			System.out.println("��2�е�1��:"+table.getCellAt(1, 0).asText());
			
			System.out.println("��1��:"+table.getCellAt(0, 0).asText()+"\t"+table.getCellAt(0, 1).asText());
			System.out.println("��2��:"+table.getCellAt(1, 0).asText()+"\t"+table.getCellAt(1, 1).asText());
			
		} catch (FailingHttpStatusCodeException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			//�رտͻ��ˣ��ͷ��ڴ�
			webClient.closeAllWindows();
		}
	}
}
//��1�е�2��:����
//��2�е�1��:007
//��1��:ѧ��	����
//��2��:007	��Ъ��