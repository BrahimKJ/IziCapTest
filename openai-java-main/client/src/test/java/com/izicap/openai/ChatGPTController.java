package com.izicap.openai;

import com.fasterxml.jackson.databind.JsonNode;
import com.izicap.openai.OpenAiService;
import com.izicap.openai.completion.CompletionRequest;
import com.izicap.openai.completion.CompletionResult;
import com.izicap.openai.completion.CompletionChoice;

import org.junit.jupiter.api.Test;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class ChatGPTController {

    String token = System.getenv("OPENAI_TOKEN");
    OpenAiService service = new OpenAiService(token);

    @Test
    String createCompletion(String input) {
  
        CompletionRequest request = new CompletionRequest();
        request.setPrompt(input);
        request.setMaxTokens(1);
        CompletionResult response = service.createCompletion(request);
        String answer = response.toString();
        return answer;
      }
    private void storeAnswerInCSV(String question, String answer) throws IOException {
        FileWriter out = new FileWriter("answers.csv", true);
        try (CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT.withHeader("question", "answer"))) {
            printer.printRecord(question, answer);
}
}
    public void main(String[] args) throws IOException
    {
    	while(true) {
        String input;
        Scanner sc = new Scanner(System.in);
        input = sc.next();
    	String answer = createCompletion(input);
    	storeAnswerInCSV(input,answer);
    }
    }
}
