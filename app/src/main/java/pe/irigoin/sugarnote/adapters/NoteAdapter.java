package pe.irigoin.sugarnote.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pe.irigoin.sugarnote.R;
import pe.irigoin.sugarnote.models.Note;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {

    private List<Note> notes;

    public NoteAdapter(List<Note> notes){
        this.notes = notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView picture;
        public TextView fullname;
        public TextView email;

        public ViewHolder(View itemView) {
            super(itemView);
            picture = (ImageView) itemView.findViewById(R.id.picture_image);
            fullname = (TextView) itemView.findViewById(R.id.fullname_text);
            email = (TextView) itemView.findViewById(R.id.email_text);
        }
    }

    @Override
    public NoteAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(NoteAdapter.ViewHolder viewHolder, int position) {
        Note note = this.notes.get(position);
        viewHolder.fullname.setText(note.getFullname());
        viewHolder.email.setText(note.getEmail());

    }

    @Override
    public int getItemCount() {
        return this.notes.size();
    }

}
