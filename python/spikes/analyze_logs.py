import json
import sys
import csv

file = sys.argv[1]


def createlog(raw):
    return {
        'msg': raw['logevent']['message1'],
        'jobName': raw['jenkins']['fullName']
    }


def fetchlog(file):
    with(open(file)) as f:
        return [createlog(json.loads(raw)) for raw in f.readlines()]


def convert2csv(logs):
    writer = csv.writer(sys.stdout, delimiter=',')
    writer.writerow(['jobName','msg'])
    for log in logs:
        jobName = log['jobName']
        msg = log['msg']
        writer.writerow([jobName, msg])


convert2csv(fetchlog(file))
