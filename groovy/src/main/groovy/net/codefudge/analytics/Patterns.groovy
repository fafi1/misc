package net.codefudge.analytics

import java.util.regex.Matcher
import java.util.regex.Pattern

class Groups {
    String g1
    String g2
    String g3
    String g4
    String g5
}

class Patterns {
    static String fetch1g(String text, Pattern oneGroup) {
        def m = oneGroup.matcher(text)

        m.find() ? m.group(1) : null
    }

    static List<String> fetchGroups(String text, Pattern groups) {
        def m = groups.matcher(text)

        m.find() ? groupsInternal(m) : null
    }

    private static List<String> groupsInternal(Matcher m) {
        def r = []
        for (int i = 1; i <= m.groupCount(); i++) {
            r.add(m.group(i))
        }
        r
    }

    static Map<String, AnalyzerPattern> fetchPatterns(List<String> lines) {
        def patterns = [:]

        lines.each {
            def tokens = createTokens(it)

//                String[] parts = findParts(tokens, 1)
            String[] full = findParts(tokens, 0)

            computeAndAddScore(full, patterns)
        }

        patterns
    }

    private static String[] findParts(String[] tokens, int partCount) {
        [tokens.join(' ')]
    }

    private static void computeAndAddScore(String[] parts, Map<String, AnalyzerPattern> patterns) {
        parts.each { patterns.put(it, null) }
    }

    private static String[] createTokens(String text) {
        text.split(' +')
    }
}
