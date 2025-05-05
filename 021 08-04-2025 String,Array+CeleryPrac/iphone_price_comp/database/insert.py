from pymongo import MongoClient
import config
client = MongoClient(config.MONGO_URI)
db = client[config.DB_NAME]

def insert_price(data):
    if 'iphone' in data['model_name'].lower():
        db.prices.insert_one(data)