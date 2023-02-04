import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import javax.json.Json;
import javax.json.JsonObject;
import java.util.Scanner;

public class Main {
	public final String siteBase = "https://economia.awesomeapi.com.br/json/last/";
	public String siteModify = "https://economia.awesomeapi.com.br/json/last/";
	public String[] splitedInfo;
	public String currencies;

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
		String[] splitedInfo = null;
		
		try {

			BufferedReader in = new BufferedReader(new InputStreamReader((connection.getInputStream()), StandardCharsets.UTF_8));
			JsonObject jsonObject = Json.createReader(in).readObject();
			in.close();

			String info = jsonObject.toString();
			splitedInfo = info.split(",");
			this.splitedInfo = splitedInfo;
			
		} catch (FileNotFoundException e) {

			//Both or one of the currencies does not exist
			System.out.println("Ambas ou uma das Moedas é inexistente.");

			this.siteModify = this.siteBase;
			setCurrency();
		}
		connection.disconnect();
	}

	public void setCurrency() throws IOException {
		Scanner scan = new Scanner(System.in);
		int aprova = 0;
		while(aprova == 0) {

			//Inform both currencies you desire to use
			System.out.print("Informe as duas moedas que deseja usar(Ex: USD-BRL): ");

			this.currencies = scan.next();

			//Regex que irá verificar se o formato da entrada é (AAA-AAA)/ Regex that will verify if the input format is (AAA-AAA)
			if(currencies.matches("^[A-Z]{3}-[A-Z]{3}$")) {
				this.siteModify += currencies;
				getQuotation();
				print();
				System.exit(0);
			} else {

				//Invalid values
				System.out.println("Valores inválidas.");

			}
		}
		scan.close();
	}

	public static void main(String[] args) throws Exception {
		new Main();
	}
}
