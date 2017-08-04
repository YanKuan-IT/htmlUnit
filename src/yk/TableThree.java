package yk;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.gargoylesoftware.htmlunit.html.HtmlTableBody;
import com.gargoylesoftware.htmlunit.html.HtmlTableFooter;
import com.gargoylesoftware.htmlunit.html.HtmlTableHeader;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;

/**
 * �������ӱ��,��ȡ����������
 * http://www.java1234.com/crawler/table02.html
 * <!DOCTYPE html>
 * <html>
 * <head>
 * <meta charset="UTF-8">
 * <title>���ӱ��</title>
 * </head>
 * <body>
 *      <table id="table1">
 *         <caption>���ӱ��</caption>
 *         <thead>
 *             <tr>
 *                 <th>����</th>
 *                 <th>����</th>
 *             </tr>
 *         </thead>
 *         <tfoot>
 *             <tr>
 *                 <td>7</td>
 *                 <td></td>
 *             </tr>
 *         </tfoot>
 *         <tbody>
 *             <tr>
 *                 <td>5</td>
 *                 <td>��</td>
 *             </tr>
 *         </tbody>
 *         <tbody>
 *             <tr>
 *                 <td>2</td>
 *                 <td>ţ</td>
 *             </tr>
 *         </tbody>
 *     </table>
 * </body>
 * </html>
 */
public class TableThree {
	public static void main(String[] args) {
		//ʵ����web�ͻ���
		WebClient webClient = new WebClient(BrowserVersion.FIREFOX_24);
		//ȡ��css֧��
		webClient.getOptions().setCssEnabled(false);
		//ȡ��JavaScript֧��
		webClient.getOptions().setJavaScriptEnabled(false);
		
		try {
			//������ȡҳ��
			HtmlPage page = webClient.getPage("http://www.java1234.com/crawler/table02.html");
			//����id��ȡ���
			HtmlTable table = page.getHtmlElementById("table1");
			
			//��ȡ������
			String caption = table.getCaptionText();
			System.out.println("�����⣺"+caption);
			
			//��ȡ��ͷ��Ϣ
			HtmlTableHeader header = table.getHeader();
			//��ȡ����ͷ��
			List<HtmlTableRow> headerRows = header.getRows();
			System.out.println("ͷ��Ϣ��");
			for(HtmlTableRow row : headerRows){
				System.out.println(row.asText());
			}
			
			//��ȡ���������Ϣ
			for(HtmlTableBody body : table.getBodies()){
				List<HtmlTableRow> rows = body.getRows();
				for(HtmlTableRow row : rows){
					System.out.println(row.asText());
				}
			}
			
			//��ȡ����Ϣ
			HtmlTableFooter footer = table.getFooter();
			List<HtmlTableRow> footRows = footer.getRows();
			System.out.println("����Ϣ��");
			for(HtmlTableRow row : footRows){
				System.out.println(row.asText());
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
//�����⣺���ӱ��
//ͷ��Ϣ��
//����	����
//5	��
//2	ţ
//����Ϣ��
//7	