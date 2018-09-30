package httpClienttest;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;

//컨슈머 생성 - 조회
public class Select {

	public static void main(String[] args) throws HttpException, IOException {
		// TODO Auto-generated method stub
		HttpClient client = new HttpClient();
		client.getParams().setContentCharset("utf-8");
		
		String url = "http://localhost:8000/contactssvc/service/contacts";
		GetMethod method = new GetMethod(url);
		
		method.setQueryString(new NameValuePair[] {
            new NameValuePair("pageNo", "1"),
            new NameValuePair("pageSize", "5") 
        });
		
		int status = client.executeMethod(method);
		if (status == 200) {
			String data = method.getResponseBodyAsString();
			System.out.println("## DATA: " + data);
		} else {
			System.out.println("getStatusCode() : " + method.getStatusCode());
			System.out.println("getStatusText() : " + method.getStatusText());
		}
	}

}
