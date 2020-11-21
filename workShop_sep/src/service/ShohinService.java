package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.ShohinBean;


public class ShohinService {
	// 問① 接続情報を記述してください
    /** ドライバーのクラス名 */
    private static final String POSTGRES_DRIVER = "org.postgresql.Driver";
    /** ・JDMC接続先情報 */
    private static final String JDBC_CONNECTION =  "jdbc:postgresql://localhost:5432/Employee";
    /** ・ユーザー名 */
    private static final String USER = "postgres";
    /** ・パスワード */
    private static final String PASS = "postgres";
    /** ・タイムフォーマット */
    static //    private static final String TIME_FORMAT = "yyyy/MM/dd hh:mm:ss";
    ArrayList<ShohinBean> ArrayList = new ArrayList<ShohinBean>();
    // 問② 入力された値を、INSERTする文
    /** ・SQL INSERT文 */
//    private static final String SQL_INSERT = "INSERT INTO drink_table(id,name,price,stock,ImgURL)"+"VALUES(?,?,?,?,?)";

    // 問③ 入力されたIDをキーにして、検索するSELECT文
    /** ・SQL SELECT文 */
    private static final String SQL_SELECT = "SELECT * FROM Items";

    static ShohinBean drinkDate = null;

    // 送信されたIDとPassWordを元に社員情報を検索するためのメソッド

    public static ArrayList<ShohinBean> search() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        try {
            // データベースに接続
            Class.forName(POSTGRES_DRIVER);
            connection = DriverManager.getConnection(JDBC_CONNECTION, USER, PASS);
            statement = connection.createStatement();
            preparedStatement = connection.prepareStatement(SQL_SELECT);

//            preparedStatement.setInt(1, price);
            // SQLを実行。実行した結果をresultSetに格納。
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                // 問⑦ tmpName,tmpComment,tmpLoginTimeに適当な値を入れてください。
                String tmpName = resultSet.getString("name");
                Integer tmpPrice = resultSet.getInt("price");
                String tmpImg = resultSet.getString("img_url");

                // 問⑧ drinkBeanに取得したデータを入れてください。
                drinkDate = new ShohinBean();
                drinkDate.setName(tmpName);
                drinkDate.setPrice(tmpPrice);
                drinkDate.setImgURL(tmpImg);
                ArrayList.add(drinkDate);
            }
            // forName()で例外発生
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            // getConnection()、createStatement()、executeQuery()で例外発生
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ArrayList;
    }
}
