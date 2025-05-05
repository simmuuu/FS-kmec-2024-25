import scrapy
# In amazon.py
import os
import sys
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '../../../')))
from database.insert import insert_price

class AmazonSpider(scrapy.Spider):
    name = 'amazon'
    allowed_domains = ['amazon.in']
    start_urls = ['https://www.amazon.in/s?k=iphone']

    def parse(self, response):
        for product in response.css('.s-result-item'):
            model = product.css('h2 span::text').get()
            price = product.css('.a-price-whole::text').get()
            if model and price:
                insert_price({'model_name': model.strip(), 'price': price.strip(), 'site':
                'Amazon'})