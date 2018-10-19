package net.codefudge.misc.fun

import java.util.function.Consumer

class TreeSearch {
    //TODO: generic methods in groovy?
    void depthFirst(Tree tree, Consumer takeIt) {
        takeIt.accept(tree.content)

        tree.children.each { depthFirst(it, takeIt) }
    }

    void breadthFirst(Tree tree, Consumer takeIt) {
        breadthFirst([tree], takeIt)
    }

    void breadthFirst(List<Tree> trees, Consumer takeIt) {
        if (!trees) return

        trees.each {takeIt.accept(it.content)}

        def newTrees = []
        trees.each {newTrees.addAll(it.children)}
        breadthFirst(newTrees, takeIt)
    }
}