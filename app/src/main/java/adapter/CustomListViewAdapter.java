package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.tk.takenoteapp.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

import model.RetroTextList;

public class CustomListViewAdapter extends ArrayAdapter<RetroTextList> {
    private final LayoutInflater layoutInflater;
    private final Context context;
    private ViewHolder holder;
    private final ArrayList<RetroTextList> textNotes;

    public CustomListViewAdapter(Context context, ArrayList<RetroTextList> textNotes){
        super(context, 0 , textNotes);
        this.context = context;
        this.textNotes = textNotes;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount(){
        return textNotes.size();
    }

    @Override
    public RetroTextList getItem(int position){
        return textNotes.get(position);
    }

    @Override
    public long getItemId(int position){
        return textNotes.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.list_view_item, null);

            holder = new ViewHolder();
            holder.subject = (TextView) convertView.findViewById(R.id.subject_name_label);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        RetroTextList textNote = textNotes.get(position);
        if(textNote != null){
            holder.subject.setText(textNote.getSubject());
        }
        return convertView;
    }

    private static class ViewHolder{
        TextView subject;
    }
}
