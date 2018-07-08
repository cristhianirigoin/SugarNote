package pe.irigoin.sugarnote.repositories;

import com.orm.SugarRecord;

import java.util.List;

import pe.irigoin.sugarnote.models.Note;
public class NoteRepository {

    public static List<Note> list(){
        List<Note> notes = SugarRecord.listAll(Note.class);
        return notes;
    }

    public static Note read(Long id){
        Note note = SugarRecord.findById(Note.class, id);
        return note;
    }

    public static void create(String fullname, String email, String password){
        Note note = new Note(fullname, email, password);
        SugarRecord.save(note);
    }

    public static void update(String fullname, String email, String password, Long id){
        Note note = SugarRecord.findById(Note.class, id);
        note.setFullname(fullname);
        note.setEmail(email);
        note.setPassword(password);
        SugarRecord.save(note);
    }

    public static void delete(Long id){
        Note note = SugarRecord.findById(Note.class, id);
        SugarRecord.delete(note);
    }

}
