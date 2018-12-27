package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tk.takenoteapp.R;

import java.util.ArrayList;

import model.TextModel;

public class TagsAdapter extends  RecyclerView.Adapter<TagsAdapter.TagsHolder>{
    private Context context;
    private ArrayList<TextModel> notes;

    public TagsAdapter(Context context, ArrayList<TextModel> notes){
        this.context = context;
        this.notes = notes;
    }

    @Override
    public TagsHolder onCreateViewHolder(ViewGroup parent, int ViewType){
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_tags,parent,false);
        return new TagsHolder(view);
    }

    @Override
    public void onBindViewHolder(TagsHolder holder, int position){
        TextModel textModel = notes.get(position);
        holder.setDetails(textModel);
    }

    @Override
    public int getItemCount(){return notes.size();}

    public class TagsHolder extends RecyclerView.ViewHolder{
        private TextView txtTags;

        public TagsHolder(View itemView){
            super(itemView);
            txtTags = itemView.findViewById(R.id.tagName);
        }

        public void setDetails(TextModel textModel){
            txtTags.setText(textModel.getTags());

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    System.out.println("dede");
                }
            });
        }
    }
}
