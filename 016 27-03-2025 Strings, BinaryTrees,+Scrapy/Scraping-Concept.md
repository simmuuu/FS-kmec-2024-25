# Scrapers, Crawlers, Spiders  

LLMs require vast amounts of data for training. Some sources include:  
- Wikipedia  
- Publicly available information  
- Web scraping and crawling for specific datasets  

## **Scrapy Architecture**  
Scrapy is a powerful web crawling framework that follows an event-driven architecture.  

### **Main Components:**  
1. **Spider** – Extracts the required data from web pages by sending requests and parsing responses.  
2. **Engine (Core)** – The heart of Scrapy, responsible for processing requests, responses, and data flow.  
3. **Scheduler** – Manages and prioritizes requests to avoid duplicate crawling.  
4. **Downloader** – Retrieves web pages and passes them to the Spider for processing.  
5. **Web (Internet)** – The external source of web pages that Scrapy fetches data from.  
6. **Pipeline** – Processes and cleans extracted data before storing it in databases, files, or APIs.  

### **Scrapy Workflow:**  
1. The Spider sends an initial request to a URL.  
2. The request goes through the Engine to the Scheduler.  
3. The Downloader retrieves the page from the web.  
4. The Spider parses the page and extracts the required data.  
5. The extracted data is passed to the Pipeline for processing and storage.  
6. The cycle repeats for new links found on the page.  



## **Twisted Framework**  
Scrapy is built on **Twisted**, an asynchronous networking framework in Python. It allows Scrapy to handle multiple requests efficiently.  

### **Features of Twisted:**  
- **Asynchronous I/O** – Handles multiple network requests without blocking.  
- **Event-Driven Architecture** – Uses callbacks and deferreds to manage tasks.  
- **Protocol Support** – Supports HTTP, SSH, FTP, and other protocols.  
- **Concurrency** – Enables Scrapy to fetch multiple pages in parallel, improving speed.  

Twisted ensures that Scrapy efficiently crawls web pages without waiting for each request to complete before starting a new one.  

