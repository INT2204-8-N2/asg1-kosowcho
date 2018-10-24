package SpeechToText;



import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SpeechRecognition {

    private final String API_KEY = "MyKey";

    //60556d09-0e84-42b7-8974-9d0b01cfee33
    //936e9bf4-b019-494d-9cfc-931a62bc0886
    private final String REQUEST = "https://asr.yandex.net/asr_xml?" +
            "uuid=01ae133b744759b58fb536d566daa1e6" +
            "&key=" + "936e9bf4-b019-494d-9cfc-931a62bc0886" +
            "&topic=queries" +
            "&lang=en-US";

    public String getString(byte[] data) {
        String res = "";
        try {
            
            URL url = new URL(REQUEST);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "audio/x-pcm;bit=16;rate=16000");//audio/x-pcm;bit=16;rate=16000 || audio/x-wav
            connection.setRequestProperty("User-Agent", "BoBa");
            connection.setRequestProperty("Host", "asr.yandex.net");
            connection.setRequestProperty("Content-Length", "" + data.length);
            connection.setRequestProperty("Transfer-Encoding", "chunked");

            connection.setUseCaches(false);
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.write(data);
            wr.flush();
            wr.close();


            System.out.println("Done");
            System.out.println();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String decodedString;
            while ((decodedString = in.readLine()) != null) {
                res += decodedString;
            }
            connection.disconnect();

        } catch (MalformedURLException c) {
            c.printStackTrace();
        } catch (ProtocolException p) {
            p.printStackTrace();
        } catch (IOException i) {
            i.printStackTrace();
        }

        return res;
    }
}
