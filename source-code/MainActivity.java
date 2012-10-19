package jp.listmanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	Button mRegistbtn;
	Button mListbtn;
	Button mmemobtn;

	private static final int MENU_ID_MENU1 = (Menu.FIRST + 1);

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		mRegistbtn = (Button) findViewById(R.id.m_registbtn);
		mRegistbtn.setOnClickListener(this);

		mListbtn = (Button) findViewById(R.id.m_listbtn);
		mListbtn.setOnClickListener(this);

		mmemobtn = (Button) findViewById(R.id.m_memo);
		mmemobtn.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		//統合時にはTest.classのTestを遷移先のクラスに変更することで解決
		if (v == mRegistbtn) {
			Intent intent = new Intent(MainActivity.this, Test.class);
			startActivity(intent);
		}
		if (v == mListbtn) {
			Intent intent = new Intent(MainActivity.this, Test.class);
			startActivity(intent);
		}
		if (v == mmemobtn) {
			Intent intent = new Intent(MainActivity.this, Test.class);
			startActivity(intent);
		}

	}
	
    // オプションメニューが最初に呼び出される時に1度だけ呼び出されます
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // メニューアイテムを追加します
        menu.add(Menu.NONE, MENU_ID_MENU1, Menu.NONE, "終了");
        return super.onCreateOptionsMenu(menu);
    }

    // オプションメニューアイテムが選択された時に呼び出されます
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean ret = true;
        switch (item.getItemId()) {
        default:
            ret = super.onOptionsItemSelected(item);
            break;
        case MENU_ID_MENU1:
            ret = true;
            finish();
            break;
        }
        return ret;
    }

}