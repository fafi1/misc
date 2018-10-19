package net.codefudge.misc.fun

import spock.lang.Specification

class TreeSpec extends Specification {
    def 'depth first'() {
        when:
        def actualOrder = []

        new TreeSearch().depthFirst(input, {
            actualOrder.add(it)
        })

        then:
        actualOrder == order

        where:
        input       | order
        onlyRoot()  | [1]
        height2_1() | [1, 2, 3]
        height3_1() | [1, 2, 4, 3]
        height4_1() | [1, 2, 4, 5, 3]
    }

    def 'breadth first'() {
        when:
        def actualOrder = []

        new TreeSearch().breadthFirst(input, {
            actualOrder.add(it)
        })

        then:
        actualOrder == order

        where:
        input       | order
        onlyRoot()  | [1]
        height2_1() | [1, 2, 3]
        height3_1() | [1, 2, 3, 4]
        height4_1() | [1, 2, 3, 4, 5]
    }

    Tree<Integer> onlyRoot() {
        def tree = new Tree<Integer>()
        tree.content = 1
        tree
    }

    Tree<Integer> height2_1() {
        def tree = new Tree<Integer>(content: 1, children: [
                new Tree(content: 2), new Tree(content: 3)
        ])

        tree
    }

    Tree<Integer> height3_1() {
        def tree = new Tree<Integer>(content: 1, children: [
                new Tree(content: 2, children: [
                        new Tree(content: 4)
                ]), new Tree(content: 3)
        ])

        tree
    }

    Tree<Integer> height4_1() {
        def tree = new Tree<Integer>(content: 1, children: [
                new Tree(content: 2, children: [
                        new Tree(content: 4),
                        new Tree(content: 5)
                ]),
                new Tree(content: 3)
        ])

        tree
    }
}
