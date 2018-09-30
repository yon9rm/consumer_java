package httpClienttest;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;

//컨슈머 생성 - 수정
public class Update {

	public static void main(String[] args) throws HttpException, IOException {
		// TODO Auto-generated method stub
		HttpClient client = new HttpClient();
		client.getParams().setContentCharset("utf-8");
		
		String url = "http://localhost:8000/contactssvc/service/contacts/20";
		PutMethod method = new PutMethod(url);
		method.setRequestHeader("Content-Type", "application/json");
		String body = "{\"name\":\"오바마\", \"tel\":\"010-5555-5555\", \"address\":\"white house\"}";
		
		StringRequestEntity requestEntity = new StringRequestEntity(body, "application/json", "utf-8");
		method.setRequestEntity(requestEntity);
		
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
