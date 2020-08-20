package in.mangaldeepDeveloper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.leo.simplearcloader.SimpleArcLoader;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.charts.ValueLineChart;
import org.eazegraph.lib.models.PieModel;
import org.eazegraph.lib.models.ValueLinePoint;
import org.eazegraph.lib.models.ValueLineSeries;
import org.json.JSONException;
import org.json.JSONObject;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {
    TextView cases , recovered , active , deaths , todayCases , todaydeaths, critical , affectedCountries;
    Button button;
    ScrollView scrollView;
    SimpleArcLoader simpleArcLoader;
    PieChart pieChart;
    ValueLineChart valueLineChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cases = findViewById(R.id.tcases);
        recovered = findViewById(R.id.recovered);
        active = findViewById(R.id.active);
        deaths = findViewById(R.id.deaths);
        todayCases = findViewById(R.id.today_cases);
        todaydeaths = findViewById(R.id.today_deaths);
        critical = findViewById(R.id.critical);
        affectedCountries = findViewById(R.id.countries);
        button = findViewById(R.id.track);
        scrollView = findViewById(R.id.scroll);
        simpleArcLoader = findViewById(R.id.loader);
        pieChart = findViewById(R.id.piechart);
        valueLineChart = findViewById(R.id.cubiclinechart);

        fetchApi();
    }

    private void fetchApi() {
        String api = "https://disease.sh/v3/covid-19/all";
        simpleArcLoader.start();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, api, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response.toString());
                    cases.setText(jsonObject.getString("cases"));
                    recovered.setText(jsonObject.getString("recovered"));
                    active.setText(jsonObject.getString("active"));
                    deaths.setText(jsonObject.getString("deaths"));
                    todayCases.setText(jsonObject.getString("todayCases"));
                    todaydeaths.setText(jsonObject.getString("todayDeaths"));
                    critical.setText(jsonObject.getString("critical"));
                    affectedCountries.setText(jsonObject.getString("affectedCountries"));
                    pieChart.addPieSlice(new PieModel("Cases",Integer.parseInt(cases.getText().toString()), Color.parseColor("#fed70e")));
                    pieChart.addPieSlice(new PieModel("Recoverd",Integer.parseInt(recovered.getText().toString()), Color.parseColor("#fe6da8")));
                    pieChart.addPieSlice(new PieModel("Deaths",Integer.parseInt(active.getText().toString()), Color.parseColor("#cda67f")));
                    pieChart.addPieSlice(new PieModel("Active",Integer.parseInt(deaths.getText().toString()), Color.parseColor("#56b7f1")));
                    pieChart.startAnimation();

                    ValueLineChart mCubicValueLineChart = (ValueLineChart) findViewById(R.id.cubiclinechart);
                    ValueLineSeries series = new ValueLineSeries();
                    series.setColor(0xFF56B7F1);
                    series.addPoint(new ValueLinePoint("Jan", 2.4f));
                    series.addPoint(new ValueLinePoint("Feb", 3.4f));
                    series.addPoint(new ValueLinePoint("Mar", .4f));
                    series.addPoint(new ValueLinePoint("Apr", 1.2f));
                    series.addPoint(new ValueLinePoint("Mai", 2.6f));
                    series.addPoint(new ValueLinePoint("Jun", 1.0f));
                    series.addPoint(new ValueLinePoint("Jul", 3.5f));
                    series.addPoint(new ValueLinePoint("Aug", 2.4f));
                    series.addPoint(new ValueLinePoint("Sep", 2.4f));
                    series.addPoint(new ValueLinePoint("Oct", 3.4f));
                    series.addPoint(new ValueLinePoint("Nov", .4f));
                    series.addPoint(new ValueLinePoint("Dec", 1.3f));

                    mCubicValueLineChart.addSeries(series);
                    mCubicValueLineChart.startAnimation();


                    simpleArcLoader.stop();
                    simpleArcLoader.setVisibility(View.GONE);
                    scrollView.setVisibility(View.VISIBLE);


                } catch (JSONException e) {

                    simpleArcLoader.stop();
                    simpleArcLoader.setVisibility(View.GONE);
                    scrollView.setVisibility(View.VISIBLE);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                simpleArcLoader.stop();
                simpleArcLoader.setVisibility(View.GONE);
                scrollView.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(stringRequest);
    }

    public void trackApi(View view) {
        startActivity(new Intent(getApplicationContext(),CoronaSePiditCountries.class));
    }
}