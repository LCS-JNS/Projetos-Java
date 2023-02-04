import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import javax.json.Json;
import javax.json.JsonObject;

import com.google.gson.Gson;

import java.util.Scanner;

public class Main {
	private final String siteBase = "https://economia.awesomeapi.com.br/json/last/";
	private String siteModify = "https://economia.awesomeapi.com.br/json/last/";
	private String currencies;
	private String currencieRemove;
	private Quotation q;

	public Main() throws IOException {
		setCurrency();
	}

	public void setCurrency() throws IOException {
		Scanner scan = new Scanner(System.in);
		int aprova = 0;
		while (aprova == 0) {

			// Jsonrm both currencies you desire to use
			System.out.print("\nInforme as duas moedas que deseja usar(Ex: USD-BRL): ");

			this.currencies = scan.next();

			// Regex que irá verificar se o formato da entrada é (AAA-AAA)
			// Regex that will verify if the input format is (AAA-AAA)
			if (currencies.matches("^[A-Z]{3}-[A-Z]{3}$")) {
				this.siteModify += currencies;
				getQuotation();
				print();
				System.exit(0);
			} else {

				// Invalid values
				System.out.println("Valores inválidos.");

			}
		}
		scan.close();
	}

	public void getQuotation() throws IOException {
		URL url = new URL(this.siteModify);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		try {

			BufferedReader in = new BufferedReader(
					new InputStreamReader((connection.getInputStream()), StandardCharsets.UTF_8));
			JsonObject jsonObject = Json.createReader(in).readObject();
			in.close();

			String json = jsonObject.toString();

			// Removendo o começo do json provido pela API pois estava atrapalhando a desserialização
			// Removing the beginning of json provided by the API because it was messing with the deserialization
			currencieRemove = this.currencies.replace("-", "");
			String str = "{\"" + currencieRemove + "\":";
			json = json.replace(str, "");
			json = json.replace("}}", "}");
			Gson gson = new Gson();
			this.q = gson.fromJson(json, Quotation.class);


		} catch (FileNotFoundException e) {

			// Both or one of the currencies does not exist
			System.out.println("Ambas ou uma das moedas é inexistente.");

			this.siteModify = this.siteBase;
			setCurrency();
		}
		connection.disconnect();
	}

	public void print() throws IOException {
		Quotation q = this.q;
		System.out.println("\nMoedas: " + q.getName());
		System.out.println("Alta: " + q.getHigh());
		System.out.println("Baixa: " + q.getLow());
		System.out.println("Cotação atual: " + q.getBid());
	}

	public static void main(String[] args) throws Exception {
		new Main();
	}
}
