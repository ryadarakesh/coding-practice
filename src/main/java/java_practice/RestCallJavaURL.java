package java_practice;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RestCallJavaURL {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://restcountries.com/v3.1/lang/german");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("accept", "application/json");
            InputStream stream = connection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(stream));
            String s ;
            StringBuffer result = new StringBuffer("");
            while ( (s= br.readLine())!= null) {
                result.append(s);
            }
            System.out.println(result);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
