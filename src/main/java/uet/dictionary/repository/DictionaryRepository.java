package uet.dictionary.repository;

import uet.dictionary.model.Word;

import java.util.List;

public interface DictionaryRepository {
    List<Word> getAllWords();
    List<Word> getListWordByEnglish(String word_target);
    Word getWordByEnglish(String word_target);
    int insertWord(String word_target, String word_explain);
    void exportToFile(List<Word> words);
}

