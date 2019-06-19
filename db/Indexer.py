import json
import os
import sqlite3


class Indexer:
    def __init__(self):
        self.file = 'index.db'

    def open_connection(self):
        dir_path = os.path.dirname(os.path.realpath(__file__))
        self.connection = sqlite3.connect(f'{dir_path}/{self.file}')
        self.cursor = self.connection.cursor()

    def build_indexer(self):
        self.open_connection()
        self.cursor.execute('''CREATE TABLE IF NOT EXISTS user(userId TEXT, folder INTEGER, file INTEGER, line INTEGER)''')
        self.cursor.execute('''CREATE TABLE IF NOT EXISTS trans(tId TEXT, folder INTEGER, file INTEGER, line INTEGER)''')
        self.connection.close()

    def insert_record_user(self, data):
        self.open_connection()
        sql = '''INSERT INTO user(userId, folder, file, line) VALUES (?, ?, ?, ?)'''
        self.cursor.execute(sql, [data["userId"], data["folder"], data["file"], data["line"]])
        self.connection.commit()
        self.connection.close()

    def insert_record_transaction(self, data):
        self.open_connection()
        sql = '''INSERT INTO trans(tId, folder, file, line) VALUES (?, ?, ?, ?)'''
        self.cursor.execute(sql, [data["transactionId"], data["folder"], data["file"], data["line"]])
        self.connection.commit()
        self.connection.close()

    def add(self, data, folder, file, line):
        d = {'folder': folder, 'file': file, 'line': line}
        block = json.loads(data)
        d['userId'] = block['header']['user']
        header = block['header']
        d['transactionId'] = block['transaction']['id']
        self.insert_record_user(d)
        self.insert_record_transaction(d)

    def getUserRecords(self, userId):
        pass

    # exists = os.path.isfile('example.db')
    # if exists:
    # 	print('already here!')
    # else:
    # conn = sqlite3.connect('example.db')
    # c = conn.cursor()
    # buildDB(c, conn)

    # dir_path = os.path.dirname(os.path.realpath(__file__))
    # my_file = Path(f'{dir_path}/{self.indexer.file}')
    # exists = my_file.exists()
    # if exists:
    #     print('already here!')
    # else:
    #     self.indexer.build_indexer()