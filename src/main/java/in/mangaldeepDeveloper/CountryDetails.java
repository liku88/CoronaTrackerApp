package in.mangaldeepDeveloper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class CountryDetails extends AppCompatActivity {

    private int positionCountry;
    TextView country , cases, recovered , critical , active , todayCases , todayDeaths, totalDeaths ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_details);

        getSupportActionBar().setTitle("Country's Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Intent intent = getIntent();
        positionCountry = intent.getIntExtra("position", 0);

        country = findViewById(R.id.countryy);
        cases = findViewById(R.id.casess);
        recovered = findViewById(R.id.recoveredd);
        critical = findViewById(R.id.criticall);
        active = findViewById(R.id.activee);
        todayCases = findViewById(R.id.tdcasess);
        todayDeaths = findViewById(R.id.tddeaths);
        totalDeaths = findViewById(R.id.deathss);

        country.setText(CoronaSePiditCountries.helperClassList.get(positionCountry).getCountry());
        cases.setText(CoronaSePiditCountries.helperClassList.get(positionCountry).getCases());
        recovered.setText(CoronaSePiditCountries.helperClassList.get(positionCountry).getRecovered());
        critical.setText(CoronaSePiditCountries.helperClassList.get(positionCountry).getCritical());
        active.setText(CoronaSePiditCountries.helperClassList.get(positionCountry).getActive());
        todayCases.setText(CoronaSePiditCountries.helperClassList.get(positionCountry).getTodayCases());
        todayDeaths.setText(CoronaSePiditCountries.helperClassList.get(positionCountry).getTodayDeaths());
        totalDeaths.setText(CoronaSePiditCountries.helperClassList.get(positionCountry).getDeaths());

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}