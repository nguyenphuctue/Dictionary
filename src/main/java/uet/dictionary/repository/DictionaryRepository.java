package uet.dictionary.repository;

import uet.dictionary.model.Word;

import java.util.List;

public interface DictionaryRepository {
    List<Word> getAllWords();

    List<Word> getListWordByEnglish(String wordTarget);

    Word getWordByEnglish(String wordTarget);

    int insertWord(String wordTarget, String wordExplain, String pronounce, String wordType);

    int updateWord(String wordTarget, String wordExplain, String pronounce, String wordType);

    int deleteWord(int id);

    void exportToFile(List<Word> words);
}

