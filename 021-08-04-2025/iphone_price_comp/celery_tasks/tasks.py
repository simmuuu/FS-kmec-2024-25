from celery import Celery
import subprocess
import config
import os
app = Celery('tasks', broker=config.REDIS_BROKER_URL)

@app.task
def run_all_spiders():
    # Get the absolute path to the scraper directory
    base_dir = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
    scraper_dir = os.path.join(base_dir, 'scraper')
    
    # Save current directory
    current_dir = os.getcwd()
    
    try:
        # Change to scraper directory where scrapy.cfg is located
        os.chdir(scraper_dir)
        
        # Now run the scrapy commands
        subprocess.run(['scrapy', 'crawl', 'amazon'])
        subprocess.run(['scrapy', 'crawl', 'flipkart'])
    finally:
        # Change back to original directory
        os.chdir(current_dir)