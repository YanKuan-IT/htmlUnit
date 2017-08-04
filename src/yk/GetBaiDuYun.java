package yk;

import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
/**
 * 抓取百度云资源   
 *	使用httpClient无法获取数据，原因就是百度云的数据加载 是通过ajax加载以及js渲染上去的，所以用httpclient搞不定
 *
 */
public class GetBaiDuYun {
	public static void main(String[] args) throws InterruptedException{
		// 实例化Web客户端  
		WebClient webClient=new WebClient(BrowserVersion.FIREFOX_24); 
		//取消css支持
		webClient.getOptions().setCssEnabled(false);
		//取消JavaScript支持
		webClient.getOptions().setJavaScriptEnabled(false);
        try {
        	HtmlPage page=webClient.getPage("http://pan.baidu.com/share/home?uk=4018480399#category/type=0");
			
        	Thread.sleep(10000);//休息10s 等待htmlunit执行Js
        	
        	System.out.println("网页内容："+page.asXml());
        	
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
