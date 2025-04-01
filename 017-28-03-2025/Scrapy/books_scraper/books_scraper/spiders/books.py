import scrapy

class QuotesSpider(scrapy.Spider):
    name = 'books'
    start_urls = ['http://books.toscrape.com']

    def parse(self, response):
        for book in response.css("article.product_pod"):
            yield {
                "title": book.css("h3 a::attr(title)").get(),
                "price": book.css("p.price_color::text").get(),
                'availability':  book.css('p.instock.availability::text')[-1].get().strip(),
                "rating": book.css("p.star-rating::attr(class)").get().split()[-1],
            }

        next_page = response.css('li.next a::attr(href)').get()
        if next_page:
            yield response.follow(next_page, callback=self.parse)
