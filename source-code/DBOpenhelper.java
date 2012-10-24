package jp.listmanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenhelper {
	
	private static final String DATABASE_NAME = "data";
	private static final int DATABASE_VERSION = 1;

	private static final String CREATE_LIST_TABLE_SQL =
		"create table List "
		+ "(rowid integer primary key autoincrement, "
		+ "name text not null, "
		+ "tag text not null";

	private static final String TABLE_SERCH="PRAGMA TABLE_INFO(CREATE_SCHEDULE_TABLE_SQL)";
	private static final String DROP_LIST_TABLE_SQL = "drop table if exists DB";

	public DBOpenhelper(Context context) {
		super(context,DATABASE_NAME ,null,DATABASE_VERSION);

	}

	public void onCreate(SQLiteDatabase db) {
		// 初期化処理 テーブル作成のクエリーを実行
		db.execSQL(CREATE_LIST_TABLE_SQL);

	}

	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		// 更新処理
		db.execSQL(DROP_LIST_TABLE_SQL);
		onCreate(db);

	}
}
