package org.example;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            String apiKey = "bebf1cb8087616669aef75d9";
            String url_str = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/USD";

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url_str))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JsonElement root = JsonParser.parseString(response.body());
            JsonObject jsonobj = root.getAsJsonObject();

            String req_result = jsonobj.get("result").getAsString();
            System.out.println("Resultado da requisição: " + req_result);

            JsonObject conversionRates = jsonobj.getAsJsonObject("conversion_rates");
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("1) Dólar =>> Peso argentino ");
                System.out.println("2)  Peso argentino =>> Dólar ");
                System.out.println("3)  Dólar =>> Real brasileiro ");
                System.out.println("4)  Real brasileiro =>> Dólar ");
                System.out.println("5)  Dólar =>> Peso colombiano ");
                System.out.println("6)  Peso colombiano =>> Dólar ");
                System.out.println("7)  Dólar =>> Peso chileno ");
                System.out.println("8) Peso chileno =>> Dólar ");
                System.out.println("9)  Dólar  =>> Boliviano ");
                System.out.println("10)  Boliviano =>> Dólar ");
                System.out.println("11) Sair ");

                int numeroDigitado = scanner.nextInt();


                if (numeroDigitado == 11) {
                    System.out.println("Progema encerrado. Até a proxima! ");
                    break;
                }
                if (numeroDigitado < 1 || numeroDigitado > 11) {
                    System.out.println("A opção digitada não correspondente. Tente novamente!");
                    continue;
                }
                System.out.println("Qual o valor que gostaria de converter");

                double converte = scanner.nextDouble();

                switch (numeroDigitado) {
                    case 1:
                        // dolar  para argentino
                        double valorARS = conversionRates.get("ARS").getAsDouble();
                        double usdMoedaArs = converte * valorARS;
                        System.out.println(converte + " Dólar = " + usdMoedaArs + " Peso argentino ");

                    case 2:
                        // argentino p dolar
                        double valorArs = conversionRates.get("ARS").getAsDouble();
                        double arsMoedaUsd = converte / valorArs;
                        System.out.println(converte + " Peso argentino = " + arsMoedaUsd + " Dólar ");
                    case 3:
                        //Dólar =>> Real brasileiro
                        double valorBRL = conversionRates.get("BRL").getAsDouble();
                        double  usdMoedaBrl = converte * valorBRL;
                        System.out.println(converte + " Dólar = " + usdMoedaBrl + " Real brasileiro ");
                   case 4:
                        //Real brasileiro =>> Dólar
                        double valorBrl= conversionRates.get("BRL").getAsDouble();
                        double brlMoedaUsd = converte / valorBrl;
                        System.out.println( converte + " Real brasileiro = " + brlMoedaUsd + " Dólar ");
                    case 5:
                    //Dólar =>> Peso colombiano

                        double valorCOP = conversionRates.get("COP").getAsDouble();
                        double usdMoedaCop = converte * valorCOP;
                        System.out.println(converte + " Dólar = " + usdMoedaCop + " Peso colombiano " );
                    case 6:
                //Peso colombiano =>> Dólar
                        double valorCop = conversionRates.get("COP").getAsDouble();
                        double copMoedaDolar = converte / valorCop;
                        System.out.println(converte + " Peso colombiano = " + copMoedaDolar + "Dólar" );
                    case 7:
                        //("7)  Dólar =>> Peso chileno ");
                        double valorCLP = conversionRates.get("CLP").getAsDouble();
                        double usdMoedaClp = converte * valorCLP;
                        System.out.println(converte + " Dólar = " + usdMoedaClp + " Peso chileno ");
                    case 8:
                        //("8) Peso chileno =>> Dólar ");
                        double valorClp = conversionRates.get("CLP").getAsDouble();
                        double clpMoedaUsd = converte / valorClp;
                        System.out.println(converte + " Peso chileno = " + clpMoedaUsd + " Dólar ");

                    case 9:
                        //9)  Dólar  =>> Boliviano ");
                        double valorBOB = conversionRates.get("BOB").getAsDouble();
                        double usdMoedaBob = converte * valorBOB;
                        System.out.println(converte + " Dólar = " + usdMoedaBob + " Boliviano ");
                    case 10:
                        //10)  Boliviano =>> Dólar ");
                        double valorBob = conversionRates.get("BOB").getAsDouble();
                        double bobMoedaUsd = converte / valorBob;
                        System.out.println(converte + " Boliviano = " + bobMoedaUsd + " Dólar ");


                }
            }
        }
        catch (
                Exception e) {
            e.printStackTrace();
        }
    }
}



