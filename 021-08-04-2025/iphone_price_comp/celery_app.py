from celery import Celery
import config
app = Celery('tasks', broker=config.REDIS_BROKER_URL)
app.conf.beat_schedule = {
    'scrape-every-5-mins': {
    'task': 'celery_tasks.tasks.run_all_spiders',
    'schedule': 60.0 * 5,
    },
}