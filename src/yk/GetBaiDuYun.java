package yk;

import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
/**
 * ץȡ�ٶ�����Դ   
 *	ʹ��httpClient�޷���ȡ���ݣ�ԭ����ǰٶ��Ƶ����ݼ��� ��ͨ��ajax�����Լ�js��Ⱦ��ȥ�ģ�������httpclient�㲻��
 *
 */
public class GetBaiDuYun {
	public static void main(String[] args) throws InterruptedException{
		// ʵ����Web�ͻ���  
		WebClient webClient=new WebClient(BrowserVersion.FIREFOX_24); 
		//ȡ��css֧��
		webClient.getOptions().setCssEnabled(false);
		//ȡ��JavaScript֧��
		webClient.getOptions().setJavaScriptEnabled(false);
        try {
        	HtmlPage page=webClient.getPage("http://pan.baidu.com/share/home?uk=4018480399#category/type=0");
			
        	Thread.sleep(10000);//��Ϣ10s �ȴ�htmlunitִ��Js
        	
        	System.out.println("��ҳ���ݣ�"+page.asXml());
        	
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
