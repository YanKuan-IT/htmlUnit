package yk;

import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;

/**
 * 模拟页面按钮点击
 * 
 */
public class ClickButton {
	public static void main(String[] args) {
		// 实例化Web客户端  
		WebClient webClient=new WebClient(BrowserVersion.FIREFOX_24); 
		//取消css支持
		webClient.getOptions().setCssEnabled(false);
		//取消JavaScript支持
		webClient.getOptions().setJavaScriptEnabled(false);
        try {
        	//解析获取页面
        	HtmlPage page=webClient.getPage("http://blog.java1234.com/index.html");
        	//获取搜索form
            HtmlForm form = page.getFormByName("myform");
            //获取查询文本框
            HtmlInput textField = form.getInputByName("q");
        	//获取提交按钮
            HtmlSubmitInput button = form.getInputByName("submitButton");
            //文本框填入数据
            textField.setValueAttribute("java");
            //模拟点击获取查询结果页面
            HtmlPage resultPage = button.click();
            
            System.out.println(resultPage.asXml());
            
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
