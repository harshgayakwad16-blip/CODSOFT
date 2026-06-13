import java.util.Scanner;
import java.net.HttpURLConnection;
import java.net.URL;

class CurrencyConverter {

    public static double getExchangeRate(String base, String target) {
        try {
            String apiUrl = "https://api.exchangerate-api.com/v4/latest/" + base;

            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            Scanner sc = new Scanner(conn.getInputStream());
            StringBuilder response = new StringBuilder();

            while (sc.hasNext()) {
                response.append(sc.nextLine());
            }
            sc.close();

            String json = response.toString();

            String searchKey = "\"" + target + "\":";
            int start = json.indexOf(searchKey) + searchKey.length();
            int end = json.indexOf(",", start);

            if (end == -1) {
                end = json.indexOf("}", start);
            }

            return Double.parseDouble(json.substring(start, end));

        } catch (Exception e) {
            System.out.println("Error fetching exchange rate!");
            return -1;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== CURRENCY CONVERTER =====");

        System.out.print("Enter Base Currency (USD, INR, EUR): ");
        String baseCurrency = sc.next().toUpperCase();

        System.out.print("Enter Target Currency (USD, INR, EUR): ");
        String targetCurrency = sc.next().toUpperCase();

        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();

        double rate = getExchangeRate(baseCurrency, targetCurrency);

        if (rate != -1) {
            double convertedAmount = amount * rate;

            System.out.println("\nExchange Rate : " + rate);
            System.out.println("Converted Amount : " + convertedAmount + " " + targetCurrency);
        }

        sc.close();
    }
}