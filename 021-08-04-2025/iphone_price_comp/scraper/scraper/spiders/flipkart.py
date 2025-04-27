import scrapy
from database.insert import insert_price

class FlipkartSpider(scrapy.Spider):
    name = 'flipkart'
    allowed_domains = ['flipkart.com']
    start_urls = []

    def start_requests(self):
        yield scrapy.Request(
            url='https://www.flipkart.com/search?q=iphone',
            headers= {
            'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.0.0 Safari/537.36'
            }
        )
    
    def parse(self, response):
            for product in response.css('div._1AtVbE'):
                model = product.css('div._4rR01T::text').get()
                price = product.css('div._30jeq3::text').get()

                if model and price:
                    insert_price({
                    'model_name': model.strip(),
                    'price': price.replace('', '').replace(',', '').strip(),
                    'site': 'Flipkart'
                })      