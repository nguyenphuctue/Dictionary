package uet.dictionary.repository;


import uet.dictionary.connection.MYSQLConnection;
import uet.dictionary.model.Word;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DictionaryRepositoryImpl implements DictionaryRepository {

    /**
     * Logic: Lấy danh sách các từ trong database
     */
    @Override
    public List<Word> getAllWords() {
        List<Word> words = new ArrayList<>();
        String query = "SELECT * FROM word";

        try (Connection connection = MYSQLConnection.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Word word = new Word();
                word.setId(rs.getInt(1));
                word.setWordTarget(rs.getString(2));
                word.setWordExplain(rs.getString(3));
                word.setPronounce(rs.getString(4));
                word.setWordType(rs.getString(5));
                words.add(word);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return words;
    }

    /**
     * Logic: Tìm kiếm từ bằng tiếng anh
     */
    @Override
    public Word getWordByEnglish(String wordTarget) {
        Word word = new Word();
        String query = "SELECT * FROM word WHERE wordTarget = ?";

        try (Connection connection = MYSQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, wordTarget);

            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                word.setId(rs.getInt(1));
                word.setWordTarget(rs.getString(2));
                word.setWordExplain(rs.getString(3));
                word.setPronounce(rs.getString(4));
                word.setWordType(rs.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return word;
    }

    /**
     * Logic: Tìm kiếm danh sách các từ bằng tiếng anh
     */
    @Override
    public List<Word> getListWordByEnglish(String wordTarget) {
        List<Word> words = new ArrayList<>();
        String query = "SELECT * FROM word WHERE wordTarget LIKE ?";

        try (Connection connection = MYSQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, wordTarget + "%");

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Word word = new Word();
                word.setId(rs.getInt(1));
                word.setWordTarget(rs.getString(2));
                word.setWordExplain(rs.getString(3));
                word.setPronounce(rs.getString(4));
                word.setWordType(rs.getString(5));
                words.add(word);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return words;
    }

    /**
     * Logic: Thêm từ vào từ điển
     */
    @Override
    public int insertWord(String wordTarget, String wordExplain, String pronounce, String wordType) {
        int row = 0;
        String query = "INSERT INTO word(wordTarget, wordExplain, pronounce, wordType) VALUE(?, ?, ?, ?)";

        try (Connection connection = MYSQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, wordTarget);
            preparedStatement.setString(2, wordExplain);
            preparedStatement.setString(3, pronounce);
            preparedStatement.setString(4, wordType);

            row = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return row;
    }

    /**
     * Logic: Sửa từ trong từ điển
     */
    @Override
    public int updateWord(String wordTarget, String wordExplain, String pronounce, String wordType) {
        int row = 0;
        String query = "UPDATE word SET wordExplain = ? , pronounce = ? , wordType = ? WHERE wordTarget = ?";

        try (Connection connection = MYSQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, wordExplain);
            preparedStatement.setString(2, pronounce);
            preparedStatement.setString(3, wordType);
            preparedStatement.setString(4, wordTarget);

            row = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return row;
    }

    /**
     * Logic: Xóa từ trong từ điển
     */
    @Override
    public int deleteWord(int id) {
        int row = 0;
        String query = "DELETE FROM word WHERE id = ?";
        try (Connection connection = MYSQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            row = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return row;
    }

    /**
     * Logic: Xuất dữ liệu ra file dictionary.txt
     */
    @Override
    public void exportToFile(List<Word> words) {
        try {
            FileWriter myWriter = new FileWriter("dictionary.txt");
            for (Word w : words) {
                myWriter.write(w.toString() + "\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}