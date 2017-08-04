package yk;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSpan;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlListItem;

public class HtmlUnit {
	public static void main(String[] args) {
		// 实例化Web客户端  
//		WebClient webClient=new WebClient(BrowserVersion.FIREFOX_24,"111.13.7.118",80); 
		WebClient webClient=new WebClient(BrowserVersion.FIREFOX_24); 
		//取消css支持
//		webClient.getOptions().setCssEnabled(false);
		//取消JavaScript支持
//		webClient.getOptions().setJavaScriptEnabled(false);
        try {
        	// 解析获取页面
            HtmlPage page=webClient.getPage("http://www.java1234.com"); 
            
//            System.out.println("网页html:"+page.asXml()); // 获取Html
//            System.out.println("====================");
//            System.out.println("网页文本："+page.asText()); // 获取文本
            
            //查找指定id的Dom元素
//            HtmlElement div = page.getHtmlElementById("navMenu");
//            System.out.println(div.asXml());
            
            //根据tag名称查询所有tag
//            List<DomElement> list = page.getElementsByTagName("a");
//            for(int i=0;i<list.size();i++){
//            	DomElement domElement = list.get(i);
//            	System.out.println(domElement.asXml());
//            }
            
            // xpath方式
//            HtmlListItem item = (HtmlListItem) page.getByXPath("//div[@id='navMenu']/ul/li").get(1);
//            System.out.println(item.asXml());
//            <li style="margin-right: 0px;margin-left: -3px;padding-left: 5px;">
//            <a href="/a/kaiyuan/" rel="dropmenu44">
//              <span>
//                Java开源项目分享
//              </span>
//            </a>  
//          </li>
            
            List<HtmlSpan> spanList = (List<HtmlSpan>) page.getByXPath("//div[@id='navMenu']/ul/li[2]/a/span");
            System.out.println(spanList.get(0).asXml());
            System.out.println(spanList.get(0).asText());
//            <span>
//            Java开源项目分享
//          </span>
//            Java开源项目分享
        	
        	
        } catch (FailingHttpStatusCodeException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
        	// 关闭客户端，释放内存
            webClient.closeAllWindows(); 
        }
	}
}
