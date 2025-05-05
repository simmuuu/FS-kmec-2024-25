BOT_NAME = 'books_scraper'

SPIDER_MODULES = ['books_scraper.spiders']
NEWSPIDER_MODULE = 'books_scraper.spiders'

# MongoDB Pipeline Settings
ITEM_PIPELINES = {
   'books_scraper.pipelines.MongoDBPipeline': 300,
}

MONGODB_URI = 'mongodb://localhost:27017'
MONGODB_DATABASE = 'bookstore'
MONGODB_COLLECTION = 'books'

# Robotstxt and Basic Settings
ROBOTSTXT_OBEY = False
CONCURRENT_REQUESTS = 1

# Optional: JSON output
FEED_FORMAT = 'json'
FEED_URI = 'books.json'