package yk;

import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTable;

/**
 * 操作简单表格,获取表格的行与列
 * http://www.java1234.com/crawler/table01.html
 * <!DOCTYPE html>
 * <html>
 * <head>
 * <meta charset="UTF-8">
 * <title>简单表格</title>
 * </head>
 * <body>
 *     <table id="table1">
 *         <tr>
 *             <th>学号</th>
 *             <th>姓名</th>
 *         </tr>
 *         <tr>
 *             <td>007</td>
 *             <td>米歇尔</td>
 *         </tr>
 *     </table>
 * </body>
 * </html>
 */
public class TableTwo {
	public static void main(String[] args) {
		//实例化web客户端
		WebClient webClient = new WebClient(BrowserVersion.FIREFOX_24);
		//取消css支持
		webClient.getOptions().setCssEnabled(false);
		//取消JavaScript支持
		webClient.getOptions().setJavaScriptEnabled(false);
		
		try {
			//解析获取页面
			HtmlPage page = webClient.getPage("http://www.java1234.com/crawler/table01.html");
			//根据id获取表格
			HtmlTable table = page.getHtmlElementById("table1");
			System.out.println("第1行第2列:"+table.getCellAt(0, 1).asText());
			System.out.println("第2行第1列:"+table.getCellAt(1, 0).asText());
			
			System.out.println("第1行:"+table.getCellAt(0, 0).asText()+"\t"+table.getCellAt(0, 1).asText());
			System.out.println("第2行:"+table.getCellAt(1, 0).asText()+"\t"+table.getCellAt(1, 1).asText());
			
		} catch (FailingHttpStatusCodeException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			//关闭客户端，释放内存
			webClient.closeAllWindows();
		}
	}
}
//第1行第2列:姓名
//第2行第1列:007
//第1行:学号	姓名
//第2行:007	米歇尔