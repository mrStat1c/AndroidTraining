package com.example.androidtraining;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidtraining.utils.NetworkHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;

public class VkActivity extends AppCompatActivity {

    private EditText searchField;
    private Button searchButton;
    private TextView result;
    private TextView errorMessage;
    private ProgressBar loadingInd;

    private void showResultTextView() {
        result.setVisibility(View.VISIBLE);
        errorMessage.setVisibility(View.INVISIBLE);
    }

    private void showErrorTextView() {
        result.setVisibility(View.INVISIBLE);
        errorMessage.setVisibility(View.VISIBLE);
    }


    @Override
    protected void onCreate(Bundle savedInstancesState) {
        super.onCreate(savedInstancesState);
        setContentView(R.layout.vk_layout);

        this.searchField = findViewById(R.id.et_search_field);
        this.searchButton = findViewById(R.id.b_search_vk);
        this.result = findViewById(R.id.tv_vk_result);
        this.errorMessage = findViewById(R.id.tv_error_message);
        this.loadingInd = findViewById(R.id.pb_loading_ind);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                URL generatedUrl = NetworkHelper.generateUrl(searchField.getText().toString());
                new VKQueryTask().execute(generatedUrl);
            }
        };

        searchButton.setOnClickListener(onClickListener);

    }

    /**
     * Отдельный поток для выполнения Get запроса
     * URL - тип входного параметра, Void - тип данных во время выполнения (???),
     * String - тип результата
     */
    class VKQueryTask extends AsyncTask<URL, Void, String> {


        @Override
        protected void onPreExecute() {
            loadingInd.setVisibility(View.VISIBLE);
        }

        /**
         * Основная работа потока
         */
        @Override
        protected String doInBackground(URL... urls) {
            String response = null;
            try {
                response = NetworkHelper.gerResponseFromUrl(urls[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return response;
        }

        /**
         * Работа, которую нужно выполнить после выполнения doInBackground()
         */
        @Override
        protected void onPostExecute(String response) {
            String firstName = null;
            String lastName = null;
            if (response != null && !response.equals("")) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    JSONArray jsonArray = jsonResponse.getJSONArray("response");
                    String resultString = "";
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject userInfo = jsonArray.getJSONObject(i);
                        firstName = userInfo.getString("first_name");
                        lastName = userInfo.getString("last_name");
                        resultString += "Имя: " + firstName + "\n" + "Фамилия: " + lastName + "\n\n";
                    }
                    result.setText(resultString);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                showResultTextView();
            } else {
                showErrorTextView();
            }
            loadingInd.setVisibility(View.INVISIBLE);
        }
    }

}
