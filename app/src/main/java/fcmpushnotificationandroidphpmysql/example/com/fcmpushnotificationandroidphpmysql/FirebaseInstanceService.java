package fcmpushnotificationandroidphpmysql.example.com.fcmpushnotificationandroidphpmysql;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class FirebaseInstanceService extends FirebaseInstanceIdService {
    @Override
    public void onTokenRefresh() {

        String token = FirebaseInstanceId.getInstance().getToken();

        registerTokenIntoDataBaseMYSQL(token);
    }

    private void registerTokenIntoDataBaseMYSQL(String token) {

        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("Token",token)
                .build();

        Request request = new Request.Builder()
                .url("https://psychoapp.000webhostapp.com/register.php")//url to register token in mysql
                .post(body)
                .build();

        try {
            client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
