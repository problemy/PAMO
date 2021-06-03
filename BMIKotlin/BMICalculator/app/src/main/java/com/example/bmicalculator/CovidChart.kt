package com.example.bmicalculator

import android.os.Bundle
import android.util.Base64
import android.view.View
import android.webkit.WebView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class CovidChart : AppCompatActivity() {
    var cases: Button? = null
    var deaths: Button? = null
    var vaccine: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_covid_chart)
        cases = findViewById(R.id.cases) as Button
        deaths = findViewById(R.id.deaths)
        vaccine = findViewById(R.id.vaccine)
        val webView = findViewById<View>(R.id.webview) as WebView
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true


        // VACCINE "<iframe src="https://ourworldindata.org/explorers/coronavirus-data-explorer?zoomToSelection=true&pickerSort=desc&pickerMetric=population&Metric=People+vaccinated&Interval=Cumulative&Relative+to+Population=true&Align+outbreaks=false&country=BHR~BRA~CHL~FRA~DEU~HUN~IND~ISR~SRB~TUR~GBR~USA~URY&hideControls=true" loading="lazy" style="width: 100%; height: 600px; border: 0px none;"></iframe>"
        //"<iframe src="https://ourworldindata.org/explorers/coronavirus-data-explorer?zoomToSelection=true&hideControls=true&Metric=Confirmed+deaths&Interval=Cumulative&Relative+to+Population=false&Align+outbreaks=false&country=~OWID_WRL" loading="lazy" style="width: 100%; height: 600px; border: 0px none;"></iframe>"
        //"<iframe src="https://ourworldindata.org/grapher/full-list-cumulative-total-tests-per-thousand" loading="lazy" style="width: 100%; height: 600px; border: 0px none;"></iframe>"

        val _cases = cases;
        if (_cases != null) {
            _cases.setOnClickListener(View.OnClickListener {
                val unencodedHtml = "<iframe src=\"https://ourworldindata.org/explorers/coronavirus-data-explorer?zoomToSelection=true&hideControls=true&Metric=Confirmed+cases&Interval=Cumulative&Relative+to+Population=false&Align+outbreaks=false&country=IND~USA~GBR~CAN~DEU~FRA\" loading=\"lazy\" style=\"width: 100%; height: 600px; border: 0px none;\"></iframe>"
                val encodedHtml = Base64.encodeToString(unencodedHtml.toByteArray(), Base64.NO_PADDING)
                webView.loadData(encodedHtml, "text/html", "base64")
            })
        }
        val __deaths = deaths;
        if (__deaths != null) {
            __deaths.setOnClickListener(View.OnClickListener {
                val unencodedHtml = "<iframe src=\"https://ourworldindata.org/explorers/coronavirus-data-explorer?zoomToSelection=true&time=2020-03-01..latest&pickerSort=desc&pickerMetric=total_cases&hideControls=true&Metric=Confirmed+deaths&Interval=Cumulative&Relative+to+Population=false&Align+outbreaks=false&country=IND~USA~GBR~CAN~DEU~FRA\" loading=\"lazy\" style=\"width: 100%; height: 600px; border: 0px none;\"></iframe>"
                val encodedHtml = Base64.encodeToString(unencodedHtml.toByteArray(), Base64.NO_PADDING)
                webView.loadData(encodedHtml, "text/html", "base64")
            })
        }
        val __vaccine = vaccine;
        if (__vaccine != null) {
            __vaccine.setOnClickListener(View.OnClickListener {
                val unencodedHtml = "<iframe src=\"https://ourworldindata.org/explorers/coronavirus-data-explorer?zoomToSelection=true&pickerSort=desc&pickerMetric=population&Metric=People+vaccinated&Interval=Cumulative&Relative+to+Population=true&Align+outbreaks=false&country=BHR~BRA~CHL~FRA~DEU~HUN~IND~ISR~SRB~TUR~GBR~USA~URY&hideControls=true\" loading=\"lazy\" style=\"width: 100%; height: 600px; border: 0px none;\"></iframe>"
                val encodedHtml = Base64.encodeToString(unencodedHtml.toByteArray(), Base64.NO_PADDING)
                webView.loadData(encodedHtml, "text/html", "base64")
            })
        }
    }
}