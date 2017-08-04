package yk;

import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.gargoylesoftware.htmlunit.html.HtmlTableCell;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;

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
public class TableOne {
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
			//����������
			for(HtmlTableRow row : table.getRows()){
				//����������
				for(HtmlTableCell cell : row.getCells()){
					System.out.print(cell.asText()+"\t");
				}
				//����
				System.out.println();
			}
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
//ѧ��	����	
//007	��Ъ��	