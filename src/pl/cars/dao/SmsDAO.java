package pl.cars.dao;

public class SmsDAO {

	// https://api.smsapi.pl/sms.do?to=665872197&message=test&test=0&access_token=FrdBslodVhAE9sedO2UZxfCHOlaW6QG4mPEH6ePg

	// private String smsUrl = "https://api.smsapi.pl/sms.do?";
	// private String accessToken =
	// "access_token=FrdBslodVhAE9sedO2UZxfCHOlaW6QG4mPEH6ePg";
	private String message;
	private String to;
	
	public static String buildUrl(String message, String to) {

		String smsUrl = "https://api.smsapi.pl/sms.do?";
		String accessToken = "access_token=FrdBslodVhAE9sedO2UZxfCHOlaW6QG4mPEH6ePg";
		String test = "0";
		StringBuilder sb = new StringBuilder();
		sb.append(smsUrl).append(accessToken).append("&").append(message).append("&").append(to).append("&")
				.append(test);

		return sb.toString();

	}

	public SmsDAO() {

	}

	public SmsDAO(String message, String to) {

		this.message = message;
		this.to = to;

	}

	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	@Override
	public String toString() {
		return "SmsDAO [message=" + message + ", to=" + to + "]";
	}



}
