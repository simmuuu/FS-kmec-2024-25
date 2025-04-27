This project is an iPhone price comparison application that:

  - Scrapes iPhone prices from Amazon and Flipkart using Scrapy spiders
  - Stores data in MongoDB
  - Uses Celery for scheduled scraping tasks (every 5 minutes)
  - Provides a Flask API to compare prices

  The structure follows a clean separation of concerns:
  - scraper/: Contains Scrapy spiders for Amazon and Flipkart
  - database/: MongoDB connection and data insertion logic
  - celery_app/ & celery_tasks/: Scheduled task management
  - flask_app.py: Web API for price comparison

  The tech stack includes Flask, Scrapy, Celery, MongoDB and Redis.


● Celery plays a crucial role as the task scheduler and distributed task processor in this application:

  1. It schedules web scraping tasks to run automatically every 5 minutes
  2. It executes the scrapy spiders that collect iPhone pricing data from Amazon and Flipkart
  3. It uses Redis as a message broker to manage the task queue

  The main components:
  - celery_app.py configures the scheduler (beat_schedule)
  - celery_tasks/tasks.py defines the task that runs the spiders
  - The task launches subprocess calls to the scrapy crawlers

  This automated scheduling ensures price data stays current without manual intervention.


Redis serves as the message broker for Celery, handling the communication between the Celery workers and scheduler. Specifically, it:

  1. Stores the task queue where Celery puts scheduled scraping jobs
  2. Maintains task states and results
  3. Facilitates communication between different Celery processes
  4. Enables distributed task execution if multiple workers are running

  The configuration in config.py sets Redis to run locally on the default port (6379).

  ● Celery and Redis in this project:

  1. Technical Implementation:
    - Celery functions as a distributed task queue system
    - Redis serves as the message broker, storing task messages and results
    - Tasks are scheduled by Celery Beat and executed by Celery Workers
  2. The Flow:
    - Celery Beat schedules the scraper task every 5 minutes
    - Task message is stored in Redis queue
    - Celery Worker picks up the task from Redis
    - Worker executes spiders to collect iPhone price data
    - Data is stored in MongoDB
  3. Benefits in this architecture:
    - Decoupled components with clear separation of concerns
    - Reliable scheduled execution independent of the web API
    - Asynchronous processing allows the API to remain responsive
    - Fault tolerance - failed jobs can be retried

  This pattern is commonly used for background processing, scheduled tasks, and distributed workloads.

  ● Celery is a distributed task queue system for Python that excels as a task scheduler by:

  1. Using a broker (Redis/RabbitMQ) to coordinate task distribution between producers and workers
  2. Providing Celery Beat for precise, crontab-like scheduling of periodic tasks
  3. Supporting both immediate and scheduled task execution with robust retry mechanisms
  4. Offering horizontal scaling through distributed worker processes

  Key strengths:
  - Highly reliable with redundancy features
  - Excellent at handling high-volume, time-insensitive workloads
  - Flexible task routing and prioritization
  - Detailed monitoring and reporting capabilities

  It outperforms cron jobs for complex scheduling while being more lightweight than full workflow engines like Airflow for simpler scheduling needs.