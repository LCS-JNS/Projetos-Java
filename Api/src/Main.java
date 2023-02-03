
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.json.Json;
import javax.json.JsonObject;
import java.util.Scanner;

public class Main {
	public final String siteBase = "https://economia.awesomeapi.com.br/json/last/";
	public String siteModify = "https://economia.awesomeapi.com.br/json/last/";
	public String[] splitedInfo;
	public String moedas;
	
	public Main() throws IOException {
		setCurrency();
	}

	public void print() throws IOException {
		String[] splitedInfo = this.splitedInfo;
		for (String s : splitedInfo) {
			if (!s.equals(splitedInfo[splitedInfo.length - 1])) {
				System.out.println(s + ",");
			} else {
				System.out.println(s);
			}
		}
	}

	public void getQuotation() throws IOException {
		URL url = new URL(this.siteModify);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		String[] splitedInfo = null;
		int status = connection.getResponseCode();
		if (status == 200) {
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			JsonObject jsonObject = Json.createReader(in).readObject();
			String info = jsonObject.toString();
			splitedInfo = info.split(",");
			in.close();
			this.splitedInfo = splitedInfo;
		} else if(status == 404){
			System.out.println("Ambas ou uma das Moedas é inexistente.");
			this.siteModify = this.siteBase;
			setCurrency();
		} else {
			System.out.println("Failed to retrieve data: HTTP error code " + status);
		}
		connection.disconnect();
	}

	public void setCurrency() throws IOException {
		Scanner scan = new Scanner(System.in);
		int aprova = 0;
		while(aprova == 0) {
			System.out.print("Informe as duas moedas que deseja usar(Ex: USD-BRL): ");
			this.moedas = scan.next();
			if(moedas.matches("^[A-Z]{3}-[A-Z]{3}$")) {
				this.siteModify += moedas;
				getQuotation();
				print();
				System.exit(0);
			} else {
				System.out.println("Moedas inválidas.");
			}
		}
		scan.close();

	}

	public static void main(String[] args) throws Exception {
		new Main();
	}
}
