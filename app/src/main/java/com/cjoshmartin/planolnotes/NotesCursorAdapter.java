package com.cjoshmartin.planolnotes;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by Josh on 11/25/15.
 Overwrites the existing cursor class to handle more complex request from the database to the interface. (i.e. multiline strings )

 */
public class NotesCursorAdapter extends CursorAdapter {


 public NotesCursorAdapter(Context context, Cursor c, int flags) {
  super(context, c, flags);
 }

 @Override
 public View newView(Context context, Cursor cursor, ViewGroup parent) {

  return LayoutInflater.from(context).inflate(R.layout.note_list_item,parent,false);
 }

 @Override
 public void bindView(View view, Context context, Cursor cursor) {


  String noteText = cursor.getString(cursor.getColumnIndex(DBOpenHelper.NOTE_TEXT));

  //looks for the position to see if the string has an newline then adds a " ..."
  int pos = noteText.indexOf(10);

  //seeing if a line feed is found
  if (pos != -1)
  {
  noteText=noteText.substring(0,pos) + "....";

  }
  //Prints text
  TextView tv = (TextView) view.findViewById(R.id.tvNote);
  tv.setText(noteText);

 }
}
