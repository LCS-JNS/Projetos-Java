import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.json.Json;
import javax.json.JsonObject;
import java.util.Scanner;

public class Main {
	public String site = "https://economia.awesomeapi.com.br/json/last/";
	

	public static void main(String[] args) throws Exception {
		new Main();

	}

	public Main() throws IOException {
		setCurrency();
		String[] splitedInfo = getQuotation();
		for (String s : splitedInfo) {
			if (!s.equals(splitedInfo[splitedInfo.length - 1])) {
				System.out.println(s + ",");
			} else {
				System.out.println(s);
			}
		}
		System.out.println();
	}

	public String[] getQuotation() throws IOException {
		URL url = new URL(this.site);
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

		} else if(status == 404){
			System.out.println("Ambas ou uma das Moedas é inexistente.");
			new Main();
		} else {
			System.out.println("Failed to retrieve data: HTTP error code " + status);
		}
		connection.disconnect();
		return splitedInfo;
	}

	public void setCurrency() {
		Scanner scan = new Scanner(System.in);
		int aprova = 0;
		while(aprova == 0) {
			System.out.print("Informe as duas moedas que deseja usar(Ex: USD-BRL): ");
			String moeda = scan.nextLine();
			if(moeda.matches("^[A-Z]{3}-[A-Z]{3}$")) {
				this.site += moeda;
				break;
			} else {
				System.out.println("Moedas inválidas.");
			}
		}
		scan.close();
	}

}
