package net.codefudge.analytics

import spock.lang.Specification
import spock.lang.Unroll

import static net.codefudge.analytics.JenkinsPatterns.getRUNNING_IN
import static net.codefudge.analytics.JenkinsPatterns.getRUNNING_ON

class AnalyzerSpikesSpec extends Specification {
    def log1 = '''Running on node1
some other output
Running on node2
check this out
ls -l
Running in /tmp/test
Running on node3
'''

    @Unroll
    def 'fetch running on'() {
        expect:
        Patterns.fetch1g(text, RUNNING_ON) == node

        where:
        text                   | node
        'no run on'            | null
        'Running on testnode1' | 'testnode1'
        'Running on testnode2' | 'testnode2'
    }

    @Unroll
    def 'fetch running in'() {
        expect:
        Patterns.fetch1g(text, RUNNING_IN) == path

        where:
        text                           | path
        'no run in'                    | null
        'Running in /tmp/workspace'    | '/tmp/workspace'
        'Running in /opt/my/workspace' | '/opt/my/workspace'

    }

    @Unroll
    def 'fetch groups'() {
        def groups = Patterns.fetchGroups(text, pattern)

        expect:
        groups == expGroups

        println expGroups

        where:
        text                                   | pattern                                  | expGroups
        'weather is nice'                      | ~/weather is (\w+)/                      | ['nice']
        'weather is sunny'                     | ~/weather is (\w+)/                      | ['sunny']
        'weather is sunny and people are nice' | ~/weather is (\w+) and people are (\w+)/ | ['sunny', 'nice']
        'sunny the weather is'                 | ~/'the weather is (\w+)/                 | null
    }

    @Unroll
    def 'fetch patterns'() {
        when:
        def patterns = Patterns.fetchPatterns(textLines)

        then:
        patterns.findAll { expPatterns.containsKey(it.key) }.size() == expPatterns.keySet().size()

        where:
        textLines             | expPatterns
        oneGroupPatternsEnd() | ['take away': null]
        oneGroupPatternsEnd() | ['Running on': new AnalyzerPattern(), 'Started by': new AnalyzerPattern()]
//        oneGroupPatternsEnd() | ['Running': null, 'on': null]
    }

    List<String> oneGroupPatternsEnd() {
        '''Started by superuser
hello world
ls -l
Started by fred
Started by sunny
Running on bigmachine
Running on jenkins1
take away
find ./ secrets | grep treasure | cat /dev/null
Started by incognito
'''.readLines()
    }
}
