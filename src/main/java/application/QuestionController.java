package application;


import gap.TextGapper;
import models.Question;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import utils.HtmlParser;

import java.util.ArrayList;

/**
 * Created by benkrasi on 9/17/17.
 */
@RestController
public class QuestionController {


    @RequestMapping("/questions")
    public ArrayList<Question> questions(@RequestParam(value="url") String url) {
        String inputText = HtmlParser.parseHtml(url);

        TextGapper tg = new TextGapper();
        ArrayList<Question> generatedQuestions = new ArrayList<>(tg.getQuestions(inputText));

        return generatedQuestions;
    }
}
