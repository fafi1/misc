package net.codefudge.analytics

class JenkinsPatterns {
    static def RUNNING_ON = ~/Running on (\w+)/
    static def RUNNING_IN = ~/Running in ([\w\\/-]+)/
}
