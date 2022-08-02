package pl.sdacademy.java.advanced.exercises.nbp;

import org.codehaus.jackson.map.ObjectMapper;
import pl.sdacademy.java.advanced.exercises.nbp.model.Rate;
import pl.sdacademy.java.advanced.exercises.nbp.model.Root;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class App {
    /*
        https://api.nbp.pl
        https://freecodegenerators.com/code-converters/json-to-pojo
        logika dla usera:
        1. podaj currency
        2. podaj ilosc na wymianę
        3. zapis do pliku
        4. itp
         */
    public static void main(String[] args) throws IOException {
        // #1 połączenie się do api i pobranie treści wiadomości do zmiennej result
        URL nbp = new URL("http://api.nbp.pl/api/exchangerates/tables/a/?format=json");
        String result = "";
        try(BufferedReader br = new BufferedReader(new InputStreamReader(nbp.openConnection().getInputStream()))) {
            String inputLine;
            while((inputLine = br.readLine()) != null) {
                result += inputLine;
            }
        } catch (IOException ex) {
            System.out.println("Exception: " + ex);
        }

        // #2 mapping String result na obiekt Root
        ObjectMapper om = new ObjectMapper();
        Root root = om.readValue(result, Root[].class)[0];

        // #3 wyciągnięcie przykładowego rejta
        double usd = root.getRates().stream()
                .filter(r -> r.getCode().equals("USD"))
                //.mapToDouble(r -> r.getMid())
                .mapToDouble(Rate::getMid)
                .findFirst()
                .orElse(0);
        System.out.println("USD: " + usd);
    }
}
