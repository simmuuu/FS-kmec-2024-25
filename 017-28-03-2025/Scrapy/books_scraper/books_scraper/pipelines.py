import pymongo

class MongoDBPipeline:
    def __init__(self, mongodb_uri, mongodb_database, mongodb_collection):
        self.mongodb_uri = mongodb_uri
        self.mongodb_database = mongodb_database
        self.mongodb_collection = mongodb_collection

    @classmethod
    def from_crawler(cls, crawler):
        return cls(
            mongodb_uri=crawler.settings.get('MONGODB_URI', 'mongodb://localhost:27017/?authSource=admin'),
            mongodb_database=crawler.settings.get('MONGODB_DATABASE', 'bookstore'),
            mongodb_collection=crawler.settings.get('MONGODB_COLLECTION', 'books')
        )

    def open_spider(self, spider):
        self.client = pymongo.MongoClient(
            self.mongodb_uri,
            username='xxx',  
            password='xxx'  
        )
        self.db = self.client[self.mongodb_database]
        self.collection = self.db[self.mongodb_collection]

    def close_spider(self, spider):
        self.client.close()

    def process_item(self, item, spider):
        self.collection.update_one(
            {'title': item['title']},  
            {'$set': dict(item)},      
            upsert=True                
        )
        return item