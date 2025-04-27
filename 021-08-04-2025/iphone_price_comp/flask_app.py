from flask import Flask, jsonify
from pymongo import MongoClient
import config

app = Flask(__name__)
client = MongoClient(config.MONGO_URI)
db = client[config.DB_NAME]

@app.route('/compare/<model_name>')
def compare(model_name):
    records = list(db.prices.find({'model_name': {'$regex': model_name, '$options': 'i'}}, {'_id':0}))
    return jsonify(records)

@app.route('/')
def home():
    return "<h1>iPhone Price Comparison API</h1><p>Use /compare/<model_name> to get prices.</p>"

if __name__ == '__main__':
    app.run(host='0.0.0.0', debug=True)