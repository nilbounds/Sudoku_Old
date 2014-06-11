package com.hatcloud.sudoku;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;

public class Sudoku extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sudoku);
		
		
		
		//Ϊ���а�ť����һ��������	
		View continueButton = findViewById(R.id.button_continue_game);
		continueButton.setOnClickListener((OnClickListener) this);
		
		View startNewGameButton = findViewById(R.id.button_new_game);
		startNewGameButton.setOnClickListener((OnClickListener) this);
		
		View rankListButton = findViewById(R.id.button_ranking_list);
		rankListButton.setOnClickListener((OnClickListener) this);
		
		View aboutButton = findViewById(R.id.button_about);
		aboutButton.setOnClickListener( this);
		
		View exitButton = findViewById(R.id.button_exit);
		exitButton.setOnClickListener((OnClickListener) this);
	}
	
	public void onClick(View v){
		switch(v.getId()){
		
			case R.id.button_continue_game:        
				startGame(Game.DIFFICULTY_CONTINUE);        
				break;
		
			case R.id.button_new_game:
				openNewGameDialog();
				break;
				
			case R.id.button_about:
				Intent i = new Intent(this,About.class);
				startActivity(i);
				break;
			
			case R.id.button_exit:
				finish();
				break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}

	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
			case R.id.settings:
				startActivity(new Intent(this,Prefs.class));
				return true;
				
			//����Ĳ˵�ѡ��...
		}
		return false;
	}
	
	//��ʾ��Ϸ�Ѷ�ѡ��Ի���
	private static final String TAG = "Sudoku";
	private void openNewGameDialog(){
		new AlertDialog.Builder(this)
			.setTitle(R.string.sudoku_difficulty_title)
			.setItems(R.array.difficulty, 
					new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int i) {
							// TODO �Զ����ɵķ������
							startGame(i);
						}
					})
			.show();
	}
	private void startGame(int i) {
	      Log.d(TAG, "clicked on " + i);
	      Intent intent = new Intent(this, Game.class);
	      intent.putExtra(Game.KEY_DIFFICULTY, i);
	      startActivity(intent);
	}

	
	
	@Override
	protected void onPause() {
		// TODO �Զ����ɵķ������
		super.onPause();
		Music.stop(this);
	}

	@Override
	protected void onResume() {
		// TODO �Զ����ɵķ������
		super.onResume();
		Music.play(this, R.raw.main);
		
	}
	
	
	

}
