package support.intergration;

import java.io.*;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.zkoss.json.*;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.*;
import org.zkoss.zul.Button;

public class RecaptchaComposer extends SelectorComposer<Component> {

	@Wire
	Button submit;
	
	@Listen("onCaptchaValidate = #form")
	public void verify(Event event) throws Exception{
		JSONObject result = verifyUserResponse(((JSONObject)event.getData()).get("response").toString());
		if (Boolean.parseBoolean(result.get("success").toString())){
			submit.setDisabled(false);
		}else{
			String errorCode = result.get("error-codes").toString();
			//log or show error
		}
	}
	

	/**
	 * Refer to https://developers.google.com/recaptcha/docs/verify
	 * Consider simplifying this method with Apache HttpClient library.
	 * @param captchaResponse
	 * @throws Exception
	 */
	private JSONObject verifyUserResponse(String captchaResponse) throws Exception {

		String url = "https://www.google.com/recaptcha/api/siteverify";
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		//add header
		con.setRequestMethod("POST");
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		String SECRET = "6Lcj5AYTAAAAANcaQYWvFkHVSkqR6FsBaCXXw54r"; //from reCaptcha
		String urlParameters = "response="+captchaResponse+"&secret="+SECRET;

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
//		System.out.println("\nSending 'POST' request to URL : " + url);
//		System.out.println("Post parameters : " + urlParameters);
//		System.out.println("Response Code : " + responseCode);

		InputStreamReader in = new InputStreamReader(con.getInputStream());

		JSONObject result = (JSONObject)JSONValue.parse(in);
		in.close();
		
		return result;
	}
}
