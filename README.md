# Secret Santa

![PyPI - Python Version](https://img.shields.io/pypi/pyversions/Django.svg)
![PyPI - Django Version](https://img.shields.io/pypi/djversions/djangorestframework.svg)

This app is designed to facilitate a gift exchange. It can be used by a private group or an individual can sign up for a mass public gift exchange (MPGE).  

## What is a gift exchange?

A gift exchange is a fun way to give and receive gifts with group of people. Everyone in the group is randomly assigned another person and they are responsible for buying that person a gift. 

## Getting Started
All dependencies can be found in the `Pipfile`. Install them manually and run

```
$python manage.py runserver
```

or just use pipenv and run

```
$pipenv run python manage.py runserver
```

## Config

A config file is required in `\secret_santa\config.json`. The file must contain a path to `db.localhost`. This can be changed in the  `settings.py` file .

## Docker

The Dockerfile can be used to run the app locally, but is intended for production use with Heroku. Before building, the production database must be added to `config.json` and referenced in `secret_santa\settings.py`.

To build, run
```
$docker build -t santa .
```
Then to push to Heroku, run
```
$heroku container:login
$heroku container:push web
$heroku container:release web
```

---

## Use Cases

- gift exchange
  - with group
  - random
- anything exchange
  - abstract the idea for any type of exchange such as:
    - book exchange, pin exchange, stamp exchange



## Similar Services

https://www.elfster.com/

## Tech Stuff

#### Backend

`Python (Django?)`

#### Datastore

`MySql`

#### Frontend

`React?`

## Helpful Resources

##### auth

https://docs.djangoproject.com/en/2.1/topics/auth/

##### react

https://www.valentinog.com/blog/tutorial-api-django-rest-react/

##### SMTP

https://docs.python.org/3/library/smtplib.html

##### config

https://docs.python.org/3/library/configparser.html

##### SMS

https://www.twilio.com/docs/sms/quickstart/python

##### amazon

https://pypi.org/project/python-amazon-product-api/