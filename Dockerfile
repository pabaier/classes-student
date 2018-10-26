# Dockerfile

# FROM directive instructing base image to build upon
FROM python:3.6

COPY . /app
WORKDIR /app

RUN pip install django
RUN pip install psycopg2-binary
RUN pip install gunicorn
RUN pip install twilio

# CMD specifcies the command to execute to start the server running.
CMD python manage.py runserver 0.0.0.0:$PORT