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
    private RecyclerViewClickListener mListener;

    public NotesAdapter(Context context, ArrayList<TextModel> notes, RecyclerViewClickListener listener){
        this.context = context;
        this.notes = notes;
        mListener = listener;
    }


    @Override
    public NotesHolder onCreateViewHolder(ViewGroup parent, int ViewType){
        View view = LayoutInflater.from(context).inflate(R.layout.content_card_view,parent,false);
        return new NotesHolder(view,mListener);
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




    public class NotesHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView txtSubject, txtNote, txtDate;
        private RecyclerViewClickListener mListener;

        public NotesHolder(View itemView, RecyclerViewClickListener listener){
            super(itemView);
            txtSubject = itemView.findViewById(R.id.subjectD);
            txtNote = itemView.findViewById(R.id.noteD);
            txtDate = itemView.findViewById(R.id.dateD);
            mListener = listener;
            itemView.setOnClickListener(this);
        }

        public void setDetails(TextModel textModel){
            txtSubject.setText(textModel.getSubject());
            txtNote.setText(textModel.getNote());
            txtDate.setText(textModel.getCurrentTime().toString());
        }

        @Override
        public void onClick(View v) {
            mListener.onClick(v, getAdapterPosition());
        }
    }
}
