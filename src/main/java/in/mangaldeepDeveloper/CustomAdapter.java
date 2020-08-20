package in.mangaldeepDeveloper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<HelperClass> {
    private Context context;
    private List<HelperClass> helperClassList;
    private List<HelperClass> helperClassListFiltered;

    public CustomAdapter(Context context, List<HelperClass> helperClassList) {
        super(context, R.layout.activity_corona_se_pidit_countries, helperClassList);

        this.context = context;
        this.helperClassList = helperClassList;
        this.helperClassListFiltered = helperClassList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listcuston, null,true);
        TextView countryName = view.findViewById(R.id.countryName);
        ImageView imageView = view.findViewById(R.id.flagImage);

        countryName.setText(helperClassListFiltered.get(position).getCountry());
        Glide.with(context).load(helperClassListFiltered.get(position).getFlags()).into(imageView);


        return view;
    }

    @Override
    public int getCount() {
        return helperClassListFiltered.size();
    }

    @Nullable
    @Override
    public HelperClass getItem(int position) {
        return helperClassListFiltered.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults  = new FilterResults();
                if (constraint == null || constraint.length() == 0){
                    filterResults.count = helperClassList.size();
                    filterResults.values = helperClassList;
                }else {
                    List<HelperClass> resultModel = new ArrayList<>();
                    String searchStr = constraint.toString().toLowerCase();

                    for (HelperClass itemsModel:helperClassList){
                        if (itemsModel.getCountry().toLowerCase().contains(searchStr)){
                            resultModel.add(itemsModel);
                        }
                        filterResults.count = resultModel.size();
                        filterResults.values = resultModel;
                    }
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
             helperClassListFiltered = (List<HelperClass>) results.values;
             CoronaSePiditCountries.helperClassList = (List<HelperClass>) results.values;
             notifyDataSetChanged();
            }
        };
        return filter;
    }
}
