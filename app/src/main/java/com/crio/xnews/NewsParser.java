// package com.crio.xnews;

// import java.io.IOException;
// import java.util.List;
//  import java.util.Collections;

// import com.fasterxml.jackson.databind.ObjectMapper;

// public class NewsParser {
//     private static final ObjectMapper objectMapper = new ObjectMapper();

// // TODO: CRIO_TASK_MODULE_PROJECT
// // Deserialize JSON String representing the response from the News API and 
// // then return the list of NewsArticle objects contained in the response.

//     public static List<NewsArticle> parse(String json) throws IOException {

//         NewsArticle[]  article = objectMapper.readValue(json, NewsArticle[].class);

//         return  List.of(article);
//     }
// }

package com.crio.xnews;

import java.io.IOException;
import java.util.List;
import java.util.Arrays;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class NewsParser {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static List<NewsArticle> parse(String json) throws IOException {
        // Step 1: Parse the whole JSON into a tree
        JsonNode root = objectMapper.readTree(json);

        // Step 2: Get only the "articles" array
        JsonNode articlesNode = root.path("articles");

        // Step 3: Convert "articles" JSON array to NewsArticle[]
        NewsArticle[] articles = objectMapper.treeToValue(articlesNode, NewsArticle[].class);

        return Arrays.asList(articles);
    }
}
