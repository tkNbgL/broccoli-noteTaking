package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tk.takenoteapp.R;

import java.util.ArrayList;
import java.util.List;

import model.TextModel;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesHolder>{
    private Context context;
    private ArrayList<TextModel> notes;

    public NotesAdapter(Context context, ArrayList<TextModel> notes){
        this.context = context;
        this.notes = notes;
    }


    @Override
    public NotesHolder onCreateViewHolder(ViewGroup parent, int ViewType){
        View view = LayoutInflater.from(context).inflate(R.layout.content_card_view,parent,false);
        return new NotesHolder(view);
    }

    @Override
    public void onBindViewHolder(NotesHolder holder, int position){
        TextModel textModel = notes.get(position);
        holder.setDetails(textModel);
    }

    @Override
    public int getItemCount(){
        return notes.size();
    }




    public class NotesHolder extends RecyclerView.ViewHolder {
        private TextView txtSubject, txtTag, txtNote;

        public NotesHolder(View itemView){
            super(itemView);
            txtSubject = itemView.findViewById(R.id.subjectD);
            txtTag = itemView.findViewById(R.id.tagsD);
            txtNote = itemView.findViewById(R.id.noteD);
        }

        public void setDetails(TextModel textModel){
            txtSubject.setText(textModel.getSubject());
            txtTag.setText(textModel.getTags());
            txtNote.setText(textModel.getNote());

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    System.out.println("dede");
                }
            });
        }

    }
}
