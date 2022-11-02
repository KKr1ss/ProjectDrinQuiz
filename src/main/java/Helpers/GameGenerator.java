/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helpers;

import Data.DrinQuizContext;
import Models.Game;
import java.util.List;
import Models.Question;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author akile
 */
public class GameGenerator {
    private DrinQuizContext _context;
    private Game game;
    
    public GameGenerator(){
        game = new Game();
        _context = new DrinQuizContext();
    }
    
    public void setChosenSources(String[] sources){
        if(sources.length == 0) {
            System.out.print("Nem választottál kategóriát!");
            return;
        }
        game.setSources(ConverterHelper.convertStringArrayToSeparatedString(sources));
        
    }
    public void setChosenCategories(String[] categories){
        game.setCategories(ConverterHelper.convertStringArrayToSeparatedString(categories));       
    }
    
    public String[] getSourcesCategories(){
        if(game.getSources() == null){
            System.out.print("Nincsen kiválasztott forrás");
            throw null;
        }
    
        String[] sources = ConverterHelper.convertSeparatedStringToStringArray(game.getSources());
        String[] categories;

        List<Question> questions = _context.Question.getAll();
        questions = questions.stream().filter(
                q -> Arrays.stream(sources).anyMatch(q.getSource()::contains)
        ).toList();
        
        Map<String, List<Question>> questionMap =
            questions.stream().collect(Collectors.groupingBy(q->q.getCategory()));
        
        categories = questionMap.keySet().toArray(new String[0]);

        return categories; 
    }
}
