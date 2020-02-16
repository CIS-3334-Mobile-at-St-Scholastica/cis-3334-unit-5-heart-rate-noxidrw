package css.cis3334.heartratetracker;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class HeartRateAdapter extends ArrayAdapter<HeartRate>{
    private final Context context;      // The activity calling this adapter
    private HeartRateList hrList;       // The object holding the arraylist of hear rates

    /**
     *
     * @param context The activity calling this adapter
     * @param rowLayout The xml file defining the layout for one item or row in the list
     * @param dummyTV the ID for a TextView in the row layout. Not used, but needed by the parent object
     * @param hrList The object holding the arraylist of hear rates
     */
    public HeartRateAdapter(Context context, int rowLayout, int dummyTV, HeartRateList hrList) {
        super(context, rowLayout, dummyTV, hrList.getList());
        this.context = context;
        this.hrList = hrList;
    }

    /**
     * This is called automatically to display each item in the list.
     *    Here you must fill the layout for one row or item in the list
     *
     * @param position index in the list that is being selected
     * @param convertView
     * @param parent The parent layout this list is in
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.heart_rate_row, null);
        //get the heart rate we are displaying
        HeartRate hr = hrList.getHeartRate(position);

        TextView labelPulse=(TextView)view.findViewById(R.id.lblPulse);
        TextView labelRange=(TextView)view.findViewById(R.id.lblRange);

        TextView tvPulse=(TextView)view.findViewById(R.id.textViewPulse);
        tvPulse.setText(hr.getPulse().toString());

        TextView tvRange=(TextView)view.findViewById(R.id.textViewRange);
        tvRange.setText(hr.getRangeName().toString());

        TextView tvSC=(TextView)view.findViewById(R.id.textViewSC);
        tvSC.setText(hr.getRangeDescrtiption().toString());

        if(hr.getRangeName() == "Resting"){
            tvPulse.setBackgroundColor(ContextCompat.getColor(context, R.color.colorRest));
            tvRange.setBackgroundColor(ContextCompat.getColor(context, R.color.colorRest));
            tvSC.setBackgroundColor(ContextCompat.getColor(context, R.color.colorRest));
            labelPulse.setBackgroundColor(ContextCompat.getColor(context, R.color.colorRest));
            labelRange.setBackgroundColor(ContextCompat.getColor(context, R.color.colorRest));
        }else if(hr.getRangeName() == "Moderate"){
            tvPulse.setBackgroundColor(ContextCompat.getColor(context, R.color.colorModerate));
            tvRange.setBackgroundColor(ContextCompat.getColor(context, R.color.colorModerate));
            tvSC.setBackgroundColor(ContextCompat.getColor(context, R.color.colorModerate));
            labelPulse.setBackgroundColor(ContextCompat.getColor(context, R.color.colorModerate));
            labelRange.setBackgroundColor(ContextCompat.getColor(context, R.color.colorModerate));
        }else if(hr.getRangeName() == "Endurance"){
            tvPulse.setBackgroundColor(ContextCompat.getColor(context, R.color.colorWeight));
            tvRange.setBackgroundColor(ContextCompat.getColor(context, R.color.colorWeight));
            tvSC.setBackgroundColor(ContextCompat.getColor(context, R.color.colorWeight));
            labelPulse.setBackgroundColor(ContextCompat.getColor(context, R.color.colorWeight));
            labelRange.setBackgroundColor(ContextCompat.getColor(context, R.color.colorWeight));
        }else if(hr.getRangeName() == "Aerobic"){
            tvPulse.setBackgroundColor(ContextCompat.getColor(context, R.color.colorCardio));
            tvRange.setBackgroundColor(ContextCompat.getColor(context, R.color.colorCardio));
            tvSC.setBackgroundColor(ContextCompat.getColor(context, R.color.colorCardio));
            labelPulse.setBackgroundColor(ContextCompat.getColor(context, R.color.colorCardio));
            labelRange.setBackgroundColor(ContextCompat.getColor(context, R.color.colorCardio));
        }else if(hr.getRangeName() == "Anaerobic"){
            tvPulse.setBackgroundColor(ContextCompat.getColor(context, R.color.colorHardCore));
            tvRange.setBackgroundColor(ContextCompat.getColor(context, R.color.colorHardCore));
            tvSC.setBackgroundColor(ContextCompat.getColor(context, R.color.colorHardCore));
            labelPulse.setBackgroundColor(ContextCompat.getColor(context, R.color.colorHardCore));
            labelRange.setBackgroundColor(ContextCompat.getColor(context, R.color.colorHardCore));
        }else if(hr.getRangeName() == "Red zone"){
            tvPulse.setBackgroundColor(ContextCompat.getColor(context, R.color.colorMax));
            tvRange.setBackgroundColor(ContextCompat.getColor(context, R.color.colorMax));
            tvSC.setBackgroundColor(ContextCompat.getColor(context, R.color.colorMax));
            labelPulse.setBackgroundColor(ContextCompat.getColor(context, R.color.colorMax));
            labelRange.setBackgroundColor(ContextCompat.getColor(context, R.color.colorMax));
        }

        return(view);
    }
}
