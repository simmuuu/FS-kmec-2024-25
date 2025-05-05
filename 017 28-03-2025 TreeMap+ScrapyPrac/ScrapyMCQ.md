# Scrapy - MCQ  

### Question 1  
**In Scrapy, what does the start_urls attribute do?**  

- a. Registers middleware  
- b. Automatically triggers the `parse()` method for each URL  
- c. Stores downloaded pages  
- d. Defines URLs for MongoDB  

<details>  
  <summary>Answer & Explanation</summary>  

  **Answer:** b. Automatically triggers the `parse()` method for each URL.  

  **Explanation:**  
  The `start_urls` attribute contains a list of URLs that Scrapy will start crawling from. Scrapy sends requests to each URL in this list and calls the `parse()` method with the response.  
</details>  

---

### Question 2  
**What happens if the next_page selector returns None?**  

- a. Scrapy restarts from the first page  
- b. Scrapy skips the URL  
- c. The crawl ends gracefully  
- d. Scrapy throws an error  

<details>  
  <summary>Answer & Explanation</summary>  

  **Answer:** c. The crawl ends gracefully.  

  **Explanation:**  
  If `next_page` is `None`, Scrapy does not throw an error. Instead, it simply stops requesting new pages and ends the crawl normally.  
</details>  

---

### Question 3  
**What is the primary role of the Scrapy Engine?**  

- a. Coordinate requests, responses, and items between components  
- b. Send data to MongoDB  
- c. Render JavaScript-based pages  
- d. Manage HTML parsing  

<details>  
  <summary>Answer & Explanation</summary>  

  **Answer:** a. Coordinate requests, responses, and items between components.  

  **Explanation:**  
  The Scrapy Engine is responsible for controlling the data flow between the Downloader, Spider, and Item Pipeline, making sure requests and responses are processed correctly.  
</details>  

---

### Question 4  
**What is the purpose of defining an Item class in Scrapy?**  

- a. Automatically maps to MongoDB  
- b. Provides structured data containers  
- c. Stores request headers  
- d. Replaces the `parse()` method  

<details>  
  <summary>Answer & Explanation</summary>  

  **Answer:** b. Provides structured data containers.  

  **Explanation:**  
  The `Item` class in Scrapy is used to define a structured container for storing scraped data. It ensures consistency and easier processing in pipelines.  
</details>  

---

### Question 5  
**What is the result of calling `insert_one()` in `process_item()` but forgetting to close the client in `close_spider()`?**  

- a. It works, but may cause a memory leak or leave open connections  
- b. Data will not be written at all  
- c. MongoDB auto-closes everything safely  
- d. Scrapy crashes  

<details>  
  <summary>Answer & Explanation</summary>  

  **Answer:** a. It works, but may cause a memory leak or leave open connections.  

  **Explanation:**  
  If the MongoDB client is not closed, the connection may remain open indefinitely, leading to potential resource leaks and excessive database connections.  
</details>  

---

### Question 6  
**What will happen if you forget to return the item in `process_item()`?**  

- a. MongoDB inserts an empty document  
- b. It crashes  
- c. Scrapy skips it  
- d. Data will not pass to next pipeline or output  

<details>  
  <summary>Answer & Explanation</summary>  

  **Answer:** d. Data will not pass to next pipeline or output.  

  **Explanation:**  
  The `process_item()` method must return the processed item, or it will not be passed to the next pipeline component or stored.  
</details>  

---

### Question 7  
**Where is the MongoDB connection usually initialized in a Scrapy pipeline?**  

- a. `parse()`  
- b. `settings.py`  
- c. `open_spider()`  
- d. `__init__()`  

<details>  
  <summary>Answer & Explanation</summary>  

  **Answer:** c. `open_spider()`.  

  **Explanation:**  
  The `open_spider()` method is called when the spider starts, making it a good place to initialize the database connection.  
</details>  

---

### Question 8  
**Which CSS selector correctly extracts quote text?**  

- a. `span.text::text`  
- b. `div.author`  
- c. `a.tag[href]`  
- d. `div.quote-text::value`  

<details>  
  <summary>Answer & Explanation</summary>  

  **Answer:** a. `span.text::text`.  

  **Explanation:**  
  The text of a quote is typically inside a `<span>` element with the class `text`, so `span.text::text` correctly extracts it.  
</details>  

---

### Question 9  
**Which line extracts all tag texts for a quote?**  

- a. `q.css('a.tag::href').getall()`  
- b. `q.select('tags').all()`  
- c. `q.css('div.tags a.tag::text').getall()`  
- d. `q.css('div.tags a.tag').get()`  

<details>  
  <summary>Answer & Explanation</summary>  

  **Answer:** c. `q.css('div.tags a.tag::text').getall()`.  

  **Explanation:**  
  This selector finds all `<a>` elements inside `div.tags` and extracts their text using `::text`, returning a list of tag names.  
</details>  

---

### Question 10  
**Which method in a Spider is called for each response?**  

- a. `parse()`  
- b. `yield()`  
- c. `start_requests()`  
- d. `scrape()`  

<details>  
  <summary>Answer & Explanation</summary>  

  **Answer:** a. `parse()`.  

  **Explanation:**  
  The `parse()` method is the default method in Scrapy Spiders that processes each response received from the crawler.  
</details>  

---

### Question 11  
**Which of the following can be returned from a Spider's `parse()` method?**  

- a. Either Items or Requests  
- b. Only Response objects  
- c. Only Requests  
- d. Only Items  

<details>  
  <summary>Answer & Explanation</summary>  

  **Answer:** a. Either Items or Requests.  

  **Explanation:**  
  The `parse()` method can return both Scrapy Items (structured data) and Requests (for further crawling).  
</details>  

---

### Question 12  
**Which setting enables a custom pipeline in Scrapy?**  

- a. `ITEM_STORAGE_BACKEND`  
- b. `SPIDER_PIPELINE`  
- c. `ITEM_PIPELINES`  
- d. `MONGO_PIPELINE`  

<details>  
  <summary>Answer & Explanation</summary>  

  **Answer:** c. `ITEM_PIPELINES`.  

  **Explanation:**  
  The `ITEM_PIPELINES` setting is used in `settings.py` to define and activate custom processing pipelines.  
</details>  

---

### Question 13  
**Why is `dict(item)` used before inserting into MongoDB?**  

- a. To remove metadata  
- b. To convert the response to JSON  
- c. MongoDB only accepts strings  
- d. Items are not serializable directly  

<details>  
  <summary>Answer & Explanation</summary>  

  **Answer:** d. Items are not serializable directly.  

  **Explanation:**  
  Scrapy Items are not directly JSON serializable, so converting them to dictionaries makes them compatible with MongoDB.  
</details>  

---

### Question 14  
**Why might this CSS selector return None? `quote.css('div.text::text').get()`**  

- a. The site uses JavaScript rendering  
- b. You forgot to install BeautifulSoup  
- c. The element doesn't exist  
- d. Quotes use `span.text`, not `div.text`  

<details>  
  <summary>Answer & Explanation</summary>  

  **Answer:** d. Quotes use `span.text`, not `div.text`.  

  **Explanation:**  
  The CSS selector is searching for a `div` element with the class `text`. If the page uses a `span` element with the class `text` instead, this selector will return `None`. You need to adjust the selector to match the correct HTML structure.  
</details>  

---

### Question 15  
**You run `db.quotes.find([ rating: 'Five' ]).count()` and get 0. What is a likely reason?**  

- a. Scrapy removes the rating before storing  
- b. You used the wrong MongoDB URI  
- c. The rating field wasn't scraped properly or pipeline was skipped  
- d. Ratings are stored as numbers  

<details>  
  <summary>Answer & Explanation</summary>  

  **Answer:** c. The rating field wasn't scraped properly or pipeline was skipped.  

  **Explanation:**  
  If the rating field was not scraped properly or the pipeline responsible for storing it was skipped, then MongoDB would not have any records with that value. Another potential reason could be that the field is not being stored correctly due to an issue with the data extraction or processing flow.  
</details>  

---  

