from celery import Celery

app = Celery(
    'scraper_project',
    broker='redis://localhost:6379/0',
    backend='redis://localhost:6379/0'
)

# Auto-discover tasks in registered apps
app.autodiscover_tasks(['celery_tasks'])