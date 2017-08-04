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
 * 操作复杂表格,获取表格的行与列
 * http://www.java1234.com/crawler/table02.html
 * <!DOCTYPE html>
 * <html>
 * <head>
 * <meta charset="UTF-8">
 * <title>复杂表格</title>
 * </head>
 * <body>
 *      <table id="table1">
 *         <caption>复杂表格</caption>
 *         <thead>
 *             <tr>
 *                 <th>个数</th>
 *                 <th>名称</th>
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
 *                 <td>猪</td>
 *             </tr>
 *         </tbody>
 *         <tbody>
 *             <tr>
 *                 <td>2</td>
 *                 <td>牛</td>
 *             </tr>
 *         </tbody>
 *     </table>
 * </body>
 * </html>
 */
public class TableThree {
	public static void main(String[] args) {
		//实例化web客户端
		WebClient webClient = new WebClient(BrowserVersion.FIREFOX_24);
		//取消css支持
		webClient.getOptions().setCssEnabled(false);
		//取消JavaScript支持
		webClient.getOptions().setJavaScriptEnabled(false);
		
		try {
			//解析获取页面
			HtmlPage page = webClient.getPage("http://www.java1234.com/crawler/table02.html");
			//根据id获取表格
			HtmlTable table = page.getHtmlElementById("table1");
			
			//获取表格标题
			String caption = table.getCaptionText();
			System.out.println("表格标题："+caption);
			
			//获取表头信息
			HtmlTableHeader header = table.getHeader();
			//获取所有头行
			List<HtmlTableRow> headerRows = header.getRows();
			System.out.println("头信息：");
			for(HtmlTableRow row : headerRows){
				System.out.println(row.asText());
			}
			
			//获取表格内容信息
			for(HtmlTableBody body : table.getBodies()){
				List<HtmlTableRow> rows = body.getRows();
				for(HtmlTableRow row : rows){
					System.out.println(row.asText());
				}
			}
			
			//获取根信息
			HtmlTableFooter footer = table.getFooter();
			List<HtmlTableRow> footRows = footer.getRows();
			System.out.println("根信息：");
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
			//关闭客户端，释放内存
			webClient.closeAllWindows();
		}
	}
}
//表格标题：复杂表格
//头信息：
//个数	名称
//5	猪
//2	牛
//根信息：
//7	