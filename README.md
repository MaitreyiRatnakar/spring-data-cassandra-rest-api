# Coding exercise 
Create REST API to perform CRUD Operation for Article Data using Spring Data with Cassandra.

- To perform this exercise, I have created a spring boot app with spring data. Spring boot app is chosen to make the application portable and runnable on any java machine. 
- Swagger interface is provided for API documentation and ease of accessibility.
- Gradle is used as a build tool and is integrated as part of the codebase. Thus, requires no additional set up.
- Mockito is used as a mocking tool while writing unit tests.

## Swagger

![Swagger](/img/swagger-sample.JPG)


### Endpoints

This app is configured to run on port 9999. Following endpoints can be used to perform CRUD operation.

#### GET ARTICLES
To get all the articles in JSON format using the following endpoint. Optionally, you can add a limit filter to restrict a number of articles.

```
GET localhost:9999/artiles?limit=1
```
#### CREATE ARTICLES
To create new article entry in Cassandra DB, you can use the following POST endpoint with a valid JSON payload.

```
POST localhost:9999/artiles
{
  "id" : 2,
  "title" : "Google will ask: 'Are you depressed?'",
  "description" : "\"People searching for \u201Cdepression\u201D on Google will soon be prompted to take a questionnaire to assess if they may be suffering from the illness. The search giant has partnered with the US National Alliance on Mental Illness (Nami) to roll out the project which is currently only for US users. Users searching for depression will be prompted to \u201Ccheck if you\u2019re clinically depressed\u201D. \u201CWhile this tool can help, it\u2019s important to note that PHQ-9 is not meant to act as a singular tool for diagnosis,\u201D Nami said. In a blog post announcing the news, Nami said the test should not be seen as replacing the insight of qualified mental health professionals - was instead a method to help people get the right help more quickly.\"\"By tapping \u201CCheck if you\u2019re clinically depressed,\u201D you can take this private self-assessment to help determine your level of depression and the need for an in-person evaluation,\u201D the organisation explained. \"\"The results of the PHQ-9 can help you have a more informed conversation with your doctor.\"\"'Trouble concentrating?'The question will appear in the Knowledge Panel - the box that appears at the top of results when users search on a mobile device. Typically this panel is used for factual information, including details drawn from Wikipedia entries.The Patient Health Questionnaire-9 is a series of nine questions about the subject\u2019s mental health. It asks how often you feel you have \u201Clittle interest or pleasure in doing things\u201D or \u201Ctrouble concentrating on things, such as reading the newspaper or watching television?\u201D. Various studies have concluded it is a concise, reliable way to accurately detect signs of clinical depression.Speaking to the Financial Times, Google product manager Vidushi Tekriwal said users who fill out the test will not have their answers logged by the company, nor would advertising be targeted to them as a result. However, one psychotherapist said the idea seemed \"\"terribly redundant\"\". Someone googling depression will probably not find more useful information via a short diagnostic than they have already surfaced in search results, argued Dr Aaron Balick, author of \"\"The Psychodynamics of Social Netowrking\"\". \"\"A better approach would be some sort of acknowledgment that the searcher may be feeling down, and offering them resources and a direct line - perhaps a chat box - to local psychological services,\"\" he told the BBC.",
  "author" : "Dave Lee",
  "tags" : "Google, depression",
  "created_at" : "11.15.2016",
  "updated_at" : "11.18.2016"
} 
```
#### DELETE ARTICLE
To delete an article use following DELETE endpoint. The ID field is required to delete an entry.

```
DELETE localhost:9999/artiles/{ID}
```
#### UPDATE ARTICLE
To update an existing article entry use following PUT endpoint. The ID needs to exist in order to successfully update article.

```
PUT localhost:9999/artiles
{
  "id" : 2,
  "title" : "Google will ask: 'Are you depressed?'",
  "description" : "\"People searching for \u201Cdepression\u201D on Google will soon be prompted to take a questionnaire to assess if they may be suffering from the illness. The search giant has partnered with the US National Alliance on Mental Illness (Nami) to roll out the project which is currently only for US users. Users searching for depression will be prompted to \u201Ccheck if you\u2019re clinically depressed\u201D. \u201CWhile this tool can help, it\u2019s important to note that PHQ-9 is not meant to act as a singular tool for diagnosis,\u201D Nami said. In a blog post announcing the news, Nami said the test should not be seen as replacing the insight of qualified mental health professionals - was instead a method to help people get the right help more quickly.\"\"By tapping \u201CCheck if you\u2019re clinically depressed,\u201D you can take this private self-assessment to help determine your level of depression and the need for an in-person evaluation,\u201D the organisation explained. \"\"The results of the PHQ-9 can help you have a more informed conversation with your doctor.\"\"'Trouble concentrating?'The question will appear in the Knowledge Panel - the box that appears at the top of results when users search on a mobile device. Typically this panel is used for factual information, including details drawn from Wikipedia entries.The Patient Health Questionnaire-9 is a series of nine questions about the subject\u2019s mental health. It asks how often you feel you have \u201Clittle interest or pleasure in doing things\u201D or \u201Ctrouble concentrating on things, such as reading the newspaper or watching television?\u201D. Various studies have concluded it is a concise, reliable way to accurately detect signs of clinical depression.Speaking to the Financial Times, Google product manager Vidushi Tekriwal said users who fill out the test will not have their answers logged by the company, nor would advertising be targeted to them as a result. However, one psychotherapist said the idea seemed \"\"terribly redundant\"\". Someone googling depression will probably not find more useful information via a short diagnostic than they have already surfaced in search results, argued Dr Aaron Balick, author of \"\"The Psychodynamics of Social Netowrking\"\". \"\"A better approach would be some sort of acknowledgment that the searcher may be feeling down, and offering them resources and a direct line - perhaps a chat box - to local psychological services,\"\" he told the BBC.",
  "author" : "Dave Lee",
  "tags" : "Google, depression",
  "created_at" : "11.15.2016",
  "updated_at" : "11.18.2016"
} 
```

### Adding Data to Cassandra

Use the sample INSERT queries provided to add data. You can also use POST endpoint to create a new "Article" entry.       
**Note:**  
- POST body should be valid JSON to add data successfully. 
- "Description" string data is tricky and need to be escaped string to have valid JSON.
- You can use online JSON string escape tools. Use this [link](https://www.freeformatter.com/json-escape.html "Freeformatter") to access the tool. 
