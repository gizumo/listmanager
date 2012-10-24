package jp.listmanager;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class RegistDao {
	
	private static final String TABLE_NAME = "ListDB";
	private static final String COLUMN_ID = "rowid";
	private static final String LIST_NAME = "name";
	private static final String LIST_TAG= "tag";
	private static final String[] ITEM =
	{ COLUMN_ID, LIST_NAME,LIST_TAG };

	private SQLiteDatabase db;

	public RegistDao(SQLiteDatabase db) {
		this.db = db;
	}

	/*
	 * データの挿入処理
	 */
	public long insert(RegistData registData) {
		ContentValues values = new ContentValues();
		values.put(LIST_NAME, registData.getListName());
		values.put(LIST_TAG, registData.getTag());
		// インサート文を発行
		// 戻り値(インサート処理　成功”追加した行番号”、失敗”-1”)を返す
		return db.insert(TABLE_NAME, null, values);
	}

	/*
	 * データの更新処理
	 */
	public int update(RegistData registData) {
		ContentValues values = new ContentValues();
		values.put(LIST_NAME, registData.getListName());
		values.put(LIST_TAG, registData.getTag());
		String whereClause = "rowid = " + registData.getRowid();
		return db.update(TABLE_NAME, values, whereClause, null);
	}

	/*
	 * 全レコード取得処理
	 */
	public List<RegistData> findAll() {
		List<RegistData> addressDataList = new ArrayList<RegistData>();

		// 第2引数：テーブルから取得対象となる列の配列、第7引数：ソートする列
		Cursor cursor = db.query(TABLE_NAME, ITEM, null, null, null, null, LIST_NAME);

		// 取得できたレコードの数だけ繰り返す　教科書195表5-5
		// moveToNext()は次のレコードが取得出来たらtrueを返す
		while(cursor.moveToNext()) {
			RegistData registData = new RegistData();
			registData.setRowid(cursor.getInt(0));
			registData.setListName(cursor.getString(1));
			registData.setTag(cursor.getString(2));
			// 取得したレコードをリストに詰めていく
			addressDataList.add(registData);
		}

		// テーブルから取得したレコードリストを返す
		return addressDataList;
	}

	/*
	 * 列番号を指定してレコード検索処理
	 */
	public RegistData findById(int rowId) {
		String selection = "rowid = " + rowId;
		Cursor cursor =
			db.query(TABLE_NAME, ITEM, selection, null, null, null, null);

		while(cursor.moveToNext()) {
			RegistData registData = new RegistData();
			registData.setRowid(cursor.getInt(0));
			registData.setName(cursor.getString(1));
			registData.setTag(cursor.getString(2));
			return registData;
		}

		// レコードが見つからない場合、nullを返す
		return null;
	}

	/*
	 * 全レコード削除
	 */
	public void deleteAll(String tableName) {

		db.delete(tableName, null, null);
		//db.close();
	}

	/*
	 * 行番号のレコードを削除処理
	 */
	public int delete(int rowId) {

		String whereClause = "rowid = " + rowId;
		return db.delete(TABLE_NAME, whereClause, null);
	}
	
}
