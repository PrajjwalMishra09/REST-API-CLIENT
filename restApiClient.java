import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

// Class declaration
public class RestApiClient {

    // Main method
    public static void main(String[] args) {
        try {
            // Define the API URL
            String apiURL = "https://jsonplaceholder.typicode.com/users/1"; // Example API

            // Create a URL object
            URL url = new URL(apiURL);

            // Open HTTP connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set request method to GET
            connection.setRequestMethod("GET");

            // Get response code
            int responseCode = connection.getResponseCode();
            System.out.println("HTTP Response Code: " + responseCode);

            // If response code is 200 (OK), read response
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
                );
                String inputLine;
                StringBuffer response = new StringBuffer();

                // Read response line by line
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Display response
                System.out.println("API Response:\n" + response.toString());
            } else {
                System.out.println("GET request failed.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
