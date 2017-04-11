package com.riotgames.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import org.json.simple.JSONObject;

public class Sender {
	final static int teamNumber = 18;
	final static String endPoint = "https://demo2446904.mockable.io/api/v1/answer";

	@SuppressWarnings("unchecked")
	public int sendResult(double result) throws IOException
	{


		// 연결
		URL url = new URL(endPoint);

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestProperty("Accept", "*/*");
		conn.setRequestProperty("X-Requested-With", "XMLHttpRequest");
		conn.setRequestMethod("POST");

		// 데이터
		JSONObject data = new JSONObject();
		   data.put("teamId", teamNumber);
		   data.put("now", System.currentTimeMillis() );
		   data.put("result", result);


		// 전송
		OutputStreamWriter osw = new OutputStreamWriter(
				conn.getOutputStream());
		try {
			osw.write(data.toString());
			osw.flush();


			// 응답
			BufferedReader br = null;

			br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

			String line = null;

			while ((line = br.readLine()) != null) {
				System.out.println(line);

			}

			// 닫기
			osw.close();
			br.close();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return 0;
	}
}
