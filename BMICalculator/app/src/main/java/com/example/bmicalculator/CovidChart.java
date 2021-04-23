package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

public class CovidChart extends AppCompatActivity {
    Button cases,deaths,vaccine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid_chart);

        cases = findViewById(R.id.cases);
        deaths = findViewById(R.id.deaths);
        vaccine = findViewById(R.id.vaccine);


        WebView webView = (WebView) findViewById(R.id.webview);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);



    // VACCINE "<iframe src="https://ourworldindata.org/explorers/coronavirus-data-explorer?zoomToSelection=true&pickerSort=desc&pickerMetric=population&Metric=People+vaccinated&Interval=Cumulative&Relative+to+Population=true&Align+outbreaks=false&country=BHR~BRA~CHL~FRA~DEU~HUN~IND~ISR~SRB~TUR~GBR~USA~URY&hideControls=true" loading="lazy" style="width: 100%; height: 600px; border: 0px none;"></iframe>"
        //"<iframe src="https://ourworldindata.org/explorers/coronavirus-data-explorer?zoomToSelection=true&hideControls=true&Metric=Confirmed+deaths&Interval=Cumulative&Relative+to+Population=false&Align+outbreaks=false&country=~OWID_WRL" loading="lazy" style="width: 100%; height: 600px; border: 0px none;"></iframe>"
    //"<iframe src="https://ourworldindata.org/grapher/full-list-cumulative-total-tests-per-thousand" loading="lazy" style="width: 100%; height: 600px; border: 0px none;"></iframe>"
        cases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String unencodedHtml =
                        "<iframe src=\"https://ourworldindata.org/explorers/coronavirus-data-explorer?zoomToSelection=true&hideControls=true&Metric=Confirmed+cases&Interval=Cumulative&Relative+to+Population=false&Align+outbreaks=false&country=IND~USA~GBR~CAN~DEU~FRA\" loading=\"lazy\" style=\"width: 100%; height: 600px; border: 0px none;\"></iframe>";
                String encodedHtml = Base64.encodeToString(unencodedHtml.getBytes(), Base64.NO_PADDING);
                webView.loadData(encodedHtml, "text/html", "base64");
            }
        });
        deaths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String unencodedHtml =
                        "<iframe src=\"https://ourworldindata.org/explorers/coronavirus-data-explorer?zoomToSelection=true&time=2020-03-01..latest&pickerSort=desc&pickerMetric=total_cases&hideControls=true&Metric=Confirmed+deaths&Interval=Cumulative&Relative+to+Population=false&Align+outbreaks=false&country=IND~USA~GBR~CAN~DEU~FRA\" loading=\"lazy\" style=\"width: 100%; height: 600px; border: 0px none;\"></iframe>";
                String encodedHtml = Base64.encodeToString(unencodedHtml.getBytes(), Base64.NO_PADDING);
                webView.loadData(encodedHtml, "text/html", "base64");
            }
        });
        vaccine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String unencodedHtml =
                        "<iframe src=\"https://ourworldindata.org/explorers/coronavirus-data-explorer?zoomToSelection=true&pickerSort=desc&pickerMetric=population&Metric=People+vaccinated&Interval=Cumulative&Relative+to+Population=true&Align+outbreaks=false&country=BHR~BRA~CHL~FRA~DEU~HUN~IND~ISR~SRB~TUR~GBR~USA~URY&hideControls=true\" loading=\"lazy\" style=\"width: 100%; height: 600px; border: 0px none;\"></iframe>";
                String encodedHtml = Base64.encodeToString(unencodedHtml.getBytes(), Base64.NO_PADDING);
                webView.loadData(encodedHtml, "text/html", "base64");
            }
        });
    }
}