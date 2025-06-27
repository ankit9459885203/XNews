// package com.crio.xnews;

// import java.io.IOException;
// import java.util.List;
// import java.util.Collections;

// public class NewsApiClient {

//     private static final String API_URL = "https://newsapi.org/v2/everything";
//     private static final String API_KEY = "f06ac10ac4de4538a1eb592001116d17";

// // TODO: CRIO_TASK_MODULE_PROJECT
// // Utilize the Okhttp3 library to send a request to the News API, including the provided query, language, and sortBy parameters.
// // Ensure that the Gradle dependency for Okhttp3 is included in build.gradle.
// // Parse the JSON response using NewsParser.
// // If the "query" parameter is empty, an IllegalArgumentException is thrown. 
// // If there is an error during the API request or response parsing, IOException is thrown.

//     public List<NewsArticle> fetchNewsArticles(String query, String language, String sortBy) throws IOException {

//         return Collections.emptyList();
//     }

// // TODO: CRIO_TASK_MODULE_PROJECT
// // Construct the URL required to make a request to the News API and use this in above method.
// // Refer to https://newsapi.org/docs/endpoints/everything for guidance on URL construction.
// // The "query" parameter is mandatory and must not be empty. 
// // If the "query" parameter is empty, throw IllegalArgumentException with message "Query parameter must not be empty".
// // The "language" and "sortBy" parameters are optional and will be included in the URL if they are non-empty.

//     private String buildUrl(String query, String language, String sortBy) {

//       return "";
//     }
// }

package com.crio.xnews;

import java.io.IOException;
import java.util.List;
import java.util.Collections;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.HttpUrl;

public class NewsApiClient {

    private static final String API_URL = "https://newsapi.org/v2/everything";
    private static final String API_KEY = "f06ac10ac4de4538a1eb592001116d17";
    private final OkHttpClient client = new OkHttpClient();

    public List<NewsArticle> fetchNewsArticles(String query, String language, String sortBy) throws IOException {
        if (query == null || query.trim().isEmpty()) {
            throw new IllegalArgumentException("Query parameter must not be empty");
        }

        String url = buildUrl(query, language, sortBy);

        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected response from API: " + response.code());
            }

            String json = response.body().string();
            return NewsParser.parse(json); // Assuming NewsParser has a static parse method.
        } catch (IOException e) {
            throw new IOException("Failed to fetch or parse news articles", e);
        }
    }

    private String buildUrl(String query, String language, String sortBy) {
        if (query == null || query.trim().isEmpty()) {
            throw new IllegalArgumentException("Query parameter must not be empty");
        }

        HttpUrl.Builder urlBuilder = HttpUrl.parse(API_URL).newBuilder()
                .addQueryParameter("q", query)
                .addQueryParameter("apiKey", API_KEY);

        if (language != null && !language.trim().isEmpty()) {
            urlBuilder.addQueryParameter("language", language);
        }

        if (sortBy != null && !sortBy.trim().isEmpty()) {
            urlBuilder.addQueryParameter("sortBy", sortBy);
        }

        return urlBuilder.build().toString();
    }
}
