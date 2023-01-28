package com.example.podgotovka66;

import android.content.Context;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterMask extends BaseAdapter {

    public Context mContext;
    public List<Model> listModel;

    public AdapterMask(Context mContext, List<Model> listModel) {
        this.mContext = mContext;
        this.listModel = listModel;
    }

    @Override
    public int getCount() {
        return listModel.size();
    }

    @Override
    public Object getItem(int position) {
        return listModel.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listModel.get(position).getID();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(mContext,R.layout.item_mask,null);
        ImageView image = v.findViewById(R.id.image);
        TextView title = v.findViewById(R.id.title);
        TextView nameCost = v.findViewById(R.id.nameCost);
        TextView cost = v.findViewById(R.id.cost);
        TextView nameStockAvailability = v.findViewById(R.id.nameStockAvailability);
        TextView stockAvailability = v.findViewById(R.id.stockAvailability);
        TextView nameAvailabilityInTheStore = v.findViewById(R.id.nameAvailabilityInTheStore);
        TextView availabilityInTheStore = v.findViewById(R.id.availabilityInTheStore);
        TextView many = v.findViewById(R.id.many);
        TextView textDescription = v.findViewById(R.id.textDescription);
        TextView description = v.findViewById(R.id.description);
        TextView textRewiews = v.findViewById(R.id.textRewiews);
        TextView rewiews = v.findViewById(R.id.rewiews);


        Model model = listModel.get(position);
        title.setText(model.getTitle());
        cost.setText(Integer.toString(model.getCost()));
        if(model.getAvailabilityInTheStore()>5)
        {
            availabilityInTheStore.setText("Много");
        }
        else {
            availabilityInTheStore.setText(Integer.toString(model.getAvailabilityInTheStore()));
        }


        if(model.getStockAvailability()>5)
        {
            stockAvailability.setText("Много");
        }
        else {
            stockAvailability.setText(Integer.toString(model.getStockAvailability()));
        }

        description.setText(model.getDescription());
        rewiews.setText(model.getRewiews());

        image m = new image(mContext);
        image.setImageBitmap(m.getUserImage(model.getImage()));
        return v;
    }


}
