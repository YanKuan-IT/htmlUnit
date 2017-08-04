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
 * ģ��ҳ�水ť���
 * 
 */
public class ClickButton {
	public static void main(String[] args) {
		// ʵ����Web�ͻ���  
		WebClient webClient=new WebClient(BrowserVersion.FIREFOX_24); 
		//ȡ��css֧��
		webClient.getOptions().setCssEnabled(false);
		//ȡ��JavaScript֧��
		webClient.getOptions().setJavaScriptEnabled(false);
        try {
        	//������ȡҳ��
        	HtmlPage page=webClient.getPage("http://blog.java1234.com/index.html");
        	//��ȡ����form
            HtmlForm form = page.getFormByName("myform");
            //��ȡ��ѯ�ı���
            HtmlInput textField = form.getInputByName("q");
        	//��ȡ�ύ��ť
            HtmlSubmitInput button = form.getInputByName("submitButton");
            //�ı�����������
            textField.setValueAttribute("java");
            //ģ������ȡ��ѯ���ҳ��
            HtmlPage resultPage = button.click();
            
            System.out.println(resultPage.asXml());
            
        } catch (FailingHttpStatusCodeException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
        	// �رտͻ��ˣ��ͷ��ڴ�
            webClient.closeAllWindows(); 
        }
	}
}
