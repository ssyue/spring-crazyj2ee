package jdbc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class ReadXml {
    public final static String URL = "jdbc:mysql://localhost:3306/test?characterEncoding=utf8&user=root&password=123456";

    public final static String SELECT = "select id from t  where pinyin_name=?";

    public final static String INSERT = "insert into t (pid,type,name,pinyin_name) values ";

    public final static int tagging_type = 20;

    public static void main(String[] args) {
            readfile();
        // convertToPinyin("北部新区");
        // System.out.println(select("appcid_1"));
         String pid= select( "province_"+convertToPinyin("广东省"));
         insert(pid,tagging_type,"东莞市","city_"+convertToPinyin("东莞市"));
         insert(pid,tagging_type,"中山市","city_"+convertToPinyin("中山市"));
         insert(pid,tagging_type,"潮州市","city_"+convertToPinyin("潮州市"));
         System.out.println(pid);
         
         String pid2= select( "province_"+convertToPinyin("湖北省"));
         insert(pid2,tagging_type,"仙桃市 ","city_"+convertToPinyin("仙桃市 "));
         insert(pid2,tagging_type,"天门市","city_"+convertToPinyin("天门市"));
         insert(pid2,tagging_type,"潜江市 ","city_"+convertToPinyin("潜江市"));
         insert(pid2,tagging_type,"神农架 ","city_"+convertToPinyin("神农架"));
         System.out.println(pid2);
        System.out.println(success + "==========");
    }

    static int success = 0;

    static void readfile() {
        try {
            @SuppressWarnings("resource")
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("/home/yuess/git/test/src/main/resources/city - all.csv"), "EUC-CN"));
            String line = reader.readLine();
            String nextline = reader.readLine();
            String uplever = line;
            String citylever = null;
            while (nextline != null) {
                String item[] = line.split(",");
                String nextItem[] = null;
                nextItem = nextline.split(",");
                if (item.length == 1 && nextItem.length == 1) {// 省级，１重复
                    String pinyin = convertToPinyin(item[0]);
                    insert("-1", tagging_type, item[0], "province_" + pinyin);
                    uplever = pinyin;
                } else if (item.length == 1 && nextItem.length > 1) {// 市级，５重复
                    String pid = select("province_" + uplever);
                    String pinyin = convertToPinyin(item[0]);
                    insert(pid, tagging_type, item[0], "city_" + pinyin);
                    citylever = pinyin;
                } else if (item.length > 1 && nextline.contains(",")) {// 县级，１重复
                    String pid = select("city_" + citylever);
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0, len = item.length; i < len; i++) {
                        String pinyin = convertToPinyin(item[i]);
                        sb.append("(" + pid + "," + tagging_type + ",'" + item[i] + "'," + "'countryside_"+citylever+"_"  + pinyin + "'),");
                    }
                    String sql = sb.toString().substring(0, sb.length() - 1);
                    System.out.println(sql);
                    insertAll(sql);
                } else if (item.length > 1 && !nextline.contains(",")) // 结束
                    break;
                line = nextline;
                nextline = reader.readLine();
            }
            String item[] = line.split(",");//最后一行数据
            String pid = select("city_" + citylever);
            StringBuilder sb = new StringBuilder();
            for (int i = 0, len = item.length; i < len; i++) {
                String pinyin = convertToPinyin(item[i]);
                sb.append("(" + pid + "," + tagging_type + ",'" + item[i] + "'," + "'countryside_"+citylever+"_" + pinyin + "'),");
            }
            String sql = sb.toString().substring(0, sb.length() - 1);
            insertAll(sql);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void insertAll(String string) {
        Connection conn = getConnection();
        PreparedStatement p = null;
        try {
            p = (PreparedStatement) conn.prepareStatement(INSERT + " " + string);
            int num = p.executeUpdate();
            System.out.println("=====批量插入====" + num);
            success = success + num;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (conn != null)
                try {
                    conn.close();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
            if (p != null)
                try {
                    p.close();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }

    private static String select(String convertToPinyin) {
        Connection conn = getConnection();
        PreparedStatement p = null;
        try {
            p = (PreparedStatement) conn.prepareStatement(SELECT);
            p.setString(1, convertToPinyin);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                return r.getString(1);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (conn != null)
                try {
                    conn.close();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
            if (p != null)
                try {
                    p.close();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
        }
        return convertToPinyin;
    }

    static void insert(String pid, int taggingType, String taggingName, String taggingApiName) {
        Connection conn = getConnection();
        PreparedStatement p = null;
        try {
            p = (PreparedStatement) conn.prepareStatement(INSERT + "(?,?,?,?)");
            p.setInt(1, Integer.parseInt(pid));
            p.setString(3, taggingName);
            p.setString(4, taggingApiName);
            p.setInt(2, taggingType);
            System.out.println("=========" + p.execute());
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (conn != null)
                try {
                    conn.close();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
            if (p != null)
                try {
                    p.close();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }

    static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection(URL);
            return conn;
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    static String convertToPinyin(String hanzi) {
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        format.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);  
        hanzi = hanzi.trim();
        int slen = hanzi.toCharArray().length;
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < slen; j++)
            try {
                sb.append(PinyinHelper.toHanyuPinyinStringArray(hanzi.charAt(j), format)[0]);
            }
            catch (BadHanyuPinyinOutputFormatCombination e) {
                e.printStackTrace();
            }
        System.out.println(sb.toString());
        return sb.toString();

    }
}
